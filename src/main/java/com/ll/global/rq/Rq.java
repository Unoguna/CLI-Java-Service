package com.ll.global.rq;

public class Rq {
    private final String actionName;
    private final String param;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split(" ", 2);
        actionName = cmdBits[0].trim();


        param = cmdBits.length == 2  ? cmdBits[1].trim() : "";

    }

    public String getActionName() {
        return actionName;
    }

    public String getId() {
        return param;
    }
}
