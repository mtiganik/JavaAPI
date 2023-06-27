import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestBasic {

    @Test
    public void TestCompare(){
        Basic basicTest = new Basic();
        int value = basicTest.compare(3,2);
        Assertions.assertEquals(1,value);
    }

    @Test
    @DisplayName("First number is less than the second")
    public void compare2() {
        Basic basicTests = new Basic();
        int value = basicTests.compare(2, 3);
        Assertions.assertEquals(-1, value);
    }


    @Test
    public void TestAdd(){
        Basic basicTest = new Basic();
        int value = basicTest.add(2,3);
        Assertions.assertEquals(5,value);
    }

    @Test
    @DisplayName("Array sorted")
    public void sortArray() {
        Basic basicTests = new Basic();
        int[] array = {5, 8, 3, 9, 1, 6};
        basicTests.sortArray(array);
        Assertions.assertArrayEquals(new int[]{1, 3, 5, 6, 8, 9}, array);
    }


}
