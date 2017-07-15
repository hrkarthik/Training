package com.acejava.usecases.chess;

public abstract class Piece {
	public String colour;
	public Movement movement;
	
	public abstract void display();
	public abstract void tracePath();
	public abstract void setMovement();
}
