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
		while(count < 10)		
		{
		display.displayMessage("Look words on the monitor!!!");
		
		String answer = display.collectResponse("What is your name?");
		
		count++;
		}
	}
}
