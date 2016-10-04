package popups.controller;

import popups.view.PopupViewer;
import popups.model.Thingy;
import java.util.List;
import java.util.ArrayList;

public class PopupsController
{
	private PopupViewer display;
	private List<Thingy> thingyList;
	
	public PopupsController()
	{
		display = new PopupViewer();
		thingyList = new ArrayList<Thingy>();
		//ArrayList is a type of List.
	}
	
	public void start()
	{
		learnLists();
	}
	
	private void askQuestionLoop()
	{
		String answer = "sample";
		
		while(answer != null && !isDouble(answer))		
		{
			answer = display.collectResponse("You need to type in a double!");
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
			display.displayMessage("That was not a double! =:<");
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
			display.displayMessage("You need to type in an int!");
		}
		
		return validInteger;
	}
	
	private void learnLists()
	{
		display.displayMessage("This is the size of the list: " + thingyList.size());
		Thingy firstThingy = new Thingy();
		thingyList.add(firstThingy);
		display.displayMessage("This is the size of the list: " + thingyList.size());
		Thingy secondThingy = new Thingy();
		thingyList.add(secondThingy);
		display.displayMessage("This is the size of the list: " + thingyList.size());
		Thingy thirdThingy = new Thingy();
		thingyList.add(thirdThingy);
		display.displayMessage("This is the size of the list: " + thingyList.size());
		
		for (int index = 0; index < 5; index++)
		{
			Thingy loopThingy = new Thingy();
			thingyList.add(loopThingy);
		}
		
		for (int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage("The thingy as this spot has words of: " + thingyList.get(index).getWords());
		}
		
		Thingy specialThingy = new Thingy();
		specialThingy.setWords("not null stuff");
		
		thingyList.add(1, specialThingy);
		
		for (int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage("The message at " + index + " is " + thingyList.get(index).getWords());
		}
		
	}
}