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
	private ActionListener toggleTraceMoveButtonListener;
	
	public Controller(Model model, View view){
		this.model = model;
		this.view = view;
	}
	
	public void control(){
		
		view.screenPanel.passFunctionCoords(model.getXValues(), model.getSineYValues(),1000);
		
		upButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(0, view.screenPanel.getGridSize()/20.0f);
				}
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					return;
				}
				
				view.screenPanel.update();
				
			}
		};
		view.upButton.addActionListener(upButtonListener);
		
		rightButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(view.screenPanel.getGridSize()/20.0f, 0);
				}
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					view.screenPanel.setTraceIndex(view.screenPanel.getTraceIndex() + (int)(view.screenPanel.getDotsPerUnit() * view.screenPanel.getGridSize()/40.0f));
					view.screenPanel.setCentre(view.screenPanel.getFunctionPoints()[view.screenPanel.getTraceIndex()].getX(), view.screenPanel.getFunctionPoints()[view.screenPanel.getTraceIndex()].getY());
				}
				
				view.screenPanel.update();
				
			}
		};
		view.rightButton.addActionListener(rightButtonListener);
		
		downButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(0, -view.screenPanel.getGridSize()/20.0f);
				}
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					return;
				}
				
				view.screenPanel.update();
				
			}
		};
		view.downButton.addActionListener(downButtonListener);
		
		leftButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.translate(-view.screenPanel.getGridSize()/20.0f, 0);
				}
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					
					view.screenPanel.setTraceIndex(view.screenPanel.getTraceIndex()- (int)(view.screenPanel.getDotsPerUnit() * view.screenPanel.getGridSize()/40.0f));
					view.screenPanel.setCentre(view.screenPanel.getFunctionPoints()[view.screenPanel.getTraceIndex()].getX(), view.screenPanel.getFunctionPoints()[view.screenPanel.getTraceIndex()].getY());
				}
				
				view.screenPanel.update();
				
			}
		};
		view.leftButton.addActionListener(leftButtonListener);
		
		zoomInButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.screenPanel.scale(1.0f/1.15f);

				view.screenPanel.update();
				
			}
		};
		view.zoomInButton.addActionListener(zoomInButtonListener);
		
		zoomOutButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				view.screenPanel.scale(1.15f);

				view.screenPanel.update();
				
			}
		};
		view.zoomOutButton.addActionListener(zoomOutButtonListener);
		
		toggleTraceMoveButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (view.screenPanel.getCurrentMode() == ScreenPanel.MOVE_MODE){
					view.screenPanel.setCurrentMode(ScreenPanel.TRACE_MODE);
					view.traceMoveToggleButton.setLabel("MOVE");
					
					float xCentre = view.screenPanel.getXBoundaries()[0]+view.screenPanel.getGridSize()/2.0f;
					float start = view.screenPanel.getFunctionPoints()[0].getX();
					int index = (int) ((xCentre - start) * view.screenPanel.getDotsPerUnit());
					
					view.screenPanel.setTraceIndex(index);
					
					view.screenPanel.setCentre(view.screenPanel.getFunctionPoints()[index].getX(), view.screenPanel.getFunctionPoints()[index].getY());
				}
				
				else if (view.screenPanel.getCurrentMode() == ScreenPanel.TRACE_MODE){
					view.screenPanel.setCurrentMode(ScreenPanel.MOVE_MODE);
					view.traceMoveToggleButton.setLabel("TRACE");
				}
				
				
				view.screenPanel.update();
				
			}
		};
		
		view.traceMoveToggleButton.addActionListener(toggleTraceMoveButtonListener);
		
		
		
		
		
		
	}

}
