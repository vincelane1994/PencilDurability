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

}
