package lista06_Pokemon.exercicio1;

public class LutaPokemon extends Controlador{
	private static int i1,i2;
	private boolean fim;
	//------------------------------------------------------	
	private class atacar extends Eventos{
		private ModelarPokemon p1,p2;
		private int ataque;
		public atacar(long tempoEvento) {
			super(tempoEvento);
		}
		
		public void pegarDadosPk(ModelarPokemon pk1,ModelarPokemon pk2,int ataque) {
			p1=pk1;	
			p2=pk2;	
			this.ataque=ataque;
		}
		
		public void acao() {
			p2.setHP(100);

		}

		public String description() {
			return (p1.getNome() + "atacou com " +p1.ataque(ataque)+"\n " + p2.getNome() + " sofreu 100 de dano. HP: " + p2.getHP());  
			
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
			ModelarLutador treinador1= new ModelarLutador("Pablo",13,2);
			ModelarLutador treinador2= new ModelarLutador("Ruan",11,1);	
			i1=1;
			i2=1;
		}


		public String description() {
			return ("Treinadores em campo e pokemons prontos. \n" + "Inciar duelo!");
		}
		
	}
	

	
	public static void main(String[] args) {
		
		LutaPokemon luta=new LutaPokemon();
		long tempoEvento = System.currentTimeMillis();
		luta.AdicionaEvento(luta.new IniciarLuta(tempoEvento));
		luta.rodar();
		
	}
	
	
}
