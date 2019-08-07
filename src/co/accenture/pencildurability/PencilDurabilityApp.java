package co.accenture.pencildurability;

import java.util.Scanner;


import co.accenture.pencildurability.objects.Pencil;

public class PencilDurabilityApp {
	public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	Pencil pencil = new Pencil();
	pencil.setEraserDurability(100);
	pencil.setMaxPointDurability(1000);
	pencil.setPencilLength(10);
	
	pencil.erase(pencil, "bill", "Buffalo bill");
	}
}
