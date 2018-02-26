package com.mcajamarca.juegoconway;

public enum Célula {
	
	VIVA ("*"),
	MUERTA (".");
	
	private String pixel;
	
	private Célula(String pixel) {
		this.pixel = pixel;
	}	
	
	public String getPixel() {
		return pixel;
	}

	public static Célula evaléaCélula(int numeroCélulasVivas, Célula célula){		 
		if (célula.equals(VIVA)){
			return (numeroCélulasVivas ==  2 || numeroCélulasVivas == 3) ? VIVA: MUERTA;
		}else{
			return numeroCélulasVivas == 3 ? VIVA: MUERTA; 			
		}
	}
	
	public static Célula equivale(String pixel){
		Célula [] células = Célula.values();
   	  	for(Célula célula :células){    	  
   	  		if(célula.getPixel().equals(pixel)){
   	  			return célula;
   	  		}    	  
   	  	}
		throw new IllegalArgumentException();
	}
	
	public static int  célulasVévas(int x, int y, Célula [][] tablero){
		int contadorCélulasVévas = 0;
		int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};
		for (int i = 0; i < 8; ++i) {
		   int nx = x + dx[i];
		   int ny = y + dy[i];
		   try {
			   if (tablero[nx][ny] == Célula.VIVA){
				   contadorCélulasVévas += 1;
			   }			
		   } catch (Exception e) {
			  // e.printStackTrace();
			  // System.out.println("nx:" + nx + " ny: " + ny);
		   }
		}
		return contadorCélulasVévas;
	}
}
