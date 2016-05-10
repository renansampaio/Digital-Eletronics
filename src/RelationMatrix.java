
public class RelationMatrix {
	int linhas = 0;
	int colunas = 0;
	private char[][] matrix;
	
	public RelationMatrix(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		setMatrix(new char[linhas][colunas]);
	}
	
	public RelationMatrix(int linhas, int colunas, boolean preencher) {
		this.linhas = linhas;
		this.colunas = colunas;
		setMatrix(new char[linhas][colunas]);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = '0';
			}
		}
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}
	
	
	public void setDados(int i, int j, char dado){
		matrix[i][j] = dado;
	}
	
	
}
