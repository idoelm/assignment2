//Ido Elmakies 316476340
package game;

public class SelfGame extends Game
{
	public synchronized void SetSign(Player P)
	{
		if(!GetFullBoard() && this.GetStatus())
		{
				System.out.println(P.GetKind() + " של תור");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int[] FreePlace = getFreeRandomCells();
				this.GetBoard()[FreePlace[0]][FreePlace[1]] = P.GetKind();
				this.printBoard();
				SetTurn();
				if(CheckWin() == P.GetKind())
				{
					System.out.println( "😄 " +P.GetKind() + " :הוא המנצח");
					this.SetStatus(false);
				}
				else if(FullBoard())
				{
					this.SetFullBoard(true);
					this.SetStatus(false);
					System.out.println("😭מנצח אין");
				}
		}
	}
}
