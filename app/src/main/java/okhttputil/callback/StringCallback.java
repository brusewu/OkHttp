package okhttputil.callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by wuxiaolong on 2017/10/31.
 */

public abstract class StringCallback extends Callback<String> {

    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {
        return response.body().string();
    }
}
