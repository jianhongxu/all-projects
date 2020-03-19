import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 0:06
 * @Description:
 */
@Data
@ToString
public class Dog {

    private String name;

    private Integer age;

    private String color;

    private Date brithday;

    private BigDecimal money;


    public Dog(String color) {
        this.color = color;
    }
}
