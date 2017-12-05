package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
        conta.setId(2); 

		Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Neg�cios");

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); // hoje
        movimentacao1.setDescricao("Viagem � SP");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
        
        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        movimentacao2.setData(amanha); // amanha
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
        
        movimentacao2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        

        em.persist(categoria1); // Agora a 'categoria1' � Managed
        em.persist(categoria2); // Agora a 'categoria2' � Managed

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();    
        em.close(); 

	}
}
