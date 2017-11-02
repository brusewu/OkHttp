package okhttputil.builder;

import okhttp3.RequestBody;
import okhttputil.request.OtherRequest;
import okhttputil.request.RequestCall;

/**
 * Created by wuxiaolong on 2017/10/31.
 */

public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder> {

    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method)
    {
        this.method = method;
    }

    @Override
    public RequestCall build()
    {
        return new OtherRequest(requestBody, content, method, url, tag, params, headers,id).build();
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody)
    {
        this.requestBody = requestBody;
        return this;
    }

    public OtherRequestBuilder requestBody(String content)
    {
        this.content = content;
        return this;
    }

}

