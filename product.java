package model;

public class product {
    private int id_product;
    private String name;
    private float price;
    private String img;
    private int position;
    private int status = 1;

    public product() {
    }

    public product(int id_product, String name, float price, String img, int position) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.img = img;
        this.position = position;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "product{" + "id_product=" + id_product + ", name=" + name + ", price=" + price + ", img=" + img + ", position=" + position + '}';
    }
    
}
