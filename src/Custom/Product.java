package Custom;

import javax.swing.Icon;

public class Product {

    public Product(String id, String name, Icon img, String price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(Icon img) {
        this.img = img;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Icon getImg() {
        return img;
    }

    public String getPrice() {
        return price;
    }
    String id, name, price;
    Icon img;
}
