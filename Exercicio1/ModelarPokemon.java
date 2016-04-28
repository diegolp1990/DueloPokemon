package lista06_Pokemon.exercicio1;

public class ModelarPokemon {
	private String nome;
	private int HP;
	private String ataque1;
	private String ataque2;
	private String ataque3;
	private String ataque4;
	private String tipo;
	
	public ModelarPokemon(String nome, String at1,String at2, String at3, String at4,int HP,String tipo){
		this.nome=nome;
		ataque1=at1;
		ataque2=at2;
		ataque3=at3;
		ataque4=at4;
		this.HP=HP;
		this.tipo=tipo;
	}
	
	public int getHP(){
		return HP;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setHP(int sangue){
		HP+=sangue;
	}
	
	public String ataque(int numAtaque){
		if (numAtaque==1)
			return ataque1;
		else if (numAtaque==2)
			return ataque2;
		else if (numAtaque==3)
			return ataque3;
		else 
			return ataque4;
	}
	
	public String getTipo(){
		return tipo;
	}
		
}
