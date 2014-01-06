/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package france.uha.ensisa.fl.notes;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Florent
 */
@Stateless
public class CategoriesBean implements CategoriesBeanLocal {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<Categories> listAllCategories() {
        Query query = em.createQuery("SELECT n FROM Categories n ORDER BY n.name ASC");
        return query.getResultList();
    }

    @Override
    public Categories createCategorie(Categories categories) {
        em.persist(categories);
        return categories;
    }
    
    //public Notes createNotes(Notes notes){return null;}
    
    @Override
    public Categories getCategories(Long id) {
        return (Categories) em.find(Categories.class, id);
    }
    
    @Override
    public void addNotes(Categories categories, Notes notes) {
        em.persist(notes);
        em.merge(categories).addNote(notes);
    }
}
