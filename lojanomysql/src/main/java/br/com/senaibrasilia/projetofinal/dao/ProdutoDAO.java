package br.com.senaibrasilia.projetofinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Produto;

public class ProdutoDAO {
public EntityManager em;	
	
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		//persist		
		em.persist(produto);			
	}
	
	public void alterar(Produto produto) {
		//merge
		em.merge(produto);
		
	}
	
	public Produto pesquisarPorId(Produto id) {
		return em.find(Produto.class, id);
	
	}
	
	public List<Produto> pesquisarPorNome(String nome) {
		//?
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
		
	}
	
	public List<Produto> pesquisarTodos() {
		//query - JPQL
		//ArrayList - List
		//Lambda - Java8
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
		
	}

}
