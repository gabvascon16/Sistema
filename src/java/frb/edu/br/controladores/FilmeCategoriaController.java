package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.IFilmeCategoria;
import frb.edu.br.dominio.entidades.FilmeCategoriaDto;
import frb.edu.br.infra.repositorios.CategoriaRepositorio;
import frb.edu.br.infra.repositorios.FilmesCategoriaRepositorio;
import java.util.List;


public class FilmeCategoriaController {
    private FilmeCategoriaDto filmeCategoria;
    private List<FilmeCategoriaDto> filmeCategorias = null;
    
    private IFilmeCategoria filmesCategoriaRepositorio = new FilmesCategoriaRepositorio();


    public FilmeCategoriaController() {
    }

    public FilmeCategoriaDto getFilmeCategoria() {
        return filmeCategoria;
    }

    public void setFilmeCategoria(FilmeCategoriaDto filmeCategoria) {
        this.filmeCategoria = filmeCategoria;
    }

    public List<FilmeCategoriaDto> getFilmeCategorias() {
        if(filmeCategorias == null){
            filmeCategorias = filmesCategoriaRepositorio.getListaTodos();
        }
        return filmeCategorias;
    }

    public void setFilmeCategorias(List<FilmeCategoriaDto> filmeCategorias) {
        this.filmeCategorias = filmeCategorias;
    }

    public IFilmeCategoria getFilmesCategoriaRepositorio() {
        return filmesCategoriaRepositorio;
    }

    public void setFilmesCategoriaRepositorio(IFilmeCategoria filmesCategoriaRepositorio) {
        this.filmesCategoriaRepositorio = filmesCategoriaRepositorio;
    }

    public String prepararInclusao(){
        filmeCategoria = new FilmeCategoriaDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        
        filmesCategoriaRepositorio.incluir(filmeCategoria);
        filmeCategorias = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        filmesCategoriaRepositorio.alterar(filmeCategoria);
        filmeCategorias = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        filmesCategoriaRepositorio.deletar( filmeCategoria.getFilme_id(), filmeCategoria.getCategoria_id());
        filmeCategorias = null;
        return "refresh";
    }
    
    
}
