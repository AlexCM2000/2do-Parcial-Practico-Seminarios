package com.emergentes.dao;

import com.emergentes.modelo.Participante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipantesDAOimpl extends ConexionDB implements ParticipantesDAO {

    @Override
    public void insert(Participante participante) throws Exception {
        try {
            this.conectar();
            String sql = "insert into participantes (apellidos,nombres,id_seminario,confirmado)values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getSeminario_id());
            ps.setInt(4, participante.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Participante participante) throws Exception {
        try {
            this.conectar();
            String sql = "update participantes set apellidos=?, nombres=?, id_seminario=?,confirmado=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getSeminario_id());
            ps.setInt(4, participante.getConfirmado());
            ps.setInt(5, participante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from participantes where id=?";
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
    public List<Participante> getAll() throws Exception {
        List<Participante> lista = null;
        try {
            this.conectar();
            String sql = "select p.id,id_seminario,apellidos,nombres,titulo,confirmado from participantes p, seminarios s where p.id_seminario=s.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Participante>();
            while (rs.next()) {
                Participante parti = new Participante();

                parti.setId(rs.getInt("id"));
                parti.setApellidos(rs.getString("apellidos"));
                parti.setNombres(rs.getString("nombres"));
                parti.setSeminario(rs.getString("titulo"));
                parti.setSeminario_id(rs.getInt("id_seminario"));
                parti.setConfirmado(rs.getInt("confirmado"));
                lista.add(parti);
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
    public Participante getById(int id) throws Exception {
        Participante cli = new Participante();
        try {
            this.conectar();
            String sql = "select * from participantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setNombres(rs.getString("nombres"));
                cli.setSeminario_id(rs.getInt("id_seminario"));
                cli.setConfirmado(rs.getInt("confirmado"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

}
