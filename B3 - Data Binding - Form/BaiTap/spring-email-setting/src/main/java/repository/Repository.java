package repository;

import java.util.List;

public interface Repository<T> {
   List<T> findAll();
   void save(T t);
   T findById(int id);
}
