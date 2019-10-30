package com.codebasics.linkedlists;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList main = new ReverseLinkedList(); 
        main.head = main.new Node("freddy");
        main.head.next = main.new Node("Sebastian");
        main.head.next.next = main.new Node("Ayala");
        main.head.next.next.next = main.new Node("Chavez");
        
        main.printNode(main.head);
        
		System.out.println("\nReversed LinkedList");
		main.head = main.reverseList(main.head);
		main.printNode(main.head);
		
	}
	
    Node head; 
	
	public Node reverseList(Node root){
		Node prev = null;
		Node current = root;
		Node next = root;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		root = prev;
		return root;
	}
	public void printNode (Node root) {
		while(root !=null) {
			System.out.println(root.data+ "\t");
			root = root.next;
		}
	}
	
	class Node {
		String data;
		Node next;
		Node(String data){
			this.data = data;
			this.next = null;
		}
	}

}
