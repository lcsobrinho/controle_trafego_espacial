package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.Planeta;
/**
 * Responsável por definir métodos de regras de negócio de Planeta
 * @author LUIS CARDOSO
 *
 */
public interface PlanetaBO  extends Serializable{
	/**
	 * Lista todos Planetas
	 * @return lista de Planetas
	 */
	public List<Planeta> listar();
	
	/**
	 * Busca um Planeta por sua chave(Url)
	 * @param planeta filtro da busca
	 * @return Planeta de retorno
	 */
	public Planeta buscarPorUrl(Planeta planeta);
	

}
