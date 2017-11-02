package okhttputil.builder;

import okhttp3.MediaType;
import okhttputil.request.PostStringRequest;
import okhttputil.request.RequestCall;

/**
 * Created by wuxiaolong on 2017/11/1.
 */

public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>{

    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }

}
