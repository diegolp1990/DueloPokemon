package lista06_Pokemon.exercicio1;

public class ModelarLutador {
	private String nomeJogador;
	private int idadeJogador,teamPok;
	public ModelarPokemon[] pokemons = new ModelarPokemon[6];
	
	public ModelarLutador (String nome,int idade,int teamPk){
		nomeJogador=nome;
		idadeJogador=idade;
		teamPok=teamPk;
		EscolherPokemons();
		
	}
	
	private void EscolherPokemons(){
		if (teamPok==1){
			pokemons[0]=new ModelarPokemon("Rhydon","Lightning Rod","Rock Head","Reckless","Tremor",300,"GR");
			pokemons[1]=new ModelarPokemon("Onix","Sturdy","Rock Head","Weak Armor","Giant",400,"GR");
			pokemons[2]=new ModelarPokemon("Nidoran","Poison Point","Rivalry","Hustle","Poisoned",150,"GR");
			pokemons[3]=new ModelarPokemon("Ivysaur","Overgrow","Chlorophyll","Flowers","Eat",350,"Gs");
			pokemons[4]=new ModelarPokemon("Cubone","Lightning Rod","Rock Head","Battle Armor","Face Skull",270,"G");
			pokemons[5]=new ModelarPokemon("Gastly","Levitate","Darkness","Evil","Sleep",240,"GhP");
		}
		else{
			pokemons[0]=new ModelarPokemon("Gyarados","Intimidate","Mold Breaker","Moxie","Poer water",380,"FW");
			pokemons[1]=new ModelarPokemon("Pinsir","Hyper Cutter","Mold Breaker","Moxie","Aerilate",310,"B");
			pokemons[2]=new ModelarPokemon("Graveler","Rock Head","Sturdy","Sand Veil","Terromote",330,"GR");
			pokemons[3]=new ModelarPokemon("Psyduck","Damp","Cloud Nine","Swift Swim","Psicodelic",400,"W");
			pokemons[4]=new ModelarPokemon("Diglett","Sand Veil","Arena Trap","Sand Force","Hidden",200,"G");
			pokemons[5]=new ModelarPokemon("Krabby","Hyper Cutter","Shell Armor","Sheer Force","Fear",210,"W");
		}		
	}
	
	
	public String getNome(){
		return nomeJogador;
	}
	
	public int getIdade(){
		return idadeJogador;
	}
}

