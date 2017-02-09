package helloWorldButtonPackage;
import java.awt.*;

import io;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame {
	private JButton plainButton, fancyButton;
	
	public ButtonTest()
	{
		super("Testing Buttons");
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//create buttons
		plainButton = new JButton("Plain Button");
		c.add(plainButton);
		
		Icon bug1 = new ImageIcon("penguineyes.gif");
		Icon bug2 = new ImageIcon("spam.jpg");
		fancyButton = new JButton("Fancy Button", bug1);
		fancyButton.setRolloverIcon(bug2);
		c.add(fancyButton);
		
		//instance of inner class ButtonHandler to use for button event handing
		
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		plainButton.addActionListener(handler);
		
		setSize(275, 100);
		show();
	}
	
	public static void main(String args[])
	{
		ButtonTest app = new ButtonTest();
		
		app.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	}

	// inner class for button handling
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "You pressed: " + e.getActionCommand());
		}
	}
}