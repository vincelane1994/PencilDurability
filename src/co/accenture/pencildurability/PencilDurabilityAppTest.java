package co.accenture.pencildurability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import co.accenture.pencildurability.objects.Pencil;

class PencilDurabilityAppTest {
	Scanner scnr = new Scanner(System.in);

	@Test
	void resetDurability() {
		Pencil pencil = new Pencil();
		pencil.setMaxPointDurability(5000);
		pencil.setPointDurability(4500);
		pencil.setPencilLength(10);
		pencil.sharpen(pencil);
		int actual = pencil.getPointDurability();
		int expected = 5000;
		assertEquals(expected, actual);
	}

	@Test
	void reducePencilLength() {
		Pencil pencil = new Pencil();
		pencil.setPencilLength(10);
		pencil.sharpen(pencil);
		int expected = 9;
		int actual = pencil.getPencilLength();
		assertEquals(expected, actual);
	}

	@Test
	void reducePointDurabilityByChar() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		pencil.write(pencil, "the", "");
		int expected = 7;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}

	@Test
	void doNotReduceDurabilityForWhiteSpace() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		pencil.write(pencil, "the dog", "");
		int expected = 4;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}

	@Test
	void pencilRunsOutOfDura() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(5);
		String written = pencil.write(pencil, "the dog", "");
		String expected = "the do ";
		String actual = written;
		assertEquals(expected, actual);
	}

	@Test
	void writeNewLine() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		String written = pencil.write(pencil, "the\ndog", "");
		String expected = "the\ndog";
		String actual = written;
		assertEquals(expected, actual);
	}

	@Test
	void newLineDoesNotDegradeDura() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		String written = pencil.write(pencil, "the\ndog", "");
		int expected = 4;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}

	@Test
	void upperCaseDegradeByTwo() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		String written = pencil.write(pencil, "T", "");
		int expected = 8;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}

	@Test
	void ifCharIsNotALetter() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(15);
		String written = pencil.write(pencil, "!@#$%^&*()-", "");
		int expected = 4;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}

	@Test
	void canSharpenWithZeroLength() {
		Pencil pencil = new Pencil();
		pencil.setPencilLength(0);
		pencil.sharpen(pencil);
		int expected = 0;
		int actual = pencil.getPencilLength();
		assertEquals(expected, actual);
	}

	@Test
	void cantEraseWithZeroEraser() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(0);
		boolean expected = false;
		boolean actual = pencil.canErase(pencil);
		assertEquals(expected, actual);
	}

	@Test
	void canEraseWithThreeEraser() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(3);
		boolean expected = true;
		boolean actual = pencil.canErase(pencil);
		assertEquals(expected, actual);
	}

	@Test
	void erase() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(3);
		String expected = "buffalo b   ";
		String actual = pencil.erase(pencil, "bill", "buffalo bill");
		assertEquals(expected, actual);
	}

	@Test
	void eraseWithSpace() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(5);
		String expected = "buffal      ";
		String actual = pencil.erase(pencil, "o bill", "buffalo bill");
		assertEquals(expected, actual);
	}

	@Test
	void eraserDuraDoesntChangeWithWhiteSpace() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(10);
		pencil.erase(pencil, "o bill", "buffalo bill");
		int expected = 5;
		int actual = pencil.getEraserDurability();
		assertEquals(expected, actual);
	}

	@Test
	void eraserDoesntHaveEnoughDurability() {
		Pencil pencil = new Pencil();
		pencil.setEraserDurability(4);
		String expected = "buffalo     ";
		String actual = pencil.erase(pencil, "o bill", "buffalo bill");
		assertEquals(expected, actual);
	}

	@Test
	void editFillEmptySpace() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(1000);
		String expected = "An onion a day keeps the doctor away";
		String actual = pencil.edit(pencil, "onion", "An       a day keeps the doctor away");
		assertEquals(expected, actual);
	}

	@Test
	void editOverWords() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(1000);
		String expected = "An artich@k@ay keeps the doctor away";
		String actual = pencil.edit(pencil, "artichoke", "An       a day keeps the doctor away");
		int expectedDura = 1000 - 9;
		int acutalDura = pencil.getPointDurability();
		assertEquals(expected, actual);
		assertEquals(expectedDura, acutalDura);
	}

	@Test
	void createPencilWithParams() {
		Pencil pencil = new Pencil(100, 5, 75);
		assertEquals(75, pencil.getEraserDurability());
		assertEquals(100, pencil.getMaxPointDurability());
		assertEquals(100, pencil.getPointDurability());
		assertEquals(5, pencil.getPencilLength());
	}




}
