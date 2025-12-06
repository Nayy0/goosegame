package goosegame;

/**class that creates a board like the classical goosegame
 */
public class ClassicalBoard extends Board{
	/**the goose cells*/
	public static final int[] GOOSE_CELLS={9,18,27,36,45,54};

	/**the trap cells*/
	public static final int[] TRAP_CELLS={31,52};

	/**the waiting Cells*/
	public static final int[] WAIT_CELLS={19};

	/**the teleportation cells*/
	public static final int[] TELEPORTATION_CELLS={6,42,58};
	
	/**
	 * builds a Classical board
	 */
	public ClassicalBoard(){
		super(63);
		this.initBoard();
	}

	/**
	 * Creates all the cells in the board based on the classical goosegame
	 */
	public void initBoard(){
		for(int i=0;i<64;i++){
                        this.theCells[i]=new Cell(i);
		}
		for(int i=0;i<ClassicalBoard.GOOSE_CELLS.length;i++){
                        this.theCells[ClassicalBoard.GOOSE_CELLS[i]]=new GooseCell(ClassicalBoard.GOOSE_CELLS[i]);
                }
                for(int i=0;i<ClassicalBoard.WAIT_CELLS.length;i++){
                        this.theCells[ClassicalBoard.WAIT_CELLS[i]]=new WaitCell(ClassicalBoard.WAIT_CELLS[i],2);
                }
                for(int i=0;i<ClassicalBoard.TRAP_CELLS.length;i++){
                        this.theCells[ClassicalBoard.TRAP_CELLS[i]]=new TrapCell(ClassicalBoard.TRAP_CELLS[i]);
                }
		this.theCells[6]=new TeleportationCell(6,12);
		this.theCells[42]=new TeleportationCell(42,30);
		this.theCells[58]=new TeleportationCell(58,1);
	}
}
