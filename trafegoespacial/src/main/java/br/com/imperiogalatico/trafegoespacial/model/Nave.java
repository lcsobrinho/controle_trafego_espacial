package br.com.imperiogalatico.trafegoespacial.model;

import java.io.Serializable;

/**
 * Entidade básica
 * @author LUIS CARDOSO
 *
 */
public class Nave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String model;
	public Integer passengers;
	public String url;
	
	
	
	public Nave(String url) {
		super();
		this.url = url;
	}
	public Nave(NaveBuilder builder) {
		
		this.name = builder.name;
		this.model = builder.model;
		this.passengers = builder.passengers;
		this.url = builder.url;
	}
	public Nave() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
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
		Nave other = (Nave) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	public static  Nave getNave()  
	{
	    return new Nave.NaveBuilder().name("Nome 1").model("Modelo 1").passengers(10).url("url 1").build();
	}
		
	@Override
	public String toString() {
		return "Nave [name=" + name + ", model=" + model + ", passengers=" + passengers + ", url=" + url + "]";
	}

	public static class NaveBuilder{
		public String name;
		public String model;
		public Integer passengers;
		public String url;
		
		public NaveBuilder name(String name){
			this.name = name;
			return this;
		}
		
		public NaveBuilder model(String model){
			this.model = model;
			return this;
		}
		
		public NaveBuilder passengers(Integer passengers){
			this.passengers = passengers;
			return this;
		}
		
		public NaveBuilder url(String url){
			this.url = url;
			return this;
		}
		
		public Nave build() {
            return new Nave(this);
        }
		
    }
	
}
