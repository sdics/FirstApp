package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

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
        assertEquals("바나나", productPS.getProductname());

    }
}
