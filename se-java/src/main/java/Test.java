import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 0:07
 * @Description:java反射测试
 */
public class Test {


    public static void main(String[] args) throws Exception {

        Dog dog = new Dog("red");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("NAME","中国田园狗");
        map.put("AGE",12);
        map.put("COLOR","黑色");
        map.put("BRITHDAY",new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-19"));
        map.put("MONEY",new BigDecimal("123.68"));

        Field[] declaredFields = dog.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class type = declaredField.getType();
            System.out.println("是否是String类型的变量:"+(type==String.class));
            System.out.println(declaredField.getType());

            //设置可以访问权限
            declaredField.setAccessible(true);

             //循环所有的值
            System.out.println(declaredField.getName().toUpperCase());
            for (String o : map.keySet()) {
                if(o.equals(declaredField.getName().toUpperCase())){
                    declaredField.set(dog, map.get(o));
                }
            }
        }

        System.out.println(dog);
    }

}
