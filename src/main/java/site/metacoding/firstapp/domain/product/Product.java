package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Integer productid;
    private String productname;
    private Integer productprice;
    private Integer productQty;
    private Timestamp crateAt;
}
