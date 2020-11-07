package ca.sheridancollege.ca.finalexam.service;

import org.springframework.stereotype.Component;

@Component
public class SearchPattern {

//	search square matrix for a pattern
	public boolean searchPattern(String pattern, char[][] squareMatrix) {

		SplitSquareMatrix splitSquareMatrix = new SplitSquareMatrix(squareMatrix);

		String forwardPattern = pattern;
		String backwardPattern = InvertPattern.invertPattern(forwardPattern);

		String[] forward_rows = splitSquareMatrix.forwardRowSplit();
		String[] backward_rows = splitSquareMatrix.backwardRowSplit();

		String[] forward_columns = splitSquareMatrix.forwardColumnSplit();
		String[] backward_columns = splitSquareMatrix.backwardColumnSplit();

		String forward_diagonal_1_pattern = splitSquareMatrix.forwardDiagonal1Split();
		String forward_diagonal_2_pattern = splitSquareMatrix.forwardDiagonal2Split();
		String backward_diagonal_1_pattern = splitSquareMatrix.backwardDiagonal1Split();
		String backward_diagonal_2_pattern = splitSquareMatrix.backwardDiagonal2Split();

		boolean pattern_found = false;

		for (int a = 0; a < forwardPattern.length(); a++) {

			if (forward_rows[a].contains(forwardPattern) || forward_rows[a].contains(backwardPattern)) {
				pattern_found = true;
			} else if (forward_columns[a].contains(forwardPattern) || forward_columns[a].contains(backwardPattern)) {
				pattern_found = true;
			} else if (backward_rows[a].contains(forwardPattern) || backward_rows[a].contains(backwardPattern)) {
				pattern_found = true;
			} else if (backward_columns[a].contains(forwardPattern) || backward_columns[a].contains(backwardPattern)) {
				pattern_found = true;
			}
		}

		if (forward_diagonal_1_pattern.contains(forwardPattern)
				|| forward_diagonal_1_pattern.contains(backwardPattern)) {
			pattern_found = true;
		} else if (forward_diagonal_2_pattern.contains(forwardPattern)
				|| forward_diagonal_2_pattern.contains(backwardPattern)) {
			pattern_found = true;
		} else if (backward_diagonal_1_pattern.contains(forwardPattern)
				|| backward_diagonal_2_pattern.contains(backwardPattern)) {
			pattern_found = true;
		}
		
		return pattern_found;
	}
}
