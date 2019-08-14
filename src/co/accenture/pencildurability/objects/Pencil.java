package co.accenture.pencildurability.objects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pencil {
	@Override
	public String toString() {
		return "\nPencil\nMaximum characters at full sharpness=" + maxPointDurability + "\nCharacters left to write=" + pointDurability
				+ "\nAmount of times to can sharpen=" + pencilLength + "\nAmount of characters you can erase=" + eraserDurability + "\n";
	}
	private int maxPointDurability;
	private int pointDurability;
	private int pencilLength;
	private int eraserDurability;
	
	Scanner scnr = new Scanner(System.in);
	public Pencil(int maxPointDurability, int pencilLength, int eraserDurability, int pointDurability) {
		super();
		this.maxPointDurability = maxPointDurability;
		this.pencilLength = pencilLength;
		this.eraserDurability = eraserDurability;
		this.pointDurability = pointDurability;
	}
	public Pencil() {
		this.maxPointDurability = 1000;
		this.pointDurability = maxPointDurability;
		this.eraserDurability = 100;
		this.pencilLength = 7;
	}


	public int getEraserDurability() {
		return eraserDurability;
	}



	public void setEraserDurability(int eraserDurability) {
		this.eraserDurability = eraserDurability;
	}



	public int getMaxPointDurability() {
		return maxPointDurability;
	}



	public void setMaxPointDurability(int maxPointDurability) {
		this.maxPointDurability = maxPointDurability;
	}



	public int getPointDurability() {
		return pointDurability;
	}



	public void setPointDurability(int pointDurability) {
		this.pointDurability = pointDurability;
	}



	public int getPencilLength() {
		return pencilLength;
	}



	public void setPencilLength(int pencilLength) {
		this.pencilLength = pencilLength;
	}



	public static void sharpen(Pencil pencil) {
		if(pencil.getPencilLength() > 0) {
			pencil.setPointDurability(pencil.getMaxPointDurability());
			pencil.setPencilLength(pencil.getPencilLength()-1);
		}else {
			System.out.println("Pencil length is now 0. Please create a new pencil to continue.");
		}
		System.out.println(pencil);
	}
	
	public static String write(Pencil pencil, String string, String written) {
		char[] chars = string.toCharArray();
		for(char character: chars) {
			if(character == ' ') {
				written = written + ' ';
			}else if(character == '\n') {
				written = written + '\n';
			}else if(Character.isUpperCase(character)){
				if(pencil.getPointDurability() > 0) {
					written = written + character;
					pencil.setPointDurability(pencil.getPointDurability()-2);
				}else {
					written = written + ' ';
				}
			}else {
				if(pencil.getPointDurability() > 0) {
					written = written + character;
					pencil.setPointDurability(pencil.getPointDurability()-1);
				}else {
					written = written + ' ';
				}
			}
		}
		System.out.println(pencil);
		return written;
	}
	public boolean canErase(Pencil pencil) {
		if(pencil.getEraserDurability() > 0) {
			return true;
		}else {
			return false;
		}
	}
	public static String erase(Pencil pencil, String string, String written) {
		String string2 = string;
		int index = written.lastIndexOf(string) + (string.length());
		for(int i = string.length(); i > 0; i--)
			if(pencil.canErase(pencil)) {
				index = index -1;
				//If the next letter is a white space.
		        if(written.charAt(index) == ' ' || written.charAt(index) == '\n') {
//			        written = written.substring(0, index) + ' ' + written.substring(index + 1);
			        string2 = string2.substring(0, string.length()-1);
		        } else {
		        //If the next letter is not a white space turn it into a white space and reduce eraser dura by 1
			        written = written.substring(0, index) + ' ' + written.substring(index + 1);
			        string2 = string2.substring(0, string.length()-1);
		        	pencil.setEraserDurability(pencil.getEraserDurability()-1);
		        }
			}
		System.out.println(pencil);
		return written;
	}
	public static String edit(Pencil pencil, String add, String written) {
		int index= 0;
		char[] chars = add.toCharArray();
		if(written.contains("  ")) {
			index = written.indexOf("  ");
			System.out.println(index);
			for(int i = 0; i < chars.length; i++) {
				if(written.charAt(index) == ' ' && pencil.pointDurability > 0) {
					written = written.substring(0, index) + chars[i] + written.substring(index+1);
				}else if (pencil.pointDurability > 0){
					written = written.substring(0, index) + '@' + written.substring(index + 2);
				}
				pencil.setPointDurability(pencil.getPointDurability()-1);
				index++;
			}
			
		}
		System.out.println(pencil);
		return written;
	}
	public static Pencil create(Scanner scnr) {
		Pencil pencil = new Pencil();
		boolean eraserSet = false;
		boolean duraSet = false;
		boolean lengthSet= false;
		do {
			System.out.println("How many characters should your eraser be able to erase?");
			try {
				pencil.setEraserDurability(getInt(scnr));
				eraserSet = true;
			} catch (InputMismatchException ex) {
				System.out.println("That was not a valid option please enter a whole number greater than zero");
			}
			scnr.nextLine();
		} while  (!eraserSet);
		do {
			System.out.println("How many characters should your your graphite tip write?");
			try {
				pencil.setMaxPointDurability(getInt(scnr));
				pencil.setPointDurability(pencil.getMaxPointDurability());
				duraSet = true;
			} catch (InputMismatchException ex) {
				System.out.println("That was not a valid option please enter a whole number greater than zero");
			}
			scnr.nextLine();
		} while  (!duraSet);
		do {
			System.out.println("How many times can you sharpen your pencil?");
			try {
				pencil.setPencilLength(getInt(scnr));
				lengthSet = true;
			} catch (InputMismatchException ex) {
				System.out.println("That was not a valid option please enter a whole number greater than zero");
			}
			scnr.nextLine();
		} while  (!lengthSet);
		return pencil;
	}
	public Pencil createDefault() {
		Pencil pencil = new Pencil();
		return pencil;
	}
	public static int getInt(Scanner scnr) {
		int numb = 0;
		do {
			System.out.println("Enter a whole number greater than zero");
			try {
				numb = scnr.nextInt();
//				scnr.nextLine();
			} catch (InputMismatchException ex) {
				System.out.println("Sorry but that was not a valid option!");
				scnr.nextLine();
			}
		} while (numb < 1);
		return numb;
	}
}

