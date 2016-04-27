package app;

/**
 * This class serves as a simple data structure to couple x and y coordinates to simplify the drawing process.
 * @author alexbie
 */
public class Point {
	
	private float x;
	private float y;
	
	public final static int VAR_X = 0;
	public final static int VAR_Y = 1;
	
	public Point(){
		this.x = 0;
		this.y = 0;
	}
	
	public Point(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
		
	}
	
	public float getY(){
		return y;
	}
	
	/**
	 * given an array of points, this function extracts the specified type of variable and organizes it into an array
	 * 
	 * @param type the type of variable extracted from the 
	 * @param points the point array where the values are extracted from
	 */
	public static int [] getIntegerValues(int var, Point [] points){
		
		int [] result =  new int [points.length];
		
		if (var == VAR_X){
			
			for (int i =0; i< points.length; i++){
				result[i] = (int) points[i].getX();
			}
			
		}
		
		else if (var == VAR_Y){
			
			for (int i =0; i< points.length; i++){
				result[i] = (int) points[i].getY();
			}
			
		}
		
		else {
			System.err.println("Unrecognized variable type.");
		}
		
		return result;
	}

}
