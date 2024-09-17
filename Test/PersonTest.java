import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1;

    @BeforeEach
    void setUP() {
        p1 = new Person("Kameron", "Patton", "000001", "Esq", 2002);
    }

    @Test
    void fullName() {
        p1.fullName();
        assertEquals("Kameron Patton", p1.fullName());
    }

    @Test
    void formalName() {
        p1.formalName();
        assertEquals("Esq Kameron Patton", p1.formalName());
    }
    
    @Test
    void getAge() {
        p1.getAge();
        assertEquals("22",p1.getAge());
    }

    @Test
    void testEquals() {
        p1.fullName();
        p1.formalName();
        p1.getAge();
    }
}