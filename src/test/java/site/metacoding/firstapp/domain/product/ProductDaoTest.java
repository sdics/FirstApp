package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.firstapp.config.MyBatisConfig;

@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void findById_test() {
        // given - ( 컨트롤러에서 받아야 될 것)
        Integer productId = 1;

        // when - ( 테스트 )
        Product productPS = productDao.findById(productId);

        // then - ( 검증 )
        assertEquals("바나나", productPS.getProductName());

    }

    @Test
    public void findAll_test() {
        // given

        // when PS = 영속화 되어있는 데이터를 뜻함
        List<Product> productListPS = productDao.findAll();

        // then
        assertEquals(2, productListPS.size());
    }

    // MyBatis는 REsultSet을 자바 Entity로 변경해줄때 빈생성자만 호출하고 setter가 없어도 값을 매핑해준다.
    @Test
    public void insert_test() {
        // given
        String productname = "수박";
        Integer productPrice = 1000;
        Integer productQty = 100;

        Product product = new Product(productname, productPrice, productQty);

        // when
        int result = productDao.insert(product);

        // then
        assertEquals(1, result);
    } // rollback

    @Test
    public void update_test() {
        // given
        Integer productId = 1;
        String productName = "수박";
        Integer productPrice = 1000;
        Integer productQty = 100;

        Product product = new Product(productName, productPrice, productQty);
        product.setProductId(productId);

        // verify
        Product productPS = productDao.findById(product.getProductId());
        assertTrue(productPS == null ? false : true);

        // when
        // product[id=1, productName="수박", productPrice=1000, productQty=100]
        // productPS [id=1, productName="바나나", productProce= 3000, productQty=98,
        // createdAt=2022-09-29]
        productPS.update(product);
        // productPS [id=1, productName="tnqkr", productProce= 1000, productQty=100,
        // createdAt=2022-09-29]
        int result = productDao.update(productPS);
        // then
        assertEquals(1, result);
    }

    @Test
    public void deleteById_test() {
        // given
        Integer productId = 1;

        // verify
        Product productPS = productDao.findById(productId);
        assertTrue(productPS == null ? false : true);

        // when
        int result = productDao.deleteById(productId);

        // then
        assertEquals(1, result);
    }
}
