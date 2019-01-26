package persistence;


import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import ordering.Article;



/**
 *
 * @author user
 */
@Entity
@Table(name="Livraisons")
@NamedQueries({
	@NamedQuery(name="Livraisons.findAll", query="SELECT l FROM ODB.LIVRAIISONS l")
})
public class Livraison implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="creationdate")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@NotNull
	@Size(min = 1, max = 8192)
	@Column(name="articles")
	private String articles;
	
	@NotNull
	@Column(name="price")
	private double price;
	
	@NotNull
	@Column(name="addrFacturation")
	String addressFacturation;
	
	@NotNull
	@Column(name="addrLivraison")
    public String addressLivraison;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreationDate(java.util.Date date) {
		this.creationDate = (Date) date;
	}
	
	
	
	public void addArticle (Article article)
	{
		this.articles += ("" + article.label + "\n" + article.description + "\n" + article.codes + "\n\n");
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Livraison)) {
			return false;
		}
		Livraison other = (Livraison) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "persistence.Livraison[ id=" + id + " ]";
	}
	
}
