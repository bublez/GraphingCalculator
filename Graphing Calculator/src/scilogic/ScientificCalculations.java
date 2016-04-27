package scilogic;

public class ScientificCalculations


/***
 * Project Manager (Owen) Changes:
 * 04/18/16 - Added method overload functionality so second paramater isnt required for trig functions
 * 			- Removed main method and replaced with calculate method
 * 			- Removed static from methods and made calculate method return the values
 */
{
	static String operationType;
	static double par1;
	static double par2;

	// variables with underscores are cancer but required.
	public double calculate(String operationType_, double par1_, double par2_)
	{

		operationType = operationType_;
		par1 = par1_;
		par2 = par2_;

		switch (operationType)
		{
		case "sin":
			return sin();
		
		case "cos":
			return cos();
			
		case "tan":
			return tan();
			
		case "ln":
			return ln();
			
		case "log":
			return log();
			
		case "factorial":
			return factorial((int) par1);
			
		case "power":
			return power();
		
		case "squareRoot":
			return squareRoot();
		
		case "add":
			return add();
			
		case "subtract":
			return subtract();
			
		case "divide":
			return divide();
		
		case "multiply":
			return multiply();
		
		case "inverseSin":
			return inverseSin();
		
		case "inverseCos":
			return inverseCos();
		
		case "inverseTan":
			return inverseTan();
			
		case "tenToTheX":
			return tenToTheX();
			
		case "eToTheX":
			return eToTheX();
		
		case "sqaured":
			return sqaured();
			

		}
		
		return 0;

	}
	
	public double calculate(String operationType_, double par1_)
	{

		operationType = operationType_;
		par1 = par1_;

		switch (operationType)
		{
		case "sin":
			return sin();
		
		case "cos":
			return cos();
			
		case "tan":
			return tan();
			
		case "ln":
			return ln();
			
		case "log":
			return log();
			
		case "factorial":
			return factorial((int) par1);
			
		case "power":
			return power();
		
		case "squareRoot":
			return squareRoot();
		
		case "add":
			return add();
			
		case "subtract":
			return subtract();
			
		case "divide":
			return divide();
		
		case "multiply":
			return multiply();
		
		case "inverseSin":
			return inverseSin();
		
		case "inverseCos":
			return inverseCos();
		
		case "inverseTan":
			return inverseTan();
			
		case "tenToTheX":
			return tenToTheX();
			
		case "eToTheX":
			return eToTheX();
		
		case "sqaured":
			return sqaured();
			

		}
		
		return 0;

	}

	// first variable
	// operation
	// second variable
	// answer
	// answer become first variable and repeat

	 public double sin()
	{
		return Math.sin(par1);

	}

	public double cos()
	{
		return Math.cos(par1);

	}

	public double tan()
	{
		return Math.tan(par1);

	}

	public double ln()
	{
		return Math.log(par1);

	}

	public double log()
	{
		return Math.log10(par1);

	}

	public double factorial(int memeNumber)
	{
		if (memeNumber == 1)
		{
			return 1;

		} else
		{
			return par1 * factorial(memeNumber - 1);
		}

	}

	public double power()
	{
		return Math.pow(par1, par2);

	}

	public double squareRoot()
	{
		return Math.sqrt(par1);

	}

	public double add()
	{
		return (par1 + par2);

	}

	public double subtract()
	{
		return (par1 - par2);

	}

	public double divide()
	{
		return (par1 / par2);

	}

	public double multiply()
	{
		return (par1 * par2);

	}

	public double inverseSin()
	{
		return Math.asin(par1);

	}

	public double inverseCos()
	{
		return Math.acos(par1);

	}

	public double inverseTan()
	{
		return Math.atan(par1);

	}

	public double tenToTheX()
	{
		return Math.pow(10, par1);

	}

	public double eToTheX()
	{
		return Math.pow(Math.E, par1);

	}

	public double sqaured()
	{
		return Math.pow(par1, 2);

	}

}
