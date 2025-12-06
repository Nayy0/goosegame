package goosegame;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WaitCellTest{

	@Test
	public void canPlayTest(){
		Cell c1=new WaitCell(10,2);
		assertFalse(c1.canPlay());
		assertFalse(c1.canPlay());
		assertTrue(c1.canPlay());
	}
}
