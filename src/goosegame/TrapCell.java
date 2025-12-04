package goosegame;

/**class for the cells you can't escape from
 */
public class TrapCell extends BadCell{
	
	/**
	 * builds a cell you can't escape from
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
	
	/**do the effect related to the trapcell
	 */
	public void badEffect(){
	//nothing happens because a trap cell is supposed to block you forever
	}

	public String toString()
