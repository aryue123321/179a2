import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {
	
	@Test
	void isImpossibleTest() {
		assertEquals(true, new Triangle(0,0,0).isImpossible(), "A point is not a triangle");
		assertEquals(true, new Triangle(1,1,2).isImpossible(), "A line is not a triangle");
		assertEquals(true, new Triangle(-1,1,1).isImpossible(), "A triangle cannot has negative length");
		assertEquals(true, new Triangle(3,1,1).isImpossible(), "length a > b+c is not a triangle");
		assertEquals(true, new Triangle(1,3,1).isImpossible(), "length b > a+c is not a triangle");
		assertEquals(true, new Triangle(1,1,3).isImpossible(), "length c > a+b is not a triangle");

	}

}