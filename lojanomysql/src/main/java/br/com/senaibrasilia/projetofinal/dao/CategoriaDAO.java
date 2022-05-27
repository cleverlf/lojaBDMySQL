package br.com.senaibrasilia.projetofinal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.viewswing.FormCadCategoria;

public class CategoriaDAO {
	
public EntityManager em;	
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria	categoria) {
		//persist		
		em.persist(categoria);			
	}
	
	public void alterar(Categoria categoria) {
		//merge
		em.merge(categoria);
		
	}
	
	public Categoria pesquisarPorId(int id) {
		
		return em.find(Categoria.class, id);
	
	}
	
	public List<Categoria> pesquisarPorNome(String nome) {
		//?
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Categoria.class).setParameter("nome", nome).getResultList();
		
	}
	
	public List<Categoria> pesquisarTodos() {
		//query - JPQL
		//ArrayList - List
		//Lambda - Java8
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Categoria.class).getResultList();
		
	}

}
