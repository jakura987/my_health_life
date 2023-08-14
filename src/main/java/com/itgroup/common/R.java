package com.itgroup.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(){
        R<T> r = new R<>();
        r.code = 1;
        return r;
    }

    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.code = 1;
        r.data = data;
        return r;
    }

    public static <T> R<T> success(T data, String msg){
        R<T> r = new R<>();
        r.code = 1;
        r.data = data;
        r.msg = msg;
        return r;
    }


    public static R error(String msg){
        R r = new R();
        r.code = 0;
        r.msg = msg;
        return r;
    }
}
