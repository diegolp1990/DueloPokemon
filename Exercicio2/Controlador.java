package lista06_Pokemon.exercicio2;


/*
 * Classe responsavel por gerenciar os eventos na lista: incluir evento / pegar proximo evento na lista(nao nulo) / deletar evento.
 */
class EventoSet{
	
	private Eventos[] eventos = new Eventos[100];
	private int index=0;
	private int next=0;
	
	
	/*
	 * Adiciono eventos na lista de eventos. 
	 */
	public void Adiciona(Eventos ev){
		
		if (index>= eventos.length)//Verificar se tem espaco na fila
			return;
		eventos[index]=ev;
		index++;
		//poderia fazer: eventos[index++]=ev;		
	}
	
	
	/*
	 * Pega o proximo evento nao nulo
	 */
	public Eventos getNext(){
		
		boolean looped =false;
		int inicio=next;
		do {
			
			next=(next+1) % eventos.length;
			
			if (inicio==next)
				looped=true;
			
			if ((next==(inicio+1) % eventos.length) && looped){				
				return null;
			}
						
		}while(eventos[next]==null);
	
		return (eventos [next]);	
	}
	
	public void limpaVetor(){
		for (int n=0;n<eventos.length;n++){
			eventos[n]=null;
			index=0;
			next=0;
		}
	}
	/*
	 * Remover o evento em questao
	 */
	public void removeCurrent(){		
		eventos[next]=null;
		
	}
	
}

public class Controlador {
	private EventoSet es=new EventoSet();
	
	public void AdicionaEvento(Eventos c){
		es.Adiciona(c);	

	}
	
	public void limparEventos(){
		es.limpaVetor();
	}
	
	public void rodar() {
		Eventos ev;
		while ((ev= es.getNext()) != null) {
			if (ev.lerTempo()){ // Se o evento ja pode ser executado
				ev.acao();
				System.out.println(ev.description());
				es.removeCurrent();		
				
			}
		}
	}
	
}








