package JogoDomino;
import java.util.ArrayList;

public class Dorme{
	public ArrayList pecas = new ArrayList();
	
	public void addPecas(Peca peca) {
		this.pecas.add(peca);
		
	}
	
	public void removePecas(Peca aux) {
		this.pecas.remove(aux);
	}
	
}
