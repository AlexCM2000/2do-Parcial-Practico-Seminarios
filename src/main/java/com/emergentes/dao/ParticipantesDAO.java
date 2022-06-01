
package com.emergentes.dao;

import com.emergentes.modelo.Participante;
import java.util.List;

public interface ParticipantesDAO {
     public void insert(Participante cliente) throws Exception;
    public void update(Participante cliente) throws Exception;
    public void delete(int id) throws Exception;
    public List<Participante> getAll() throws Exception;
    public Participante getById(int id) throws Exception;
}
