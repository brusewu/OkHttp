package okhttputil.builder;

import java.io.File;

import okhttp3.MediaType;
import okhttputil.request.PostFileRequest;
import okhttputil.request.RequestCall;

/**
 * Created by wuxiaolong on 2017/11/1.
 */

public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {

    private File file;
    private MediaType mediaType;


    public OkHttpRequestBuilder file(File file)
    {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostFileRequest(url, tag, params, headers, file, mediaType,id).build();
    }
}
