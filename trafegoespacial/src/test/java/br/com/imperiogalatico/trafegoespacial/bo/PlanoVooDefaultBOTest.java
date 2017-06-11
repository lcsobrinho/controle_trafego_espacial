package br.com.imperiogalatico.trafegoespacial.bo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.imperiogalatico.trafegoespacial.bo.contract.PlanoVooBO;
import br.com.imperiogalatico.trafegoespacial.exception.ApplicationException;
import br.com.imperiogalatico.trafegoespacial.model.Nave;
import br.com.imperiogalatico.trafegoespacial.model.Planeta;
import br.com.imperiogalatico.trafegoespacial.model.PlanoVoo;
import br.com.imperiogalatico.trafegoespacial.model.Tripulante;
import java.util.Date;

public class PlanoVooDefaultBOTest {
	
	@Test(expected=ApplicationException.class)
	public void validacaoCampoObrigatorioTripulante() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();

		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo.setListaTripulante(null);
		planoVooBO.validacaoCamposObrigatorios(planoVoo);
	}
	
	@Test(expected=ApplicationException.class)
	public void validacaoCampoObrigatorioPlaneta() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo.setPlanetaDestino(null);
		planoVooBO.validacaoCamposObrigatorios(planoVoo);
	}
	
	@Test(expected=ApplicationException.class)
	public void validacaoCampoObrigatorioNave() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo.setNaveEspacial(null);
		
		planoVooBO.validacaoCamposObrigatorios(planoVoo);
	}
	
	@Test(expected=ApplicationException.class)
	public void validacaoCampoObrigatorioData() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo.setDataVoo(null);
		
		planoVooBO.validacaoCamposObrigatorios(planoVoo);
	}
	
	@Test
	public void validacaoCampoObrigatorioOK() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		Nave nave = new Nave.NaveBuilder().name("Nave Teste").model("Modelo Teste").passengers(10).url("Url Nave Teste").build();
		
		Planeta planeta = new Planeta.PlanetaBuilder().name("Planeta Teste").climate("Clima Teste").
				   diameter("100").population("1000").terrain("Terreno Teste").url("Url Planeta Teste").build();

		List<Tripulante> listaTripulante = new ArrayList<Tripulante>();
		listaTripulante.add(new Tripulante.TripulanteBuilder().name("Tripulante teste 1").gender("Masculino").url("Url Tripulante teste 1").build());
		listaTripulante.add(new Tripulante.TripulanteBuilder().name("Tripulante teste 2").gender("Feminino").url("Url Tripulante teste 2").build());
	
		PlanoVoo planoVoo = new PlanoVoo.PlanoVooBuilder().codigo(1L).planetaDestino(planeta).naveEspacial(nave).listaTripulante(listaTripulante).dataVoo(new Date()).build();
		
		boolean retorno = planoVooBO.validacaoCamposObrigatorios(planoVoo);
		Assert.assertTrue(retorno);
	}
	
	
	@Test(expected=ApplicationException.class)
	public void validacaoCapacidadeNaveTripulante() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo.getNaveEspacial().setPassengers(1);		
		planoVooBO.validacaoRegraDeNegocio(planoVoo);
	}
	
	@Test
	public void validacaoRegraDeNegocioOK() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		boolean retorno = planoVooBO.validacaoRegraDeNegocio(planoVoo);
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void validacaoGeralOK() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		PlanoVoo planoVoo = getPlanoVooValidacaoCamposObrigatorios();
		boolean retorno = planoVooBO.validacao(planoVoo);
		Assert.assertTrue(retorno);
	}
	
	@Test(expected=ApplicationException.class)
	public void validacaoRegraDeNegocioPlanetaDestinoAnterior() throws Exception{
		PlanoVooBO planoVooBO  = new PlanoVooDefaultBO();
		
		PlanoVoo planoVoo1 = getPlanoVooValidacaoCamposObrigatorios();	
		planoVoo1.setCodigo(null);
		planoVooBO.salvar(planoVoo1);
		PlanoVoo planoVoo2 = getPlanoVooValidacaoCamposObrigatorios();
		planoVoo2.setCodigo(null);
		planoVooBO.validacaoRegraDeNegocio(planoVoo2);
		
	}
	
	public PlanoVoo getPlanoVooValidacaoCamposObrigatorios(){
		Nave nave = new Nave.NaveBuilder().name("Nave Teste").model("Modelo Teste").passengers(10).url("Url Nave Teste").build();
		Planeta planeta = new Planeta.PlanetaBuilder().name("Planeta Teste").climate("Clima Teste").
													   diameter("100").population("1000").terrain("Terreno Teste").url("Url Planeta Teste").build();
		List<Tripulante> listaTripulante = new ArrayList<Tripulante>();
		listaTripulante.add(new Tripulante.TripulanteBuilder().name("Tripulante teste 1").gender("Masculino").url("Url Tripulante teste 1").build());
		listaTripulante.add(new Tripulante.TripulanteBuilder().name("Tripulante teste 2").gender("Feminino").url("Url Tripulante teste 2").build());

		return new PlanoVoo.PlanoVooBuilder().codigo(1L).naveEspacial(nave).planetaDestino(planeta).listaTripulante(listaTripulante).dataVoo(new Date()).build();
		
	}
}
