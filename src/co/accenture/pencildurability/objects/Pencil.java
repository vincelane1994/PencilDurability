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
	public boolean canErase(Pencil pencil) {
		if(pencil.getEraserDurability() > 0) {
			return true;
		}else {
			return false;
		}
	}
	public String erase(Pencil pencil, String string, String written) {
		for(int i = string.length(); i > 0; i--)
			if(pencil.canErase(pencil)) {
				int index = written.lastIndexOf(string) + (i-1);
		        if(written.charAt(index) == ' ' || written.charAt(index) == '\n') {
			        written = written.substring(0, index) + ' ' + written.substring(index + 1);
			        string = string.substring(0, string.length()-1);
		        } else {
			        written = written.substring(0, index) + ' ' + written.substring(index + 1);
			        string = string.substring(0, string.length()-1);
		        	pencil.setEraserDurability(pencil.getEraserDurability()-1);
		        	
		        }
			}
		return written;
	}
}
