
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

import elements.Message;
import elements.Server;
import elements.User;

/**
 * Defines a class that implements a simulation of a basic messaging program.
 * @author leylayayladere
 * @version 1.0
 */
public class Main {
	
	/**
	 * Reads the input from input file, takes the type of event number from input and then does the appropriate operations.
	 * <p> While doing the appropriate operations which are given in input file, writes required informations to output file.
	 * @param args Takes input file to give an appropriate output file, also in order to test the code.
	 * @throws FileNotFoundException Prevents from an error in case of the file not found.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		
		int numOfUsers = input.nextInt();
		int numOfQueries = input.nextInt();
		long capacity = input.nextLong();
		
		ArrayList<User> users = new ArrayList<User>();
		int id = 0;
		
		while(numOfUsers != 0) {
			users.add(new User(id));
			id++;
			numOfUsers--;
		}
		
		Server server = new Server(capacity);
		int time = 0; 
		
		while(numOfQueries != 0) {
			int typeOfEvent = input.nextInt();
			
			if(typeOfEvent == 0) { //sends a message
				int senderID = input.nextInt();
				int receiverID = input.nextInt();
				String msgBody = input.nextLine(); 
				msgBody = msgBody.substring(1); 
				users.get(senderID).sendMessage(users.get(receiverID), msgBody, time, server);
				server.checkServerLoad(output);
				time++;
			}
			if(typeOfEvent == 1) { //receives messages
				int receiverID = input.nextInt();
				users.get(receiverID).getInbox().receiveMessages(server, time);
				server.checkServerLoad(output); 
				time++;
			}
			if(typeOfEvent == 2) { //reads certain amount of messages
				int receiverID = input.nextInt();
				int numOfMsgs = input.nextInt();
				int num = users.get(receiverID).getInbox().readMessages(numOfMsgs, time);
				while(num != 0) {
					time++;
					num--;
				}
	
			}
			if(typeOfEvent == 21) { //reads all messages from a sender
				int receiverID = input.nextInt();
				int senderID = input.nextInt();
				int num = users.get(receiverID).getInbox().readMessages(users.get(senderID), time);
				while(num != 0) {
					time++;
					num--;
				}
			}
			if(typeOfEvent == 22) { //reads a specific message
				int receiverID = input.nextInt();
				int msgID = input.nextInt();
				users.get(receiverID).getInbox().readMessage(msgID, time);
				time++;
			}
			if(typeOfEvent == 3) { //adds a friend
				int id1 = input.nextInt();
				int id2 = input.nextInt();
				if(users.get(id1).isFriendWith(users.get(id2))) {
					// do nothing 
				}else {
					users.get(id1).addFriend(users.get(id2));
				}
				time++;
			}
			if(typeOfEvent == 4) { //removes a friend
				int id1 = input.nextInt();
				int id2 = input.nextInt();
				if(users.get(id1).isFriendWith(users.get(id2))) {
					users.get(id1).removeFriend(users.get(id2));
				}else {
					// do nothing
				}
				time++;
			}
			if(typeOfEvent == 5) { //flushes server
				server.flush();
				time++;
			}
			if(typeOfEvent == 6) { //prints the current size of the serve
				output.println("Current load of the server is " + server.getCurrentSize() + " characters.");
				time++;
			}
			if(typeOfEvent == 61) { //prints the last message a user has read
				int userID = input.nextInt();
				
				Iterator<Message> itr = users.get(userID).getInbox().getRead().iterator();
				
				if(!users.get(userID).getInbox().getRead().isEmpty()) {
				
					Message last = itr.next();
					
					while(itr.hasNext()) {
						last = itr.next();
					}
					
					output.println(last.toString());
					
				}
				time++;
			}
			
			numOfQueries--;
		}
		
	}
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

