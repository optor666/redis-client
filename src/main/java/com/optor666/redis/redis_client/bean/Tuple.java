package com.optor666.redis.redis_client.bean;

/**
 * Created by optor666 on 2018/6/28.
 */
public class Tuple {

    private String value;

    private double score;

    public Tuple(String value, double score) {
        this.value = value;
        this.score = score;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return value + " " + score;
    }
}
