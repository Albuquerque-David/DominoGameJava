package JogoDomino;


public class Peca{
	public int parNum[] = new int[2];
	
	public void setparNum(int num1, int num2) {
		this.parNum[0] = num1;
		this.parNum[1] = num2;
	}
	
	public int[] getparNum() {
		return parNum;
	}
	
	public Peca(int num1, int num2) {
		this.parNum[0] = num1;
		this.parNum[1] = num2;
	}

	
	public boolean equals(Object o) {
		if(o instanceof Peca) {
			Peca aux= (Peca)o;
			if(aux.parNum[0]==this.parNum[0]&&aux.parNum[1]==this.parNum[1]) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
