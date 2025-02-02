package application;

public class Model {

	public float calculate(long num1, long num2, String operator)
	{
		//Available operator options
		switch(operator)
		{
			case "+":
				return num1 + num2;
			case "-":
				return num1 - num2;
			case "*":
				return num1 * num2;
			case "/":
				if(num2 == 0)
					return 0;
				else
					return num1 / num2;
			case "%":
				return num1 % num2;
			case "^":
				return (float) Math.pow(num1, num2); //Use casting for type conversion
			case "Sqrt":
				return (float)(Math.sqrt(num1)); 
			default:
				return 0;
		}
			
	}
}
