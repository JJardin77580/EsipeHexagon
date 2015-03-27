package hexalib;

public class Coordinates {
	public final int q;
	public final int r;
	
	public Coordinates(int q,int r) {
		this.q=q;
		this.r=r;
		
	}
	
	public int getx(){
		return q;
	}
	
	public int gety(){
		return r;
	}
	@Override
	public int hashCode() {
		return r - Integer.rotateLeft(q, 16);
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Coordinates c=(Coordinates)obj;
		return ((this.q== c.q) && (this.r==c.r));
	}
	
	
	
}
