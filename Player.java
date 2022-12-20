//Ido Elmakies 316476340
package game;

public abstract class Player 
{
	private String Kind;
	
	public Player(String s)
	{
		Kind = s;
	}
	
	public String GetKind()
	{
		return this.Kind;
	}
}
