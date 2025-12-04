package goosegame;

/**
 * class for clear bad cells
 */
public abstract class BadCell{

	/**
         * builds a cell with clear bad effect
         */
        public BadCell(int index){
                super(index);
        }

        /**return false because you can't escape
         * @return false because you can't escape
         */
        public boolean canPlay(){
                return false;
        }
	
	/**do the effect related to the cell
         */
	public abstract void badEffect();
}
