package com.optor666.redis.redis_client.core;

import com.optor666.redis.redis_client.bean.Tuple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by optor666 on 2018/6/28.
 */
public class Cmd implements CmdInterface {

    private InputStream is;

    private OutputStream os;

    private BufferedReader br;

    private boolean loggerSwitch;

    public Cmd(InputStream is, OutputStream os) {
        this(is, os, false);
    }

    public Cmd(InputStream is, OutputStream os, boolean loggerSwitch) {
        this.is = is;
        this.os = os;

        this.br = new BufferedReader(new InputStreamReader(is));

        this.loggerSwitch = loggerSwitch;
    }

    public boolean isLoggerSwitch() {
        return loggerSwitch;
    }

    public void setLoggerSwitch(boolean loggerSwitch) {
        this.loggerSwitch = loggerSwitch;
    }

    private void exec(String cmd) throws IOException {
        os.write((cmd + "\r\n").getBytes());
        os.flush();
    }

    // Key
    @Override
    public boolean del(String key) {
        try {
            exec("del " + key);
            return Integer.parseInt(br.readLine().substring(1)) == 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> sort(String key, boolean alpha, int offset, int count, boolean asc) {
        //sort dd17c0fee819b9c79696a382f9634dbd87 alpha limit 0 5 desc
        List<String> res = new ArrayList<>();

        StringBuilder cmdStr = new StringBuilder();
        cmdStr.append("sort " + key);
        if (alpha) {
            cmdStr.append(" alpha");
        }
        cmdStr.append(" limit " + offset + " " + count);
        if (!asc) {
            cmdStr.append(" desc");
        }
        try {
            exec(cmdStr.toString());
            int rows = Integer.parseInt(br.readLine().substring(1));
            for (int i = 0; i < rows; i++) {
                br.readLine();
                res.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String type(String key) {
        try {
            exec("type " + key);
            return br.readLine().substring(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String randomkey() {
        try {
            exec("randomkey");
            br.readLine();
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // String
    @Override
    public String get(String key) {
        try {
            exec("get " + key);
            String preLen = br.readLine();
            if (preLen.equals("$-1")) {
                return null;
            }
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean set(String key, String value) {
        try {
            exec("set " + key + " " + value);
            if ("+OK".equals(br.readLine())) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Hash

    // List
    @Override
    public int llen(String key) {
        try {
            exec("llen " + key);
            return Integer.parseInt(br.readLine().substring(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<String> lrange(String key, int start, int end) {
        try {
            exec("lrange " + key + " " + start + " " + end);
            int len = Integer.parseInt(br.readLine().substring(1));
            List<String> res = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                br.readLine();
                res.add(br.readLine());
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Set
    @Override
    public boolean sismember(String key, String member) {
        try {
            exec("sismember " + key + " " + member);
            return Integer.parseInt(br.readLine().substring(1)) == 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Sorted Set
    @Override
    public int zcard(String key) {
        try {
            exec("zcard " + key);
            return Integer.parseInt(br.readLine().substring(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String zrange(String key, int start, int end) {
        try {
            exec("zrange " + key + " " + start + " " + end);
            String firstLine = br.readLine();
            int rows = Integer.parseInt(firstLine.substring(1));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rows; i++) {
                br.readLine();
                sb.append(br.readLine());
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tuple> zrangeWithScores(String key, int start, int end) {
        try {
            exec("zrange " + key + " " + start + " " + end + " withscores");
            String firstLine = br.readLine();
            int rows = Integer.parseInt(firstLine.substring(1)) / 2;
            List<Tuple> tuples = new ArrayList<>(rows);
            for (int i = 0; i < rows; i++) {
                br.readLine();
                String value = br.readLine();
                br.readLine();
                double score = Double.parseDouble(br.readLine());
                tuples.add(new Tuple(value, score));
            }
            return tuples;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tuple> zrevrangeWithScores(String key, int start, int end) {
        try {
            exec("zrevrange " + key + " " + start + " " + end + " withscores");
            String firstLine = br.readLine();
            int rows = Integer.parseInt(firstLine.substring(1)) / 2;
            List<Tuple> tuples = new ArrayList<>(rows);
            for (int i = 0; i < rows; i++) {
                br.readLine();
                String value = br.readLine();
                br.readLine();
                double score = Double.parseDouble(br.readLine());
                tuples.add(new Tuple(value, score));
            }
            return tuples;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // HyperLogLog

    // Geo

    // Pub/Sub
    @Override
    public int publish(String channel, String msg) {
        String cmd = "PUBLISH " + channel + " " + msg;
        try {
            exec(cmd);
            return Integer.parseInt(br.readLine().substring(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void psubscribe(String topic, TopicMessageListener listener) {
        String cmd = "PSUBSCRIBE " + topic;

        String channel, msg;
        try {
            exec(cmd);

            if (!(br.readLine().equals("*3") && br.readLine().equals("$10") && br.readLine().equals("psubscribe")
                    && br.readLine().equals("$" + topic.length()) && br.readLine().equals(topic) && br.readLine().equals(":1"))) {
                throw new RuntimeException("PSubscribe Failed.");
            }

            while ((msg = br.readLine()) != null) {
                if (msg.equals("*4") && br.readLine().equals("$8") && br.readLine().equals("pmessage") && br.readLine().equals("$" + topic.length())
                        && br.readLine().equals(topic) && br.readLine().startsWith("$") && (channel = br.readLine()) != null
                        && br.readLine().startsWith("$") && (msg = br.readLine()) != null) {
                    listener.handle(channel, msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void subscribe(String channel, ChannelMessageListener listener) {
        String cmd = "SUBSCRIBE " + channel;

        String msg;
        try {
            exec(cmd);

            if (!(br.readLine().equals("*3") && br.readLine().equals("$9") && br.readLine().equals("subscribe")
                    && br.readLine().equals("$7") && br.readLine().equals(channel) && br.readLine().equals(":1"))) {
                throw new RuntimeException("Subscribe Failed.");
            }

            while ((msg = br.readLine()) != null) {
                if (msg.equals("*3") && br.readLine().equals("$7") && br.readLine().equals("message") && br.readLine().equals("$7")
                        && br.readLine().equals(channel) && br.readLine().length() > 0 && (msg = br.readLine()) != null) {
                    listener.handle(msg);
                } else {
                    throw new RuntimeException("Unknow Error.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Transaction

    // Script

    // Connection
    @Override
    public boolean select(int dbNum) {
        try {
            exec("select " + dbNum);
            if ("+OK".equals(br.readLine())) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Server
    @Override
    public long dbsize() {
        try {
            exec("dbsize");
            return Long.parseLong(br.readLine().substring(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String info() {
        try {
            exec("info");
            br.readLine();
            String line;
            StringBuilder sb = new StringBuilder();
            while (!(line = br.readLine()).equals("")) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
