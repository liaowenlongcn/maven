package pojo.vo;

import java.util.List;

/**
 * Created by wenlong.liao on 2018/9/2.
 */
public class BaseListVO<T> {
    //    返回码
    private int code;
    //    总条数
    private int count;
    //    提示语
    private String msg;
    //    数据集
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
