
public class ConvertEquation {
	
	String equation; //A + B + CD'
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
		RelationMatrix m = new RelationMatrix(qtdLinhas, qtdColunas);
		int l = 0;
		for (int i = 0; i < equation.length(); i++) {
			
			if(equation.charAt(i) == '+')
				l++;
			
			//caractere A
			if(equation.charAt(i) == 'A' && (i+1) < equation.length() && equation.charAt(i+1) != '\''){
				m.setDados(l,0,'1');
			}else if(equation.charAt(i) == 'A' && equation.charAt(i+1) == '\''){
				m.setDados(l,0,'0');
			}else{
				m.setDados(l,0,'x');
			}
			
			//caractere B
			if(equation.charAt(i) == 'B' && equation.charAt(i+1) != '\''){
				m.setDados(l,1,'1');
			}else if(equation.charAt(i) == 'B' && equation.charAt(i+1) == '\''){
				m.setDados(l,1,'0');
			}else{
				m.setDados(l,1,'x');
			}
			
			//caractere C
			if(equation.charAt(i) == 'C' && equation.charAt(i+1) != '\''){
				m.setDados(l,2,'1');
			}else if(equation.charAt(i) == 'C' && equation.charAt(i+1) == '\''){
				m.setDados(l,2,'0');
			}else{
				m.setDados(l,2,'x');
			}
			
			//caractere D
			if(equation.charAt(i) == 'D' && (i+1) < equation.length() && equation.charAt(i+1) != '\''){
				m.setDados(l,3,'1');
			}else if(equation.charAt(i) == 'D' && (i+1) < equation.length() && equation.charAt(i+1) == '\''){
				m.setDados(l,3,'0');
			}else{
				m.setDados(l,3,'x');
			}
		}
		
		return m.getMatrix();
	}
}
