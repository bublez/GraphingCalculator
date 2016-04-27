package app;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * This class handles all the graphical elements of the program, containing all functions used to display things on the screen.
 * The controller links this with the underlying logic from the model.
 * @author alexbie
 */
public class View {
	
	// background and frame
	public JPanel background;
	public JFrame frame;
	public ScreenPanel screenPanel;
	
	//panel to hold buttons
	public JPanel buttonPanel;
	
	//buttons for moving, tracing, and zooming\
	public JButton leftButton;
	public JButton upButton;
	public JButton rightButton;
	public JButton downButton;
	
	public Button traceMoveToggleButton;
	public JButton zoomInButton;
	public JButton zoomOutButton;
	
	
	public View(){
		
		init();
	}
	
	private void init(){
		
		//create the frame
		frame = new JFrame("GDC");
		frame.setSize(300, 680);
		frame.setLayout(null);
		
		
		//set some default settings
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//add components to the frame
		addComponents();

		update();
	}

	public void update() {
		frame.validate();
		frame.repaint();
		
	}
	
	// add all the components including the dice, buttons, and chart + labels
	private void addComponents() {
		
		// create a screen
		screenPanel = new ScreenPanel(7,7,280);
		frame.add(screenPanel);
		
		// create a panel to hold all the buttons
		buttonPanel = new JPanel();
		buttonPanel.setBounds(7, 290, 280, 48);
		buttonPanel.setLayout(null);
		frame.add(buttonPanel);
		
		//create the up button, add it to the button panel
		upButton = new BasicArrowButton(BasicArrowButton.NORTH, null, Color.GRAY, Color.BLACK, Color.WHITE);
		upButton.setBounds(16,0,15,15);
		buttonPanel.add(upButton);
		
		//create the right button, add it to the button panel
		rightButton = new BasicArrowButton(BasicArrowButton.EAST,null, Color.GRAY, Color.BLACK, Color.WHITE);
		rightButton.setBounds(32,16,15,15);
		buttonPanel.add(rightButton);
		
		//create the down button, add it to the button panel
		downButton = new BasicArrowButton(BasicArrowButton.SOUTH, null, Color.GRAY, Color.BLACK, Color.WHITE);
		downButton.setBounds(16,32,15,15);
		buttonPanel.add(downButton);
		
		//create the left button, add it to the button panel
		leftButton = new BasicArrowButton(BasicArrowButton.WEST, null, Color.GRAY, Color.BLACK, Color.WHITE);
		leftButton.setBounds(0,16,15,15);
		buttonPanel.add(leftButton);
		
		// create the zoom-in button, format it, and then add it to the button panel
		zoomInButton = new JButton(new ImageIcon("res/zoom-in.png"));
		zoomInButton.setBorder(null);
		zoomInButton.setContentAreaFilled(false);
		zoomInButton.setBackground(Color.WHITE);
		zoomInButton.setBounds(48, 0, 24, 24);
		buttonPanel.add(zoomInButton);
		
		// create the zoom-out button, format it, and then add it to the button panel
		zoomOutButton = new JButton(new ImageIcon("res/zoom-out.png"));
		zoomOutButton.setBorder(null);
		zoomOutButton.setContentAreaFilled(false);
		zoomOutButton.setBackground(Color.WHITE);
		zoomOutButton.setBounds(48, 24, 24, 24);
		buttonPanel.add(zoomOutButton);
		
		// create the trace-move toggle button and add it to the button panel
		traceMoveToggleButton = new Button("TRACE");
		traceMoveToggleButton.setBackground(null);
		traceMoveToggleButton.setFont(new Font("Century Gothic", Font.BOLD, 10));
		traceMoveToggleButton.setBounds(72, 12,40,24);
		traceMoveToggleButton.setFocusable(false);
		buttonPanel.add(traceMoveToggleButton);

		
		
		
	
		
	}
	
}
