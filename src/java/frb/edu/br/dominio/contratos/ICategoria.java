
package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.CategoriaDto;
import java.util.List;


public interface ICategoria {
    boolean incluir(CategoriaDto categoria);
    boolean alterar(CategoriaDto categoria);
    boolean deletar(int id);
    CategoriaDto getRegistroPorId(int id);
    List<CategoriaDto> getListaTodos();
}
