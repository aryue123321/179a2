import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class TriangleIdentityTest {
	
	/*
	 * 
	 */
	@Nested
	class Identity_Test{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {
		    "0, 0, 0", 
		    "0, 1, 1", 
		    "1, 0, 1",
		    "1, 1, 0",
		    "2, 3, 0"
		})
		void eq1_with_zero_length(int s1, int s2, int s3) {
		  
			Triangle t = new Triangle(s1,s2,s3);
			assertAll( 
			    () -> assertTrue(t.isImpossible(), "should return true if any length is zero"),
			    () -> assertFalse(t.isEquilateral(), "should return false for isEquilateral() if any length is zero"),
			    () -> assertFalse(t.isIsosceles(), "should return false for isIsosceles() if any length is zero"),
			    () -> assertFalse(t.isRightAngled(), "should return false for isRightAngled() if any length is zero"),
			    () -> assertFalse(t.isScalene(), "should return false for isScalene() if any length is zero")
			);
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
      
      Triangle t = new Triangle(s1,s2,s3);
      assertTrue(t.isImpossible(), "should return true if any length is negative");
    };
    
    //-------------------------------------------------------------------------------------
    @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
    @CsvSource(value = {
        "1, 1, 3", 
        "3, 1, 1", 
        "1, 3, 1",
        "1, 1, 3"
    })
    void eq3_with_one_length_is_greater_than_sum_of_others(int s1, int s2, int s3) {
      
      Triangle t = new Triangle(s1,s2,s3);
      assertTrue(t.isImpossible(), "should return true one of the length is greater than the sum of others");
    };
		
  //-------------------------------------------------------------------------------------
    @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
    @CsvSource(value = {
        "1, 1, 1", 
        "2147483647, 2147483647, 2147483647"
        })
    void eq4_equilateral(int s1, int s2, int s3) {
      
      Triangle t = new Triangle(s1,s2,s3);
      assertFalse(t.isImpossible(), "should return false for equilateral");
    };
	
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "2, 2, 1", 
      "2147483647, 2147483647, 1"
      })
  void eq5_Isoseles(int s1, int s2, int s3) {
    
    Triangle t = new Triangle(s1,s2,s3);
    assertFalse(t.isImpossible(), "should return false for Isoseles");
  };
  
  //-------------------------------------------------------------------------------------
  @ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
  @CsvSource(value = {
      "3, 4, 5", 
      "4, 3, 5",
      "5, 3, 4",
      })
  void eq6_right_angled(int s1, int s2, int s3) {
    
    Triangle t = new Triangle(s1,s2,s3);
    assertFalse(t.isImpossible(), "should return false for Isoseles");
  };
}
	
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
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
  
}
	
	
