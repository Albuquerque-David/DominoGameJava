package JogoDomino;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		int aux=0;
		int aux2=0;
		int aux3=0;
		int cont=28;
		int vencedor=0;
		int primeira=0;
		int escolha=0;
		int jogada=0;
		Peca pecaaux;
		Peca pecaaux2;
		
		//classe para sortear numeros
		Random gerador = new Random();
		
		//array de jogadores
		Pessoa jogador[] = new Pessoa[4];
		
		//os 4 jogadores
		jogador[0] = new Pessoa();
		jogador[1] = new Pessoa();
		jogador[2] = new Pessoa();
		jogador[3] = new Pessoa();
		Maquina maquina1 = new Maquina();
		Dorme dorme = new Dorme();
		ArrayList mesa = new ArrayList();
		
		
		int controle=-1;
		int numJogadores=0;
		ArrayList todasPecas = new ArrayList();
		Scanner read = new Scanner(System.in);
		
		while(controle!=0) {
			System.out.println("-----------------------------------------------");
			System.out.println("!!!!!SUPER DOMINÓ ADVENTURES!!!!!!\n");
			System.out.println("Pressione 1 para jogar contra a máquina.");
			System.out.println("Pressione 2 para jogar contra jogadores localmente.");
			System.out.println("Pressione 3 para ver a pontuação dos jogadores.");
			System.out.println("Pressione 0 para sair."); 
			System.out.println("-----------------------------------------------");
			controle = read.nextInt();
			switch(controle) {
				case 0: //sair do jogo
					break; 
				case 1: //jogar contra a máquina
					System.out.println();
					System.out.println("[Em desenvolvimento. Aguarde a próxima atualização para jogar contra a máquina.]");
					System.out.println();
					break; //fim da opção jogar contra máquina
				case 2: //jogar contra jogadores
					System.out.println("Selecione a quantidade de jogadores (2-4).\n");
					
					while(numJogadores!=2&&numJogadores!=3&&numJogadores!=4) { //verificar se foram inseridos entre 2 e 4 jogadores
						numJogadores=read.nextInt();
						if(!(numJogadores==2||numJogadores==3||numJogadores==4))
							System.out.println("Digite um número entre 2-4");
					}
					
					for(int i=0;i<7;i++) { //gera todas as peças do dominó
						for(int j=i;j<7;j++) {
							pecaaux = new Peca(i,j);
							todasPecas.add(pecaaux);
						}
					}
					
					aux=0;
					
					while(aux!=7) { //distribui as peças para os jogadores
						aux2=gerador.nextInt(cont);
						pecaaux = (Peca)todasPecas.get(aux2);
						jogador[0].addPecas(pecaaux);
						todasPecas.remove(aux2);
						cont--;
						
						aux2=gerador.nextInt(cont);
						pecaaux = (Peca)todasPecas.get(aux2);
						jogador[1].addPecas(pecaaux);
						todasPecas.remove(aux2);
						cont--;
						
						
						if(numJogadores==3) { //se houver 3 jogadores, distribui para o jogador 3
							aux2=gerador.nextInt(cont);
							pecaaux = (Peca)todasPecas.get(aux2);
							jogador[2].addPecas(pecaaux);
							todasPecas.remove(aux2);
							cont--;
						}
						if(numJogadores==4) { //se houver 4 jogadores, distribui para o jogador 3 e 4
							aux2=gerador.nextInt(cont);
							pecaaux = (Peca)todasPecas.get(aux2);
							jogador[2].addPecas(pecaaux);
							todasPecas.remove(aux2);
							cont--;
							aux2=gerador.nextInt(cont);
							pecaaux = (Peca)todasPecas.get(aux2);
							jogador[3].addPecas(pecaaux);
							todasPecas.remove(aux2);
							cont--;
						}
						aux++;
					}
					
					if(!todasPecas.isEmpty()) { //verifica se sobraram peças
						dorme.pecas=todasPecas; //coloca o restante das peças no dorme
					}
					
					while(vencedor==0) { //enquanto não houver vencedor, repete o bloco de jogadas
						jogada=0;
						System.out.println();
						if(aux3==numJogadores)
							aux3=0;
						aux3++;
						if(primeira==0) { //mesa vazia, primeira jogada
							System.out.println("[Vez do jogador 1. Mesa vazia. Jogue qualquer peça.]\n");
							primeira=-1;
							todasPecas=jogador[0].getPecas();
							
							for(int i=0; i<todasPecas.size();i++) { //mostra todas as peças do jogador
								pecaaux=(Peca)todasPecas.get(i);
								int [] parNumaux = pecaaux.getparNum();
								System.out.print(i+1 + ". ");
								System.out.print("|" + parNumaux[0] + "|");
								System.out.println("  |" + parNumaux[1] + "|");
								
							}
							
							escolha=read.nextInt();
							mesa.add((Peca)todasPecas.get(escolha-1));
							pecaaux=(Peca)todasPecas.get(escolha-1);
							jogador[0].removePecas(pecaaux);
						
						}
						else {
							
							Thread.sleep(1000);
							
							System.out.println("Vez do jogador "+(aux3)+".\n");
							todasPecas=jogador[aux3-1].getPecas();
							while(jogada!=1) {
								System.out.println("-----------------------MESA------------------------");
								for(int i=0; i<mesa.size();i++) { //mostra todas as peças da mesa
									pecaaux=(Peca)mesa.get(i);
									int [] parNumaux = pecaaux.getparNum();
									System.out.print("|" + parNumaux[0] + "|");
									System.out.print("|" + parNumaux[1] + "| ");
								}
								System.out.println();
								System.out.println("-----------------------MESA------------------------\n");
								
							for(int i=0; i<todasPecas.size();i++) { //mostra todas as peças do jogador
								pecaaux=(Peca)todasPecas.get(i);
								int [] parNumaux = pecaaux.getparNum();
								System.out.print(i+1 + ". ");
								System.out.print("|" + parNumaux[0] + "|");
								System.out.println("|" + parNumaux[1] + "|");
								if(i==todasPecas.size()-1)
									System.out.println("0. Comprar peça do dorme.");
							}
							
							escolha=read.nextInt(); //escolha da peça que irá jogar ou se vai comprar do dorme
							
							if(escolha!=0) {
								pecaaux=(Peca)todasPecas.get(escolha-1);
								pecaaux2=(Peca)mesa.get(0);
								if(pecaaux.parNum[0]==pecaaux2.parNum[0]) { //compara com peça na esquerda da mesa
									jogada=1;
									jogador[aux3-1].removePecas(pecaaux);
									pecaaux.parNum[0]=pecaaux.parNum[1];
									pecaaux.parNum[1] = -1;
									mesa.add(0, pecaaux);
								}
								else {
	
										if(pecaaux.parNum[1]==pecaaux2.parNum[0]) { //compara com peça na esquerda da mesa
											jogada=1;
											jogador[aux3-1].removePecas(pecaaux);
											pecaaux.parNum[1] = -1;
											mesa.add(0, pecaaux);
										}
										else {
	
												pecaaux=(Peca)todasPecas.get(escolha-1); //peça na direita da mesa
												pecaaux2=(Peca)mesa.get(mesa.size()-1);
	
													if(pecaaux.parNum[0]==pecaaux2.parNum[1]) {
														jogada=1;
														jogador[aux3-1].removePecas(pecaaux);
														pecaaux.parNum[0] = -1;
														mesa.add(pecaaux);
													}
													else {
	
															if(pecaaux.parNum[1]==pecaaux2.parNum[1]) { //peça na direita da mesa
																jogada=1;
																jogador[aux3-1].removePecas(pecaaux);
																pecaaux.parNum[1]=pecaaux.parNum[0];
																pecaaux.parNum[0] = -1;
																mesa.add(pecaaux);
															} 
															else { //peça invalida
																System.out.println("[PEÇA INVALIDA!]\n");
															}
														}
													}
												}
								}
							
							
							else { //comprar do dorme
								if(!(dorme.pecas.isEmpty())) { //verificar se o dorme está vazio
								for(int i=0; i<dorme.pecas.size();i++) { //mostra todas as peças da mesa
									pecaaux=(Peca)dorme.pecas.get(i);
									int [] parNumaux = pecaaux.getparNum();
									System.out.print(i+1 + ". ");
									System.out.print("|" + parNumaux[0] + "|");
									System.out.println("|" + parNumaux[1] + "|");
								}
								System.out.println();
								escolha=read.nextInt();  //escolha da peça do dorme para comprar
								pecaaux=(Peca)dorme.pecas.get(escolha-1);
								dorme.removePecas(pecaaux); 
								jogador[aux3-1].addPecas(pecaaux);
								aux--;
								System.out.println("[Peça comprada!]");
								System.out.println();
								Thread.sleep(500);
							}
								else { //dorme vazio
									System.out.println("[Não há mais peças no dorme.]");
									System.out.println();
									Thread.sleep(1000);
									aux--;
								}
							}	
							
						} //else do "mesa vazia, primeira jogada"
							
						} //else da vez do jogador
						
						todasPecas=jogador[aux3-1].getPecas();
						if(todasPecas.isEmpty()) {  //verifica se o jogador está com as mãos vazias. 
							System.out.println("JOGADOR "+aux3+" VENCEU!");
							jogador[aux3-1].addPonto();
							vencedor=1;
						}
						
						
					} //while do turno e pra acabar a rodada
					
					break; //fim da opção jogar entre jogadores
					
				case 3: //exibe pontuação dos jogadores
					if(jogador[0].getPontuacao()!=0)
						System.out.println("O jogador 1 fez"+jogador[0].getPontuacao()+" pontos");
					if(jogador[1].getPontuacao()!=0)
						System.out.println("O jogador 2 fez"+jogador[1].getPontuacao()+" pontos");
					if(jogador[2].getPontuacao()!=0)
						System.out.println("O jogador 3 fez"+jogador[2].getPontuacao()+" pontos");
					if(jogador[3].getPontuacao()!=0)
						System.out.println("O jogador 4 fez"+jogador[3].getPontuacao()+" pontos");
					break;
				default:
					System.out.println("[Por favor, digite um número válido!]\n");
					Thread.sleep(1000);
					break;
			}
			
		} //while do controle
		
	} //main

}
