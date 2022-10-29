import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int countOfKittens;

    public FelineTest(int countOfKittens) {
        this.countOfKittens = countOfKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getCountOfKittens() {
        return new Object[][]{
                {1},
                {2},
        };
    }

    @Test
    public void TestCatGetFood() throws Exception {
        Feline feline1 = new Feline();
        List<String> actualResult = List.of("Животные", "Птицы", "Рыба");
        List<String> expectedResult = feline1.getFood("Хищник");
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void TestCatGetFamily() throws Exception {
        Feline feline2 = new Feline();
        String actualResult = "Кошачьи";
        String expectedResult = feline2.getFamily();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void TestCatGetKittens() throws Exception {
        Feline feline3 = new Feline();
        int actualResult = 1;
        int expectedResult = feline3.getKittens();
        assertEquals(actualResult, expectedResult);
    }

}
