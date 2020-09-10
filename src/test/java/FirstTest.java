import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    @BeforeEach
    public void TestStart(){
        System.out.println("Test start");
    }

    @AfterEach
    public void TestFinished(){
        System.out.println("Test finished");
    }

    @BeforeAll
    public static void Started(){
        System.out.println("FirstTest class started");
    }

    @AfterAll
    public static void Finished(){
        System.out.println("All tests in FirstTest finished");
    }

    @Test
    public void myTest() {
        System.out.println("My first autotest running");
        assertEquals(1,1/0);
    }

    @Test
    public void test1(){
        System.out.println("Test №1");
        assertEquals(4, 2+2);
    }

    @Test
    public void test2(){
        System.out.println("Test №2");
        assertEquals(5, 2+2);
    }

    @Test
    public void test3(){
        System.out.println("Test №3");
        assertTrue(2+2==4);
    }

    @Test
    public void test4(){
        System.out.println("Test №4");
        assertTrue(2+2==5);
    }

    @Test
    public void test5(){
        System.out.println("Test №5");
        Assertions.assertAll("",
                () -> assertEquals(1, 1/0),
                () -> assertEquals(4, 2+2),
                () -> assertEquals(5, 2+2),
                () -> assertTrue(2+2==4),
                () -> assertTrue(2+2==5));

    }
}
