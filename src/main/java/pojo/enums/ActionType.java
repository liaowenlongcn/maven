package pojo.enums;

/**
 * Created by wenlong.liao on 2018/9/24.
 */
public enum ActionType {
    IsList(0),
    IsAdd(1),
    IsEdit(2),
    IsDef(3);

    private final Integer value;
    //构造方法必须是private或者默认
    private ActionType(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
