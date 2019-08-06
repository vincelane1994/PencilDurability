package co.accenture.pencildurability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import co.accenture.pencildurability.objects.Pencil;

class PencilDurabilityAppTest {

	@Test
	void resetDurability() {
		Pencil pencil = new Pencil();
		pencil.setMaxPointDurability(5000);
		pencil.setPointDurability(4500);
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
		pencil.write(pencil, "the");
		int expected = 7;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}
	@Test
	void doNotReduceDurabilityForWhiteSpace() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(10);
		pencil.write(pencil, "the dog");
		int expected = 4;
		int actual = pencil.getPointDurability();
		assertEquals(expected, actual);
	}
	@Test
	void pencilRunsOutOfDura() {
		Pencil pencil = new Pencil();
		pencil.setPointDurability(5);
		String written = pencil.write(pencil, "the dog");
		String expected = "the do ";
		String actual = written;
		System.out.println(written);
		assertEquals(expected, actual);
	}

}
