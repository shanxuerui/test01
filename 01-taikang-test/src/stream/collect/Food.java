package stream.collect;

import java.math.BigDecimal;

/**
 * @className Food
 * @author:ShanXuerui
 * @date 2020/10/15 14:04
 */
public class Food {
    String name;
    BigDecimal price;
    String id;
    String address;


    public Food(String name, BigDecimal price, String id, String address) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String
    getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Food() {
    }
}
