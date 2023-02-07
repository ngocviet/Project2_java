package model;

import java.sql.Date;

public class order {
    private int id_order;
    private Date createDate;
    private float totalPrice;
    private String selers;
    private int status = 1;

    public order() {
    }

    public order(int id_order, Date createDate, float totalPrice, String selers) {
        this.id_order = id_order;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.selers = selers;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSelers() {
        return selers;
    }

    public void setSelers(String selers) {
        this.selers = selers;
    }

}
