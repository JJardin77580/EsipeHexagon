package hexalib;

public class Coordinates {
	int q;
	int r;
	
	public Coordinates(int q,int r) {
		this.q=q;
		this.r=r;
		
	}
	
	@Override
	public int hashCode() {
		int premier=31 ;
		return (((q ^ (q>>> 32)) + (r ^ (r >>> 32)))*premier);
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		Coordinates c=(Coordinates)obj;
		return ((this.q== c.q) && (this.r==c.r));
	}
	
	
	
}
