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
}
