package me.creeper.creepermodtest.computers;

public class Result {
    public String msg;
    public boolean error;

    public Result(String msg) {
        this(msg, false);
    }

    public Result(String msg, boolean error) {
        this.msg = msg;
        this.error = error;
    }
}
