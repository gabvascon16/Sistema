package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.IFilme;
import frb.edu.br.dominio.entidades.FilmeDto;
import frb.edu.br.infra.repositorios.FilmeRepositorio;
import java.util.List;


public class FilmeController {
    private FilmeDto filme;
    private List<FilmeDto> filmes = null;
    
    private IFilme filmeRepositorio = new FilmeRepositorio();


    public FilmeController() {
    }

    public FilmeDto getFilme() {
        return filme;
    }

    public void setFilme(FilmeDto filme) {
        this.filme = filme;
    }

    public List<FilmeDto> getFilmes() {
        if(filmes == null){
            filmes = filmeRepositorio.getListaTodos();
        }
        return filmes;
    }
    
    public String prepararInclusao(){
        filme = new FilmeDto();
        return "vaiParaIncluirFilme";
    }
    
    public String finalizaInclusao(){
        
        filmeRepositorio.incluir(filme);
        filmes = null;
        return "voltaParaListagemFilme";
    }
    
    public String finalizaEdicao(){
        filmeRepositorio.alterar(filme);
        filmes = null;
        return "voltaParaListagemFilme";
    }
    
    public String finalizaDelecao(){
        filmeRepositorio.deletar( filme.getFilme_id() );
        filmes = null;
        return "refresh";
    }
    
   
}
