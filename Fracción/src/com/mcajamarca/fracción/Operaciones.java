package com.mcajamarca.fracción;

public final class Operaciones {
	
	public Operaciones() {
		throw new AssertionError("No puedo instanciar ésta clase");
	}
	
	public static final int mcd(final int a, final int b) {
		return b == 0 ? a : mcd(b, a % b);
	}
	
	public static final int mcm(final int a, final int b) {
		   return a * b / mcd(a, b);
	}
	
}
