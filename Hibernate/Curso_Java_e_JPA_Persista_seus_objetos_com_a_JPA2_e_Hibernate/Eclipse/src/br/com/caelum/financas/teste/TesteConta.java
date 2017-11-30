package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.caelum.financas.util.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteConta {
    public static void main(String[] args) {

    	/**********************ESTADO TRANSIENT**********************/
    	
    	//Estado Transient * * *
        Conta conta = new Conta();
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        
        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        // * * *        
        
        // Estado Managed * * *
        em.persist(conta);
        
        em.getTransaction().commit();
        // * * *

        em.close();

        /******************************************************************************/
        
        /**********************ESTADO DETACHED**********************/
        //Estado Detached
        conta.setTitular("Tadeu Pereira");
        
        EntityManager em2 = new JPAUtil().getEntityManager();

        em2.getTransaction().begin();
        // * * *        
        
        // Estado Managed * * *
        em2.merge(conta);
        
        em2.getTransaction().commit();
        // * * *
        System.out.println(conta.getTitular());
        em2.close();

        /******************************************************************************/
        
        /**********************ESTADO DETACHED - REMOVENDO**********************/
        
        EntityManager em3 = new JPAUtil().getEntityManager();
        
       // Estado Managed * * *
        Conta contaRemover = em3.find(Conta.class, 1);

        em3.getTransaction().begin();
        // * * *        
        
        
        em3.remove(contaRemover);
        
        em3.getTransaction().commit();
        // * * *
        
        em3.close();
    }

}
