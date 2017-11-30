package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteBuscaConta {

	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		// Estado Managed
		Conta conta = em.find(Conta.class, 1);
		conta.setTitular("Cesar Ueltinton");
		
		System.out.println(conta.getTitular());
		
		//Fim do estado Managed, Comitou as alteracoes, se existir
		em.getTransaction().commit();
		
		//Fecha a conexao
		em.close();
	}
	
	
	
	
}
