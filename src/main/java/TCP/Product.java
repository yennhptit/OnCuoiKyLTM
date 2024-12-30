package TCP;

import java.io.Serializable;

public class Product implements Serializable {
    //    id int, name String, price double, int discount
    private static final long serialVersionUID = 20231107;
    public int id;
    public String name;
    public double price;
    public int discount;

    public Product(int id, String name, double price, int discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
//    bằng tổng các chữ số trong phần nguyên của giá sản phẩm (price)
    public void changeDiscount()
    {
        int nguyen = (int) price;
        String str = String.valueOf(nguyen);
        int res = 0;
        for (char c : str.toCharArray())
        {
            System.out.println(c);
            res += c - '0';
            System.out.println(res);
        }
        discount = res;
    }
}
