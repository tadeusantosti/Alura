package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.TipoMovimentacao;

public class MovimentacaoDao {

	EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {

		String jpqlMedia = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipoMovimentacao = :pTipo group by m.data";

		Query query = em.createQuery(jpqlMedia);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return query.getResultList();
	}

}
