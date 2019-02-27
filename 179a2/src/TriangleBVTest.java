import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleBVTest {

  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, true", 
      "0, 2, 2, true", 
      "1, 2, 2, false",
      "2147483647, 1, 5, true",
      
      "-1, -1, 200, true", 
      "0, 0, 2, true", 
      "1, 1, 2, true",
      "2147483647, 2147483647, 5, false",
      
      "-1, -1, -1, true", 
      "0, 0, 0, true", 
      "1, 1, 1, false",
      "2147483647, 2147483647, 2147483647, false",
      
      "3, 4, 5, false",
      "4, 4, 3, false",
      "10, 10, 10, false",
  })
  void test_for_is_impossible(int s1, int s2, int s3, boolean expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.isImpossible());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, false", 
      "0, 2, 2, false", 
      "1, 2, 2, false",
      "2147483647, 1, 5, false",
      
      "-1, -1, 200, false", 
      "0, 0, 2, false", 
      "1, 1, 2, false",
      "2147483647, 2147483647, 5, false",
      
      "-1, -1, -1, false", 
      "0, 0, 0, false", 
      "1, 1, 1, true",
      "2147483647, 2147483647, 2147483647, true",
      
      "3, 4, 5, false",
      "4, 4, 3, false",
      "10, 10, 10, true",
  })
  void test_for_is_equilateral(int s1, int s2, int s3, boolean expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.isEquilateral());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, false", 
      "0, 2, 2, false", 
      "1, 2, 2, true",
      "2147483647, 1, 5, false",
      
      "-1, -1, 200, false", 
      "0, 0, 2, false", 
      "1, 1, 2, true",
      "2147483647, 2147483647, 5, true",
      
      "-1, -1, -1, false", 
      "0, 0, 0, false", 
      "1, 1, 1, true",
      "2147483647, 2147483647, 2147483647, true",
      
      "3, 4, 5, false",
      "4, 4, 3, true",
      "10, 10, 10, true",
      "4, 5, 6, false",
  })
  void test_for_is_isosceles(int s1, int s2, int s3, boolean expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.isIsosceles());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, false", 
      "0, 2, 2, false", 
      "1, 2, 2, false",
      "2147483647, 1, 5, false",
      
      "-1, -1, 200, false", 
      "0, 0, 2, false", 
      "1, 1, 2, false",
      "2147483647, 2147483647, 5, false",
      
      "-1, -1, -1, false", 
      "0, 0, 0, false", 
      "1, 1, 1, false",
      "2147483647, 2147483647, 2147483647, false",
      
      "3, 4, 5, true",
      "4, 4, 3, false",
      "10, 10, 10, false",
      "4, 5, 6, false",
  })
  void test_for_is_right_angled(int s1, int s2, int s3, boolean expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.isRightAngled());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, false", 
      "0, 2, 2, false", 
      "1, 2, 2, false",
      "2147483647, 1, 5, false",
      
      "-1, -1, 200, false", 
      "0, 0, 2, false", 
      "1, 1, 2, false",
      "2147483647, 2147483647, 5, false",
      
      "-1, -1, -1, false", 
      "0, 0, 0, false", 
      "1, 1, 1, false",
      "2147483647, 2147483647, 2147483647, false",
      
      "3, 4, 5, false",
      "4, 4, 3, false",
      "10, 10, 10, false",
      "4, 5, 6, true",
  })
  void test_for_is_scalene(int s1, int s2, int s3, boolean expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.isScalene());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, impossible", 
      "0, 2, 2, impossible", 
      "1, 2, 2, isossceles",
      "2147483647, 1, 5, impossible",
      
      "-1, -1, 200, impossible", 
      "0, 0, 2, impossible", 
      "1, 1, 2, isossceles",
      "2147483647, 2147483647, 5, isossceles",
      
      "-1, -1, -1, impossible", 
      "0, 0, 0, impossible", 
      "1, 1, 1, equilateal",
      "2147483647, 2147483647, 2147483647, equilateal",
      
      "3, 4, 5, right-angled",
      "4, 4, 3, isossceles",
      "10, 10, 10, equilateal",
      "4, 5, 6, scalane",
  })
  void test_for_classify(int s1, int s2, int s3, String expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.classify());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, -1", 
      "0, 2, 2, -1", 
      "1, 2, 2, 0.9682458365518543",
      "2147483647, 1, 5, -1",
      
      "-1, -1, 200, -1", 
      "0, 0, 2, -1", 
      "1, 1, 2, -1",
      "2147483647, 2147483647, 5, 5368709117.5",
      
      "-1, -1, -1, -1", 
      "0, 0, 0, -1", 
      "1, 1, 1, 0.4330127018922193",
      "2147483647, 2147483647, 2147483647, 1.996918621258039e+18",
      
      "3, 4, 5, 6.0",
      "4, 4, 3, 5.562148865321747",
      "10, 10, 10, 43.30127018922193",
      "4, 5, 6, 9.921567416492215",
  })
  void test_for_getArea(int s1, int s2, int s3, double expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.getArea());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, expect= {3}")
  @CsvSource(value = {
      "-1, 100, 200, -1", 
      "0, 2, 2, -1", 
      "1, 2, 2, 5",
      "2147483647, 1, 5, -1",
      
      "-1, -1, 200, -1", 
      "0, 0, 2, -1", 
      "1, 1, 2, -1",
      "2147483647, 2147483647, 5, 4294967299",
      
      "-1, -1, -1, -1", 
      "0, 0, 0, -1", 
      "1, 1, 1, 3",
      "2147483647, 2147483647, 2147483647, 6442450941",
      
      "3, 4, 5, 12",
      "4, 4, 3, 11",
      "10, 10, 10, 30",
      "4, 5, 6, 15",
  })
  void test_for_getPerimeter(int s1, int s2, int s3, long expected) {
    Triangle t1 = new Triangle(s1,s2,s3);
    assertEquals(expected, t1.getPerimeter());
  };
  
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "-1, 100, 200", 
      "0, 2, 2", 
      "1, 2, 2",
      "2147483647, 1, 5",
      
      "-1, -1, 200", 
      "0, 0, 2", 
      "1, 1, 2",
      "2147483647, 2147483647, 5",
      
      "-1, -1, -1", 
      "0, 0, 0", 
      "1, 1, 1",
      "2147483647, 2147483647, 2147483647",
      
      "3, 4, 5",
      "4, 4, 3",
      "10, 10, 10",
      "4, 5, 6",
  })
  void test_for_getter_setter(int s1, int s2, int s3) {
    Triangle t = new Triangle(0,0,0);
    t.setSideLengths(s1, s2, s3);
    assertEquals(String.format("%d,%d,%d", s1, s2,s3), 
        t.getSideLengths());
  };
}
