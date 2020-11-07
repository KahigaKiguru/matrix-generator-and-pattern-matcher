package ca.sheridancollege.ca.finalexam.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SquareMatrixService {

	private Random random = new Random();
	
	private SearchPattern searchPattern = new SearchPattern();
	

	String forward_diagonal_1_pattern = "";
	String forward_diagonal_2_pattern = "";

	String backward_diagonal_1_pattern = "";
	String backward_diagonal_2_pattern = "";

	private char[][] squareMatrix;	

//	generate a square matrix of length :n
	public char[][] generateSquareMatrix(int length) {
		char[][] sq_matrix = new char[length][length];
		
		sq_matrix = populateSquareMatrix(sq_matrix);
		
		this.squareMatrix = sq_matrix;
		
		return sq_matrix;

	}
	
	public boolean searchPattern(String pattern) {
		if (searchPattern.searchPattern(pattern, squareMatrix)) {
			return true;
		}else {
			return false;
		}
	}
//	populate square matrix with random letters of the English alphabet
	private char[][] populateSquareMatrix(char[][] squareMatrix) {
		int arraylength = squareMatrix.length;
		String letters = "abcdefghijklmnopqrstuvwxyz";
		for (int x = 0; x < arraylength; x++) {
			for (int y = 0; y < arraylength; y++) {
				squareMatrix[x][y] = letters.charAt(random.nextInt(letters.length()));
			}
		}
		return squareMatrix;
	}

}
