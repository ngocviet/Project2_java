package model;

public class orderDetail {
    private int id_orderDetail;
    private int order_id;
    private int product_id;
    private int quantity;
    private int status = 1;

    public orderDetail(int id_orderDetail, int order_id, int product_id, int quantity) {
        this.id_orderDetail = id_orderDetail;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public orderDetail() {
    }

    public int getId_orderDetail() {
        return id_orderDetail;
    }

    public void setId_orderDetail(int id_orderDetail) {
        this.id_orderDetail = id_orderDetail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
