package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * connects the logic of the program with what is visible
 * creates instances of the model (containing the logic) and the view (display code)
 * 
 * @author alexbie
 *
 */
public class Controller {
	
	// instances of model and view
	private Model model;
	private View view;
	
	// listeners for movement
	private ActionListener upButtonListener;
	private ActionListener rightButtonListener;
	private ActionListener downButtonListener;
	private ActionListener leftButtonListener;
	
	// listeners for zoom buttons
	private ActionListener zoomInButtonListener;
	private ActionListener zoomOutButtonListener;
	
	// listeners for the trace toggle button
	private ActionListener traceMoveToggleButtonListener;
	
	public Controller(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Call this method to enable all the button listeners and the functionality they provide.
	 */
	public void control(){
		
		// pass initial function values
		view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
		view.screenPanel.update();
		
		// create the listener for the up button
		upButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// translate the screen, and calculate new values
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(0, view.screenPanel.getGridSize()/20.0f);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));

				}
				
				// if the calculator is in trace mode: no functionality
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					return;
				}
				
				view.screenPanel.update();
				
			}
		};
		view.upButton.addActionListener(upButtonListener);
		
		// create the listener for the right button
		rightButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// translate the screen, and calculate new values
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(view.screenPanel.getGridSize()/20.0f, 0);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));

				}
				
				// if the calculator is in trace mode:
				// translate the screen, calculate new values, and centre the screen on the centre values of the function
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					view.screenPanel.translate(view.screenPanel.getGridSize()/20.0f, 0);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
					Point functionCentre = view.screenPanel.getFunctionPoints()[500];
					view.screenPanel.setCentre(functionCentre.getX(), functionCentre.getY());
				}
				
				
				view.screenPanel.update();
				
			}
		};
		view.rightButton.addActionListener(rightButtonListener);
		
		// create the listener for the down button
		downButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// translate the screen, and calculate new values
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(0, -view.screenPanel.getGridSize()/20.0f);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));

				}
				
				// if the calculator is in trace mode: no functionality
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					return;
				}
			
				view.screenPanel.update();
				
			}
		};
		view.downButton.addActionListener(downButtonListener);
		
		// create the listener for the left button
		leftButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// translate the screen, and calculate new values
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(-view.screenPanel.getGridSize()/20.0f, 0);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));

				}
				
				// if the calculator is in trace mode:
				// translate the screen, calculate new values, and centre the screen on the centre values of the function
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					view.screenPanel.translate(-view.screenPanel.getGridSize()/20.0f, 0);
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
					Point functionCentre = view.screenPanel.getFunctionPoints()[500];
					view.screenPanel.setCentre(functionCentre.getX(), functionCentre.getY());
				}
				
				
				view.screenPanel.update();
				
			}
		};
		view.leftButton.addActionListener(leftButtonListener);
		
		// create listener for the zoom-in button
		zoomInButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// scales the grid size of the screen
				// a smaller gridsize means the screen is more zoomed in.
				view.screenPanel.scale(1.0f/1.15f);
				
				// calculate new function values given the new boundaries
				view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
				view.screenPanel.update();
				
			}
		};
		view.zoomInButton.addActionListener(zoomInButtonListener);
		
		// create listener for the zoom-out button
		zoomOutButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// scales the grid size of the screen
				// a larger gridsize means the screen is more zoomed out.
				view.screenPanel.scale(1.15f);
				
				// calculate new function values given the new boundaries
				view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
				view.screenPanel.update();
				
			}
		};
		view.zoomOutButton.addActionListener(zoomOutButtonListener);
		
		// create the listener for the trace-move toggle button
		traceMoveToggleButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){ // if the current mode is MOVE_MODE, toggle the mode to TRACE_MODE and change the text on the button
					view.screenPanel.setCurrentMode(ScreenPanel.TRACE_MODE);
					view.traceMoveToggleButton.setLabel("MOVE");
					
					//calculate function coordinates within the current xBounds and centre the screen on the functionCentre.
					view.screenPanel.passFunctionCoords(model.getXValues(view.screenPanel.getXBoundaries()), model.getYValues(view.screenPanel.getXBoundaries()));
					Point functionCentre = view.screenPanel.getFunctionPoints()[500];
					view.screenPanel.setCentre(functionCentre.getX(), functionCentre.getY());
					
				
				}
				
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){ // if the current mode is TRACE_MODE, toggle the mode to MODE_MODE and change the text on the button
					view.screenPanel.setCurrentMode(ScreenPanel.MOVE_MODE);
					view.traceMoveToggleButton.setLabel("TRACE");
				}
				
				
				view.screenPanel.update();
				
			}
		};
		view.traceMoveToggleButton.addActionListener(traceMoveToggleButtonListener);
		
		
		
		
		
		
	}

}
