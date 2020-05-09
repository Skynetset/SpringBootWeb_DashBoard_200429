package com.privatal.springbootweb.exception;

/**
 * @program: spring-boot-web
 * @description: TODO
 * @author: 1260535819@qq.com
 * @create: 2020-04-30 20:38
 */
public class UserExistsException extends Throwable {
    public UserExistsException() {
        super("11111");
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }

    protected UserExistsException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
