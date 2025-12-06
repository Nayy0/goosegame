package goosegame;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GooseCellTest{

	@Test
	public void reboundTest(){
		int dice=5;
		Cell c1=new GooseCell(1);
		assertSame(6,c1.rebound(5));
	}
}
