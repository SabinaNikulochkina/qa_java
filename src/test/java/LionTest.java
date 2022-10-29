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
public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getGender() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void TestOfGetKittens() throws Exception {
        Lion lion1 = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        assertEquals(expectedResult, lion1.getKittens());
    }

    @Test
    public void TestOfDoesHaveMane() throws Exception {
        Lion lion2 = new Lion(sex, feline);
        boolean actualResult = lion2.doesHaveMane();
        boolean expectedResult = hasMane;
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void incorrectGender() throws Exception {
        Lion lion3 = new Lion("Мальчик", feline);
        String actualResult = "Используйте допустимые значения пола животного - самец или самка";
        boolean expectedResult = lion3.doesHaveMane();
        assertEquals(actualResult, expectedResult);
    }

   @Test
   public void TestGetFood() throws Exception {
        Lion lion4 = new Lion("Самец", feline);
        List<String> actualResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(actualResult);
        List<String> expectedResult = lion4.getFood();
        assertEquals(actualResult, expectedResult);
   }
}
