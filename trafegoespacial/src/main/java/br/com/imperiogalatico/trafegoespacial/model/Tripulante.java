package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;

/**
 * Entidade básica
 * @author LUIS CARDOSO
 *
 */
public class Tripulante implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;
    public String gender;    
    public String url;
    
    public Tripulante(TripulanteBuilder builder){
    	this.name = builder.name;
    	this.gender = builder.gender;
    	this.url = builder.url;
    }
    
    public Tripulante(){
    	
    }
   
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static class TripulanteBuilder{
		public String name;
	    public String gender;	    
	    public String url;
	    
	    public TripulanteBuilder name(String name){
	    	this.name = name;
	    	return this;
	    }
	    
	    public TripulanteBuilder gender(String gender){
	    	this.gender = gender;
	    	return this;
	    }
	    
	    public TripulanteBuilder url(String url){
	    	this.name = url;
	    	return this;
	    }
	    public Tripulante build(){
	    	return new Tripulante(this);
	    }
	    
	}

   
}
