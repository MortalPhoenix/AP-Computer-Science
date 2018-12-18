package Chapter8Projects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class Number17Panel extends JPanel
{
	Random rand = new Random();

	Point[][] coords = new Point[8][8];
	int STARTLOCATIONX = 100, STARTLOCATIONY = 100;

	public Number17Panel()
	{
		setBackground(Color.orange);
		setPreferredSize(new Dimension(500, 500));

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				coords[i][j] = pointP(STARTLOCATIONX, STARTLOCATIONY);
				STARTLOCATIONX += 40;
			}
			STARTLOCATIONY += 40;
			STARTLOCATIONX -= 320;
		}

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		int redCounter = 0, blackCounter = 0, hold = 0;

		final int width = 40, height = 40;

		STARTLOCATIONX = 100;
		STARTLOCATIONY = 100;

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (g.getColor() == Color.white)
				{
					g.setColor(Color.black);
				} else
					g.setColor(Color.white);

				g.fillRect((int) coords[i][j].getX(), (int) coords[i][j].getY(), width, height);

				hold = rand.nextInt(3);

				if (hold == 0 && redCounter < 5 && g.getColor() == Color.black)
				{
					g.setColor(Color.red);
					g.fillOval((int) coords[i][j].getX(), (int) coords[i][j].getY(), width, height);
					redCounter++;
				}

				else if (hold == 1 && blackCounter < 8 && g.getColor() == Color.black)
				{
					g.setColor(Color.gray);
					g.fillOval((int) coords[i][j].getX(), (int) coords[i][j].getY(), width, height);
					blackCounter++;
				}

				STARTLOCATIONX += 40;

				g.setFont(new Font("Helvetica", Font.BOLD, 25));
				g.drawString(coords[i][j].toString(), 25, 25);
			}

			if (g.getColor() == Color.black || g.getColor() == Color.gray || g.getColor() == Color.red)
			{
				g.setColor(Color.white);
			} else
			{
				g.setColor(Color.black);
			}
			STARTLOCATIONX -= 320;
			STARTLOCATIONY += 40;
		}
	}

	public int getXPosition()
	{
		return STARTLOCATIONX;
	}

	public int getYPosition()
	{
		return STARTLOCATIONY;
	}

	public Point pointP(int x, int y)
	{
		STARTLOCATIONX = x;
		STARTLOCATIONY = y;

		return new Point(STARTLOCATIONX, STARTLOCATIONY);
	}

	public void paintWhiteSquare(Graphics g, int xLocation, int yLocation)
	{
		g.setColor(Color.white);
		g.fillRect(xLocation, yLocation, 40, 40);
	}

	public void paintBlackSquare(Graphics g, int xLocation, int yLocation)
	{
		g.setColor(Color.black);
		g.fillRect(xLocation, yLocation, 40, 40);
	}

	public void paintChecker(Graphics g, int xLocation, int yLocation)
	{
		g.fillOval(xLocation, yLocation, 40, 40);
	}
}