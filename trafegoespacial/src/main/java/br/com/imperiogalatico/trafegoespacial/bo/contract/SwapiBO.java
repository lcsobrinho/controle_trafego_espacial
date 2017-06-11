package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

/**
 * Define todos métodos utilizados para buscar informações na api SWAPI
 * @author LUIS CARDOSO
 *
 */
public interface SwapiBO extends Serializable{
	
	/**
	 * Lista todos Planetas da SWAPI
	 * @param url da API relacionada a todos Planetas
	 * @return Lista de planetas
	 */
	public List<Planeta> listarPlaneta(String url);
	
	/**
	 * Lista todos Tripulantes da SWAPI
	 * @param url da API relacionada a todos Tripulantes
	 * @return Lista de Tripulantes
	 */
	public List<Tripulante> listarTripulante(String url);
	
	/**
	 * Lista todas Naves da SWAPI
	 * @param url da API relacionada a todas naves
	 * @return Lista de Naves
	 */
	public List<Nave> listarNave(String url);
	
	/**
	 * Busca uma Nave específica
	 * @param url Url da Nave
	 * @return Nave de retorno
	 */
	public Nave buscarNave(String url) ;
	
	/**
	 * Busca um Planeta específico
	 * @param url Url do planeta
	 * @return Planeta de retorno
	 */
	public Planeta buscarPlaneta(String url);
	
	/**
	 * Busca um Tripulante específico
	 * @param url Url do Tripulante
	 * @return Tripulante de retorno
	 */
	public Tripulante buscarTripulante(String url);	
	
}
