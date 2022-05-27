package br.com.senaibrasilia.projetofinal.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDAO;
import br.com.senaibrasilia.projetofinal.dao.ProdutoDAO;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Principal {
	
public static void main(String[] args) {
		
		
		
		Categoria c1 = new Categoria("Periferico");
		Categoria c2 = new Categoria("Cadeira");
		Categoria c3 = new Categoria("Desktop");
		Produto p1 = new Produto("Mouse", "Mouse Dell Optico",new BigDecimal("100"),c1);
		p1.getDatalocal().atStartOfDay();
		Produto p2 = new Produto("Cadeira", "Herman Miller",new BigDecimal("10720"),c2);
		p2.getDatalocal().atStartOfDay();
		Produto p3 = new Produto("Computador", "Workstation Precision 3650",new BigDecimal("9234"),c3);
		p3.getDatalocal().atStartOfDay();
		
				
				
		em.getTransaction().begin();	
		prodao.cadastrar(p1);
		catdao.cadastrar(c1);
		prodao.cadastrar(p2);
		catdao.cadastrar(c2);
		prodao.cadastrar(p3);
		catdao.cadastrar(c3);			
		//prodao.pesquisarPorNome("Mouse");
		em.getTransaction().commit();
		em.close();					
		
	
	}
	private static EntityManager em = JPAUtil.getEntityManager();
	private static ProdutoDAO prodao = new ProdutoDAO(em);
	private static CategoriaDAO catdao = new CategoriaDAO(em);
}
