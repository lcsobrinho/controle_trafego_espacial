package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.List;

import javax.inject.Inject;

import br.com.imperiogalatico.trafegoespacial.bo.contract.SwapiBO;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;
import br.com.imperiogalatico.trafegoespacial.service.client.SwapiClient;

public class SwapiDefaultBO implements SwapiBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SwapiClient swapiClient;
	
	@Override
	public List<Planeta> listarPlaneta(String url) {
		return swapiClient.listarPlaneta(url);
	}

	@Override
	public List<Tripulante> listarTripulante(String url) {
		return swapiClient.listarTripulante(url);
	}

	@Override
	public List<Nave> listarNave(String url) {
		return swapiClient.listarNave(url);
	}
	
	@Override
	public Nave buscarNave(String url) {
		return swapiClient.buscarNave(url);
	}

	@Override
	public Planeta buscarPlaneta(String url) {
		return swapiClient.buscarPlaneta(url);
	}

	@Override
	public Tripulante buscarTripulante(String url) {
		return  swapiClient.buscarTripulante(url);
	}
	
	
}
