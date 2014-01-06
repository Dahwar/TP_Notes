package france.uha.ensisa.fl.notes;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Florent
 */
@ManagedBean
@SessionScoped
public class Controller {

    @EJB
    private CategoriesBeanLocal categoriesBean;
    private Categories editedCategories = new Categories();
    private Notes editedNotes = new Notes();
    
    
    public Controller() {
    }
    
    public String doCreateCategories() {
        editedCategories = new Categories();
        return "createCategories.xhtml";
    }
    
    public String doCreateNotes(Long id) {
        editedCategories = categoriesBean.getCategories(id);
        editedNotes = new Notes();
        return "createNotes.xhtml";
    }
    
    public String doAddCategories() {
        categoriesBean.createCategorie(editedCategories);
        return "index.xhtml";
    }
    
    public String doAddNotes() {
        categoriesBean.addNotes(editedCategories, editedNotes);
        return "index.xhtml";
    }
    
    public Categories getEditedCategories() {
        return editedCategories;
    }
    
    public Notes getEditedNotes() {
        return editedNotes;
    }
    
    public List<Categories> getCategories() {
        return categoriesBean.listAllCategories();
    }
    
    public List<Notes> getNotes(Long id) {
        List<Notes> temp = new ArrayList<>();
        if(categoriesBean.getCategories(id) != null) {
            return categoriesBean.getCategories(id).getNotes();
        }
        return temp;
    }
    
    public String doDisplayNotes(Notes notes) {
        editedNotes.setTitle(notes.getTitle());
        editedNotes.setNote(notes.getNote());
        return "notesDisplay.xhtml"; 
    }
}
