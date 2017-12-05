package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteConsultaFuncaoCount {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		String jpql = "select count(m) from Movimentacao m where m.conta = :pConta";

		Query query = em.createQuery(jpql);

		query.setParameter("pConta", conta);

		Long quantidade = (Long) query.getSingleResult();

		System.out.println("A conta:" + conta.getId() + " possui " + quantidade + " movimentacoes");

		em.getTransaction().commit();
		em.close();

	}
}
