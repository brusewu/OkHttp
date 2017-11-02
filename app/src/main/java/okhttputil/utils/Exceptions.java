package okhttputil.utils;

/**
 * Created by wuxiaolong on 2017/10/31.
 */

public class Exceptions {
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }
}
