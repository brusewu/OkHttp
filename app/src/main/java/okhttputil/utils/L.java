package okhttputil.utils;

import android.util.Log;

/**
 * Created by wuxiaolong on 2017/10/31.
 */

public class L {

    private static boolean debug = false;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }
}
