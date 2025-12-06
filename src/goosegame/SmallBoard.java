package goosegame;

/**class that creates a small board
 */
public class SmallBoard extends Board{
	
	/**
	 * builds a small board
	 */
	public SmallBoard(){
		super(6);
	}

	public void initBoard(){
		this.theCells[0]=new Cell(0);
		this.theCells[1]=new WaitCell(1,2);
		this.theCells[2]=new GooseCell(2);
		this.theCells[3]=new TrapCell(3);
		this.theCells[4]=new Cell(4);
		this.theCells[5]=new TeleportationCell(5,1);
		this.theCells[6]=new Cell(6);
	}
}

