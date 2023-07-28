package com.example.WordSearchApi1.helpers;

import org.springframework.stereotype.Component;

import com.example.WordSearchApi1.models.SoupModelRequest;
import com.example.WordSearchApi1.models.SoupModelResponse;

@Component
public class MatrixSearchHelper {
	
	private int numIndex[] = new int[2];
	
	public int[] getnumIndex() {
		return this.numIndex;
	}
	
	public char[][] matrixConvert(SoupModelRequest soup){
			
    	SoupModelResponse modelResponse = new SoupModelResponse();
    	modelResponse.setSearchword(soup.getSearchword());
    	modelResponse.setRows(soup.getRows());
    	modelResponse.setWord(soup.getWord());
    	
    	int n = soup.getSearchword().length()/soup.getRows();
    	int m = soup.getRows();
    	char matrix[][] = new char[m][n];
    	int k = 0;
    	for(int i = 0; i < m; i++ ) {
    		for(int j = 0; j < n; j++ ) {
    			matrix[i][j] = soup.getSearchword().charAt(k);
    			k++;
    		}
    	}
    	return matrix;	    	
    }  

    // Función para buscar la palabra horizontalmente
    public boolean searchHorizontal(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lenWord = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n - lenWord; j++) {
                // Comprobar si la palabra coincide con la submatriz horizontal que comienza en (i, j)
                if (searchWordSubMatrix(matrix, word, i, j, 0, 1)) {
                	this.numIndex[0] = i;
                	this.numIndex[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    // Función para buscar la palabra verticalmente
    public boolean searchVertical(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lenWord = word.length();

        for (int i = 0; i <= m - lenWord; i++) {
            for (int j = 0; j < n; j++) {
                // Comprobar si la palabra coincide con la submatriz vertical que comienza en (i, j)
                if (searchWordSubMatrix(matrix, word, i, j, 1, 0)) {
                	this.numIndex[0] = i;
                	this.numIndex[1] = j;	                	
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchRightDiagonal(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lenWord = word.length();

        for (int i = 0; i <= m - lenWord; i++) {
            for (int j = 0; j <= n - lenWord; j++) {
                // Comprobar si la palabra coincide con la submatriz en diagonal hacia la derecha que comienza en (i, j)
                if (searchWordSubMatrix(matrix, word, i, j, 1, 1)) {
                	this.numIndex[0] = i;
                	this.numIndex[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    // Función para buscar la palabra en dirección diagonal hacia la izquierda
    public boolean searchLeftDiagonal(char[][] matrix, String word) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lenWord = word.length();

        for (int i = 0; i <= m - lenWord; i++) {
            for (int j = lenWord - 1; j < n; j++) {
                // Comprobar si la palabra coincide con la submatriz en diagonal hacia la izquierda que comienza en (i, j)
                if (searchWordSubMatrix(matrix, word, i, j, 1, -1)) {
                	this.numIndex[0] = i;
                	this.numIndex[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    // Función auxiliar para buscar la palabra en una submatriz de la matriz
    public boolean searchWordSubMatrix(char[][] matrix, String word, int row, int col, int rowIncrement, int colIncrement) {
        int lenWord = word.length();
        for (int i = 0; i < lenWord; i++) {
            if (word.charAt(i) != matrix[row + i * rowIncrement][col + i * colIncrement]) {
                return false;
            }
        }
        return true;
    }

}
