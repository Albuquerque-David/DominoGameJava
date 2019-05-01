package JogoDomino;

public abstract class Jogador {
	public abstract void addPecas(Peca peca);
	public abstract void removePecas(Peca peca);
	public abstract void deletarPontuacao();
	public abstract int getPontuacao();
}
