package guru.leco.springbootjwt.services;

import java.util.List;

public interface CrudService<T, ID> {

    T save(T object);

    T findById(ID id);

    List<T> findAll();

    void removeById(ID id);

    T update(ID id, T object);
}
