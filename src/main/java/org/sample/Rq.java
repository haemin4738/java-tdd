package org.sample;

public class Rq {
    private final String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }

    public String getActionName() {
        String[] cmdBits = cmd.split("\\?");
        return cmdBits[0];
    }

    public String getParam(String name, String defaultValue) {
        //등록?이름=홍길동&등록?고향=남원
        String queryString  = cmd.split("\\?", 2)[1];
        // 이름=홍길동&등록?공향=남원
        String[] paramsBits = queryString.split("=", 2);

        String paramName= paramsBits[0];
        String paramValue = paramsBits[1];

        if (!name.equals(paramName)) return defaultValue;

        return paramValue;
    }
}
