package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.Comparator;
import java.util.List;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.dao.PlanoVooMemoryDAO;
import br.com.imperiogalatico.trafegoespacial.dao.contract.PlanoVooDAO;
import br.com.imperiogalatico.trafegoespacial.exception.ApplicationException;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;

/**
 * Responsável por toda regra de negócio do plano de Voo
 * @author LUIS CARDOSO
 *
 */
public class PlanoVooDefaultBO implements PlanoVooBO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530902364658825004L;

	private PlanoVooDAO planoVooDAO;	
	

	public PlanoVooDefaultBO() {
		planoVooDAO = new PlanoVooMemoryDAO();
	}

	@Override
	public void salvar(PlanoVoo planoVoo) throws Exception {
		validacao(planoVoo);
		if(planoVoo != null && planoVoo.getCodigo() != null){
			planoVooDAO.atualizar(planoVoo); 
		}else{
			planoVooDAO.adicionar(planoVoo);
		}
		
	}
	
	
	/**
	 * Valida Todas regras de negócio de Planos de voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacao(PlanoVoo planoVoo) throws Exception{
		boolean validacaoCamposObrigatorios = validacaoCamposObrigatorios(planoVoo);
		boolean validacaoRegraNegocio = validacaoRegraDeNegocio(planoVoo);
		return (validacaoCamposObrigatorios && validacaoRegraNegocio);
	}
	/**
	 * Valida campos obrigatórios de Planos de Voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacaoCamposObrigatorios(PlanoVoo planoVoo) throws Exception{
		if(planoVoo.getPlanetaDestino() == null){
			throw new ApplicationException("Favor informar um Planeta!");
		}
		if(planoVoo.getNaveEspacial() == null){
			throw new ApplicationException("Favor informar uma Nave Espacial!");
		}		
		if(planoVoo.getListaTripulante() == null || planoVoo.getListaTripulante().size() == 0 ){
			throw new ApplicationException("Favor informar pelo menos 1 Tripulante!");
		}
		
		if(planoVoo.getDataVoo() == null ){
			throw new ApplicationException("Favor informar data e horário do voo!");
		}
		
		return true;
		
	}
	
	/**
	 * Valida regras de negócio de Planos de voo
	 * @param planoVoo Plano de voo a ser validado
	 * @throws Exception
	 */
	public boolean validacaoRegraDeNegocio(PlanoVoo planoVoo) throws Exception{	
		
		if(planoVoo.getListaTripulante().size() > planoVoo.getNaveEspacial().getPassengers().intValue() ){
			throw new ApplicationException("A quantidade de tripulantes não pode ser maior que a capacidade da Nave.!");
		}
		
		PlanoVoo planoAnterior = buscarAnterior(planoVoo);
		if(planoAnterior != null && 
				!planoAnterior.equals(planoVoo) && 
				planoAnterior.getPlanetaDestino().equals(planoVoo.getPlanetaDestino())){
			throw new ApplicationException("O Planeta destino não pode ser o mesmo que o voo anterior!");
		}
		
		return true;
	}
	
	/**
	 * Busca o plano de voo anterior ao informado por parâmetro
	 * @param planoVoo referência
	 * @return Plano de voo anterior
	 */
	public PlanoVoo buscarAnterior(PlanoVoo planoVoo) {
		PlanoVoo planoAnterior = null;
		
		List<PlanoVoo> listaPlanos = buscarTodos();
		ordernar(listaPlanos);
		if(listaPlanos !=null && listaPlanos.size() >0){
			int posicao = listaPlanos.indexOf(planoVoo) ;
			if(posicao > 0){
				planoAnterior = listaPlanos.get((posicao-1));
			}else{
				planoAnterior = listaPlanos.get((listaPlanos.size() - 1));
			}
		}
		return planoAnterior;
	}
	
	
	public PlanoVooDAO getPlanoVooDAO() {
		return planoVooDAO;
	}

	public void setPlanoVooDAO(PlanoVooDAO planoVooDAO) {
		this.planoVooDAO = planoVooDAO;
	}

	@Override
	public List<PlanoVoo> buscarTodos() {
		return planoVooDAO.buscarTodos();
	}
	
	@Override
	public List<PlanoVoo> buscarPorFiltro(PlanoVoo chave){
		List<PlanoVoo> lista = planoVooDAO.buscarPorFiltro(chave);
		ordernar(lista);
		return lista;
	}
	
	public void ordernar(List<PlanoVoo> lista) {
		lista.sort(new Comparator<PlanoVoo>() {
			@Override
			public int compare(PlanoVoo o1, PlanoVoo o2) {
				return o1.getDataVoo().compareTo(o2.getDataVoo());
				
			}
		});
	}

	@Override
	public void excluir(List<PlanoVoo> listaPlanoSelected) throws Exception {
		if(listaPlanoSelected == null || listaPlanoSelected.size() == 0){
			throw new ApplicationException("Esclolha pelo menos um plano de Voo");
		}
		planoVooDAO.excluir(listaPlanoSelected);
		
	}

	@Override
	public PlanoVoo buscarPorCodigo(PlanoVoo planoVoo) {
		return planoVooDAO.buscarPorChave(planoVoo);
	}
	
	

}
