package lista06_Pokemon.exercicio2;
/*
 * Classe respons�vel por controlar o momento de tal evento ocorrer.
 * 
 * � necess�rio implementar o que ser� feit quando o for o tempo do evento ocorrer e
 * o que mostrar ap�s a acao ocorrer
 */


abstract public class Eventos {
	private long tempoEvento;
	
	public Eventos(long tempoEvento){
		this.tempoEvento=tempoEvento;		
	}
	
	public boolean lerTempo(){
		return System.currentTimeMillis()>=tempoEvento; //se o tempo de ocorrer o evento j passou
	}
	
	abstract public void acao();
	abstract public String description();
	
}
