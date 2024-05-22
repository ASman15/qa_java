import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionExceptionTest {
    String sex;
    boolean expectedResult;

    @Parameterized.Parameters
    public static Object [][] data() {
        return new Object [][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    public LionExceptionTest(String sex, boolean expectedResult) throws Exception {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }
    @Test
    public void doesHaveMain() throws Exception {

        Lion lion = new Lion (sex, null);
        Assert.assertEquals(expectedResult ,Lion.doesHaveMane());
    }
}
