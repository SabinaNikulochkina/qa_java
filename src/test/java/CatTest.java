import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void TestOfGetKittens() throws Exception {
        Cat cat1 = new Cat(feline);
        String expectedResult = "Мяу";
        String actualResult = cat1.getSound();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestCatGetFood() throws Exception {
        Cat cat2 = new Cat(feline);
        List<String> actualResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(actualResult);
        List<String> expectedResult = cat2.getFood();
        assertEquals(actualResult, expectedResult);
    }
}
