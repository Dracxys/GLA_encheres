/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import model.Users;

/**
 *
 * @author lionnet5u
 */
@Stateless(name = "PersonManager")
public class UsersManagerBean implements UsersManagerBeanLocal {
    
    @PersistenceContext(unitName = "GLA")
    private EntityManager em;

    @Resource(lookup = "jdbc/GLA")
    private DataSource dataSource;
    private Connection connection;
    
    @PostConstruct
    public void initialize() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    @PreDestroy
    public void cleanup() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public Boolean addPerson(){
        Users user = new Users();
        em.persist(user);
        return true;
    }
    
        public Users firstCustomer() {
        Users users = em.find(Users.class, 1L);
        return users;
    }

    
  /*  public Boolean addPerson(String last, String first, String nick) {
        Person person = new Person(first, last, nick);
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO PERSONS(NICKNAME,FIRSTNAME,LASTNAME) VALUES("
                    + "\'"
                   
                    + person.getFirstname()
                    + "\',\'"
                    + person.getLastname()+ "\')");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return true;
    }*/
/*
    @Override
    public List<Person> allPersons() {
        List<Person> liste = new ArrayList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM PERSONS");
            while(rs.next()){
                String nickname = rs.getString("NICKNAME");
                String lastname = rs.getString("LASTNAME");
                String firstname = rs.getString("FIRSTNAME");
                liste.add(new Person(firstname, lastname, nickname));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return liste;
    }*/
        
    public List<Integer> getAllStatus(){
        ArrayList<Integer> liste = (ArrayList<Integer>)em.createNamedQuery("Integer.findAll").getResultList();
        return liste;
    }

    @Override
    public Boolean addPerson(String last, String first, Date birthday) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
