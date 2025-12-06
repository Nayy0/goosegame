package goosegame;

/**
 * class for the wait cell
 */
public class WaitCell extends Cell{
	/**the counter*/
	protected int counter;

	/**the number of turns the player has to wait in the cell*/
	protected int nbTurns;

	/**
	 * builds a wait cell
	 */
	public WaitCell(int index,int nbTurns){
		super(index);
		this.counter=0;
		this.nbTurns=nbTurns;
	}
	
	/**return this's counter
	 * @return this's counter
	 */
	public int getCounter(){
		return this.counter;
	}

	/**return this's nbTurns
	 * @return this's nbTurns
	 */
	public int getNbTurns(){
		return this.nbTurns;
	}

	/**return true if this's counter equals this's nbTurns
	 * @return true if the player can play
	 */
	public boolean canPlay(){
		if (this.counter==this.nbTurns){
			this.counter=0;
			return true;
		}else{
			this.counter++;
			return false;
		}
	}

	/**return the string representation of the cell
	 * @return the string repreesentation of the cell
	 */
	public String toString(){
		return super.toString()+" (waiting for "+this.nbTurns+" turns) ";
	}
}
