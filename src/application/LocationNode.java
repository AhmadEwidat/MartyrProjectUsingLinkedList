package application;
//node of location
class LocationNode {
    private String location;
    private DoublyLinkedList martyrsList;
    private LocationNode prev;
    private LocationNode next;

    public LocationNode(String location) {
        this.location = location;
        this.martyrsList = new DoublyLinkedList();
        this.prev = null;
        this.next = null;
    }

    public String getLocation() {
        return location;
    }
    

    public void setLocation(String location) {
		this.location = location;
	}

	public DoublyLinkedList getMartyrsList() {
        return martyrsList;
    }
	

    public void setMartyrsList(DoublyLinkedList martyrsList) {
		this.martyrsList = martyrsList;
	}

	public LocationNode getPrev() {
        return prev;
    }

    public void setPrev(LocationNode prev) {
        this.prev = prev;
    }

    public LocationNode getNext() {
        return next;
    }

    public void setNext(LocationNode next) {
        this.next = next;
    }
}


