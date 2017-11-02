package okhttputil.callback;

/**
 * Created by wuxiaolong on 2017/11/1.
 */

public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);

}
