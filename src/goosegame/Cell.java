package goosegame;

/**
 * class for the goosegame's cell
 */
public class Cell{
	/**the index of the cell*/
	protected int index;

	/**
	 * builds a cell with en index
	 * @param index
	 */
	public Cell(int index){
		this.index=index;
	}
	
	/**return the index of the cell
	 * @return this's index
	 */
	public int getIndex(){
		return this.index;
	}

	/**return true because it is a good cell
	 * @return true
	 */
	public boolean canPlay(){
		return true;
	}

	/**
	 * return the index of the foolowing square
	 * @param dice the dice thrown
	 * @return the index of the following square
	 */
	public int rebound(int dice){
		return this.index;
	}

	/**return the string representation of the cell
	 * @return the string representation of the cell
	 */
	public String toString(){
		return " cell "+this.index+" ";
	}
}
