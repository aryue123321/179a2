import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {
	
	@Test
	void isImpossibleTest() {
		assertEquals(true, new Triangle(0,0,0).isImpossible(), "A point is not a triangle");
		assertEquals(true, new Triangle(1,1,2).isImpossible(), "A line is not a triangle");
		assertEquals(false, new Triangle(1,1,1).isImpossible(), "Invalid traingle with lengths all zeros ");

	}

}