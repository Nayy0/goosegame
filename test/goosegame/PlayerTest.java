package goosegame;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{

	@Test
	public void canPlayTest(){
		Cell c1=new Cell(4);
		Player p1=new Player("nay");
		p1.changeCell(c1);
		assertTrue(p1.canPlay());
		Cell c2=new TrapCell(2);
		p1.changeCell(c2);
		assertFalse(p1.canPlay());
	}
}
