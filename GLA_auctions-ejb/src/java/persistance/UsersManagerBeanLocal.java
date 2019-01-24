/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import model.Users;

/**
 *
 * @author lionnet5u
 */
@Local
public interface UsersManagerBeanLocal {
        public Boolean addPerson(String last, String first, Date birthday);
        public List<Integer>  getAllStatus();
        //public List<Person> allPersons();
}
