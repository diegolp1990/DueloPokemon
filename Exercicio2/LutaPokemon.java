package lista06_Pokemon.exercicio2;

import java.util.Random;

public class LutaPokemon extends Controlador{
	private static int i1=0,i2=0,tipoLuta;
	private int round=0;
	private static ModelarLutador treinador1;
	private static ModelarLutador treinador2;
	private boolean fim=false,troca=false;
	
	//------------------------------------------------------	
	private class atacar extends Eventos{
		
		private ModelarPokemon p1,p2;
		private int ataque;
		private ModelarLutador treinador;
		
		public atacar(long tempoEvento,ModelarPokemon pk1,ModelarPokemon pk2,ModelarLutador trein,int ataque) {
			super(tempoEvento);
			p1=pk1;	
			p2=pk2;	
			this.ataque=ataque;
			treinador=trein;
		}
					
		public void acao() {			
			p2.setHP(-100);
			
			if (TemPokemons(treinador)!=true)
				fim=true;
				
			if (p2.getHP()<=0 && tipoLuta==2){
				System.out.println("Pokemon Selvagem perdeu");
				limparEventos();
				troca=true;
			}
		}

		public String description() {
			if (troca==false){
				return (p1.getNome() + " atacou com " +p1.ataque(ataque)+"\n" + p2.getNome() + " sofreu 100 de dano. HP: " + p2.getHP());
			}
			else{
				return (p1.getNome() + " venceu!");
			}
			
		}		
		
	}
	
	//------------------------------------------------------
	private class TrocarPokemon extends Eventos{
		private ModelarLutador treinador;
		private int troca,tr;
		
		public TrocarPokemon(long tempoEvento,ModelarLutador treinador,int troca,int tr) {
			super(tempoEvento);
			this.treinador=treinador;
			this.troca=troca;
			this.tr=tr;
		}

	
		public void acao() {
			if (tr==1)
				i1=troca;
			else
				i2=troca;
		}
		
		public String description() {
			return (treinador.getNome()+ " trocou de pokemon. \nPokemon atual:" + treinador.pokemons[i1].getNome()+ ". HP: " + treinador.pokemons[i1].getHP());
		}
				
	}
	//------------------------------------------------------
	private class Item extends Eventos{
		private ModelarPokemon p1;
		
		public Item(long tempoEvento,ModelarPokemon p1) {
			super(tempoEvento);
			this.p1=p1;			
		}

		public void acao() {
			p1.setHP(50);
		}

		public String description() {
			return (p1.getNome()+" encheu seu sangue. HP: "+ p1.getHP());
		}		
	
		
	}
	//------------------------------------------------------
	private class Fugir extends Eventos{
		private ModelarLutador treinador1,treinador2;
		
		
		public Fugir(long tempoEvento,ModelarLutador treinador1,ModelarLutador treinador2) {
			super(tempoEvento);
			this.treinador1=treinador1;
			this.treinador2=treinador2;
		}

		public void acao() {
			fim=true;
		}

		public String description() {
			return ("O treinador "+treinador1.getNome()+ " fugiu! Vitoria do " + treinador2.getNome());
		}
		
	}
	//------------------------------------------------------
	/*
	 * Classe que simula uma luta pokemon. Nela se simula contra outro treinador ou contra um pokemon selvagem.
	 * Contra o treinador pode-se adicionar ou tirar rounds com ifs de acordo com o objetivo da simulacao.
	 * Ap�s simulada a luta, a variavel fim eh setada como true, o vetor eventos eh zerado e o jogo finalizado
	 */
	private class IniciarLuta extends Eventos{		
		
		public IniciarLuta(long tempoEvento){
			super(tempoEvento);
		}

		public void acao() {
			
			
			
			if (round==0){
				treinador1=new ModelarLutador("Pablo",13,2); 
			}
			
			long tempoEvento = System.currentTimeMillis();		
	
			
			if (fim==true){
				limparEventos();
				System.exit(0);
			}
			
			if (tipoLuta==1){
				if (round==0){
					treinador2=new ModelarLutador("Ruan",12,1); 
					round++;
				}
				if (round==1){
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2
					AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[i2],treinador1.pokemons[i1],treinador1,3)); //treinador 2 ataca treinador 1
					round++;
				}
				
				else if (round==2){
					AdicionaEvento(new TrocarPokemon(tempoEvento, treinador1, 2, 1)); //treinador 1 troca de pokemon			
					AdicionaEvento(new Item(tempoEvento+1000, treinador2.pokemons[i2]));//treinador 2 enche o sangue
					round++;
				}
				
				else if(round ==3){				
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2				
					AdicionaEvento(new Item(tempoEvento+1000, treinador2.pokemons[i2]));//treinador 2 enche o sangue
					round++;
				}
			
				else if(round==4){
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2
					AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[i2],treinador1.pokemons[i1],treinador1,3)); //treinador 2 ataca treinador 1
					round++;
				}
				
				else if (round==5){
				AdicionaEvento(new Fugir(tempoEvento, treinador1, treinador2));//treinador 1 foge da luta			
				round++;	
				}
			}	
			
			
			else {
				
				if (troca==true){
					System.exit(0);
				}
												
				if (round==0){
					treinador2=new ModelarLutador("Pokemon Selvagem",0,3); 
					treinador2.setNome(treinador2.pokemons[0].getNome());
					round++;
				}
				Random ataqueAle= new Random ();	
				if (treinador1.pokemons[i1].getHP()<=100){
					AdicionaEvento(new TrocarPokemon(tempoEvento-500, treinador1, i1+1, 1));
				}
				else if (round==1){//ataque
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[0],treinador2,3));
					round++;
				}
				else if(round==2){//ataque
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[0],treinador2,3)); 
					round++;
				}
				else if (round==3){//item
					AdicionaEvento(new Item(tempoEvento, treinador1.pokemons[i1]));
					round++;
				}
				else if (round==4){//ataque
					AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[0],treinador2,3)); 
					round++;
				}
				else if (round==5){//item
					AdicionaEvento(new Item(tempoEvento, treinador1.pokemons[i1]));
					round++;
				}
					
				//acoes do pokemon selvagem (aleatoria)	
				if (TemPokemons(treinador2)){
					int at = ataqueAle.nextInt(4)+1;//Escolhe aleatoriamente um dos 4 ataques do pokemon selvagem
					if (treinador1.pokemons[i1].getHP()<=100){
						AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[0],treinador1.pokemons[i1+1],treinador1,at)); 				
					}
					else {
					AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[0],treinador1.pokemons[i1],treinador1,at)); 
					}
				}		
				
								
			}
			
			if (fim!=true){
				AdicionaEvento(new IniciarLuta(tempoEvento+1200));
				if (round==6){
					round=1;
				}
			}
			
		}


		public String description() {
			return ("----");
		}
		
	}
	
	//------------------------------------------------------


	
	
	
	//------------------------------------------------------
	/*
	 * O metodo a seguir verifica se treinador que levou dano ainda possui pokemons com HP maior que 0
	 */
	public static boolean TemPokemons(ModelarLutador treinador1){
		
		for (int k=0;k<6;k++){
			if (treinador1.pokemons[k]==null||treinador1.pokemons[k].getHP()>0 ){
				return true;
			}
		}		
		return false;
	}
	
	//------------------------------------------------------

	public static void main(String[] args)  {
		/*
		LutaPokemon luta=new LutaPokemon();
		long tempoEvento = System.currentTimeMillis();
		tipoLuta=2;
		luta.limparEventos();
		luta.AdicionaEvento(luta.new IniciarLuta(tempoEvento));
		luta.rodar();	*/	
		CriaCampo campo= new CriaCampo();
		campo.imprimirCampo();
		campo.posicaoBoneco(4, 3);
	}
	
	
}
