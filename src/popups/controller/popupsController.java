package popups.controller;

import popups.view.PopupViewer;

public class PopupsController
{
	private PopupViewer display;
	
	public PopupsController()
	{
		display = new PopupViewer();
	}
	
	public void start()
	{
		int count = 0;
		String answer = "sample";
		while(answer != null && !answer.equals(""))		
		{
		display.displayMessage("Look words on the monitor!!!");
		
		answer = display.collectResponse("What is your name?");
		
		count++;
		}
	}
	
	/**
	 * Checks a supplied String value to see if it can be converted to a Double.
	 * @param potentialValue The supplied String.
	 * @return Whether the conversion to a double is possible as a boolean value.
	 */
	private boolean isDouble(String potentialValue)
	{
		boolean validDouble = false;
		
		try 
		{
			double testValue = Double.parseDouble(potentialValue);
			validDouble = true;
		}
		catch(NumberFormatException notDoubleError)
		{
			display.displayMessage("That was not a double =:<");
		}
		
		return validDouble;
	}
	
	/**
	 * Checks a supplied String value if it can be converted to an Integer. If it cannot a popup message is displayed.
	 * @param potentialValueThe supplied String.
	 * @return Whether the conversion to an integer is possible.
	 */
	private boolean isInteger(String potentialValue)
	{
		boolean validInteger = false;
		
		try
		{
			int testValue = Integer.parseInt(potentialValue);
			validInteger = true;
		}
		catch(NumberFormatException notIntegerError)
		{
			display.displayMessage(notIntegerError.getMessage());
			display.displayMessage("YOu need to type in an int!");
		}
		
		return validInteger;
	}
}