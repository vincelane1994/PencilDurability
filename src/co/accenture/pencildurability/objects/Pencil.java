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
		pencil.setPointDurability(pencil.getMaxPointDurability());
		pencil.setPencilLength(pencil.getPencilLength()-1);
	}
	
	public static void write(Pencil pencil, String string) {
		char[] chars = string.toCharArray();
		for(char character: chars) {
			if(character != ' ') {
				if(pencil.getPointDurability() > 0) {
					System.out.print(character);
					pencil.setPointDurability(pencil.getPointDurability()-1);
				}else {
					System.out.print('u');
				}
			}else if(character == ' ') {
				System.out.print(' ');
			}
		}
		
	}
}
