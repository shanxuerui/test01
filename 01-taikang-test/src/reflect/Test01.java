package reflect;

import java.math.BigDecimal;

/**
 * @className Test01
 * @author:ShanXuerui
 * @date 2021/2/26 16:02
 */
public class Test01 {
    public static void main(String[] args) {

        try {
            User user = new User();
            user.setName("zs");
            user.setAge(18);

            Class<User> userClass = User.class;
            User user1 = userClass.newInstance();
            Class<? extends User> aClass = user.getClass();
            User user2 = aClass.newInstance();

//            System.out.println(userClass.getDeclaredMethod("getName").invoke(user));
//            System.out.println(userClass.getMethod("getAge").invoke(user));

            System.out.println(aClass.getDeclaredMethod("getName").invoke(user));
            System.out.println(aClass.getDeclaredMethod("getAge", String.class, BigDecimal.class).invoke(user, "xuerui", new BigDecimal("50")));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
