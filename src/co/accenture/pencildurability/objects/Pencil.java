package co.accenture.pencildurability.objects;

public class Pencil {
	private int maxPointDurability;
	private int pointDurability;
	private int pencilLength;
	private int eraserDurability;
	
	
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
		return written;
		
	}
}
