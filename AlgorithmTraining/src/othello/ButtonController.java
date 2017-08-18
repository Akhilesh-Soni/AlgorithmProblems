package othello;

import java.awt.Color;

public class ButtonController {
	int array[][];
	int scorePlayerOne,scorePlayerTwo ;
	public ButtonController() {
		// TODO Auto-generated constructor stub
		scorePlayerOne = 0; 
		scorePlayerTwo = 0;
		array = new int[8][8]; 
 		array[3][3] = 1;
		array[3][4] = 2;
		array[4][3] = 2;
		array[4][4] = 1;	
	}
	
	public void updateArray(int getRow, int getColumn, int currentValue) {
		array[getRow][getColumn] = currentValue;
		return;
	}
	
	//enable the valid buttons for player 
	public void createValidMove(int row, int column) {
		
		int currentValue = array[row][column];
		int anotherValue = 0;
		if(currentValue == 1){
			anotherValue = 2;
		}else {
			anotherValue = 1;
		}
		
		/*
		 * Check in Top direction of the current button 
		 * row will be decreased while column is fixed
		*/
		for(int index = row-1; (index-1) >= 0;index--){
			if(array[index][column] == anotherValue && array[index-1][column] == 0){
				GameManager.mainGui.jButton[index-1][column].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index-1][column].setEnabled(true);
				break;
			}
		}

		/*
		 * Check in bottom direction of the current button 
		 * row will be increased while column is fixed
		*/
		for(int index = row+1; (index+1) < 8;index++){
			if(array[index][column] == anotherValue && array[index+1][column] == 0){
				GameManager.mainGui.jButton[index+1][column].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index+1][column].setEnabled(true);
				break;
			}
		}
		
		/*
		 * Check in left direction of the current button 
		 * row will be fixed while column is decreased
		*/
		for(int index = column-1; (index-1) >= 0;index--){
			if(array[row][index] == anotherValue && array[row][index-1] == 0){
				GameManager.mainGui.jButton[row][index-1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[row][index-1].setEnabled(true);
				break;
			}
		}
		
		
		/*
		 * Check in right direction of the current button 
		 * row will be fixed while column is increased
		*/
		for(int index = column+1; (index+1) < 8;index++){
			if(array[row][index] == anotherValue && array[row][index+1] == 0){
				GameManager.mainGui.jButton[row][index+1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[row][index+1].setEnabled(true);
				break;
			}
		}
		
		/*
		 * Check in Top-Left(diagonal) direction of the current button 
		 * row will be decreased and column is also decreased
		*/
		for(int index1 = row-1,index2 = column-1; (index1-1) >= 0 && (index2-1) >= 0; index1--,index2--){
			if(array[index1][index2] == anotherValue && array[index1-1][index2-1] == 0){
				GameManager.mainGui.jButton[index1-1][index2-1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index1-1][index2-1].setEnabled(true);
				break;
			}
		}
		
		/*
		 * Check in Top-right(diagonal) direction of the current button 
		 * row will be decreased and column is increased
		*/
		for(int index1 = row-1,index2 = column+1; (index1-1) >= 0 && (index2+1) < 8; index1--,index2++){
			if(array[index1][index2] == anotherValue && array[index1-1][index2+1] == 0){
				GameManager.mainGui.jButton[index1-1][index2+1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index1-1][index2+1].setEnabled(true);
				break;
			}
		}
		/*
		 * Check in Bottom-right(diagonal) direction of the current button 
		 * row will be increased and column is also increased
		*/
		for(int index1 = row+1,index2 = column+1; (index1+1) < 8 && (index2+1) < 8; index1++,index2++){
			if(array[index1][index2] == anotherValue && array[index1+1][index2+1] == 0){
				GameManager.mainGui.jButton[index1+1][index2+1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index1+1][index2+1].setEnabled(true);
				break;
			}
		}
		/*
		 * Check in Bottom-Left(diagonal) direction of the current button 
		 * row will be increased and column is decreased
		*/
		for(int index1 = row+1,index2 = column-1; (index1+1) < 8 && (index2-1) >= 0; index1++,index2--){
			if(array[index1][index2] == anotherValue && array[index1+1][index2-1] == 0){
				GameManager.mainGui.jButton[index1+1][index2-1].setBackground(Color.GREEN);
				GameManager.mainGui.jButton[index1+1][index2-1].setEnabled(true);
				break;
			}
		}
		
	}

	//This Method will paint the buttons
	private void paint(int getRow, int getColumn,int currentValue) {
		
		if(currentValue == 1){
			System.out.print(" Inside 1" );
			updateArray(getRow, getColumn, currentValue);
			GameManager.mainGui.jButton[getRow][getColumn].setBackground(Color.BLUE);
		}else{
			System.out.print(" Inside 2" );
			updateArray(getRow, getColumn, currentValue);
			GameManager.mainGui.jButton[getRow][getColumn].setBackground(Color.BLACK);
		}
			return;

	}

	
	/*
	 * This Method find the position where the button can be painted in 8
	 * direction and call the paint method to paint the button as well as update
	 * the array value
	 */
	public void paintTheButtons(int getRow, int getColumn, int currentValue) {
		int anotherValue = 0;
		if (currentValue == 1) {
			// set the selected Button color blue
			GameManager.mainGui.jButton[getRow][getColumn]
					.setBackground(Color.BLUE);
			GameManager.mainGui.jButton[getRow][getColumn].setEnabled(false);
			anotherValue = 2;
		} else {
			// set the selected Button color black
			anotherValue = 1;
			GameManager.mainGui.jButton[getRow][getColumn]
					.setBackground(Color.BLACK);
			GameManager.mainGui.jButton[getRow][getColumn].setEnabled(false);
		}

		// update the array by current value at current position
		updateArray(getRow, getColumn, currentValue);

		/*
		 * We will start the loop till we did not find 0 or currrentValue in any
		 * 8 position in Array regarding the current position. If just any 8
		 * position in array contain 0 than we simply break the loop if just top
		 * position in array contain anotherValue than we replace the
		 * currentValue at that position and change the color of button
		 * accordingly
		 */

		/*
		 * Check in Top direction of the current button row will be decreased
		 * while column is fixed.
		 */

		for (int index = getRow - 1; (index - 1) >= 0; index--) {
			if (array[index][getColumn] == anotherValue && array[index - 1][getColumn] == currentValue) {
				System.out.print("\n Inside Top if ");
				paint(index, getColumn, currentValue);
				
			} else {
				System.out.print("\n Inside Top else ");
		
			}

		}

		/*
		 * Check in Bottom direction of the current button row will be increased
		 * while column is fixed.
		 */
		for (int index = getRow + 1; (index + 1) < 8; index++) {
			if (array[index][getColumn] == anotherValue && array[index + 1][getColumn] == currentValue) {
				System.out.print("\n Inside Bottom if");
				paint(index, getColumn, currentValue);
				
			} else {
				System.out.print("\n Inside Bottom else");
			}
		}

		/*
		 * Check in Left direction of the current button row will be fixed while
		 * column is decreased.
		 */
		for (int index = getColumn - 1; (index - 1) >= 0; index--) {
			if (array[getRow][index] == anotherValue && array[getRow][index - 1] == currentValue) {
				System.out.print("\n Inside left if");
				paint(getRow, index, currentValue);
			} else {
				System.out.print("\n Inside left else");
			}
		}
		/*
		 * Check in Right direction of the current button row will be fixed
		 * while column is increased.
		 */
		for (int index = getColumn + 1; (index + 1) < 8; index++) {
			if (array[getRow][index] == anotherValue && array[getRow][index+1] == currentValue) {
				System.out.print("\n Inside right if");
				paint(getRow, index, currentValue);
				
			} else {
				System.out.print("\n Inside right else");
				
			}
		}

		/*
		 * Check in Top-Left(diagonal) direction of the current button row will
		 * be decreased and column is also decreased
		 */
		for (int index1 = getRow - 1, index2 = getColumn - 1; (index1 - 1) >= 0
									&& (index2 - 1) >= 0; index1--, index2--) {
			if (array[index1][index2] == anotherValue && array[index1 - 1][index2 - 1] == currentValue) {
				System.out.print("\n Inside Top-Left if");
				paint(index1, index2, currentValue);
				
			} else {
				System.out.print("\n Inside Top-Left else");
			}
		}
		/*
		 * Check in Top-right(diagonal) direction of the current button row will
		 * be decreased and column is increased
		 */
		for (int index1 = getRow - 1, index2 = getColumn + 1; (index1 - 1) >= 0
				&& (index2 + 1) < 8; index1--, index2++) {
			
			if (array[index1][index2] == anotherValue && array[index1 - 1][index2 + 1] == currentValue) {
				System.out.print("\n Inside Top-Right if");
				paint(index1, index2, currentValue);
			} else {
				System.out.print("\n Inside Top-Right else");

			}
		}

		/*
		 * Check in Bottom-right(diagonal) direction of the current button row
		 * will be increased and column is also increased
		 */
		for (int index1 = getRow + 1, index2 = getColumn + 1; (index1 + 1) < 8
				&& (index2 + 1) < 8; index1++, index2++) {
			
			if (array[index1][index2] == anotherValue && array[index1 + 1][index2 + 1] == currentValue) {
				System.out.print("\n Inside Bottom-Right if");
				paint(index1, index2, currentValue);
				
			} else {
				System.out.print("\n Inside Bottom-Right else");
		
			}
		}
		/*
		 * Check in Bottom-Left(diagonal) direction of the current button row
		 * will be increased and column is also decreased
		 */
		for (int index1 = getRow + 1, index2 = getColumn - 1; (index1 + 1) < 8
				&& (index2 - 1) >= 0; index1++, index2--) {
			
			if (array[index1][index2] == anotherValue && array[index1 + 1][index2 - 1] == currentValue) {
				System.out.print("\n Inside Bottom-Left if");
				paint(index1, index2, currentValue);
				
			} else {
				System.out.print("\n Inside Bottom-Left else");
			
			}
		}
	}



	public void countScore() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(array[i][j] == 1){
					scorePlayerOne++;
				}
				else {
					scorePlayerTwo++;
				}
			}
		}
		if(scorePlayerOne>scorePlayerTwo){
			GameManager.mainGui.displayLabel.setText("Player One Won...");
			GameManager.mainGui.displayColor.setBackground(Color.BLUE);
		}
		else {
			GameManager.mainGui.displayLabel.setText("Player Two Won...");
			GameManager.mainGui.displayColor.setBackground(Color.BLACK);
		}
	}
}
