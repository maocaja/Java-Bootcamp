package com.mcajamarca.juegoconway;

public enum Célula {
		
	VIVA {
	    @Override
	    public Célula evalúaCélula(int vecinoVivos) {
	    	return (vecinoVivos ==  2 || vecinoVivos == 3) ? VIVA: MUERTA;
	    }
	}, MUERTA {
	      @Override
	      public Célula evalúaCélula(int vecinoVivos) {
	    	  return vecinoVivos == 3 ? VIVA: MUERTA; 		
	      }
	};
	
	private static final char PIXEL_VIVA   = '*';
    private static final char PIXEL_MUERTA = '.';
    
	public abstract Célula evalúaCélula(int vecinoVivos);
	
	public static Célula equivale(char pixel){
		Célula célula = Célula.MUERTA;
		switch (pixel) {
    	case PIXEL_VIVA:
    		célula = Célula.VIVA;
    		break;
        case PIXEL_MUERTA:
        	célula = Célula.MUERTA;
        	break;
        default:
        	célula = Célula.MUERTA;
        }
		return célula;		
	}
	   
	public String toString() {
		StringBuilder pixel = new StringBuilder();
		switch (this) {
	    	case VIVA:
	    		pixel.append(PIXEL_VIVA);
	    		break;
	        case MUERTA:
	        	pixel.append(PIXEL_MUERTA);
	        	break;
	        }
	        return pixel.toString();
	    }
	}

