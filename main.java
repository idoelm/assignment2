//Ido Elmakies 316476340
package game;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;


public class main 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{


		Scanner s = new Scanner(System.in);
		
		OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-8");
		writer.write("?לשחק תרצה משחק איזה\n"
				+ "מחשב מול מחשב .1\n"
				+ "מחשב מול שחקן .2\n"
				);
		writer.flush();
		
		int choice = s.nextInt();
		
		switch (choice)
		{
		case 1: 
		{
			Game g = new SelfGame();
			SelfPlayer p1 = new SelfPlayer("X");
			SelfPlayer p2 = new SelfPlayer("O");
			MyThread t1 = new MyThread(g, p1);
			MyThread t2 = new MyThread(g, p2);
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 2: 
		{
			SelfPlayer p1;
			UserPlayer p2;
			Game g = new UserGame();
			if(((int)(Math.random() * (2 - 0) + 0) == 0))
			{
				p1 = new SelfPlayer("X");
				p2 = new UserPlayer("O");
			}
			else
			{
				p1 = new SelfPlayer("O");
				p2 = new UserPlayer("X");
			}
			MyThread t1 = new MyThread(g, p1);
			MyThread t2 = new MyThread(g, p2);
			
			writer.write(p2.GetKind() + " שלך הסימון אוקי\n");
			writer.flush();
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		System.out.println("בי בי");
	}

}
