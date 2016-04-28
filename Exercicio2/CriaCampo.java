package lista06_Pokemon.exercicio2;

public class CriaCampo {
	 private String m[][]=new String [5][5];
	
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
	
	public void imprimirCampo(){
		
		System.out.println(m[0][0]+ " "+m[0][1]+ " "+m[0][2]+ " "+m[0][3]+ " "+m[0][4]);
		
		System.out.println(m[1][0]+ " "+m[1][1]+ " "+m[1][2]+ " "+m[1][3]+ " "+m[1][4]);
		
		System.out.println(m[2][0]+ " "+m[2][1]+ " "+m[2][2]+ " "+m[2][3]+ " "+m[2][4]);
		
		System.out.println(m[3][0]+ " "+m[3][1]+ " "+m[3][2]+ " "+m[3][3]+ " "+m[3][4]);
		
		System.out.println(m[4][0]+ " "+m[4][1]+ " "+m[4][2]+ " "+m[4][3]+ " "+m[4][4]);
		
		System.out.println("---------------------------------------");
		
	}
	
	public void posicaoBoneco(int linha, int coluna){
		CriarCampo();
		m[linha][coluna]="*";
		imprimirCampo();
	}
	
	
}
