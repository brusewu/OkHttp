package com.okhttppackage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttputil.OkHttpUtils;
import okhttputil.callback.BitmapCallback;
import okhttputil.callback.StringCallback;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTv;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Button http_btn;
    private Button post;
    private Button image;
    private Button uploadFile;

    public static final String POST_URL = "http://zhushou.72g.com/app/gift/gift_list/";

    public class MyStringCallback extends StringCallback
    {
        @Override
        public void onBefore(Request request, int id)
        {
           // setTitle("loading...");
        }

        @Override
        public void onAfter(int id)
        {
          //  setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id)
        {
           // e.printStackTrace();
          //  mTv.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id)
        {
           Log.e(TAG, "onResponse：complete");
           mTv.setText("onResponse:" + response);

            switch (id)
            {
                case 100:
                    Toast.makeText(MainActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(MainActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id)
        {
           Log.e(TAG, "inProgress:" + progress);
           mProgressBar.setProgress((int) (100 * progress));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = (TextView) findViewById(R.id.id_textview);
        mImageView = (ImageView) findViewById(R.id.id_imageview);
        mProgressBar = (ProgressBar) findViewById(R.id.id_progress);
        http_btn = (Button)findViewById(R.id.http);
        post = (Button)findViewById(R.id.post);
        image = (Button)findViewById(R.id.image);
        uploadFile = (Button)findViewById(R.id.uploadFile);

        mProgressBar.setMax(100);
       /* GetRequest getRequest = new GetRequest();
        try {
            getRequest.getRequestTest("http://gank.io/api/search/query/listview/category/Android/count/10/page/1");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        http_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getHttpHtml();

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                post();
                //getImage();

            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadFile();
            }
        });

    }

/*
Get request
*/
    public void getHttpHtml()
    {
        String url = "http://gank.io/api/search/query/listview/category/Android/count/10/page/1";

        OkHttpUtils
                .get()//
                .url(url)//
                .id(100)
                .build()//
                .execute(new MyStringCallback());

    }
/*
Get request the image
 */
    public void getImage()
    {
        mTv.setText("");
        String url = "http://7xi8d6.com1.z0.glb.clouddn.com/2017-10-31-nozomisasaki_official_31_10_2017_10_49_17_24.jpg";
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        mTv.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id)
                    {
                        Log.e("TAG", "onResponse：complete");
                        mImageView.setImageBitmap(bitmap);
                    }
                });
    }
    //https://itscoder.com/weeklyblog-phase-8/


    public void getHttpsHtml()
    {
        String url = "https://itscoder.com/weeklyblog-phase-8/";

//                "https://12
//        url =3.125.219.144:8443/mobileConnect/MobileConnect/authLogin.action?systemid=100009&mobile=13260284063&pipe=2&reqtime=1422986580048&ispin=2";
        OkHttpUtils
                .get()//
                .url(url)//
                .id(101)
                .build()//
                .execute(new MyStringCallback());

    }

    public void post()
    {
        String url =POST_URL;
        OkHttpUtils
                .post()//
                .url(url)//
                .addParams("page", "12")
                .addParams("name", "news")
                .addParams("pageSize", "20")
                .addParams("id", "34")
                .addParams("type", "6")
                .build()//
                .execute(new MyStringCallback());
    }


    public void uploadFile()
    {
        //获取SD卡的文件
        File file = new File(Environment.getExternalStorageDirectory(), "23.png");
        if (!file.exists())
        {
            Toast.makeText(MainActivity.this, "The file not find. Please modify the file path", Toast.LENGTH_SHORT).show();
            return;
        }
        /*
        Map<String, String> params = new HashMap<>();
        params.put("username", "张鸿洋");
        params.put("password", "123");

        Map<String, String> headers = new HashMap<>();
        headers.put("APP-Key", "APP-Secret222");
        headers.put("APP-Secret", "APP-Secret111");
        */
        String url = "http://10.11.64.50/upload/UploadServlet";

        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", file)//
                .url(url)//
               // .headers(headers)//
                .build()//
                .execute(new MyStringCallback());
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
