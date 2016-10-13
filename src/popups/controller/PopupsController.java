package popups.controller;

import popups.view.PopupViewer;
import popups.model.Thingy;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PopupsController
{
	private PopupViewer display;
	private List<Thingy> thingyList;
	private Scanner readKeyboardInput;
	
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
		
		thingyList.get(3).setWords("I just changed what is inside");
		Thingy tempThingy = thingyList.get(4);
		tempThingy.setWords("also changed");
		
		for (int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage(thingyList.get(index).getWords());
		}
		
		Thingy replacement = new Thingy();
		replacement.setWords("I am a replicant");
		
		Thingy old = thingyList.set(0, replacement);
		
		for (int index = 0; index < thingyList.size(); index++)
		{
			display.displayMessage(thingyList.get(index).getWords());
		}
		old.setWords("I was replaced:(");
		display.displayMessage(old.getWords());
		
		thingyList.remove(4);
		display.displayMessage("The size is now " + thingyList.size());
		old = thingyList.remove(4);
		display.displayMessage("The size is now " + thingyList.size());
		display.displayMessage("This is what I removed: " + old. getWords());
		thingyList.add(0, old);
		
		String answer = "none";
		answer = display.collectResponse("Type in what you want to change the spot '4' in the list:");
		//thingyList.set(4, answer);
		
		//for-each loops
		for (Thingy currentThingy : thingyList)
		{
			display.displayMessage("The current value is " + currentThingy.getWords());
		}
		
		for (Thingy currentThingy : thingyList)
		{
			currentThingy.setWords(currentThingy.getWords() + "number");
		}
		
		for (Thingy currentThingy : thingyList)
		{
			display.displayMessage("The current value is " + currentThingy.getWords());
		}
	}
}