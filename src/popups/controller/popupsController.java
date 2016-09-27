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
		while(!answer.equals(""))		
		{
		display.displayMessage("Look words on the monitor!!!");
		
		answer = display.collectResponse("What is your name?");
		
		count++;
		}
	}
}
