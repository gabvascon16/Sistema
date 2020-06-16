package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.ICategoria;
import frb.edu.br.dominio.entidades.CategoriaDto;
import frb.edu.br.infra.repositorios.CategoriaRepositorio;
import java.util.List;


public class CategoriaController {
    private CategoriaDto categoria;
    private List<CategoriaDto> categorias = null;
    
    private ICategoria categoriaRepositorio = new CategoriaRepositorio();


    public CategoriaController() {
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaDto> getCategorias() {
        if(categorias == null){
            categorias = categoriaRepositorio.getListaTodos();
        }
        return categorias;
    }
    
    public String prepararInclusao(){
        categoria = new CategoriaDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        
        categoriaRepositorio.incluir(categoria);
        categorias = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        categoriaRepositorio.alterar(categoria);
        categorias = null;
        return "voltaParaListagem";
    }
    
    public String finalizaDelecao(){
        categoriaRepositorio.deletar( categoria.getCategoria_id() );
        categorias = null;
        return "refresh";
    }
    
    
}
