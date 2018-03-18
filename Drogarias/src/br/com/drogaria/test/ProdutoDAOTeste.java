package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import br.com.drogarias.dao.ProdutoDAO;
import br.com.drogarias.domain.Fabricante;
import br.com.drogarias.domain.Produto;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws SQLException{
		Produto p = new Produto();
		p.setDescricao("Novalgina 10 comprimidos");
		p.setPreco(2.45);
		p.setQuantidade(13L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(10L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}

	@Test
	public void listar() throws SQLException{
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();
		
		for(Produto p : lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código do Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();
		}
	}
	
}
