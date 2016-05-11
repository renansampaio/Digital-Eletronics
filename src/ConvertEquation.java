
public class ConvertEquation {
	
	String equation; //A’BC+AB+B’C’D
	int qtdLinhas = 1;
	boolean[] colunas = new boolean[4];
	int qtdColunas = 0;
	
	public ConvertEquation(String equation) {
		this.equation = equation.toUpperCase();
		
		for (int i = 0; i < colunas.length; i++) {
			colunas[i] = false;
		}
		
		linhas(this.equation);
		colunas(this.equation);
	}

	private void linhas(String equation) {
		
		for (int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == '+'){
				qtdLinhas++;
			}
		}
	}
	
	private void colunas(String equation){
		for (int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == 'A')
				colunas[0] = true;
			if(equation.charAt(i) == 'B')
				colunas[1] = true;
			if(equation.charAt(i) == 'C')
				colunas[2] = true;
			if(equation.charAt(i) == 'D')
				colunas[3] = true;
		}
		for (int i = 0; i < colunas.length; i++) {
			if(colunas[i] == true){
				qtdColunas++;
			}
		}
	}
	
	public void imprimirLinhas(){
		System.out.println(qtdLinhas);
	}
	
	public void imprimirColunas(){
		System.out.println(qtdColunas);
	}
	
	public char[][] analise(){
		RelationMatrix m = new RelationMatrix(qtdLinhas, qtdColunas, true);
		int l = 0;
		for (int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == '+')
				l++;
			
			switch (equation.charAt(i)) {
				case 'A':
					caractere(m,'A',0,i,l);
					break;
				case 'B':
					caractere(m,'B',1,i,l);
					break;
				case 'C':
					caractere(m,'C',2,i,l);
					break;
				case 'D':
					caractere(m,'D',3,i,l);
					break;
				default:
					break;
			}
		}
		return m.getMatrix();
	}
	
	private void caractere(RelationMatrix m, char caractere, int coluna, int i, int l){
		if((i+1) < equation.length()){
			if(equation.charAt(i+1) != '\''){
				m.setDados(l,coluna,'1');
			}else if(equation.charAt(i+1) == '\''){
				m.setDados(l,coluna,'0');
			}else{
				m.setDados(l,coluna,'x');
			}
		}
	}
}
