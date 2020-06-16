package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.ICategoria;
import frb.edu.br.dominio.entidades.CategoriaDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoriaRepositorio extends DaoUtil implements ICategoria{

    public CategoriaRepositorio() {
        super();
    }    
    
    @Override
    public boolean incluir(CategoriaDto categoria) {
        String sql = "INSERT INTO categoria (nome)" +
                     " VALUES (?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, categoria.getNome());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0; 
    }

    @Override
    public boolean alterar(CategoriaDto categoria) {
        String sql = "UPDATE categoria SET nome=?" +
                     " WHERE categoria_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setString(1, categoria.getNome());
            ps.setInt(2, categoria.getCategoria_id());
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM categoria WHERE categoria_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
                       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public CategoriaDto getRegistroPorId(int id) {
        CategoriaDto ctg = new CategoriaDto();
        String sql = "SELECT categoria_id, nome, "; 
        sql += "ultima_atualizacao FROM categoria ";
        sql += " WHERE categoria_id = ?";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ctg = new CategoriaDto(rs.getInt("categoria_id"),
                                      rs.getString("nome"), 
                                      rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return ctg;
    }

    @Override
    public List<CategoriaDto> getListaTodos() {
        List<CategoriaDto> ctgs = new LinkedList<CategoriaDto>();
        String sql = "SELECT categoria_id, nome, "; 
        sql += "ultima_atualizacao FROM categoria ";
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                ctgs.add( new CategoriaDto(rs.getInt("categoria_id"),
                                      rs.getString("nome"), 
                                      rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
        return ctgs;
    }
    
}
