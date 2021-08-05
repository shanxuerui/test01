package BigDecimal;

import java.math.BigDecimal;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2021/2/26 10:45
 */
public class Test01 {
    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("0.9185");

        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_UP));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_DOWN));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_CEILING));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_FLOOR));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_HALF_EVEN));

        BigDecimal bigDecimal1 = new BigDecimal("100000");
        BigDecimal bigDecimal2 = new BigDecimal("0.00005");
        BigDecimal bigDecimal11 = new BigDecimal(100000);
        BigDecimal bigDecimal22 = new BigDecimal(0.00005);

        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal11.add(bigDecimal22));
        System.out.println(bigDecimal1.multiply(bigDecimal2));
        System.out.println(bigDecimal11.multiply(bigDecimal22));

    }
}
