package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;

/**
 * Entidade básica
 * @author LUIS CARDOSO
 *
 */
public class Planeta implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
    public String diameter;
    public String climate;
    public String terrain;
    public String population;
    public String url;
    
    public Planeta(String url) {
		super();
		this.url = url;
	}
	public Planeta() {
		super();
	}
	
	public Planeta(PlanetaBuilder builder) {
		this.name = builder.name;
		this.diameter = builder.diameter;
		this.climate = builder.climate;
		this.terrain = builder.terrain;
		this.population = builder.population;
		this.url = builder.url;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planeta other = (Planeta) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	public static class PlanetaBuilder{
		public String name;
	    public String diameter;
	    public String climate;
	    public String terrain;
	    public String population;
	    public String url;
	    
	    public PlanetaBuilder name(String name){
	    	this.name = name;
	    	return this;
	    }
	    
	    public PlanetaBuilder diameter(String diameter){
	    	this.diameter = diameter;
	    	return this;
	    }
	    
	    public PlanetaBuilder climate(String climate){
	    	this.climate = climate;
	    	return this;
	    }
	    
	    public PlanetaBuilder terrain(String terrain){
	    	this.terrain = terrain;
	    	return this;
	    }
	    
	    public PlanetaBuilder population(String population){
	    	this.population = population;
	    	return this;
	    }
	    
	    public PlanetaBuilder url(String url){
	    	this.url = url;
	    	return this;
	    }
	    
	    public Planeta build() {
            return new Planeta(this);
        }
	}
    
    
    

}
