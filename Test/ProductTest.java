import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product p1;

    @BeforeEach
    void setUP(){
        p1 = new Product("Knife", "Silver sharp object","000001",5.99);
    }

    @Test
    void fullProduct() {
        p1.fullProduct();
        assertEquals("Knife Silver sharp object 5.99", p1.fullProduct());
    }
    @Test
    void testEquals() {
        p1.fullProduct();
    }
}
