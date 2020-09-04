
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class FirstTest {

    @BeforeEach
    public static void TestStart(){
        System.out.println("Test start");
    }

    @AfterEach
    public static void TestFinished(){
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
    }

    @Test
    public void test1(){
        System.out.println("Test №1");
    }

    @Test
    public void test2(){
        System.out.println("Test №2");
    }

    @Test
    public void test3(){
        System.out.println("Test №3");
    }

    @Test
    public void test4(){
        System.out.println("Test №4");
    }

    @Test
    public void test5(){
        System.out.println("Test №5");
    }
}
