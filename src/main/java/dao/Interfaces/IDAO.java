package dao.Interfaces;

import java.util.List;

public interface IDAO<E> {
        E create(E entity);
        E getById(int id);
        List<E> getAll();
        E update(E entity);
        int delete(int id);
}

