import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point; 

public class LightLamp extends Applet 
{
	Color[] colArr;
	Thread th;
	boolean colFlag;
	boolean chgFlag;
	int y;
	public void init()
	{
		y=370;
		colFlag=false;
		chgFlag=false;
		colArr=new Color[2];
		colArr[0]=Color.BLACK;
		colArr[1]=Color.YELLOW;
		this.addMouseMotionListener(new MyListener());
		this.addMouseListener(new MyListener());
	}
	public void paint(Graphics g)
	{
		g.setColor(colArr[0]);
		g.drawRect(100,500,600,50);
		g.drawLine(350,350,300,500);
		g.drawLine(450,350,500,500);
		g.drawArc(50,150,700,200,180,180);
		g.drawLine(50,250,100,50);
		g.drawLine(750,250,700,50);
		g.drawOval(100,20,600,50);
		g.drawOval(150,150,50,100);
		g.drawOval(650,150,50,100);
		g.drawOval(350,100,100,200);
		g.drawLine(700,300,700,y);
		g.fillRect(690,y,20,20);
		
		if(colFlag)
			g.setColor(colArr[1]);
		g.fillOval(101,21,599,49);
		g.fillOval(151,151,49,99);
		g.fillOval(651,151,49,99);
		g.fillOval(351,101,99,199);
	}
	class MyListener implements MouseMotionListener,MouseListener
	{
		Point currP;
		public void mouseDragged(MouseEvent e)
		{
			if(chgFlag)
			{
				currP=e.getPoint();
				y=currP.y;
				repaint();
			}
		}
		public void mousePressed(MouseEvent e)
		{
			currP=e.getPoint();
			if(currP.x>=690 && currP.x<=710 && currP.y>=370 &&currP.y<=390)
			{
				chgFlag=true;
				colFlag=!colFlag;
			}
		}
		public void mouseReleased(MouseEvent e)
		{
			if(chgFlag)
			{
				y=370;
				chgFlag=false;
				repaint();
			}
		}
		public void mouseClicked(MouseEvent e)
		{}
		public void mouseEntered(MouseEvent e)
		{}
		public void mouseExited(MouseEvent e)
		{}
		public void mouseMoved(MouseEvent e)
		{}
	}
}