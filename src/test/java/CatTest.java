import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private List <String> expectedFood() {
        return List.of("Животные", "Птицы", "Рыба");
    }

    @Mock
    Feline feline = new Feline();
    @Mock
    Cat cat = new Cat(feline);


    @Test
    public void getSoundTest() {
        String returnCatGetSound = cat.getSound();
        Assert.assertEquals("Мяу", returnCatGetSound);
    }

    @Test
    public void catFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood());
        List <String> allCatFood = cat.getFood();
        Assert.assertEquals(expectedFood(), allCatFood);

    }

}
