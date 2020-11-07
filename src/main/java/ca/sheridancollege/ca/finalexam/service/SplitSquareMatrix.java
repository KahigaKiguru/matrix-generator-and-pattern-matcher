package ca.sheridancollege.ca.finalexam.service;

import org.springframework.stereotype.Component;

@Component
public class SplitSquareMatrix {

	private char[][] squareMatrix;

	public SplitSquareMatrix(char[][] squareMatrix) {
		this.squareMatrix = squareMatrix;
	
	}

//	split matrix into forward and backward columns
	public String[] forwardColumnSplit() {
		String forward_columns[] = new String[squareMatrix.length];
		String forward_column = "";
		for (int x = 0; x < squareMatrix.length; x++) {
			for (int y = 0; y < squareMatrix.length; y++) {

				forward_column += squareMatrix[y][x];
			}
			forward_columns[x] = forward_column;
		}
		return forward_columns;
	}

	public String[] backwardColumnSplit() {
		String backward_columns[] = new String[squareMatrix.length];
		
		String backward_column = "";
		
		for (int x = 0; x < squareMatrix.length; x++) {
			for (int y = 0; y < squareMatrix.length; y++) {

				backward_column += squareMatrix[y][x];
			}
			
			backward_columns[x] = InvertPattern.invertPattern(backward_column);
		}
		return backward_columns;
	}

//	split matrix into forward and backward rows
	public String[] forwardRowSplit() {
		String forward_rows[] = new String[squareMatrix.length];
		String forward_row = "";
		for (int x = 0; x < squareMatrix.length; x++) {
			for (int y = 0; y < squareMatrix.length; y++) {

				forward_row += squareMatrix[x][y];
			}
			forward_rows[x] = forward_row;
		}
		return forward_rows;
	}

	public String[] backwardRowSplit() {
		String backward_rows[] = new String[squareMatrix.length];	
		String backward_row = "";
		for (int x = 0; x < squareMatrix.length; x++) {
			for (int y = 0; y < squareMatrix.length; y++) {

				backward_row += squareMatrix[x][y];
			}
			backward_rows[x] = InvertPattern.invertPattern(backward_row);
		}
		return backward_rows;
	}

//	diagonal 1 forward split
	public String forwardDiagonal1Split() {

		String forward_diagonal_1 = "";
		for (int y = 0; y < squareMatrix.length; y++) {

			forward_diagonal_1 += squareMatrix[y][y];
		}

		return forward_diagonal_1;
	}
	
//	diagonal 1 forward split
	public String backwardDiagonal1Split() {

		String backward_diagonal_1 = "";
		for (int y = 0; y < squareMatrix.length; y++) {

			backward_diagonal_1 += squareMatrix[y][y];
		}
		return InvertPattern.invertPattern(backward_diagonal_1);

	}

//	diagonal 2 forward split
	public String forwardDiagonal2Split() {
		String forward_diagonal_2 = "";
		for (int y = squareMatrix.length - 1; y > 0; y--) {
			int x = 0;
			forward_diagonal_2 += squareMatrix[x][y];
			x++;
		}
		return forward_diagonal_2;		
	}
//	diagonal 2 backward split
	public String backwardDiagonal2Split() {
		String backward_diagonal_2 = "";
		for (int y = squareMatrix.length - 1; y > 0; y--) {
			int x = 0;
			backward_diagonal_2 += squareMatrix[x][y];
			x++;
		}
		return InvertPattern.invertPattern(backward_diagonal_2);
	}

}
