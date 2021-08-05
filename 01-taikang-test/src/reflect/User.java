package reflect;

import java.math.BigDecimal;

/**
 * @className User
 * @author:ShanXuerui
 * @date 2021/2/26 16:02
 */
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge(String name, BigDecimal bigDecimal) {
        BigDecimal add = new BigDecimal(String.valueOf(this.age)).add(bigDecimal);

        return name + ":" + add;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
