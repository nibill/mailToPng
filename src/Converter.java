import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class Converter
{
	public Converter()
	{
		
	}
	
	Viewer viewer = new Viewer();
	BufferedImage image;
	
	protected void convert(String mailAddress)
	{
		int width = (mailAddress.length() * 7) + 5;
		int heigth = 16;
		
		image = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		g2.drawString(mailAddress, 10, 10);
	}
	
	public void save(JFileChooser saver)
	{
		if (saver.showSaveDialog(Viewer.frame) == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				if (saver.getSelectedFile().getAbsolutePath()
						.toLowerCase().endsWith(".png"))
					ImageIO.write(image, "png", saver.getSelectedFile());
				else
					ImageIO.write(image, "png", new File(saver
							.getSelectedFile().getAbsolutePath()
							+ ".png"));
			} catch (IOException e)
			{
				System.out.println("Doesn't work");
			}
		}

	}
}
