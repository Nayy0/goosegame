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

	/**
	 * start a game until the game isFinished
	 */
	public Player play(){
		while(! this.isFinished()){
			for (Player p : this.thePlayers){
				if (p.canPlay()){
					int d=p.twoDiceThrow();
					this.board.moveOn(p,d);
					System.out.println();
					if(this.isFinished){
						Systeme.out.println(p+"has won.");
						return p;
					}
				}else{
					p.getCell.badEffect();
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


