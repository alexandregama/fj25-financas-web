package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EstatisticasBean {

		public void gera() {
			System.out.println("Gerando estàtisitcas");
		}
}
