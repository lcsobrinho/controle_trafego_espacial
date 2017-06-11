package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Nave;

/**
 * Responsável por definir métodos de regras de negócio de Nave
 * @author LUIS CARDOSO
 *
 */
public interface NaveBO extends Serializable{
	/**
	 * Lista todas naves
	 * @return lista de naves
	 */
	public List<Nave> listar();
	
	/**
	 * Busca uma Nave por sua chave(Url)
	 * @param Nave filtro da busca
	 * @return Nave de retorno
	 */
	public Nave buscarPorUrl(Nave nave);
}
