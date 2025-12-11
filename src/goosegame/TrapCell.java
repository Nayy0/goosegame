package goosegame;

/**class for the cells you can't escape from
 */
public class TrapCell extends Cell{
	
	/**
	 * builds a cell you can't escape from
	 * @param index the index of the cell
	 */
	public TrapCell(int index){
		super(index);
	}
	
	/**return false because you can't escape
	 * @return false because you can't escape
	 */
	public boolean canPlay(){
		return false;
	}
	
	/**return the String representation of the cell
	 * @return the string representation of the cell
	 */
	public String toString(){
		return super.toString()+" (trap) ";
	}
}
