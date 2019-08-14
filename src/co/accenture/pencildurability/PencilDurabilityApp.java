package co.accenture.pencildurability;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.accenture.pencildurability.objects.Pencil;

public class PencilDurabilityApp {
	public static void main(String[] args) {
		boolean mainMenu = true;
		String written = "";
		String string;
		Scanner scnr = new Scanner(System.in);
		Pencil pencil = Pencil.create(scnr);
		do {
			System.out.println(written);
			System.out.println("===Main menu===\n1. Write\n2. Erase\n3. Sharpen\n4. Create New Pencil\n5. Edit last gap\n6. Exit");
			int userChoice = getInt(scnr);
			scnr.nextLine();
			switch (userChoice) {
			case 1://write
				System.out.println("What would you like to write?");
				string = scnr.nextLine();
				written = Pencil.write(pencil, string, written);
				break;
			case 2://erase
				System.out.println("What would you like to erase?");
				string = scnr.nextLine();
				if(written.contains(string)) {
				written = Pencil.erase(pencil, string, written);
				}else {
					System.out.println("\"" + string + "\"" + " Could not be found");
				}
				break;
			case 3://sharpen
				Pencil.sharpen(pencil);
				System.out.println("Your pencil has been sharpened.");
				break;
			case 4://create new
				pencil = Pencil.create(scnr);
				break;
			case 5://edit
				System.out.println("What would you like to write in the gap?");
				string = scnr.nextLine();
				if(written.contains("  ")) {
					written = Pencil.edit(pencil, string, written);					
				}else {
					System.out.println("Could not find a gap.");
				}
				break;
			case 6://exit
				mainMenu = false;
				break;
			}
		} while (mainMenu);
		scnr.close();

	}

	public static int getInt(Scanner scnr) {
		int numb = 0;
		do {
			try {
				numb = scnr.nextInt();
//				scnr.nextLine();
			} catch (InputMismatchException ex) {
				System.out.println("That was not a valid option please enter a whole number greater than zero");
				scnr.nextLine();
			}
		} while (numb < 1);
		return numb;
	}
}
