package com.ll.global.rq;

public class Rq {
    private final String actionName;
    private final int id;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split(" ", 2);
        actionName = cmdBits[0].trim();

        id = cmdBits.length == 2  ? Integer.parseInt(cmdBits[1].trim()) : -1;

    }

    public String getActionName() {
        return actionName;
    }

    public int getId() {
        return id;
    }
}
