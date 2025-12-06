package goosegame;

public abstract class Board{
	/**the number of cells*/
	protected final int nbOfCells;

	/**the Cells*/
	protected Cell[] theCells;
	
	/**
	 * builds a board 
	 * @param nbCells the number of cells of the game
	 */
	public Board(int nbCells){
		this.nbOfCells=nbCells;
		this.theCells=new Cell[nbCells+1];
		this.initBoard();
	}

	/**creates all the cells of this's theCells
	 */
	public abstract void initBoard();

	/**return the cell at the index i
	 * @param i the index
	 * @return the cell at the index i
	 */
	public Cell getCell(int i){
		return this.theCells[i];
	}

	/**return the number of cells
	 * @return the number of cells
	 */
	public int getNbOfCells(){
		return this.nbOfCells;
	}
}

