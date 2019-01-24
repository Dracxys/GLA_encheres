/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author simon
 */
@ManagedBean(name = "articleBean")
@RequestScoped
public class ArticleBean {
    
    String label, description, deadline;
    String[] categories;
    Double startingprice;
    /**
     * Creates a new instance of ArticleBean
     */
    public ArticleBean() {
    }
    
}
