package dao;

import java.util.List;

public interface Dao<T> {

	boolean create(T t);

	T retrieve(int id);

	List<T> retrieveAll();

	boolean update(T t, String[] params);

	boolean delete(T t);

}
