package com.BC.dao;

import java.util.List;

public interface DaoInterface<T> {
	
	public void add(T element);
	
	public void update(T element);
	
	public void delete(T element);
	
	public T findByColumn(String column, String condition);
	
	public T findByColumn(String column, Long condition);
	
	public List<T> findAll();
		
	public List<T> findAllByColumn(String column, String condition);
	
	public List<T> findAllByColumn(String column, Long condition);
	
}
