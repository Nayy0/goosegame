package goosegame;

public class GooseCell extends Cell{

	/**
	 * builds a goose cell
	 * @param index the index of the cell
	 */
	public GooseCell(int index){
		super(index);
	}
	
	/**
         * return the index of the foolowing cell after the rebound
         * @param dice the dice thrown
         * @return the index of the following cell after the rebound
         */
	public int rebound(int dice){
		return this.index+dice;
	}

	public String toString(){
		return super.toString()+" (goose) and jumps to ";
	}
}

