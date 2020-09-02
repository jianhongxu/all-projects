import com.alibaba.fastjson.JSONObject;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/9/2 15:10
 * @Description:
 */
public class FastJsonTest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","xujianhong");
        jsonObject.put("age",85);

        JSONObject address = new JSONObject();
        address.put("city","重庆市");
        jsonObject.put("address", address);

        System.out.println(jsonObject);
    }
}
