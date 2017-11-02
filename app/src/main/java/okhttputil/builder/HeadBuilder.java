package okhttputil.builder;

import okhttputil.OkHttpUtils;
import okhttputil.request.OtherRequest;
import okhttputil.request.RequestCall;

import static android.R.attr.id;
import static android.R.attr.tag;

/**
 * Created by wuxiaolong on 2017/11/1.
 */

public class HeadBuilder extends GetBuilder{

    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
