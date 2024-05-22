import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private List<String> expectedFood() {
        return List.of("Животные", "Птицы", "Рыба");
    }
    private int kittensCount = 1;

    @Mock
    Feline feline = new Feline();

    @Test
    public void felineFoodTest() throws Exception {
        Feline feline = new Feline();
        List <String> felineFood = feline.eatMeat();
        Assert.assertEquals(expectedFood(), felineFood);
    }

    @Test
    public void felineGetKittensTest() {
        feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(kittensCount);
    }
    @Test
    public void felineGetKittenTest() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
}
