package guru.leco.springbootjwt.services;

import java.util.List;

public interface CrudService<T, S> {

    T save(S object);

    T findById(Integer id);

    List<T> findAll();

    void removeById(Integer id);

    T update(Integer id, S object);
}
