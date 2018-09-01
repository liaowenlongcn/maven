package pojo.enums;

/**
 * Created by wenlong.liao on 2018/9/1.
 */
public enum ResultCode {

    Success(0),
    Failure(1);

    private final int value;
    //构造方法必须是private或者默认
    private ResultCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
