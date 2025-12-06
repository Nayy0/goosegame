package goosegame;

/**class for the cells you can't escape from
 */
public class TrapCell extends Cell{
	
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

	public String toString(){
		return super.toString()+" (trap) ";
	}
}
