package uebung01Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uebung01.Calculator;

class CalculatorTest {

	Calculator calc;

	@BeforeEach
	void setUp() {
		calc = new Calculator();
	}

	@Test
	void testAdd() {
		assertEquals(20, calc.add(12, 8));
	}

	@Test
	void testSubtract() {
		assertEquals(4, calc.subtract(12, 8));
	}

	@Test
	void testMultiply() {
		assertEquals(20, calc.multiply(4, 5));
	}

	@Test
	void testDivide() {
		assertEquals(0, calc.divide(10, 12));
	}

}
