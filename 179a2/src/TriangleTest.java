import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTest {
	
	static double calculateArea(long a, long b, long c) {
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	
	static boolean isRightAngled(long a, long b, long c) {
		return (a*a + b*b == c*c) || (b*b + c*c == a*a) || (a*a + c*c == b*b);
	}
	
	@Nested
	class InvalidTriangleTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"0,0,0", "-1,-1,-1", "-1,2,3", "1,1,2", "-3,-4,-5", "3,1,1", "2147483647,2147483647,0"})
		void properties_of_invalid_triangle(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
				() -> assertEquals("impossible", t.classify(), "invalid triangle classifies as impossible"),
				() -> assertEquals(-1, t.getArea(), "invalid triangle return area -1"),
				() -> assertEquals(-1, t.getPerimeter(), "invalid triangle return perimeter -1"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), "return input lengths in string"),
				() -> assertFalse(t.isEquilateral(), "invalid triangle is not equilateral"),
				() -> assertTrue(t.isImpossible(), "invalid triangle is impossible"),
				() -> assertFalse(t.isIsosceles(), "invalid triangle is not isosceles"),
				() -> assertFalse(t.isRightAngled(), "invalid triangle is not right angled"),
				() -> assertFalse(t.isScalene(), "invalid triangle is not scalene")
			);
		}
	}
	
	@Nested
	class EquilateralTriangleTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"2,2,2", "1,1,1", "2147483647,2147483647,2147483647"})
		void properties_of_equilateral(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
				() -> assertEquals("equilateral", t.classify(), "equilateral classifies as isosceles"),
				() -> assertEquals(TriangleTest.calculateArea(s1, s2, s3), t.getArea(), " equilateral has area same as calculated"),
				() -> assertEquals(s1+s2+s3, t.getPerimeter(), "equilateral perimeter"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), "equilateral return input lengths in string"),
				() -> assertTrue(t.isEquilateral(), "equilateral is equilateral"),
				() -> assertFalse(t.isImpossible(), "equilateral is not impossible"),
				() -> assertTrue(t.isIsosceles(), "equilateral is isosceles"),
				() -> assertFalse(t.isRightAngled(), "equilateral is not right angled"),
				() -> assertFalse(t.isScalene(), "equilateral is not scalene")
			);
		}
	}
	
	
	@Nested
	class PureIsoscelesTriangleTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"2,2,1", "1,2,2", "2,1,2", "2147483647, 2147483647, 1"})
		void properties_of_isosceles(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
					/**
					 * Remarks: Triangle.classify() misspell "isosceles" as "isossceles"
					 */
				() -> assertEquals("isossceles", t.classify(), "pure isosceles classifies as isosceles"),
				() -> assertEquals(TriangleTest.calculateArea(s1, s2, s3), t.getArea(), " pure isosceles area has area same as calculated"),
				() -> assertEquals(s1+s2+s3, t.getPerimeter(), "pure isosceles perimeter"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), "return input lengths in string"),
				() -> assertFalse(t.isEquilateral(), "pure isosceles is not equilateral"),
				() -> assertFalse(t.isImpossible(), "pure isosceles is not impossible"),
				() -> assertTrue(t.isIsosceles(), "pure isosceles is isosceles"),
				() -> assertFalse(t.isRightAngled(), "pure isosceles is not right angled"),
				() -> assertFalse(t.isScalene(), "pure isosceles is not scalene")
			);
		}
	}
	
	@Nested
	class RightAngledTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"3,4,5", "27304196, 27304197, 38613965"})
		void properties_of_equilateral(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
				() -> assertEquals("right-angled", t.classify(), "right angled classifies as right angled"),
				() -> assertEquals(TriangleTest.calculateArea(s1, s2, s3), t.getArea(), "right angled has area same as calculated"),
				() -> assertEquals(s1+s2+s3, t.getPerimeter(), "equilateral perimeter"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), "right angled return input lengths in string"),
				() -> assertFalse(t.isEquilateral(), "right angled is not equilateral"),
				() -> assertFalse(t.isImpossible(), "right angled is not impossible"),
				() -> assertFalse(t.isIsosceles(), "right angled is isosceles"),
				() -> assertEquals(TriangleTest.isRightAngled(s1, s2, s3), t.isRightAngled(), "right angled is right angled"),
				() -> assertFalse(t.isScalene(), "right angled is not scalene")
			);
		}
	}
	
	@Nested
	class CloseToRightAngledTest{
		
		@ParameterizedTest(name = "s1 = {0}, s2 = {1}, s3 = {2}")
		@CsvSource(value = {"1295743693, 1295743692, 1832458304"})
		void properties_of_close_to_right_angled(int s1, int s2, int s3) {
			Triangle t = new Triangle(s1,s2,s3);
			assertAll(
				() -> assertEquals("scalene", t.classify(), "close to right angled classifies as scalene"),
				() -> assertEquals(TriangleTest.calculateArea(s1, s2, s3), t.getArea(), "close to right angled has area same as calculated"),
				() -> assertEquals(s1+s2+s3, t.getPerimeter(), "equilateral perimeter"),
				() -> assertEquals(String.format("%d,%d,%d", s1, s2, s3), t.getSideLengths(), " close to right angled return input lengths in string"),
				() -> assertFalse(t.isEquilateral(), "close to right angled is not equilateral"),
				() -> assertFalse(t.isImpossible(), "close to right angled is not impossible"),
				() -> assertFalse(t.isIsosceles(), "close to right angled is not isosceles"),
				() -> assertEquals(TriangleTest.isRightAngled(s1, s2, s3), t.isRightAngled(), "close to right angled is not right angled"),
				() -> assertTrue(t.isScalene(), "close to right angled is scalene")
			);
		}
	}
	

}