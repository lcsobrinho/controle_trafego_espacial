package br.com.imperiogalatico.trafegoespacial.service.client;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.imperiogalatico.trafegoespacial.model.Models;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

/**
 * Responsável pela comunicação com serviço SWAPI
 * @author LUIS CARDOSO
 *
 */
public class SwapiClient {

	private HttpHeaders getHttpHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("User-Agent", "JAVA-APPLICATION");
		return headers;
	}
	
	/**
	 * Listagem de Planetas
	 * @param url Url do serviço
	 * @return lista de Planetas
	 */
	public List<Planeta> listarPlaneta(String url) {
		
		HttpHeaders headers = getHttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Models<Planeta>> res = restTemplate.exchange(
	        		url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Models<Planeta>>() {});
		return res.getBody().results;

	}

	/**
	 * Listagem de Tripulantes
	 * @param url Url do serviço
	 * @return lista de Tripulante
	 */
	public List<Tripulante> listarTripulante(String url) {
		HttpHeaders headers = getHttpHeaders();

		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Models<Tripulante>> res = restTemplate.exchange(
	        		url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Models<Tripulante>>() {});

		return res.getBody().results;

	}

	/**
	 * Listagem de Nanes
	 * @param url Url do serviço
	 * @return lista de Naves
	 */
	public List<Nave> listarNave(String url) {

		HttpHeaders headers = getHttpHeaders();

		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Models<Nave>> res = restTemplate.exchange(
				    url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Models<Nave>>() {});

		return res.getBody().results;
	}
	
	/**
	 * Busca Nave pelo código (url)
	 * @param url Url do serviço
	 * @return Nave solicitada
	 */
	public Nave buscarNave(String url) {

		HttpHeaders headers = getHttpHeaders();

		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Nave> res = restTemplate.exchange(
				    url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Nave>() {});

		return res.getBody();
	}
	
	/**
	 * Busca Planeta pelo código (url)
	 * @param url Url do serviço
	 * @return Planeta solicitado
	 */
	public Planeta buscarPlaneta(String url) {

		HttpHeaders headers = getHttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Planeta> res = restTemplate.exchange(
	        		url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Planeta>() {});
		return res.getBody();

	}
	
	/**
	 * Busca Tripulante pelo código (url)
	 * @param url Url do serviço
	 * @return Tripulante solicitado
	 */
	public Tripulante buscarTripulante(String url) {
		HttpHeaders headers = getHttpHeaders();

		RestTemplate restTemplate = new RestTemplate();
		
		 ResponseEntity<Tripulante> res = restTemplate.exchange(
	        		url,
	                HttpMethod.GET,
	                new HttpEntity<String>(headers),
	                new ParameterizedTypeReference<Tripulante>() {});

		return res.getBody();

	}

}
