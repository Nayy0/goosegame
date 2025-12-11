package goosegame;

import java.util.*;

/**
 * class to play the goosegame
 */
public class Game{
	/**the players of the game*/
	protected List<Player> thePlayers;

	/**the board*/
	protected Board board;

	/**
	 * builds a game
	 * @param b the board of the game
	 */
	public Game(Board b){
		this.board=b;
		this.thePlayers=new ArrayList<Player>();
	}

	/**
	 * add a player to this's thePlayers
	 * @param p a player we add
	 */
	public void addPlayer(Player p){
		this.thePlayers.add(p);
	}
	
	/**return a different player at the given cell 
	 * @param c the cell we want to get the players from
	 * @return a different player at the given cell
	 */
	public List<Player> getPlayers(Cell c){
		List<Player> res=new ArrayList<Player>();
		for (Player p : this.thePlayers){
			if (p.getCell()==c){
				res.add(p);
			}
		}return res;
	}

	/**print the played turn
	 * @param previousCell the previous cell of p
	 * @param reachedCell the cell reached by the p before the rebound
	 * @param busy true if p's cell is busy
	 * @param p the player
	 * @param d the dice thrown
	 */
	private void printTurn(Cell previousCell,Cell reachedCell,boolean busy,Player p,int d){
		if (reachedCell==p.getCell()){
                	this.printTurnWhenNoJumps(previousCell,reachedCell,busy,p,d);
	       	}else{
			 if (!busy){
                                System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell+" and jumps to "+p.getCell());
                        }else{
				Player p2=this.getPlayers(previousCell).get(0);
				System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" throws "+d+"and reaches "+reachedCell+"cell is busy, "+p2+" is sent to "+previousCell);
			}
		 }
	}
	
	/** print the played turn when player doesn't jump
         * @param previousCell the previous cell of p
         * @param reachedCell the cell reached by the p before the rebound
         * @param busy true if p's cell is busy
         * @param p the player
         * @param d the dice thrown
         */
        public void printTurnWhenJumps(Cell previousCell,Cell reachedCell,boolean busy,Player p,int d){
		if(!busy){
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell+" and jumps to "+p.getCell());
		}else{
			Player p2=this.getPlayers(previousCell).get(0);
			System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" throws "+d+"and reaches "+reachedCell+"cell is busy, "+p2+" is sent to "+previousCell);
		}
	}

	/** print the played turn when player doesn't jump
	 * @param previousCell the previous cell of p
         * @param reachedCell the cell reached by the p before the rebound
         * @param busy true if p's cell is busy
         * @param p the player
         * @param d the dice thrown
	 */
	public void printTurnWhenNoJumps(Cell previousCell,Cell reachedCell,boolean busy,Player p,int d){
		if (!busy){
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell);
		}else{
			Player p2=this.getPlayers(previousCell).get(0);
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+"and reaches "+reachedCell+"cell is busy, "+p2+" is sent to "+previousCell);
		}
	}
	
	/**return true if the cell of a player is busy and make the switch
	 * @param p1 the player playing
	 * @param previousCell the previousCell of the player
	 * @return true if the cell of the player is busy
	 */
	public boolean busyCell(Player p1,Cell previousCell){
		List<Player> players=this.getPlayers(p1.getCell());
		Player p2=null;
		for (Player p : players){
			if (p!=p1){
				p2=p;
			}
		}
		if (p2!=null){
			p2.changeCell(previousCell);
			return true;
		}
		return false;
	}

	/**return the reachedCell before the rebound
	 * @param p the player
	 * @param dice the dice
	 * @return the reachedCell before the rebound
	 */
	public Cell moveOn(Player p,int dice){
		Cell previousCell=p.getCell();
		int reachedCellIndex=p.getCell().getIndex()+dice;
		if (p.getCell().getIndex()+dice>this.board.getNbOfCells()){
			reachedCellIndex=this.board.getNbOfCells()-(reachedCellIndex-this.board.getNbOfCells());
		}
		Cell reachedCell=this.board.getCell(reachedCellIndex);
		p.changeCell(reachedCell);
		int finalCellIndex=reachedCell.rebound(dice);
		if (finalCellIndex>this.board.getNbOfCells()){
			finalCellIndex=this.board.getNbOfCells()-(finalCellIndex-this.board.getNbOfCells());
		}
		Cell finalCell=this.board.getCell(finalCellIndex);
		p.changeCell(finalCell);
		return reachedCell;
	}

	/**
	 * start a game until the game isFinished
	 * @throws NoPlayerException when this's thePlayers has no players 
	 * @return the player who won
	 */
	public Player play() throws NoPlayerException {
		if (this.thePlayers.isEmpty()){
			throw new NoPlayerException("No players to play");
		}
		while(! this.isFinished()){
			for (Player p : this.thePlayers){
				if (p.canPlay()){
					Cell previousCell=p.getCell();
					int d=p.twoDiceThrow();
					Cell reachedCell=this.moveOn(p,d);
					boolean busy=this.busyCell(p,previousCell);
					printTurn(previousCell,reachedCell,busy,p,d);
					if(this.isFinished()){
						System.out.println(p+" has won.");
						return p;
					}
				}else{
					System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" cannot play.");
				}
			}
		}
		return null;
	}

	/**return true if the game isFinished
	 *@return true if the game is finished
	 */
	public boolean isFinished(){
		for (Player p : this.thePlayers){
			if (p.getCell().getIndex()==this.board.nbOfCells){
				return true;
			}
		}return false;
	}
}


