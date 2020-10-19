package ist261.main;

import ist261.chatbot.infra.Chatbot;
import ist261.chatbot.infra.ChatbotGUI;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Chatbot nowChatbot = new Chatbot("James", "TestBot");
		
		ChatbotGUI nowChatbotGUI = new ChatbotGUI(nowChatbot);

	}

}
