package br.com.imperiogalatico.trafegoespacial.enuns;

/**
 * Identifica as URL's gerais da api SWAPI
 * @author LUIS CARDOSO
 *
 */
public enum UrlGeralSwapiEnum {
	
	PLANETA("http://swapi.co/api/planets/"),
	NAVE("http://swapi.co/api/starships/"),
	TRIPULANTE("http://swapi.co/api/people/");

	public String url;

	private UrlGeralSwapiEnum(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
	

}
