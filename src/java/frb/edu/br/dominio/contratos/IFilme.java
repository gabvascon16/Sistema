
package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.FilmeDto;
import java.util.List;


public interface IFilme {
    boolean incluir(FilmeDto filme);
    boolean alterar(FilmeDto filme);
    boolean deletar(int id);
    FilmeDto getRegistroPorId(int id);
    List<FilmeDto> getListaTodos();
}
