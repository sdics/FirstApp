package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
    private Timestamp crateAt;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Product() {
    } // MyBatis에게 필요한것 .

    public Product(String productName, Integer productPrice, Integer productQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }

    public void update(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productQty = product.getProductQty();
    }

    public Product(Integer productId) {
        this.productId = productId;

    }
}
