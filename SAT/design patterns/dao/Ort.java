package dao;

public class Ort {

	protected int ortsID;

	protected int x;
	protected int y;
	protected int z;

	public Ort(int ortsID, int x, int y, int z) {
		super();
		this.ortsID = ortsID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getOrtsID() {
		return ortsID;
	}

	@Override
	public String toString() {
		return "Ort ID: " + this.getOrtsID() + ", x:" + this.getX() + ", y:" + this.getY() + ", z:" + this.getZ();
	}

}
