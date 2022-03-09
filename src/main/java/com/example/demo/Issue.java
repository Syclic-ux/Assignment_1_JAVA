package com.example.demo;
/**
 * <h2>Issue</h2>
 * This class handles all ticket issue related stuff
 * @author ianmhenriquez
 *
 */
public class Issue {
	static int i = 0;
	/**
	 * This method tracks and add to a ticketNumber 
	 * @param obj this is the student that issues the ticket
	 * @param item this is the item he is issuing a ticket for
	 */
	public void IssueTicket(Student obj, Library_Item item) {
		if(item.getLibitem_qnt() == 0) {
			i++;
			obj.setTicketNum(i);
		}
	}
}
