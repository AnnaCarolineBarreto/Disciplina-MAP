package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriangleTest {

	// Teste para tri�ngulo Equil�tero: Todos os lados iguais

	@Test
	public void equilateralTriangleHaveEqualSides() throws TriangleException {
		Triangle triangle = new Triangle(2, 2, 2);

		assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
	}

	// Teste para um tri�ngulo is�sceles: Dois lados iguais.

	@Test
	public void testValidIsoscelesTriangle() throws TriangleException {
		Triangle triangle = new Triangle(3, 4, 4);

		assertEquals(TriangleKind.ISOSCELES, triangle.getKind());

	}

	// Teste para um tri�ngulo escaleno: Todos os lados diferentes.

	@Test
	public void testValidScaleneTriangle() throws TriangleException {
		Triangle triangle = new Triangle(3, 4, 5);

		assertEquals(TriangleKind.SCALENE, triangle.getKind());
	}
	

	// N�o permite que tr�s lados iguais a zero sejam especificados, conforme exigido pelas regras geom�tricas.
	
	@Test
	public void testinavlidZeroSides() {
		try {
			new Triangle(0, 0, 0);
			fail("Expected exception");
		} catch (TriangleException e) {
		}
	}

	// Teste para tri�ngulo com lados negativos: Lan�amento da exce��o TriangleException

	@Test
	public void testNegativeSides() {
		try {
			new Triangle(-1, 2, 3);
			fail("Expected exception");
		} catch (TriangleException e) {
		}
	}

	// Teste para um tri�ngulo com lados que violam a desigualdade triangular.

	@Test
	public void testInvalidImpossibleTriangle() {
		assertThrows(TriangleException.class, () -> new Triangle(1, 2, 3));
	}
}
