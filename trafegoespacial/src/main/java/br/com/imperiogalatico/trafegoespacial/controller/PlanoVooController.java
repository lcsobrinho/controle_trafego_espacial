package br.com.imperiogalatico.trafegoespacial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imperiogalatico.trafegoespacial.bo.contract.NaveBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.TripulanteBO;
import br.com.imperiogalatico.trafegoespacial.exception.ApplicationException;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;

@Named
@ViewScoped
public class PlanoVooController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PlanetaBO planetaBO;
	
	@Inject
	private NaveBO naveBO;
	
	@Inject
	private TripulanteBO tripulanteBO;
	
	@Inject
	private PlanoVooBO planoVooBO;
	
	private List<Planeta> listaPlaneta;
	private Planeta planeta;
	private List<Nave> listaNave;
	private Nave nave;
	private List<Tripulante> listaTripulante;	
	private List<Tripulante> listaTripulanteSelected;
	private List<PlanoVoo> listaPlanoVoo; 
	private List<PlanoVoo> listaPlanoSelected;
	private PlanoVoo planoVoo;
	private PlanoVoo planoVooDetalhe;
	private PlanoVoo planoVooFilter;
	private Date dataVoo;
	
	@PostConstruct
	public void init(){
		planoVooFilter = new PlanoVoo();
		listaPlaneta = planetaBO.listar();
		listaNave = naveBO.listar();	
		
	}
	
	public String pesquisar(){
		listaPlanoVoo = planoVooBO.buscarPorFiltro(planoVooFilter);
		return null;
	}
	
	public void initCadastroPlanoVoo(Long codigo){
		
		if(codigo!=null){
			PlanoVoo planoVooTemp = planoVooBO.buscarPorCodigo(new PlanoVoo(codigo));
			planeta = new Planeta(planoVooTemp.getPlanetaDestino().getUrl());
			nave = new Nave(planoVooTemp.getNaveEspacial().getUrl());
			dataVoo= planoVooTemp.getDataVoo();
			listaTripulanteSelected = planoVooTemp.getListaTripulante();
		}else{			
			nave = new Nave();
			planeta = new Planeta();
			dataVoo= new Date();
		}
		planoVoo = new PlanoVoo();
		if(codigo != null && codigo.longValue() != 0){
			planoVoo.setCodigo(codigo);
		}
		
			
		listaTripulante = tripulanteBO.listar();
	}

	public List<PlanoVoo> getListaPlanoSelected() {
		return listaPlanoSelected;
	}



	public void setListaPlanoSelected(List<PlanoVoo> listaPlanoSelected) {
		this.listaPlanoSelected = listaPlanoSelected;
	}



	public List<PlanoVoo> getListaPlanoVoo() {
		return listaPlanoVoo;
	}

	public void setListaPlanoVoo(List<PlanoVoo> listaPlanoVoo) {
		this.listaPlanoVoo = listaPlanoVoo;
	}

	public PlanoVoo getPlanoVoo() {
		return planoVoo;
	}

	public void setPlanoVoo(PlanoVoo planoVoo) {
		this.planoVoo = planoVoo;
	}

	public PlanoVoo getPlanoVooFilter() {
		return planoVooFilter;
	}

	public void setPlanoVooFilter(PlanoVoo planoVooFilter) {
		this.planoVooFilter = planoVooFilter;
	}
	public String salvar() {
		try{
			if(planoVoo == null || planoVoo.getCodigo() == null){
				planoVoo = new PlanoVoo();
			}else{
				planoVoo.setListaTripulante(new ArrayList<Tripulante>());
			}
			
			Planeta lPlaneta = planetaBO.buscarPorUrl(planeta);
			Nave lNave = naveBO.buscarPorUrl(nave);
			planoVoo.setNaveEspacial(lNave);
			planoVoo.setPlanetaDestino(lPlaneta);
			planoVoo.setDataVoo(dataVoo);
			if(listaTripulanteSelected != null && listaTripulanteSelected.size() > 0){
				for(Tripulante tripulante : listaTripulanteSelected){
					tripulante = tripulanteBO.buscarPorUrl(tripulante);
					planoVoo.getListaTripulante().add(tripulante);
				}
			}
			
			planoVooBO.salvar(planoVoo);
			saveMessage("registro cadastrado com sucesso!");
		}catch (Exception e) {
			tratarExcessao(e);
			return null;
		}
		
		return "manterPlanoVoo";
	}
	
	public void tratarExcessao(Exception exception){
		if(exception instanceof ApplicationException){
			saveMessageErro(exception.getMessage());
		}else{
			saveMessageErro("Erro inesperado, favor entrar em contato com administrador");
		}
	}
	
	public void saveMessage(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage("Sucesso",  mensagem) );
    }
	public void saveMessageErro(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,  null) );
    }
	
	
	public String excluir() {
		try{
			planoVooBO.excluir(listaPlanoSelected);
			saveMessage("registro(s) excluído(s) com sucesso!");
		}catch (Exception e) {
			tratarExcessao(e);
			
		}		
		return pesquisar();
	}
	
	public PlanoVoo getPlanoVooDetalhe() {
		return planoVooDetalhe;
	}

	public void setPlanoVooDetalhe(PlanoVoo planoVooDetalhe) {
		this.planoVooDetalhe = planoVooDetalhe;
	}

	public String editar(Long codigo) {
		return "cadastroPlanoVoo?faces-redirect=true&codigo="+codigo;
	}
	
	public String novo() {
		return "cadastroPlanoVoo";
	}

	public List<Nave> getListaNave() {
		return listaNave;
	}

	public void setListaNave(List<Nave> listaNave) {
		this.listaNave = listaNave;
	}

	public Nave getNave() {
		return nave;
	}

	public List<Tripulante> getListaTripulante() {
		return listaTripulante;
	}

	public Date getDataVoo() {
		return dataVoo;
	}

	public void setDataVoo(Date dataVoo) {
		this.dataVoo = dataVoo;
	}

	public void setListaTripulante(List<Tripulante> listaTripulante) {
		this.listaTripulante = listaTripulante;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public List<Planeta> getListaPlaneta() {
		return listaPlaneta;
	}

	public void setListaPlaneta(List<Planeta> listaPlaneta) {
		this.listaPlaneta = listaPlaneta;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}

	public List<Tripulante> getListaTripulanteSelected() {
		return listaTripulanteSelected;
	}

	public void setListaTripulanteSelected(List<Tripulante> listaTripulanteSelected) {
		this.listaTripulanteSelected = listaTripulanteSelected;
	}

}
