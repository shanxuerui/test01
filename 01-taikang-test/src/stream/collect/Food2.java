package stream.collect;

import java.math.BigDecimal;

/**
 * @className Food
 * @author:ShanXuerui
 * @date 2020/10/15 14:04
 */
public class Food2 {
    String name;
    BigDecimal price;
    String id;
    String address;
    Integer sale;


    public Food2(String name, BigDecimal price, String id, String address, Integer sale) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.address = address;
        this.sale = sale;
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

    public String getId() {
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

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Food2{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", sale=" + sale +
                '}';
    }
}
