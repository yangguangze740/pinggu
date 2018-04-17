package com.zhulin.common.resp;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    public R() {
        put("code", 0);
    }

    public static R error() {
        return error(500, "未确定异常,请联系开发人员");
    }

    public static R error(String message) {
        return error(500, message);
    }

    public static R error(int code, String message) {
        R r = new R();

        r.put("code", code);
        r.put("message", message);

        return r;
    }

    public static R ok(String message) {
        R r = new R();

        r.put("message", message);

        return r;
    }

    public static R ok(Map<String, Object> data) {
        R r = new R();

        r.putAll(data);

        return r;
    }

    public static R ok() {
        return new R();
    }
}
