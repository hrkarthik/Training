package com.acejava.usecases.studentMangSystem;

public enum ClassStand {
	

		FIRST(1, "I"), 
		SECOND(2, "II"),
		THIRD(3, "III"),
		FOURTH(4, "IV"),
		FIFTH(5, "V");

		private int code;
		private String name;

		private ClassStand(int code, String name) {
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

