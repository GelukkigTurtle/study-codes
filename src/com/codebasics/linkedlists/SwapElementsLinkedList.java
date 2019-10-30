package com.codebasics.linkedlists;

public class SwapElementsLinkedList {
	public static void main(String[] args) {

	    Node start = null;  
	  
	    // The constructed linked list is:  
	    // 1.2.3.4.5.6.7  
	    start=push(start, 7);  
	    start=push(start, 6);  
	    start=push(start, 5);  
	    start=push(start, 4);  
	    start=push(start, 3);  
	    start=push(start, 2);  
	    start=push(start, 1);  
	  
	    System.out.print("Linked list before calling swapNodes() ");  
	    start.printList();  
	  
	    start=swapNodes(start, 5,3);  
	  
	    System.out.print("Linked list after calling swapNodes() ");  
	    start.printList();  
	}
	
	
	static class Node{
		int data;
		Node next;
		Node(int data, Node node_next){
			this.data = data;
			this.next = node_next;
		}
		
		void printList() {
			Node node = this;
			while(node.next != null) {
				System.out.println(node.data +" ");
				node = node.next;
			}
		}
	}
	//add node method
	static Node push(Node head,int data) {
		 head = new Node(data,head);
		 return head;
	}
	
	static Node swapNodes(Node head_ref, int x, int y) {
		Node head = head_ref;
		if(x == y) return null;
		Node a = null, b = null;
		//search in linked list x and y, then store them a and b 
		while(head_ref.next != null) {
			if(head_ref.next.data == x) {
				a = head_ref;
			}else if(head_ref.next.data == y) {
				b = head_ref;
			}
			
			head_ref = head_ref.next;
		}
		
		//after find them change the pointers
		if(a != null && b != null) {
			Node temp = a.next;
			a.next = b.next;
			b.next = temp;
			temp = a.next.next;
			a.next.next = b.next.next;
			b.next.next = temp;
		}
		return head;
	}
}


