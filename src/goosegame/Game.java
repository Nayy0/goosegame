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
	 */
	public Game(Board b){
		this.board=b;
		this.thePlayers=new ArrayList<Player>();
	}

	/**
	 * add a player to this's thePlayers
	 */
	public void addPlayer(Player p){
		this.thePlayers.add(p);
	}
	
	/**return a different player at the given cell 
	 * @param c
	 * @param p the player we don't want to have
	 * @return a different player at the given cell
	 */
	public Player getPlayer(Cell c,Player p2){
		for (Player p2 : this.thePlayers){
			if (p2.getCell()==c && p1!=p2){
				return p2;
			}
		}return null;
	}

	/**print the played turn
	 * @param previousCell
	 * @param reachedCell
	 * @param busy
	 * @param p the player
	 * @param d
	 */
	private void printTurn(Cell previousCell,Cell reachedCell,boolean busy,Player p,int d){
		if (reachedCell==p.getCell){
                	this.printTurnWhenNoJumps(Cell previousCell,Cell reachedCell,boolean busy,Player p,int d);
	       	}else{
			 if (!busy){
                                System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell+" and jumps to cell "+p.getCell());
                        }else{
				Player p2=this.getPlayer(previousCell,p);
				System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" throws "+d+"and reaches "+reachedCell+"cell is busy, "+p2+" is sent to "previousCell);
			}
		 }
	}
	
	/** print the played turn when player doesn't jump
         * @param previousCell
         * @param reachedCell
         * @param busy
         * @param p the player
         * @param d
         */
        public void printTurnWhenJumps(Cell previousCell,Cell reachedCell,boolean busy,Player p,d){
		if(!busy){
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell+" and jumps to cell "+p.getCell());
		}else{
			Player p2=this.getPlayer(previousCell,p);
			System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" throws "+d+"and reaches "+reachedCell+"cell is busy, "+p2+" is sent to "previousCell);
		}
	}

	/** print the played turn when player doesn't jump
	 * @param previousCell
         * @param reachedCell
         * @param busy
         * @param p the player
	 * @param d
	 */
	public void printTurnWhenNoJumps(Cell previousCell,Cell reachedCell,boolean busy,Player p,d){
		if (!busy){
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+" and reaches "+reachedCell);
		}else{
			Player p2=this.getPlayer(previousCell);
			System.out.println(p+" is in cell "+previousCell.getIndex()+", "+p+" throws "+d+"and reaches "+rechedCell+"cell is busy, "+p2+" is sent to "+previousCell);
		}
	}
	
	/**return true if the cell of a player is busy and make the switch
	 * @param p the player
	 * @param previousCell the previousCell of the player
	 * @return true if the cell of the player is busy
	 */
	public boolean busyCell(Player p,Cell previousCell){
		p2=this.getPlayer(p.getCell(),p);
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
		Cell reachedCell=this.board[reachedCellIndex];
		p.changeCell(reachedCell);
		int finalCellIndex=reachedCell.rebound();
		Cell finalCell=this.board[finalCellIndex];
		p.changeCell(finalCell);
		this.busyCell(p,previousCell);
		return reachedCell;
	}

	/**
	 * start a game until the game isFinished
	 */
	public Player play(){
		while(! this.isFinished()){
			for (Player p : this.thePlayers){
				if (p.canPlay()){
					Cell previousCell=p.getCell();
					int d=p.twoDiceThrow();
					Cell reachedCell=this.moveOn(p,d);
					boolean busy=this.busyCell(p,previousCell);
					printTurn(previousCell,reachedCell,busy,p,d);
					if(this.isFinished){
						Systeme.out.println(p+"has won.");
						return p;
					}
				}else{
					System.out.println(p+" is in cell "+p.getCell().getIndex()+", "+p+" cannot play.");
				}
			}
		}
	}

	/**return true if the game isFinished
	 *@return true if the game is finished
	 */
	public boolean isFinished(){
		return board.isFinished();
	}
}


