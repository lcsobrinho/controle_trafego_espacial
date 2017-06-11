package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

/**
 * Responsável por definir métodos de regras de negócio de Tripulante
 * @author LUIS CARDOSO
 *
 */
public interface TripulanteBO extends Serializable{
	/**
	 * Lista todos Tripulantes
	 * @return lista de Tripulantes
	 */
	public List<Tripulante> listar();
	
	/**
	 * Busca um Tripulante por sua chave(Url)
	 * @param tripulante filtro da busca
	 * @return Tripulante de retorno
	 */
	public Tripulante buscarPorUrl(Tripulante tripulante);
}
