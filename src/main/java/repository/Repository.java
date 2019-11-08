package repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

    T findOne(Long id);

    List<T> findAll();

    T create(T object) throws IOException;

    T update(Long id, T object);

    void delete(Long id);
}
