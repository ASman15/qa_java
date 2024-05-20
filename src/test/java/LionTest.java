import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    String sex;
    boolean expectedResult;
    private List<String> expectedFood() {
        return java.util.List.of("Животные", "Птицы", "Рыба");
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    Feline feline = new Feline();
    @Mock
    Lion lion = new Lion("Самец", feline);

    @Parameterized.Parameters
    public static Object [][] data() {
        return new Object [][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    public LionTest(String sex, boolean expectedResult) throws Exception {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Test
    public void doesHaveMain() throws Exception {

        Lion lion = new Lion (sex, null);
        Assert.assertEquals(expectedResult ,Lion.doesHaveMane());
    }

    @Test
    public void lionFoodTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood());
        List <String> lionFood = lion.getFood();
        Assert.assertEquals(expectedFood(), lionFood);
    }
    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion ("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int lionGetKittens = lion.getKittens();
        Assert.assertEquals(1, lionGetKittens);
    }

}


