package app;


public class AppThread implements Runnable{

	private View view;
	private Model model;
	private Controller controller;
	
	
	@Override
	public void run() {
		
		
		System.out.println("appThread running!");
		init();
	}
	
	
	public void init(){
		
		//sets up instances of view and model, and attaches it to the instance of controller
		view = new View();
		
		
		model = new Model();
		controller = new Controller(model, view);
		
		// runs the controller, attaches all the listeners to the buttons and screen components
		controller.control();
	}
	
	
	


}
