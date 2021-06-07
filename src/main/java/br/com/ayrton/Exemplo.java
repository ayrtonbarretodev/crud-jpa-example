package br.com.ayrton;

import br.com.ayrton.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Exemplo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

          //Pesquisando no banco o cliente de código 1
          //Na pesquisa não é preciso abrir e fechar transação, pois ela nao vai adicionar , atualizar ou remover nada no banco
//        Cliente cliente = entityManager.find(Cliente.class,1);
//        System.out.println(cliente.getNome());


//        Cliente cliente = new Cliente();
//        cliente.setNome("Eletro Silva");

          //Adicionando ao banco
//        entityManager.getTransaction().begin(); //iniciando uma transação
//        entityManager.persist(cliente);
//        entityManager.getTransaction().commit(); //enviando

        //removendo do banco
        //é sempre importante buscar antes de excluir
//        Cliente cliente = entityManager.find(Cliente.class,2);
//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();

//        Cliente cliente = entityManager.find(Cliente.class,1);
//        entityManager.getTransaction().begin();
//        cliente.setNome("Armazen Feliz Alterado");
//        entityManager.getTransaction().commit();

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Armazém Estrela");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
