package ch.zhaw.windowImpl;

import javax.swing.*;

import ch.zhaw.canvas.IObject;
import ch.zhaw.canvas.MyObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PropertiesDialog extends JFrame {

	private static final long serialVersionUID = 1L;

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
		
		initWindow();
	}

	private void initWindow()
	{
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		setLocation(posX, posY);
		
		JTextField posXinput = new JTextField();
		posXinput.setText(posX +"");
		add(posXinput, BorderLayout.NORTH);
		
		JTextField posYinput = new JTextField();
		posYinput.setText(posY +"");
		add(posYinput, BorderLayout.CENTER);
		
		JButton okButton = new JButton();
		okButton.setText("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						objects.add(new MyObject(posX, posY, durchmesser));
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
