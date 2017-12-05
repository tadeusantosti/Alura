package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.TipoMovimentacao;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = new Conta();
		conta.setId(2);

		MovimentacaoDao dao = new MovimentacaoDao(em);

		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);

		System.out.println("O resultado das medias é: " + medias);

		em.getTransaction().commit();
		em.close();

	}
}
