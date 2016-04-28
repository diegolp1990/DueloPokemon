package lista06_Pokemon.exercicio1;

public class LutaPokemon extends Controlador{
	private static int i1,i2;
	private static ModelarLutador treinador1;
	private static ModelarLutador treinador2;
	private boolean fim;
	
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
		}

		public String description() {
			return (p1.getNome() + " atacou com " +p1.ataque(ataque)+"\n " + p2.getNome() + " sofreu 100 de dano. HP: " + p2.getHP());  
			
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
			return (treinador.getNome()+ " trocou de pokemon. \n Pokemon atual:" + treinador.pokemons[i1].getNome()+ ". HP: " + treinador.pokemons[i1].getHP());
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
			return ("O treinador "+treinador1.getNome()+ " fugiu! Vitória do " + treinador2.getNome());
		}
		
	}
	//------------------------------------------------------
	
	private class IniciarLuta extends Eventos{		
		
		public IniciarLuta(long tempoEvento){
			super(tempoEvento);
		}

		public void acao() {
			treinador1=new ModelarLutador("Pablo",13,2);
			treinador2= new ModelarLutador("Ruan",11,1);
			i1=1;
			i2=1;
			long tempoEvento = System.currentTimeMillis();		
			
			//Seguindo a ordem de preferencia: atacar (soma 1000 do anterior), item (soma 750 do anterior), trocar (soma 500 do anterior)
			// e fugir (soma 250 do anterior).
			AdicionaEvento(new atacar(tempoEvento,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2
			if (fim==true)
				System.out.println("treinador 2 não tem mais pokemons");
				System.exit(0);	
			
			AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[i2],treinador1.pokemons[i1],treinador1,3)); //treinador 2 ataca treinador 1
			if (fim==true)
				System.out.println("treinador 1 não tem mais pokemons");
				System.exit(0);	
			
			AdicionaEvento(new TrocarPokemon(tempoEvento+1500, treinador1, 2, 1)); //treinador 1 troca de pokemon
			
			AdicionaEvento(new Item(tempoEvento+2250, treinador2.pokemons[i2]));//treinador 2 enche o sangue
			
			AdicionaEvento(new atacar(tempoEvento+3250,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2
			if (fim==true)
				System.out.println("treinador 2 não tem mais pokemons");
				System.exit(0);	
			
			AdicionaEvento(new Item(tempoEvento+3000, treinador2.pokemons[i2]));//treinador 2 enche o sangue
			
			AdicionaEvento(new atacar(tempoEvento+4000,treinador1.pokemons[i1],treinador2.pokemons[i2],treinador2,3)); //treinador 1 ataca treinador 2
			if (fim==true)
				System.out.println("treinador 2 não tem mais pokemons");
				System.exit(0);				
			
			AdicionaEvento(new atacar(tempoEvento+1000,treinador2.pokemons[i2],treinador1.pokemons[i1],treinador1,3)); //treinador 2 ataca treinador 1
			if (fim==true)
				System.out.println("treinador 1 não tem mais pokemons");
				System.exit(0);
				
			AdicionaEvento(new Fugir(tempoEvento+2500, treinador1, treinador2));//treinador 1 foge da luta			
			if (fim==true)
				System.exit(0);			
			
		}


		public String description() {
			return ("Inicio da luta");
			//return ("Treinadores em campo e pokemons prontos. \n" + "Inciar duelo!");
		}
		
	}
	//------------------------------------------------------
	/*
	 * O metodo a seguir verifica se treinador que levou dano ainda possui pokemons com HP maior que 0
	 */
	public static boolean TemPokemons(ModelarLutador treinador1){
		
		for (int k=0;k<6;k++){
			if (treinador1.pokemons[k].getHP()>0)
				return true;			
		}		
		return false;
	}
	
	public static void main(String[] args) throws Exception  {
		
		LutaPokemon luta=new LutaPokemon();
		long tempoEvento = System.currentTimeMillis();
		luta.AdicionaEvento(luta.new IniciarLuta(tempoEvento));
		luta.rodar();
		
			
	}
	
	
}
