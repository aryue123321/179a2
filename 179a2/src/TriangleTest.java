import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTest {
	
	@Nested
	class InvalidTriangleTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"0,0,0", "-1,-1,-1", "-1,2,3", "1,1,2", "-3,-4,-5", "3,1,1"})
		void properties_of_invalid_triangle(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
				() -> assertEquals("impossible", t.classify(), "invalid triangle classifies as impossible"),
				() -> assertEquals(-1, t.getArea(), "invalid triangle return area -1"),
				() -> assertEquals(-1, t.getPerimeter(), "invalid triangle return perimeter -1"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), "return the same lengths"),
				() -> assertFalse(t.isEquilateral(), "invalid triangle is not equilateral"),
				() -> assertTrue(t.isImpossible(), "invalid triangle is impossible"),
				() -> assertFalse(t.isIsosceles(), "invalid triangle is not isosceles"),
				() -> assertFalse(t.isRightAngled(), "invalid triangle is not isosceles"),
				() -> assertFalse(t.isScalene(), "invalid triangle is not scalene")
			);
		}
	}
	

}