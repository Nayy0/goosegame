package goosegame;

public class ClassicalBoard extends Board{
	/**the goose cells*/
	public static final int[] GOOSE_CELLS={9,18,27,36,45,54};

	/**the trap cells*/
	public static final int[] TRAP_CELLS={31,52};

	/**the waiting Cells*/
	public static final int[] WAITING_CELLS={19};

	/**the teleportation cells*/
	public static final int[] TELEPORTATION_CELLS={6,42,58};
	
	public void initBoard(){}
