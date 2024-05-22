import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.List;


public class LionTest {
    String sex;
    public LionTest() throws Exception {
    }

    private List<String> expectedFood() {
        return java.util.List.of("Животные", "Птицы", "Рыба");
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    Feline feline = new Feline();
    @Mock
    Lion lion = new Lion("Самец", feline);

    @Test
    public void lionFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
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
    @Test(expected = Exception.class)
    public void doesHaveMainThird() throws Exception {
        Lion lion = new Lion (sex, null);
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка" ,Lion.doesHaveMane());
    }
}


