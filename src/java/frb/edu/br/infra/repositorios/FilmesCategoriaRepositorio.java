package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IFilmeCategoria;
import frb.edu.br.dominio.entidades.FilmeDto;
import frb.edu.br.dominio.entidades.FilmeCategoriaDto;
import frb.edu.br.dominio.entidades.CategoriaDto;
import frb.edu.br.infra.data.DaoUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmesCategoriaRepositorio extends DaoUtil implements IFilmeCategoria {

    public FilmesCategoriaRepositorio() {
        super();
    }

    @Override
    public boolean incluir(FilmeCategoriaDto filmeCategoria) {
        String sql = "INSERT INTO filme_categoria (filme_id, categoria_id) "
                + " VALUES (?, ?) ";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, filmeCategoria.getFilme().getFilme_id());
            ps.setInt(2, filmeCategoria.getCategoria().getCategoria_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean alterar(FilmeCategoriaDto filmeCategoria) {
        String sql = "UPDATE filme_categoria SET filme_id=?, categoria_id=?"
                + " WHERE filme_id=? and categoria_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, filmeCategoria.getFilme().getFilme_id());
            ps.setInt(2, filmeCategoria.getCategoria().getCategoria_id());
            ps.setInt(3, filmeCategoria.getFilme_id());
            ps.setInt(4, filmeCategoria.getCategoria_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public boolean deletar(int filme_id, int categoria_id) {
        String sql = "DELETE FROM filme_categoria "
                + " WHERE filme_id=? and categoria_id=?";
        PreparedStatement ps;
        int ret = -1;
        try {
            ps = getPreparedStatement(sql);
            ps.setInt(1, filme_id);
            ps.setInt(2, categoria_id);

            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret > 0;
    }

    @Override
    public FilmeCategoriaDto getRegistroPorId(int filme_id, int categoria_id) {
        FilmeCategoriaDto filmCtg = new FilmeCategoriaDto();

        String sql = "SELECT filme_id, categoria_id, ultima_atualizacao FROM filme_categoria WHERE filme_id=? and categoria_id=?";

        FilmeRepositorio film = new FilmeRepositorio();
        CategoriaRepositorio ctg = new CategoriaRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, filme_id);
            ps.setInt(2, categoria_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                filmCtg = new FilmeCategoriaDto(rs.getInt("filme_id"),
                        rs.getInt("categoria_id"),
                        film.getRegistroPorId(rs.getInt("filme_id")),
                        ctg.getRegistroPorId(rs.getInt("categoria_id")),
                        rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filmCtg;
    }

    @Override
    public List<FilmeCategoriaDto> getListaTodos() {
        List<FilmeCategoriaDto> filmCtg = new LinkedList<FilmeCategoriaDto>();

        String sql = "SELECT filme_id, categoria_id, ultima_atualizacao FROM filme_categoria";

        FilmeRepositorio film = new FilmeRepositorio();
        CategoriaRepositorio ctg = new CategoriaRepositorio();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FilmeDto films = film.getRegistroPorId(rs.getInt("filme_id"));
                CategoriaDto ctgs = ctg.getRegistroPorId(rs.getInt("categoria_id"));
                filmCtg.add(new FilmeCategoriaDto(
                        rs.getInt("filme_id"),
                        rs.getInt("categoria_id"),
                        films,
                        ctgs,
                        rs.getDate("ultima_atualizacao")));

            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(FilmesCategoriaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filmCtg;
    }

}
