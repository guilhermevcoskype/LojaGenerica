package br.com.loja.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.loja.model.Produto;
import br.com.loja.model.TipoProduto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Page<Produto> findByTipoProduto(TipoProduto tipoProduto, Pageable paginacao);

	@Query("FROM Produto p " + "WHERE LOWER(p.descricao) like %:buscado% ")
	Page<Produto> findProdutoDaBusca(@Param("buscado") String searchTerm, Pageable pageable);

}
