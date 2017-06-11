package br.com.imperiogalatico.trafegoespacial.bo.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

/**
 * 
 * @author LUIS CARDOSO
 *
 */
public interface PlanoVooBO extends Serializable{
	
	/**
	 * Persiste um Plano de Voo
	 * @param planoVoo Plano de Voo a ser persistido
	 * @throws Exception
	 */
	public void salvar(PlanoVoo planoVoo) throws Exception;
	
	/**
	 * Lista todos Planos de Voo
	 * @return Lista de Plano de Voo de retorno
	 */
	public List<PlanoVoo> buscarTodos();
	
	/**
	 * Exclui uma lista de Plano de Voo
	 * @param listaPlanoSelected Lista de Plano de Voo a serem excluídos
	 * @throws Exception
	 */
	public void excluir(List<PlanoVoo> listaPlanoSelected)  throws Exception;
	
	/**
	 * Busca Plano de Voo por código
	 * @param planoVoo Filtro
	 * @return Lista de Plano de Voo de retorno
	 */
	public PlanoVoo buscarPorCodigo(PlanoVoo planoVoo);
	
	/**
	 * Lista Plano de Voo por filtro
	 * @param chave Filtro
	 * @return Lista de Plano de Voo de retorno
	 */
	public List<PlanoVoo> buscarPorFiltro(PlanoVoo chave);
	
	/**
	 * Valida Todas regras de negócio de Planos de voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacao(PlanoVoo planoVoo) throws Exception;
	/**
	 * Valida campos obrigatórios de Planos de Voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacaoCamposObrigatorios(PlanoVoo planoVoo) throws Exception;
	
	/**
	 * Valida regras de negócio de Planos de voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacaoRegraDeNegocio(PlanoVoo planoVoo) throws Exception;
}
