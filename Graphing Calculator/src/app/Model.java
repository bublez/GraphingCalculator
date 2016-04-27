package app;

/**
 * contains all the data and logic
 * the controller links the values provided by the model to what is shown in the view
 *
 */
public class Model {
	
	
	public float [] getXValues(float [] XBounds){
		float [] result = new float [1000];
		
		float diff = (XBounds[1] - XBounds[0]) / 1000.0f;
		
		for (int i = 0; i<1000; i++){
			result[i] = diff * i + XBounds[0];
		}
		
		
		return result;
		
	}
	
	public float [] getYValues(float [] XBounds){
		
		float [] XValues = getXValues(XBounds);
		
		float [] result = new float [1000];
		
		for (int i = 0; i<1000; i++){
			result[i] = (float) Math.sin(XValues[i]);
		}

		
		return result;
	}
	
	
	
}
		


