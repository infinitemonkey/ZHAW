package ch.zhaw.windowImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ch.zhaw.App;
import ch.zhaw.log.Logger;
import ch.zhaw.window.IWindow;

public class MenuBarDecorator extends WindowDecorator {
    
	public MenuBarDecorator (IWindow decoratedWindow) {
        super(decoratedWindow);
        draw();
    }
 
    @Override
    public void draw() {
        decoratedWindow.draw();
        drawMenuBar();
    }
 
    private void drawMenuBar() {
    	Logger.info("SimpleWindow: MenuBarDecorator: drawMenuBar()");
        JMenuBar menuBar = new JMenuBar();
        decoratedWindow.getFrame().setJMenuBar(menuBar);
        JMenu menu = new JMenu("Datei");
        menuBar.add(menu);
        
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem exitAction = new JMenuItem("Exit");

        menu.add(newAction);
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Logger.info("SimpleWindow: MenuBarDecorator: newAction");
            	App.restart();
            }
        });
        menu.add(exitAction);
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Logger.info("SimpleWindow: MenuBarDecorator: exitAction");
            	System.exit(1);
            }
        });
    }
 
    @Override
    public String getDescription() {
        return decoratedWindow.getDescription() + ", + vertical scrollbars";
    }

    @Override
	public JFrame getFrame() {
		return decoratedWindow.getFrame();
	}
}
