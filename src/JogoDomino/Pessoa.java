package JogoDomino;
import java.util.ArrayList;
import java.util.List;


public class Pessoa extends Jogador{
	private String nome;
	private ArrayList pecas = new ArrayList();
	private int pontuacao;
	
	
	public ArrayList getPecas() {
		return this.pecas;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addPonto() {
		this.pontuacao+=1;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	
	public void deletarPontuacao() {
		this.pontuacao=0;
	}

	
	public void addPecas(Peca peca) {
		this.pecas.add(peca);
		
	}
	
	public void removePecas(Peca aux) {
		this.pecas.remove(aux);
	}
	
	
}
