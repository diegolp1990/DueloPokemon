package lista06_Pokemon.exercicio1;

public class LutaPokemon extends Controlador{
	
	//------------------------------------------------------	
	private class atacar extends Eventos{
		private int HPpokemon;
		private String nomePk;
		private Pokemons p;
		
		public atacar(long tempoEvento) {
			super(tempoEvento);
		}
		
		public void pegarDadosPk(Pokemons pk) {
			p=pk;			
		}
		
		public void acao() {
			p.HP-=500;	

		}

		public String description() {
			if (HPpokemon<=0)
				return (nomePk + "sofreu 500 de dano. \n" + "HP: " +  String.valueOf(HPpokemon) + "\n" + nomePk + " está fora de combate.");  
			return (nomePk + "sofreu 500 de dano. \n" + "HP: " +  String.valueOf(HPpokemon));
			
		}		
		
	}
	
	//------------------------------------------------------
	private class TrocarPokemon{
		
		
		
		
		
		
	}
	//------------------------------------------------------
	private class Item extends Eventos{
		private int HPpokemon;
		private String nomePk;
		private Pokemons p;
		
		public Item(long tempoEvento) {
			super(tempoEvento);
			
		}

		public void acao() {
			p.HP+=200;
		}

		public String description() {
			return null;
		}		
		
		public void pegarDadosPk(Pokemons pk) {
			p=pk;			
		}
		
	}
	//------------------------------------------------------
	private class Fugir extends Eventos{

		public Fugir(long tempoEvento) {
			super(tempoEvento);
		}

		public void acao() {
			
		}

		public String description() {
			return null;
		}
		
	}
	
	
	
}
