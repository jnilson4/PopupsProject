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
		display.displayMessage("Look words on the monitor!!!");
	}
}
