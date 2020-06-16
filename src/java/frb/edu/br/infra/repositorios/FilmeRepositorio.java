package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IFilme;
import frb.edu.br.dominio.entidades.FilmeDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilmeRepositorio extends DaoUtil implements IFilme{

    public FilmeRepositorio() {
        super();
    }    
    

    @Override
    public FilmeDto getRegistroPorId(int id) {
        FilmeDto film = new FilmeDto();
        String sql = "SELECT filme_id, titulo, "; 
        sql += "descricao, ano_de_lancamento, preco_da_locacao FROM filme ";
        sql += " WHERE filme_id = ?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                film = new FilmeDto(rs.getInt("filme_id"),
                                      rs.getString("titulo"), 
                                      rs.getString("descricao"), 
                                      rs.getString("ano_de_lancamento"), 
                                      rs.getDouble("preco_da_locacao"));
               
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return film;
    }

    @Override
    public List<FilmeDto> getListaTodos() {
        List<FilmeDto> films = new LinkedList<FilmeDto>();
        String sql = "SELECT filme_id, titulo, "; 
        sql += "descricao, ano_de_lancamento, preco_da_locacao FROM filme ";
        
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                films.add( new FilmeDto(rs.getInt("filme_id"),
                                      rs.getString("titulo"), 
                                      rs.getString("descricao"), 
                                      rs.getString("ano_de_lancamento"), 
                                      rs.getDouble("preco_da_locacao")));        
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilmeRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
        return films;
    }

    @Override
    public boolean incluir(FilmeDto filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(FilmeDto filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
