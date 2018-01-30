package org.sid.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.CategoryDao;
import org.sid.dto.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	private static List<Category> categories = new ArrayList<Category>();
	static {
		Category c = new Category();
		c.setId(1);
		c.setName("Televisions");
		c.setDescription("this is a description of tv");
		c.setImageURL("");

		Category c1 = new Category();
		c1.setId(2);
		c1.setName("Mobiles");
		c1.setDescription("this is a description of mobiles");
		c1.setImageURL("");

		categories.add(c);
		categories.add(c1);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category c:categories)
		{
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	

}
