package application;

import java.util.Date;

import javafx.scene.control.Label;

//the double linked list of locations
public class DoublyLinkedList1 {
	private LocationNode head;
	private LocationNode tail;
	private String string = new String();
	private int numberOfMartyrs;
	private Martyr martyr;
	private LocationNode locationNode;
	private String Report="";
	

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public LocationNode getTail() {
		return tail;
	}

	public void setTail(LocationNode tail) {
		this.tail = tail;
	}

	public LocationNode getHead() {
		return head;
	}

	public void setHead(LocationNode head) {
		this.head = head;
	}

	public LocationNode getLocationNode() {
		return locationNode;
	}

	public void setLocationNode(LocationNode locationNode) {
		this.locationNode = locationNode;
	}

	public Martyr getMartyr() {
		return martyr;
	}

	public void setMartyr(Martyr martyr) {
		this.martyr = martyr;
	}

	public int getNumberOfMartyrs() {
		return numberOfMartyrs;
	}

	public void setNumberOfMartyrs(int numberOfMartyrs) {
		this.numberOfMartyrs = numberOfMartyrs;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public DoublyLinkedList1() {

	}

//add sorted location
	public void insertOrderedLocation(String location) {
		LocationNode newNode = new LocationNode(location);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			LocationNode current = head;
			while (current != null) {
				
				int comparison = location.compareToIgnoreCase(current.getLocation());
				 if (comparison == 0) {
						// Duplicate location found, no need to insert
						return;
					}
				 else if (comparison < 0) {
					// Insert newNode before current node
					if (current == head) {
						newNode.setNext(current);
						current.setPrev(newNode);
						head = newNode;
					} else {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
					}
					return;
				} 
				current = current.getNext();
			}

			// Insert newNode at the end of the list
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void insertOrUpdateLocation(String location, Martyr martyr) {
		// exist location
		if (head == null) {
			LocationNode newNode = new LocationNode(location);
			newNode.getMartyrsList().insertSorted(martyr);
			head = newNode;
			tail = newNode;
		} else {
			LocationNode current = head;

			while (current != null) {
				if (current.getLocation().equals(location)) {
					current.getMartyrsList().insertSorted(martyr);
					return;
				}
				current = current.getNext();
			}

//to add new location
			LocationNode newNode = new LocationNode(location);
			newNode.getMartyrsList().insertSorted(martyr);

			if (location.compareToIgnoreCase(head.getLocation()) < 0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else if (location.compareToIgnoreCase(tail.getLocation()) > 0) {
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else {
				current = head.getNext();
				while (current != null) {
					if (location.compareToIgnoreCase(current.getLocation()) < 0) {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
						break;
					}
					current = current.getNext();
				}
			}
		}
	}

	// search location
	public boolean searchLocation(String location) {
		LocationNode current = head;

		while (current != null) {
			if (current.getLocation().equalsIgnoreCase(location)) {
				return true;
			}
			current = current.getNext();
		}

		return false; 
	}

//update input location
	public boolean updateLocation(String oldLocation, String newLocation) {
		LocationNode current = head;
		boolean locationUpdated = false;
		while (current != null) {
			if (current.getLocation().equalsIgnoreCase(oldLocation)) {
				current.setLocation(newLocation);

				locationUpdated = true;
			}
			current = current.getNext();
		}

		return locationUpdated;
	}

//delete input location
	public void deleteLocation(String location) {
		LocationNode current = head;

		while (current != null) {
			if (current.getLocation().equals(location)) {
				LocationNode prev = current.getPrev();
				LocationNode next = current.getNext();

				if (prev != null) {
					prev.setNext(next);
				} else {
					head = next;
				}

				if (next != null) {
					next.setPrev(prev);
				} else {
					tail = prev;
				}

				break;
			}

			current = current.getNext();
		}
	}
	public void deleteMartyr(String Martyr) {
		LocationNode current = head;

		while (current != null) {
			DoublyLinkedListNode doublyLinkedListNode=current.getMartyrsList().getHead();
			while(doublyLinkedListNode!=null) {
			if (doublyLinkedListNode.getMartyr().getName().contains(Martyr)) {
				DoublyLinkedListNode prev = doublyLinkedListNode.getPrev();
				DoublyLinkedListNode next = doublyLinkedListNode.getNext();

				if (prev != null) {
					prev.setNext(next);
				} else {
					doublyLinkedListNode = next;
				}

				if (next != null) {
					next.setPrev(prev);
				} else {
					current.getMartyrsList().setTail( prev);
				}

				break;
			}
			doublyLinkedListNode=doublyLinkedListNode.getNext();
			}

			current = current.getNext();
		}
	}

//to add martyr in location
	public void addMartyrInLocation(String location, Martyr newMartyr) {
		LocationNode current = head;

		while (current != null) {
			if (current.getLocation().equals(location)) {
				DoublyLinkedListNode newNode = new DoublyLinkedListNode(newMartyr);
				current.getMartyrsList().insertSorted(newMartyr);
				return;
			}

			current = current.getNext();
		}
	}

//to print all martys to input location
	public void displayAllMartyrsByLocation(String location) {
		LocationNode current = head;
		boolean locationFound = false;
		while (current != null) {
			if (current.getLocation().equals(location)) {
				string += ("Location: " + current.getLocation() + "\n");
				current.getMartyrsList().display();
				string += (current.getMartyrsList().getString());

				locationFound = true;
			}
			current = current.getNext();
		}

		if (!locationFound) {
			string += ("Location not found: " + location);
		}
	}

	public void printAllMartyrsWithLocations() {
		LocationNode current = head;
		while (current != null) {
			DoublyLinkedListNode martyrNode = current.getMartyrsList().getHead();

			while (martyrNode != null) {
				Martyr martyr = martyrNode.getMartyr();
				string += (martyr.getName() + ", " + martyr.getAge() + ", " + current.getLocation() + " ,"
						+ martyr.getDateOfDeath() + ", " + martyr.getGender() + "\n");

				martyrNode = martyrNode.getNext();
			}

			current = current.getNext();
			string += "\n";// Add an empty line between locations
		}

	}

//search by part of name 
	public void searchMartyrByName(String name) {
		numberOfMartyrs = 0;
		LocationNode current = head;
		while (current != null) {
			DoublyLinkedListNode martyrNode = current.getMartyrsList().getHead();
			while (martyrNode != null) {
				if (martyrNode.getMartyr().getName().contains(name)) {
					string += (martyrNode.getMartyr().toString() + "\n");
					martyr = martyrNode.getMartyr();
					locationNode = current;
					numberOfMartyrs++;
				}
				martyrNode = martyrNode.getNext();
			}
			current = current.getNext();
			string += "\n";
		}
	}

	// calculate the number of martyrs has input age in location
	public int countMartyrsByAgeInLocation(String location, int age) {
		LocationNode current = head;
		int count = 0;

		while (current != null) {
			if (current.getLocation().equalsIgnoreCase(location)) {
				DoublyLinkedListNode martyrNode = current.getMartyrsList().getHead();
				while (martyrNode != null) {
					if (martyrNode.getMartyr().getAge() == age) {
						count++;
					}
					martyrNode = martyrNode.getNext();
				}
				break; // Break the loop once the location is found
			}
			current = current.getNext();
		}

		return count;
	}

//calculate the number of  martyrs has input gender in location
	public int countMartyrsByGenderInLocation(String location, char gender) {
		LocationNode current = head;
		int count = 0;

		while (current != null) {
			if (current.getLocation().equalsIgnoreCase(location)) {
				DoublyLinkedListNode martyrNode = current.getMartyrsList().getHead();
				while (martyrNode != null) {
					if (martyrNode.getMartyr().getGender() == (gender)) {
						count++;
					}
					martyrNode = martyrNode.getNext();
				}
				break; // Break the loop once the location is found
			}
			current = current.getNext();
		}

		return count;
	}

	// to calculate average
	public double calculateAverageAgeInLocation(String location) {
		LocationNode current = head;
		int count = 0;
		int totalAge = 0;

		while (current != null) {
			if (current.getLocation().equalsIgnoreCase(location)) {
				DoublyLinkedListNode martyrNode = current.getMartyrsList().getHead();
				while (martyrNode != null) {
					totalAge += martyrNode.getMartyr().getAge();
					count++;
					martyrNode = martyrNode.getNext();
				}
				break; // Break the loop once the location is found
			}
			current = current.getNext();
		}

		if (count == 0) {
			return 0; // To avoid division by zero if no martyrs are found in the location
		}

		return (double) totalAge / count;
	}

//to prev and next
	private LocationNode currentLocation;

	public void setCurrentLocation(LocationNode locationNode) {
		currentLocation = locationNode;
	}

	public LocationNode getCurrentLocation() {
		return currentLocation;
	}

	public LocationNode getNextLocation() {
		if (currentLocation != null) {
			currentLocation = currentLocation.getNext();
		}
		return currentLocation;
	}

	public LocationNode getPreviousLocation() {
		if (currentLocation != null) {
			currentLocation = currentLocation.getPrev();
		}
		return currentLocation;
	}

	public void reportOfLocation(String st) {
		int count=0;
		double Ages=0;
		double age=0;
		int childs=0;
		int guys=0;
		int mans=0;
		int old=0;
		int M=0;
		int F=0;
		int counter = 0;
		int temp = 0;
		String date = "";
		LocationNode current = head;
		while (current != null) {

			if (current.getLocation().equalsIgnoreCase(st)) {
				Report="";
				Report+=current.getLocation()+":\n";
				DoublyLinkedListNode doublyLinkedListNode = current.getMartyrsList().getHead();
				while (doublyLinkedListNode != null) {
					count++;
					Ages+=doublyLinkedListNode.getMartyr().getAge();
					age=doublyLinkedListNode.getMartyr().getAge();
					
					if(String.valueOf(doublyLinkedListNode.getMartyr().getGender()).equalsIgnoreCase("M")) {
						M++;
					}
					else if(String.valueOf(doublyLinkedListNode.getMartyr().getGender()).equalsIgnoreCase("F")) {
						F++;
					}
					if(age<18) {
						childs++;
					}
					else if(age>=18&& age<=30) {
						guys++;
					}
					else if(age>30&&age<60) {
						mans++;
					}
					else if(age>=60) {
						old++;
					}if (doublyLinkedListNode == current.getMartyrsList().getHead()) {
						counter++;
					} else if (doublyLinkedListNode.getMartyr().getDateOfDeath()
							.compareTo(doublyLinkedListNode.getPrev().getMartyr().getDateOfDeath()) == 0) {
						counter++;
					} else if (counter >= temp) {
						temp = counter;
						counter = 1;
						date = doublyLinkedListNode.getMartyr().getDateOfDeath();
					} else {
						counter = 1;
					}
					
					doublyLinkedListNode=doublyLinkedListNode.getNext();
				}
				break;
				
			}
			
			current=current.getNext();
		}
		
		Report+="the number of Martyrs Age less than 18 :"+String.valueOf(childs)+"\n";
		Report+="the number of Martyrs Age greater than or equal 18 and less than or equal 30  :"+String.valueOf(guys)+"\n";
		Report+="the number of Martyrs Age greater than 30 and less than 60  :"+String.valueOf(mans)+"\n";
		Report+="the number of Martyrs Age greater than or equal 60  :"+String.valueOf(old)+"\n";
		Report+="the average of age :"+String.valueOf((double)(Ages/count))+"\n";
		Report+="the number of male Martyrs :"+M+"\n";
		Report+="the number of female Martyrs : "+F+"\n";
		Report+="the Max date :"+date+"\n";
		
	}

	// to get node
	public LocationNode getLocationNode(String locationName) {
		LocationNode currentNode = head;

		while (currentNode != null) {
			if (currentNode.getLocation().equalsIgnoreCase(locationName)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}

		// Location not found
		return null;
	}

}
