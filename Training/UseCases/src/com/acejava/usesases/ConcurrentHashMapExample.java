package com.acejava.usesases;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMapExample<K,V> {

	int size;
	ArrayList<Node<K,V>> list;
	ArrayList<ReentrantLock> lockList;

	public ConcurrentHashMapExample() {
		size = 16;
		list = new ArrayList<>();
		lockList = new ArrayList<>();
		initializeLocks();
	}

	private int hash(K key){
		return key.hashCode();
	}

	private int getIndex(K key){
		return hash(key);
	}

	private void initializeLocks(){
		for(int i=0; i<size; i++){
			lockList.add(new ReentrantLock());
		}		
	}

	public void add(K key, V value){
		int index = getIndex(key);
		ReentrantLock lock = lockList.get(index);
		lock.lock();
		Node<K, V> newNode = new Node<K, V>(key, value);
		Node<K, V> node = list.get(index);
		if(null == node){
			list.add(newNode);
		}
		else{
			while(null != node.nextNode){
				node = node.nextNode;
			}
			node.nextNode = newNode;
		}
	}

	private class Node<K,V>{
		final K key;
		volatile V value;
		Node<K, V> nextNode = null;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
