
package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import java.util.List;


public interface VentaDAO {
        public void insert(Seminario venta) throws Exception;
    public void update(Seminario venta) throws Exception;
    public void delete(int id) throws Exception;
    public List<Seminario> getAll() throws Exception;
    public Seminario getById(int id) throws Exception;
}
