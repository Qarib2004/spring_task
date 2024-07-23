package JDBC.SQL.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public CategoryService() {
    }

    private static final Logger logger = Logger.getLogger(CategoryService.class.getName());

    public void insert(Category category){
        logger.info("Info: "+category);
        categoryRepository.insert(category);
    }

    public void delete(int id){
        categoryRepository.delete(id);
    }

    public void update(Category category,int id){
        categoryRepository.update(category,id);
    }

    public List<Category> selectAll(){
        return categoryRepository.selectAll();
    }

    public List<Category> selectById(int id){
        return categoryRepository.selectById(id);
    }
}
