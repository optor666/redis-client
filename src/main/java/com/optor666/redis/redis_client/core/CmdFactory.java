package com.optor666.redis.redis_client.core;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by optor666 on 2018/8/17.
 */
public final class CmdFactory {

    public static CmdInterface getInstance(InputStream is, OutputStream os) {
        return getInstance(is, os, false);
    }

    public static CmdInterface getInstance(InputStream is, OutputStream os, boolean loggerSwitch) {
        Cmd cmd = new Cmd(is, os, loggerSwitch);
        CmdProxy cmdProxy = new CmdProxy();
        return cmdProxy.bind(cmd);
    }
}
