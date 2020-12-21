package com.psms.common.exception.user;

/**
 * 验证码失效异常类
 * 
 * @author jeethink  官方网址：www.jeethink.vip
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
