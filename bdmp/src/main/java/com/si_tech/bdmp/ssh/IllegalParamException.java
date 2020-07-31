package com.si_tech.bdmp.ssh;

/**
 * 
 * <p>Title: IllegalParamException</p>
 * <p>Description: 参数异常</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: 思特奇 </p>
 * @author heweia
 * @version 1.0
 * @createtime 2019-4-9 上午9:09:44
 *
 */
public class IllegalParamException extends Exception {
    
    private static final long serialVersionUID = -1148039976867829902L;

    public IllegalParamException() {
        super();
    }

    public IllegalParamException(String message) {
        super(message);
    }

    public IllegalParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParamException(Throwable cause) {
        super(cause);
    }
}
