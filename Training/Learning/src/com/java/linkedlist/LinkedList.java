package com.java.linkedlist;

public class LinkedList {

	static Node head = null;

	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.add( "1");
		obj.add( "2");
		obj.add( "4");
		obj.add( "3");
		obj.add( "0");
		System.out.println(obj.toString());
		//System.out.println(obj.delete("0"));
		//System.out.println(obj.toString());
		//head = obj.reverse(head);
		head = obj.cloneLinkedList(head);
		System.out.println(obj.toString());
	}

	public void add(String value){
		Node node = head;
		if(null == node){			
			head = node = new Node(value);
			return;
		}
		while(null != node.next){			
			node = node.next;
		}
		node.next = new Node(value);
	}

	public boolean delete(String value){
		Node prev;
		Node node;		
		prev = node = head;

		if(null != node && value == node.value){
			head = node.next;
			return true;
		}

		while(null != node){
			if(value == node.value){
				prev.next = node.next;
				return true;
			}			
			prev = node;
			node = node.next;			
		}

		return false;
	}

	public Node reverse(Node node){
		if(null == node)
			return node;
		if(null == node.next)
			return node;
		Node tempNode = reverse(node.next);
		node.next.next = node;
		node.next = null;

		return tempNode;
	}

	@Override
	public String toString(){
		Node node = head;
		String string = "";
		String stringAddress = "";
		if(null == node)
			return string;
		while(null != node){
			string = string+node.value;
			stringAddress = stringAddress +"***"+node;
			//System.out.println(string);
			node = node.next;
		}
		return string+"\n"+stringAddress;		
	}

	protected class Node{
		String value;
		Node next = null;

		public Node(String value) {
			this.value = value;
		}
	}

	/*@Override
	protected Object clone() throws CloneNotSupportedException {

	}*/

	public Node cloneLinkedList(Node node){
		Node head = null;
		Node temp = null;
		while(null != node){
			if(null == head){
				head = temp = new Node(node.value);		
				node = node.next;
			}
			else{
				temp.next = new Node(node.value);
				temp = temp.next;
				node = node.next;
			}
		}		
		return head;
	}
}
