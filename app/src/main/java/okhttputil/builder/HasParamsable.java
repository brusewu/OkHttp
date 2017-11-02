package okhttputil.builder;

import java.util.Map;

/**
 * Created by wuxiaolong on 2017/10/31.
 */

public interface HasParamsable {

    OkHttpRequestBuilder params(Map<String, String> params);
    OkHttpRequestBuilder addParams(String key, String val);
}
