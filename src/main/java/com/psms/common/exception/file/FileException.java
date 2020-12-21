package com.psms.common.exception.file;

import com.psms.common.exception.BaseException;

/**
 * 文件信息异常类
 * 
 * @author jeethink  官方网址：www.jeethink.vip
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
