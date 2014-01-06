/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package france.uha.ensisa.fl.notes;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Florent
 */
@Local
public interface CategoriesBeanLocal {
    List<Categories> listAllCategories();
    Categories createCategorie(Categories categories);
    Categories getCategories(Long id);
    void addNotes(Categories categories, Notes notes);
}
