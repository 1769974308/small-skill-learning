package com.taotao.common.api;

/**封装API的错误码
 * @auther ASUS
 * @date 2021/12/9
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
