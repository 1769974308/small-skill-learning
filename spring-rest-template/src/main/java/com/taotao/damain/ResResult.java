package com.taotao.damain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ASUS
 * @date 2022/6/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResResult<T> {

    private int code;

    private String msg;

    private T data;

    public ResResult(T data) {
        this.code = 200;
        this.msg = "成功";
        this.data = data;
    }
}
