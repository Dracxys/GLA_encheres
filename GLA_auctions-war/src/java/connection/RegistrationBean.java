/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author lionnet5u
 */
@ManagedBean ( name = "registrationBean")
@RequestScoped
public class RegistrationBean {
    
    @EJB 
    NameHandlerBeanLocal nameHandler;
    @EJB 
    PersonManagerBeanLocal personeManager;
    
    private String firstname,lastname, title, fulltitle;
    private Status status;
    private Date birthday;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public void setFulltitle(String fulltitle) {
        this.fulltitle = fulltitle;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public String greetings() {
        return "finInscription"; 
    }
    public String registerUser(){
        personeManager.addPerson(firstname,lastname, birthday, status);
        return nameHandler.greetingsMessage(lastname);
    }
    
    public List<Status> allStatus(){
        return personeManager.getAllStatus();
    }
    /*
    public List<Person> allPersons(){
        return personeManager.allPersons();
    } */
}
