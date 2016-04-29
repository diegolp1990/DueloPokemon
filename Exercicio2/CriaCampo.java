package lista06_Pokemon.exercicio2;

import java.util.Random;

public class CriaCampo {
	 private String m[][]=new String [5][5];
	 private String local;
	 private int linha,coluna;
	 public CriaCampo(){
		 CriarCampo();
	 }
	
	public void CriarCampo(){//C = chao e G=gramado , Campo 5x5
		//Primeira linha
		m[0][0]="C";
		m[0][1]="C";		
		m[0][2]="C";
		m[0][3]="C";
		m[0][4]="C";
		//Segunda linha
		m[1][0]="G";
		m[1][1]="G";
		m[1][2]="C";
		m[1][3]="G";
		m[1][4]="C";
		//Terceira linha
		m[2][0]="G";
		m[2][1]="G";
		m[2][2]="C";
		m[2][3]="G";
		m[2][4]="C";
		//Quarta linha
		m[3][0]="G";
		m[3][1]="G";
		m[3][2]="C";
		m[3][3]="G";
		m[3][4]="C";
		//Quinta linha
		m[4][0]="G";
		m[4][1]="G";
		m[4][2]="C";
		m[4][3]="C";
		m[4][4]="C";
		
	}
	
	private void imprimirCampo(){
		
		System.out.println(m[0][0]+ " "+m[0][1]+ " "+m[0][2]+ " "+m[0][3]+ " "+m[0][4]);
		
		System.out.println(m[1][0]+ " "+m[1][1]+ " "+m[1][2]+ " "+m[1][3]+ " "+m[1][4]);
		
		System.out.println(m[2][0]+ " "+m[2][1]+ " "+m[2][2]+ " "+m[2][3]+ " "+m[2][4]);
		
		System.out.println(m[3][0]+ " "+m[3][1]+ " "+m[3][2]+ " "+m[3][3]+ " "+m[3][4]);
		
		System.out.println(m[4][0]+ " "+m[4][1]+ " "+m[4][2]+ " "+m[4][3]+ " "+m[4][4]);
		
		System.out.println("---------------------------------------");
		
	}
	
	private void posicaoBoneco(int linha, int coluna){
		CriarCampo();
		local=m[linha][coluna];
		m[linha][coluna]="*";
		imprimirCampo();
	}
	
	public String PegarLocalBoneco(){
			return (local);		
	}
	
	
	// metodo que faz a movimentacao do boneco a partir da posicao atual dele [linha][coluna]
	public void andarBoneco(int linha, int coluna){
		int at;
		Random posicao= new Random ();
		
		/* Controle das linhas */		 
		if (linha-1==0){//se ele esta na primeira linha
			 at = posicao.nextInt(2)+1;//Escolhe aleatoriamente entre dois numeros (1 e 2)
			if (at==1){//mantem na linha
				this.linha=linha;
			}
			else{//vai para a linha de baixo
				this.linha=linha+1;
			}
		}
		else if (linha-1==4){//se ele esta na ultima linha
			at = posicao.nextInt(2)+1;//Escolhe aleatoriamente entre dois numeros (1 e 2)
			if (at==1){//mantem na linha
				this.linha=linha;
			}
			else{//vai para a linha de cima
				this.linha=linha-1;
			}		
		}
		else{//caso contrario podeir pra cima ou pra baixo
			at = posicao.nextInt(3)+1;//Escolhe aleatoriamente entre tres numeros (1,2 e 3)
			if (at==1){//mantem na linha
				this.linha=linha;
			}
			else if (at==2){//vai para a linha de cima
				this.linha=linha-1;
			}	
			else{//vai para a linha de baixo
				this.linha=linha+1;
			}		
		}
		
		
		/* Controle das colunas */		 
		if (coluna-1==0){//se ele esta na primeira coluna
			 at = posicao.nextInt(2)+1;//Escolhe aleatoriamente entre dois numeros (1 e 2)
			if (at==1){//mantem na coluna
				this.coluna=coluna;
			}
			else{//vai para a coluna da direita
				this.coluna=coluna+1;
			}
		}
		else if (coluna-1==4){//se ele esta na ultima coluna
			at = posicao.nextInt(2)+1;//Escolhe aleatoriamente entre dois numeros (1 e 2)
			if (at==1){//mantem na coluna
				this.coluna=coluna;
			}
			else{//vai para a coluna da esquerda
				this.coluna=coluna-1;
			}		
		}
		else{//caso contrario pode ir pra esquerda ou pra direita
			at = posicao.nextInt(3)+1;//Escolhe aleatoriamente entre tres numeros (1,2 e 3)
			if (at==1){//mantem na coluna
				this.coluna=coluna;
			}
			else if (at==2){//vai para a coluna da esquerda
				this.coluna=coluna-1;
			}	
			else{//vai para a coluna da direta
				this.coluna=coluna+1;
			}		
		}
		
		posicaoBoneco(linha, coluna);
		
		
		
	}
	
	public int getLinha(){
		return linha;
	}
	
	public int getColuna(){
		return coluna;
	}
	
}
