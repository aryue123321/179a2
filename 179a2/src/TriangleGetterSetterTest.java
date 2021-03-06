import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleGetterSetterTest {

  private Triangle t = new Triangle(0,0,0);
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "0, 0, 0", 
      "0, 1, 1", 
      "1, 0, 1",
      "1, 1, 0",
      "2, 3, 0"
  })
  void eq1_with_zero_length(int s1, int s2, int s3) {
    String condition = "any length is zero";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "-1, -1, -1", 
      "-1, 1, 1", 
      "1, -1, 1",
      "1, 1, -1"
  })
  void eq2_with_negative_length(int s1, int s2, int s3) {
    String condition = "any length is negative";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
    
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "1, 1, 3", 
      "3, 1, 1", 
      "1, 3, 1",
      "1, 1, 3",
      "2147483647, 1, 2",
      "1, 2147483647, 2",
      "2, 1, 2147483647"
  })
  void eq3_with_one_length_is_greater_than_sum_of_others(int s1, int s2, int s3) {
    String condition = "one of the length is greater than the sum of others";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
    
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "1, 1, 1", 
      "2147483647, 2147483647, 2147483647"
      })
  void eq4_equilateral(int s1, int s2, int s3) {
    String condition = "equilateral";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "2, 2, 1", 
      "2147483647, 2147483647, 1"
      })
  void eq5_isoseles(int s1, int s2, int s3) {
    String condition = "isoseles";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "3, 4, 5", 
      "4, 3, 5",
      "5, 3, 4",
      })
  void eq6_right_angled(int s1, int s2, int s3) {
    String condition = "right angled";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "3, 5, 7", 
      "2147483647, 214748364, 2147480000",
      "2147483647, 2147483646, 3",
      })
  void eq7_scalene(int s1, int s2, int s3) {
    String condition = "scalene";
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "1, 1, 2", 
      "500000, 500000, 1000000",
      "1,2,3"
      })
  void boundary_one_of_the_length_equal_to_sum_of_others(int s1, int s2, int s3) {
    String condition = "scalene";
    Triangle t = new Triangle(s1,s2,s3);
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths(), 
        "test for <getSideLengths()> after <setSideLengths()> if " + condition);
  };
}

