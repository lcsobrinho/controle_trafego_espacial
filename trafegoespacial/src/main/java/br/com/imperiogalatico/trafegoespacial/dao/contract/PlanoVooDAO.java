package br.com.imperiogalatico.trafegoespacial.dao.contract;

import java.io.Serializable;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

/**
 * Responsável por operações de negócio da entidade PlanoVoo 
 * @author LUIS CARDOSO
 *
 */
public interface PlanoVooDAO  extends Serializable{

	/**
	 * Persiste na "memória" um Plano de Voo
	 * @param planoDeVoo Objeto a ser persistido
	 */
	void adicionar(PlanoVoo planoDeVoo);
	
	/**
	 * Atualiza um Plano de Voo
	 * @param planoDeVoo Objeto a ser atualizado
	 */
	void atualizar(PlanoVoo planoDeVoo);

	/**
	 * Busca um Plano de Voo pela chave
	 * @param chave filtro da pesquisa
	 * @return Plano de Voo de retorno
	 */
	PlanoVoo buscarPorChave(PlanoVoo chave);

	/**
	 * Lista todos Plano de Voo
	 * @return lista de Plano de Voo
	 */
	List<PlanoVoo> buscarTodos();

	/**
	 * Limpa a memória, eclui todos Planos de Voo
	 */
	void limparBase();

	/**
	 * Gerar código único para registros de Plano de Voo
	 * @return código único
	 */
	long getSeqPlanoDeVooNextVal();
	
	/**
	 * Excluir lista de Plano de Voo
	 * @param listaPlanoSelected Lista de objetos a serem excluídos
	 */
	void excluir(List<PlanoVoo> listaPlanoSelected);
	
	
	/**
	 * Busca uma lista Plano de Voo por filtro
	 * @param chave filtro da pesquisa
	 * @return lista de Plano de Voo de retorno
	 */
	List<PlanoVoo> buscarPorFiltro(PlanoVoo chave);

}