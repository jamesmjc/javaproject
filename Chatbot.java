package ist261.chatbot.infra;

import javax.lang.model.util.ElementScanner6;

public class Chatbot {
	
	private String userName = "YOUR NAME HERE";
	private String botName = "BOT NAME HERE";
	
	public Chatbot(String userName, String botName) {
		this.userName = userName;
		this.botName = botName;
	}
	
	public String getResponse(String nowInputText) {
		// TODO Auto-generated method stub
		
		/*
		 * Example 1: Simply echo
		 */
		//return nowInputText+" (ECHO)";
		
		/*
		 * Example 2: Simple version of "Hello"
		 */
		if(nowInputText.toUpperCase().contains("HI")||nowInputText.toUpperCase().contains("HELLO")) {
			return "Hi, nice to meet you :) I am "+botName+".";
		}
		else if(nowInputText.toUpperCase().contains("WE ARE"))
		{
			return "Penn State!";
		}
		else 
		{
			return nowInputText+" (ECHO)";
		}
	}
		

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBotName() {
		return botName;
	}

	public void setBotName(String botName) {
		this.botName = botName;
	}

	
	
	

}
