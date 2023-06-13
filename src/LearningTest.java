import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearningTest {
    Learning obj;
@BeforeEach
public void setup(){
   obj = new Learning();
}
    @Test
    void testCountVowelsAndConsonants() {
        String str = "ae";
        long expectedVowelCount = 2;
        long actualVowelCount = obj.findVowels(str);
        assertEquals(expectedVowelCount, actualVowelCount);

    }

}