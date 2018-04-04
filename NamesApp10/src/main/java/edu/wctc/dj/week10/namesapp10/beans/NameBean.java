package edu.wctc.dj.week10.namesapp10.beans;

import edu.wctc.dj.week10.namesapp10.model.Name;
import edu.wctc.dj.week10.namesapp10.service.NameService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nameBean")
@Scope("session")
public class NameBean implements Serializable {

    @Autowired
    private NameService nameService;
    private Name name;
    private List<Name> nameList;

    public NameBean() {
    }

    public String allNames() throws Exception {
        nameList = nameService.getAllNames();
        return "nameList";
    }

    public void nameDetail(AjaxBehaviorEvent event) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("nameDetail.xhtml?id=" + name.getId());
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("IOException", name.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Name> getNameList() {
        return nameList;
    }

    public void setNameList(List<Name> nameList) {
        this.nameList = nameList;
    }

}
