package commn;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wenlong.liao on 2018/9/1.
 */
public class ObjectHelper {
    public static void toBean(Object filterBean,Object targetBean) throws Exception {
        Class filterClass = Class.forName(filterBean.getClass().getName());
        Class targetClass = Class.forName(targetBean.getClass().getName());
        Field[] fields1 = filterClass.getDeclaredFields();
        Field[] fields2 = targetClass.getDeclaredFields();
        ObjectHelper commonUtils = new ObjectHelper();
        for (Field f1 : fields1) {
            Object value = commonUtils.invokeGetMethod(filterBean, f1.getName(), null);
            for (Field f2 : fields2) {
                if (f1.getName().equals(f2.getName())) {
                    Object[] obj = new Object[1];
                    obj[0] = value;
                    commonUtils.invokeSetMethod(targetBean, f2.getName(), obj);
                }
            }
        }
    }

    private Object invokeGetMethod(Object filterBean, String fieldName, Object[] args) {
        String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method method = null;
        try {
            method = Class.forName(filterBean.getClass().getName()).getDeclaredMethod("get" + methodName);
            return method.invoke(filterBean);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private Object invokeSetMethod(Object targetBean, String fieldName, Object[] args){
        String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
        Method method = null;
        try
        {
            Class[] parameterTypes = new Class[1];
            Class targetClass = Class.forName(targetBean.getClass().getName());
            Field field = targetClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            method = targetClass.getDeclaredMethod("set" + methodName,parameterTypes);
            return method.invoke(targetBean,args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }


}
