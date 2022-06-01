
package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SeminariosDAOimpl extends ConexionDB implements SeminariosDAO{

    @Override
    public void insert(Seminario seminario) throws Exception {
  try {
            this.conectar();
            
            String sql = "insert into seminarios (titulo,fecha,cupo)values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupos());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "update seminarios set titulo=?, fecha=?,cupos=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupos());
            ps.setInt(4, seminario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        try {
            this.conectar();
            String sql = "select * from seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Seminario>();
            while (rs.next()) {
                Seminario p = new Seminario();

                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setFecha(rs.getDate("fecha"));
                p.setCupos(rs.getInt("cupo"));

                lista.add(p);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Seminario getById(int id) throws Exception {
    Seminario semin = new Seminario();
        try {
            this.conectar();
            String sql = "select * from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                semin.setId(rs.getInt("id"));
                semin.setTitulo(rs.getString("titulo"));
                semin.setFecha(rs.getDate("fecha"));
                semin.setCupos(rs.getInt("cupo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return semin;
    }
    
}
