package okhttputil.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;

/**
 * Created by wuxiaolong on 2017/11/1.
 */

public abstract class BitmapCallback extends Callback<Bitmap>{
    @Override
    public Bitmap parseNetworkResponse(Response response , int id) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }
}
