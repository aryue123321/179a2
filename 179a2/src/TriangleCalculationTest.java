import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleCalculationTest {

  /*
   * Unit Test for getPrimeter()
   */
   @Nested
    class GetPerimeter_Test{
      
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "0, 0, 0", 
         "0, 1, 1", 
         "1, 0, 1",
         "1, 1, 0",
         "2, 3, 0"
     })
     void eq1_with_zero_length(int s1, int s2, int s3) {
       String condition = "any length is zero";
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(-1, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     }
       
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
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(-1, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
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
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(-1, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
       
     //-------------------------------------------------------------------------------------
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "1, 1, 1, 3", 
         "2147483647, 2147483647, 2147483647, 6442450941"
         })
     void eq4_equilateral(int s1, int s2, int s3, long expected) {
       String condition = "equilateral";
       Triangle t = new Triangle(s1,s2,s3);    
       assertEquals(expected, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
     
     //-------------------------------------------------------------------------------------
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "2, 2, 1, 5", 
         "2147483647, 2147483647, 1, 4294967295"
         })
     void eq5_isoseles(int s1, int s2, int s3, long expected) {
       String condition = "isoseles";
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(expected, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
     
     //-------------------------------------------------------------------------------------
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "3, 4, 5, 12", 
         "4, 3, 5, 12",
         "5, 3, 4, 12",
         })
     void eq6_right_angled(int s1, int s2, int s3, long expected) {
       String condition = "right angled";
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(expected, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
     
     //-------------------------------------------------------------------------------------
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "3, 5, 7, 15", 
         "2147483647, 214748364, 2147480000, 4509712011",
         "2147483647, 2147483646, 3, 4294967296",
         })
     void eq7_scalene(int s1, int s2, int s3, long expected) {
       String condition = "scalene";
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(expected, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
     
     //-------------------------------------------------------------------------------------
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
     @CsvSource(value = {
         "1, 1, 2", 
         "500000, 500000, 1000000",
         "1,2,3"
         })
     void boundary_one_of_the_length_equal_to_sum_of_others(int s1, int s2, int s3) {
       String condition = "scalene";
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals(-1, t.getPerimeter(), "test for <getPerimeter()> if " + condition);
     };
   }
   
   /*
    * Unit Test for getArea()
    */
    @Nested
     class GetArea_Test{
       
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
      @CsvSource(value = {
          "0, 0, 0", 
          "0, 1, 1", 
          "1, 0, 1",
          "1, 1, 0",
          "2, 3, 0"
      })
      void eq1_with_zero_length(int s1, int s2, int s3) {
        String condition = "any length is zero";
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(-1, t.getArea(), "test for <getArea()> if " + condition);
      }
        
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
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(-1, t.getArea(), "test for <getArea()> if " + condition);
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
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(-1, t.getArea(), "test for <getArea()> if " + condition);
      };
        
      //-------------------------------------------------------------------------------------
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
      @CsvSource(value = {
          "1, 1, 1, 0.4330127018922193", 
          "2147483647, 2147483647, 2147483647, 1.996918621258039e+18"
          })
      void eq4_equilateral(int s1, int s2, int s3, double expected) {
        String condition = "equilateral";
        Triangle t = new Triangle(s1,s2,s3);    
        assertEquals(expected, t.getArea(), "test for <getArea()> if " + condition);
      };
      
      //-------------------------------------------------------------------------------------
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
      @CsvSource(value = {
          "2, 2, 1, 0.9682458365518543", 
          "2147483647, 2147483647, 1, 1073741823.5"
          })
      void eq5_isoseles(int s1, int s2, int s3, double expected) {
        String condition = "isoseles";
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(expected, t.getArea(), "test for <getArea()> if " + condition);
      };
      
      //-------------------------------------------------------------------------------------
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
      @CsvSource(value = {
          "3, 4, 5, 6", 
          "4, 3, 5, 6",
          "5, 3, 4, 6",
          })
      void eq6_right_angled(int s1, int s2, int s3, double expected) {
        String condition = "right angled";
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(expected, t.getArea(), "test for <getArea()> if " + condition);
      };
      
      //-------------------------------------------------------------------------------------
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
      @CsvSource(value = {
          "3, 5, 7, 6.49519052838329", 
          "2147483647, 214748364, 2147480000, 2.3029569313718573e+17",
          "2147483647, 2147483646, 3, 3037000497.854729",
          })
      void eq7_scalene(int s1, int s2, int s3, double expected) {
        String condition = "scalene";
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(expected, t.getArea(), "test for <getArea()> if " + condition);
      };
      
      //-------------------------------------------------------------------------------------
      @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
      @CsvSource(value = {
          "1, 1, 2", 
          "500000, 500000, 1000000",
          "1,2,3"
          })
      void boundary_one_of_the_length_equal_to_sum_of_others(int s1, int s2, int s3) {
        String condition = "scalene";
        Triangle t = new Triangle(s1,s2,s3);
        assertEquals(-1, t.getArea(), "test for <getArea()> if " + condition);
      };
    }

}
