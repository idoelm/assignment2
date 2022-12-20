//Ido Elmakies 316476340
package game;

public class MyThread extends Thread
{
	Game g;
	Player p;
	
	 public MyThread(Game MyGame, Player MyPlayer)
	 {
		this.g = MyGame;
		this.p = MyPlayer;
	 }
	 
	 public void run()
	 {
		
		 
		 while (g.GetStatus())
		 {
			 synchronized (g) 
			 {
			 while(g.GetTurn() != p.GetKind())
			 {
				 synchronized (g) 
				 {
					 try 
					 {
						 g.wait();
			        } catch (InterruptedException e) 
			        {
			          // handle exception
			        }
				}
		    }
			g.SetSign(p);
			g.notifyAll();
		  }
		 }
	 } 
}
