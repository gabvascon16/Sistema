
package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.FilmeCategoriaDto;
import java.util.List;


public interface IFilmeCategoria {
    boolean incluir(FilmeCategoriaDto filmecategoria);
    boolean alterar(FilmeCategoriaDto filmecategoria);
    boolean deletar(int filme_id, int categoria_id);
    FilmeCategoriaDto getRegistroPorId(int filme_id, int categoria_id);
    List<FilmeCategoriaDto> getListaTodos();
}
