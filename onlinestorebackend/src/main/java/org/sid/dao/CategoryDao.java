package org.sid.dao;

import java.util.List;

import org.sid.dto.Category;

public interface CategoryDao {
	List<Category> list();
	Category get(int id);

}
