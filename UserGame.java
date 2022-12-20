package game;

import java.util.Scanner;

//Ido Elmakies 316476340
public class UserGame extends Game
{
	private Scanner s = new Scanner(System.in);
	private int row,col;
	public synchronized void SetSign(Player P)
	{
		if(!FullBoard() && this.GetStatus())
		{
				System.out.println(P.GetKind() + " של תור");
				int[] FreePlace = getFreeRandomCells();
				if(P instanceof UserPlayer )
				{
					do {
					System.out.println("שלך הסימון להצבת ועמודה שורה בחר אוקי");
					row = s.nextInt();
					col = s.nextInt();
					
					if(row < 0 || row > 3 || col < 0 || col > 3 ||  this.GetBoard()[row][col] != null)
						System.out.println("חוקי לא מהלך");
				
					} while (row < 0 || row > 3 || col < 0 || col > 3 || this.GetBoard()[row][col] != null);
					
					this.GetBoard()[row][col] = P.GetKind();
				}
				else
				{
					this.GetBoard()[FreePlace[0]][FreePlace[1]] = P.GetKind();
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.printBoard();
				SetTurn();
				if(CheckWin() == P.GetKind())
				{
					if(P instanceof UserPlayer)
						System.out.println( "😄 " + "ניצחת ברכות\n" + P.GetKind() + " :הוא המנצח");
					else
						System.out.println("😄 " + P.GetKind() + " :הוא המנצח");
					this.SetStatus(false);
				}
		}
	}
}
