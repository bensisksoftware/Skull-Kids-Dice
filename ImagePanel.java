import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.Graphics2D;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel implements ActionListener {
	Timer timer = new Timer(22, this); // Draws image every x miliseconds. 5 is good
	
	Image skullkids = new ImageIcon("skullkidsjpg").getImage();
	
	public ImagePanel() {
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {	
		repaint();
	}
}