package project0;

import java.util.List;

public interface Dao<E> {
    void insert(E e);
    List<E> getAll();
    void update(E e);
    void delete(E e);  
}
