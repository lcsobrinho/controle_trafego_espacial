package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanetaBO;
import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.enuns.UrlGeralSwapiEnum;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;

public class PlanetaDefaultBO implements PlanetaBO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SwapiBO swapi;
	
	
	public PlanetaDefaultBO() {
	}

	@Override
	public List<Planeta> listar() {
		List<Planeta> lista = swapi.listarPlaneta(UrlGeralSwapiEnum.PLANETA.getUrl());
		ordernar(lista);
		return lista;
	}

	@Override
	public Planeta buscarPorUrl(Planeta planeta) {
		Planeta planetaRetorno = null;
		if(planeta !=null && planeta.getUrl() !=null){
			planetaRetorno = swapi.buscarPlaneta(planeta.getUrl());
		}
		return planetaRetorno;
	}
	
	/**
	 * Ordena lista de Planetas
	 * @param lista ordenada
	 */
	public void ordernar(List<Planeta> lista) {
		lista.sort(new Comparator<Planeta>() {
			@Override
			public int compare(Planeta o1, Planeta o2) {
				return o1.getName().compareTo(o2.getName());
				
			}
		});
	}

}
