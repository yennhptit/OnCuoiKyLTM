package RMI;

import java.io.Serializable;

public class Order implements Serializable {
    //String id, String customerCode, String orderDate, String shippingType
    private static final long serialVersionUID = 20241132L;
    public String id,customerCode,orderDate,shippingType, orderCode;

    public Order(String id, String customerCode, String orderDate, String shippingType, String orderCode) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
        this.orderCode = orderCode;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", shippingType='" + shippingType + '\'' +
                '}';
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    //    Bắt đầu bằng hai ký tự đầu của shippingType, viết in hoa.
//•	Kế đến là ba ký tự cuối của customerCode.
//•	Cuối cùng là ngày và tháng từ orderDate (theo định dạng "ddMM").
//    Ví dụ: Nếu đơn hàng có mã khách hàng là "C123456", ngày đặt hàng là "2023-10-05", và loại giao hàng là "Express",
//    thì mã orderCode sẽ là "EX4560510".

    public void changeorderCode()
    {
        String ans = "";
        System.out.println(shippingType);
        ans = shippingType.substring(0, 2);
        System.out.println(ans);
        ans  = ans.toUpperCase();
        System.out.println(ans);
        ans += customerCode.charAt(customerCode.length() - 3);
        ans += customerCode.charAt(customerCode.length() - 2);
        ans += customerCode.charAt(customerCode.length() - 1);
        String[] arr = orderDate.split("-");
        ans += arr[2];
        ans += arr[1];
        orderCode = ans;

    }
}
