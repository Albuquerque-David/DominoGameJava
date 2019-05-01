	package JogoDomino;
	import java.util.ArrayList;
	
	public class Maquina extends Jogador{
		private String nome;
		private ArrayList pecas = new ArrayList();
		private int pontuacao;
		
		@Override
		public void addPecas(Peca peca) {
			this.pecas.add(peca);
		}
		
		public void setNome(String nome) {
			this.nome=nome;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setPontuacao(int pontuacao) {
			this.pontuacao+=pontuacao;
		}
		
		public void deletarPontuacao() {
			this.pontuacao=0;
		}
		
		public int getPontuacao() {
			return pontuacao;
		}
		
		public void removePecas(Peca aux) {
			this.pecas.remove(aux);
		}
	}
