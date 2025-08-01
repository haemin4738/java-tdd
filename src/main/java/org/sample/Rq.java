package org.sample;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String cmd;
    private final Map<String, String> params;
    public Rq(String cmd) {
        this.cmd = cmd;

//        params = new HashMap<>();
        //"등록?이름=홍길동&고향=남원" -> "등록", "이름=홍길동&고향=남원"
        String[] cmdBits = cmd.split("\\?", 2);
        String queryString = cmdBits.length == 2 ? cmdBits[1] : "";
//        //이름=홍길동&고향=남원
//        String[] queryStringBits = queryString.split("&");
//
//        // [이름=홍길동, 고향=남원]
//        for (String paramStr  : queryStringBits) {
//            // "이름=홍길동" -> "이름", "홍길동"
//            // "고향=남원" -> "고향", "남원"
//            String[] paramBits = paramStr.split("=", 2);
//            String paramName = paramBits[0];
//            String paramValue = paramBits[1];
//
//            params.put(paramName, paramValue);
//        }

        params = Arrays.stream(queryString.split("&"))
                .map(e -> e.split("=", 2))
                .filter(e -> e.length == 2 && !e[0].isBlank() && !e[1].isBlank())
                .collect(Collectors.toMap(e->e[0], e-> e[1]));
    }

    public String getActionName() {
        String[] cmdBits = cmd.split("\\?");
        return cmdBits[0];
    }

    public String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);
    }
}
