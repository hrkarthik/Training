package com.acejava.usecases.studentMangSystem;

public enum Subjects {	
	
		HINDI(1, "Hindi"), 
		ENGLISH(2, "English"),
		MATHMATICS(3, "Maths"),
		PHYSICS(4, "Physics"),
		CHEMISTRY(5, "Chemistry");

		private int code;
		private String name;

		private Subjects(int code, String name) {
			this.code = code;
			this.name = name;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
	}

