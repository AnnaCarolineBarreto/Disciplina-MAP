package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriangleTest {

	// Teste para triângulo Equilátero: Todos os lados iguais

	@Test
	public void equilateralTriangleHaveEqualSides() throws TriangleException {
		Triangle triangle = new Triangle(2, 2, 2);

		assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
	}

	// Teste para um triângulo isósceles: Dois lados iguais.

	@Test
	public void testValidIsoscelesTriangle() throws TriangleException {
		Triangle triangle = new Triangle(3, 4, 4);

		assertEquals(TriangleKind.ISOSCELES, triangle.getKind());

	}

	// Teste para um triângulo escaleno: Todos os lados diferentes.

	@Test
	public void testValidScaleneTriangle() throws TriangleException {
		Triangle triangle = new Triangle(3, 4, 5);

		assertEquals(TriangleKind.SCALENE, triangle.getKind());
	}
	

	// Não permite que três lados iguais a zero sejam especificados, conforme exigido pelas regras geométricas.
	
	@Test
	public void testinavlidZeroSides() {
		try {
			new Triangle(0, 0, 0);
			fail("Expected exception");
		} catch (TriangleException e) {
		}
	}

	// Teste para triângulo com lados negativos: Lançamento da exceção TriangleException

	@Test
	public void testNegativeSides() {
		try {
			new Triangle(-1, 2, 3);
			fail("Expected exception");
		} catch (TriangleException e) {
		}
	}

	// Teste para um triângulo com lados que violam a desigualdade triangular.

	@Test
	public void testInvalidImpossibleTriangle() {
		assertThrows(TriangleException.class, () -> new Triangle(1, 2, 3));
	}
}
