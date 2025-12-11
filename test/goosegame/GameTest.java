package goosegame;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GameTest{
	
	private Board b;
	private Player p1;
	private Player p2;
	private Game g;

	@BeforeEach
	public void before(){
		this.b=new SmallBoard();
		this.p1=new Player("nay");
		this.p2=new Player("sam");
		this.g=new Game(this.b);
		this.g.addPlayer(this.p1);
		this.g.addPlayer(this.p2);
		this.p1.changeCell(this.b.getCell(0));
		this.p2.changeCell(this.b.getCell(0));
	}

	@Test
	public void getPlayersReturnsTheRightPlayers(){
		List<Player> lP=this.g.getPlayers(this.b.getCell(0));
		assertSame(this.p1,lP.get(0));
		assertSame(this.p2,lP.get(1));
		List<Player> lP2=this.g.getPlayers(this.b.getCell(1));
		assertTrue(lP2.isEmpty());
	}

	@Test
	public void busyReturnsFalseWhenCellIsNotBusy(){
		this.p1.changeCell(this.b.getCell(3));
		assertFalse(this.g.busyCell(this.p1,this.b.getCell(0)));
	}

	@Test
	public void busyCellReturnsTrueAndDoesTheSwitch(){
		assertTrue(this.g.busyCell(this.p1,this.b.getCell(3)));
		assertSame(this.b.getCell(0),this.p1.getCell());
		assertSame(this.b.getCell(3),this.p2.getCell());
	}

	@Test
	public void moveOnWorksWithAllTypesOfCell(){
		assertSame(this.b.getCell(2),this.g.moveOn(this.p1,2));
		assertSame(this.b.getCell(4),this.p1.getCell());
		assertSame(this.b.getCell(4),this.g.moveOn(this.p2,4));
		assertSame(this.b.getCell(4),this.p2.getCell());
		assertSame(this.b.getCell(4),this.p1.getCell());
	}

	@Test
	public void moveOnWorksWellWhenPlayerExceedTheArival(){
		assertSame(this.b.getCell(5),this.g.moveOn(this.p1,7));
		assertSame(this.b.getCell(1),this.p1.getCell());
	}
	
	@Test
	public void playThrowsNoPlayerExeptionWhenNoPlayers(){
		Game g2=new Game(this.b);
		assertThrows(NoPlayerException.class, () -> g2.play());
	}

	@Test
	public void isFinishedTest(){
		assertFalse(this.g.isFinished());
		this.g.moveOn(this.p1,2);
		assertFalse(this.g.isFinished());
		this.g.moveOn(this.p2,6);
		assertTrue(this.g.isFinished());
	}
}

