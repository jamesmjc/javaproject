package ist261.chatbot.infra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.rmi.CORBA.Util;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class ChatbotGUI extends JFrame {

	private Chatbot nowChatbot;
	
	private JFrame nowGUIFrame;
	
	private JTextField inputTextBox;
	private JTextPane chatHistoryPane;
	
	private JButton psuButton;
	
	public ChatbotGUI(Chatbot nowChatbot) {
		
		this.nowChatbot = nowChatbot;
		
		/*
		 * Task 1: Make the interface prettier!
		 * 
		 * Desc:
		 * As you can see, this interface (GUI) is kind of ugly. Please try to modify the following
		 * code to move the components around or change their appearance (color, size, etc) to make
		 * this interface looks nicer. Please explain what you did in your video.
		 * 
		 */
		
		//create the frame of chatbot
		nowGUIFrame = new JFrame();
		nowGUIFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nowGUIFrame.setVisible(true);
		nowGUIFrame.setResizable(false);
		nowGUIFrame.setLayout(null);
		nowGUIFrame.setSize(500, 600);
		nowGUIFrame.setTitle("Chatbot "+nowChatbot.getBotName()+"");
		
		
		//create JTextPane
		chatHistoryPane = new JTextPane();
		nowGUIFrame.add(chatHistoryPane);
		chatHistoryPane.setSize(500, 450);
		chatHistoryPane.setLocation(2, 2);
		
		//create JTextField
		inputTextBox = new JTextField();
		nowGUIFrame.add(inputTextBox);
		inputTextBox.setSize(497, 30);
		inputTextBox.setLocation(2, 455);
		inputTextBox.addActionListener(new InputTextListener(inputTextBox, chatHistoryPane, this));
		
		/*
		 * Task 2: Connect the "We are!" button to the chatbot and show the response on the chat pane. 
		 * 
		 * Desc:
		 * This "We are!" button automatically sends a "We are!" message to the chat pane. However, it
		 * does not send the message to the chatbot, nor showing the chatbot's response on the chat
		 * pane. Please finish this part. Namely, when you click this button, the chat pane will (1)
		 * show "[USER NAME]: We are!", (2) pass this message to the chatbot and receive its response,
		 * and (3) show "[BOT NAME]: [RESPONSE SENT BY THE BOT]" on the chat pane.
		 * 
		 */
		
		//create JButton
		psuButton = new JButton("We are!", null);
		nowGUIFrame.add(psuButton);
		psuButton.setBounds(2, 500, 140, 40);
		psuButton.addActionListener(new ButtonListener(chatHistoryPane, this));
	
		
		/*
		 * Task 3: Add a response in Chatbot.java to respond to "We are!". 
		 * 
		 * Desc:
		 * Now you finish the "We are!" button, however, the chat pane only shows "[BOT NAME]: We are!
		 *  [ECHO]". Please go to Chatbot.java to implement an automatic response. 
		 *   
		 */
	    	
	}

	public ChatbotGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public Chatbot getChatbot() {
		return nowChatbot;
	}
	
	public static void appendToPane(JTextPane nowPane, String senderName, String message, Color color){
		
		String nowMsg = senderName+": "+message+"\n";
		
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 16);
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = nowPane.getDocument().getLength();
        nowPane.setCaretPosition(len);
        nowPane.setCharacterAttributes(aset, false);
        nowPane.replaceSelection(nowMsg);
        
    }
}

class ButtonListener implements ActionListener{
	
	private ChatbotGUI chatbotUtil;
	
	//private JTextField nowInputTextBox;
	private JTextPane nowChatHistoryPane;
	
	public ButtonListener(JTextPane chatHistoryPane, ChatbotGUI chatbotUtil) {
		this.chatbotUtil = chatbotUtil;
		//nowInputTextBox = inputTextBox;
		nowChatHistoryPane = chatHistoryPane;
		//nowUserName = userName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ChatbotGUI.appendToPane(nowChatHistoryPane, chatbotUtil.getChatbot().getUserName(), "We are!", Color.BLUE);
		
		String nowChatbotResponse = chatbotUtil.getChatbot().getResponse("We are!");
		ChatbotGUI.appendToPane(nowChatHistoryPane, chatbotUtil.getChatbot().getBotName(), nowChatbotResponse, Color.BLACK);
		
	}
	
}

class InputTextListener implements ActionListener{
	
	private ChatbotGUI chatbotUtil;
	
	private JTextField nowInputTextBox;
	private JTextPane nowChatHistoryPane;
	
	public InputTextListener(JTextField inputTextBox, JTextPane chatHistoryPane, ChatbotGUI chatbotUtil) {
		this.chatbotUtil = chatbotUtil;
		nowInputTextBox = inputTextBox;
		nowChatHistoryPane = chatHistoryPane;
		//nowUserName = userName;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nowInputText = nowInputTextBox.getText();
		ChatbotGUI.appendToPane(nowChatHistoryPane, chatbotUtil.getChatbot().getUserName(), nowInputText, Color.BLUE);
		
		String nowChatbotResponse = chatbotUtil.getChatbot().getResponse(nowInputText);
		ChatbotGUI.appendToPane(nowChatHistoryPane, chatbotUtil.getChatbot().getBotName(), nowChatbotResponse, Color.BLACK);
		
		//
		//appendToPane(nowChatHistoryPane, nowMsg, Color.BLUE);
		
		nowInputTextBox.setText("");
		
	}
	
	
}

