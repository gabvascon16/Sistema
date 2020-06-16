
package frb.edu.br.dominio.entidades;

import java.util.Date;


public class CategoriaDto {
    private int categoria_id;
    private String nome;
    private Date ultima_atualizacao;

    public CategoriaDto() {
    }

    public CategoriaDto(int categoria_id, String nome, Date ultima_atualizacao) {
        this.categoria_id = categoria_id;
        this.nome = nome;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public CategoriaDto(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltimaatualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

 
}
