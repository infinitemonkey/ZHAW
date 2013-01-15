package ch.zhaw.windowImpl;

import javax.swing.*;

import ch.zhaw.canvas.IObject;
import ch.zhaw.canvas.IObjectFactory;
import ch.zhaw.canvas.MyObject;
import ch.zhaw.canvas.ObjectFactory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PropertiesDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	IObjectFactory objectFactory;
	
	private int posX;
	private int posY;
	private int durchmesser;
	private ArrayList<IObject> objects;
	
	public PropertiesDialog(ArrayList<IObject> objects, int posX, int posY, int durchmesser)
	{
		super("New Object: Properties");
		
		this.posX = posX;
		this.posY = posY;
		this.durchmesser = durchmesser;
		this.objects = objects;
		this.objectFactory = new ObjectFactory();
		
		initWindow();
	}

	private void initWindow()
	{
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 110));
		setLocation(posX, posY);
		
		JPanel northFrame = new JPanel();
		northFrame.setLayout(new BorderLayout());
		add(northFrame, BorderLayout.NORTH);
		
		JLabel posXlabel = new JLabel("posX");
		northFrame.add(posXlabel, BorderLayout.WEST);
		
		final JTextField posXinput = new JTextField();
		posXinput.setText(posX +"");
		northFrame.add(posXinput, BorderLayout.EAST);
		
		
		JPanel southFrame = new JPanel();
		southFrame.setLayout(new BorderLayout());
		add(southFrame, BorderLayout.CENTER);
		
		JLabel posYlabel = new JLabel("posY");
		southFrame.add(posYlabel, BorderLayout.WEST);
		
		final JTextField posYinput = new JTextField();
		posYinput.setText(posY +"");
		southFrame.add(posYinput, BorderLayout.EAST);
		
		JButton okButton = new JButton();
		okButton.setText("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						objects.add(objectFactory.createInstanceOfObject(Integer.parseInt(posXinput.getText()), Integer.parseInt(posYinput.getText()), durchmesser, 1000));
						dispose();
			}
		});
		add(okButton, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	//button ok click:
	//objects.add(new MyObject(x, y, 10));
	
	
	public int getDurchmesser() {
		return durchmesser;
	}

	public int getPosY() {
		return posY;
	}

	public int getPosX() {
		return posX;
	}
}
