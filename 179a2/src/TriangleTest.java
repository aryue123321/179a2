import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class TriangleTest {
	
	/*
	 * 
	 */
	@Nested
	class IsImpossibe_Test{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {
		    "0, 0, 0", 
		    "1, 1, 0", 
		    "-1, -1, -1"})
		void should_return_true(int s1, int s2, int s3) {
		  
			Triangle t = new Triangle(s1,s2,s3);
			assertTrue(t.isImpossible(), "should return true for invalid triangle");
		};
		
    @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
    @CsvSource(value = {"1, 1, 1", "2147483647, 2147483647, 2147483647"})
    void should_return_false(int s1, int s2, int s3) {
      
      Triangle t = new Triangle(s1,s2,s3);
      assertFalse(t.isImpossible(), "should return false for invalid triangle");
    };
	}
	
	/*
	 * 
	 */
	 @Nested
	  class IsIsosceles_Test{
	    
	    @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
	    @CsvSource(value = {
	        "2147483647, 2147483647, 2147483647",  
	        "2147483647, 2147483647, 1",
	        "1, 2147483647, 2147483647",
	        "2147483647, 1, 2147483647",
	        "2, 2, 1",
	        "2, 1, 2",
	        "1, 2, 2",
	        })
	    void should_return_true_for_isIsosceles(int s1, int s2, int s3) {
	      
	      Triangle t = new Triangle(s1,s2,s3);
	      assertTrue(t.isIsosceles(), "should return true for isIsosceles()");
	    };
	    
	    
	    @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
	    @CsvSource(value = {
	        "1, 1, 0", 
	        "2147483647, 2147483647, -1", 
	        "3, 4, 5"})
	    void should_return_false_for_isIsosceles(int s1, int s2, int s3) {
	      
	      Triangle t = new Triangle(s1,s2,s3);
	      assertFalse(t.isIsosceles(), "should return false for isIsosceles()");
	    };
	  }
	 
	 
	 /*
	  * 
	  */
   @Nested
   class Classify_Test{
     
       @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
       @CsvSource(value = {
           "1, 1, 0",
           "0, 0, 0",
           "-3, -4, -5",
           "2147483647, 2147483647, 0",
           "1, 2, 4"
           })
       void should_return_impossible(int s1, int s2, int s3) {
         
         Triangle t = new Triangle(s1,s2,s3);
         assertEquals("impossible", t.classify(), "should return \"impossible\" for classify()");
       };
       
    
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
     @CsvSource(value = {
         "4, 4, 1", 
         "1, 4, 4",
         "4, 1, 4",
         "2147483647, 2147483647, 1",
         "1, 2147483647, 2147483647",
         "2147483647, 1, 2147483647",
         })
     void should_return_issoseles(int s1, int s2, int s3) {
       
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals("isossceles", t.classify(), "should return \"isossceles\" for classify()");
     };
     
     
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
     @CsvSource(value = {
         "3, 4, 5", 
         "4, 3, 5",
         "5, 3, 4",
         })
     void should_return_right_angled(int s1, int s2, int s3) {
       
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals("right-angled", t.classify(), "should return \"right-angled\" for classify()");
     };
   
   
     @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
     @CsvSource(value = {
         "1, 1, 1", 
         "2147483647, 2147483647, 2147483647",
         })
     void should_return_equilateral(int s1, int s2, int s3) {
       
       Triangle t = new Triangle(s1,s2,s3);
       assertEquals("equilateral", t.classify(), "should return \"equilateral\" for classify()");
     };
   }
   
   /*
    * Unit Test for getPrimeter()
    */
    @Nested
     class GetPerimeter_Test{
       
       @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, perimeter= {3}")
       @CsvSource(value = {
           "2147483647, 2147483647, 2147483647, 6442450941",  
           "1, 1, 1, 3",
           })
       void for_valid_triangle(int s1, int s2, int s3, long expected) {
         
         Triangle t = new Triangle(s1,s2,s3);
         assertEquals(expected, t.getPerimeter(), "should return perimeter for valid triangle");
       };
       
       @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
       @CsvSource(value = {
           "0, 0, 0",
           "1, 1, 0", 
           "2147483647, 2147483647, -1", 
           "3, 4, -5"})
       void for_invalid_triangle(int s1, int s2, int s3) {
         
         Triangle t = new Triangle(s1,s2,s3);
         assertEquals(-1, t.getPerimeter(), "should return perimeter -1 for invalid triangle");
       };
     }
    
    /*
     * 
     */
     @Nested
      class GetArea_Test{
        
        @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}, area= {3}")
        @CsvSource(value = {
            "2147483647, 2147483647, 2147483647, 1.996918621258039e+18",  
            "1, 1, 1, 0.4330127018922193",
            "3, 4, 5, 6.0",
            "7, 8, 9, 26.832815729997478"
            })
        void for_valid_triangle(int s1, int s2, int s3, double expected) {
          
          Triangle t = new Triangle(s1,s2,s3);
          assertEquals(expected, t.getArea(), "should return area for valid triangle");
        };
        
        @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
        @CsvSource(value = {
            "0, 0, 0",
            "1, 1, 0",
            "0, 1, 1",
            "1, 0, 1",
            "2147483647, 2147483647, -1", 
            "3, 4, -5",
            "3, 4, 8"})
        void for_invalid_triangle(int s1, int s2, int s3) {
          
          Triangle t = new Triangle(s1,s2,s3);
          assertEquals(-1, t.getArea(), "should return area -1 for invalid triangle");
        };
      }
}
	
	
