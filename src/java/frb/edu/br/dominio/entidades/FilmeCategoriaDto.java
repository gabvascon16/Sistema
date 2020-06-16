package frb.edu.br.dominio.entidades;

import java.util.Date;

public class FilmeCategoriaDto {
    private int filme_id;
    private int categoria_id;

    private FilmeDto filme;
    private CategoriaDto categoria;
    private Date ultima_atualizacao;
    
    public FilmeCategoriaDto() {
        filme = new FilmeDto();
        categoria = new CategoriaDto();
    }

    public FilmeCategoriaDto(int filme_id, int categoria_id, FilmeDto filme, CategoriaDto categoria, Date ultima_atualizacao) {
        this.filme_id = filme_id;
        this.categoria_id = categoria_id;
        this.filme = filme;
        this.categoria = categoria;
        this.ultima_atualizacao = ultima_atualizacao;
    }



    public FilmeCategoriaDto(int filme_id, int categoria_id) {
        this.filme_id = filme_id;
        this.categoria_id = categoria_id;
        filme = new FilmeDto();
        categoria = new CategoriaDto();
    }

    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    
    public FilmeDto getFilme() {
        return filme;
    }

    public void setFilme(FilmeDto filme) {
        this.filme = filme;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
    
    
    
    
}
