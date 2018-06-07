package com.mcajamarca.últimodígito;

public class ÚltimoDígito {
	
	public static int ultimoDígito(int número){
		int length = String.valueOf(número).length();
		return Integer.parseInt("" +String.valueOf(número).charAt(length - 1));
	}
	
	public static void main(String[] args) {
		System.out.println(ultimoDígito(123456));
	}

}
