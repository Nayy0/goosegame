package goosegame;

public class GameMain{

	public static void main(String[] args){
		try{
			Board b=new ClassicalBoard();
			Game g=new Game(b);
			for (String name : args){
				Player p=new Player(name);
				p.changeCell(b.getCell(0));
				g.addPlayer(p);
			}
			g.play();
		}catch(NoPlayerException e){
			System.out.println("entrez les noms des joueurs en argument");
		}
	}
}
		

