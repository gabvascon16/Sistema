package frb.edu.br.dominio.entidades;

import java.util.Date;

public class FilmeDto {

    private int filme_id;
    private String titulo;    
    private String descricao;
    private String ano_de_lancamento;
    private double preco_da_locacao;

    public FilmeDto() {
    }

    public FilmeDto(int filme_id, String titulo, String descricao, String ano_de_lancamento, Double preco_da_locacao) {
        this.filme_id = filme_id;
        this.titulo = titulo;   
        this.descricao = descricao;
        this.ano_de_lancamento = ano_de_lancamento;
        this.preco_da_locacao = preco_da_locacao;

    }

    public FilmeDto(int filme_id) {
        this.filme_id = filme_id;
    }

    
    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 

    public double getPreco_da_locacao() {
        return preco_da_locacao;
    }

    public void setPreco_da_locacao(double preco_da_locacao) {
        this.preco_da_locacao = preco_da_locacao;
    }

}

