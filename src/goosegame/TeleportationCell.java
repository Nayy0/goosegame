package goosegame;

/**
 * class for the teleportation cell
 */
public class TeleportationCell extends Cell{
	
	/**the index of the teleportation*/
	protected int teleportationIndex;

	/**builds a teleportation cell
	 * @param index
	 * @param it the teleportation index
	 */
	public TeleportationCell(int index,int it){
		super(index);
		this.teleportationIndex=it;
	}
	
	/**return this's teleportation index
	 * @return this's teleportation index
	 */
	public int getTeleportationIndex(){
		return this.teleportationIndex;
	}

	/**
         * return the index of the foolowing square
         * @param dice the dice thrown
         * @return the index of the following square
         */
	public int rebound(int dice){
		return this.teleportationIndex;
	}

	/**return the string representation of the cell
         * @return the string representation of the cell
         */
        public String toString(){
                return super.toString()+" (teleport to "+this.teleportationIndex+" ) ";
        }
}
