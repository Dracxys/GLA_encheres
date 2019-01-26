package ordering;


import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import persistence.Livraison;



/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class OrderManagerBean
{

	
	private static final double maxWeight = 50;
	private static final double maxVolume = 500;
	
	
	@PersistenceContext(unitName = "GLA_livraison-ejbPU")
    private EntityManager em;
	
	
	public void treatCommande (Commande cmd)
	{
		double totalWeight = 0;
		double totalVolume = 0;
		double totalPrice = 0;
		
		Livraison livraison = new Livraison();
		
		for (Article article : cmd.getArticles()) {
			double volume = (article.dimX * article.dimY * article.dimZ);
			
			if (
					(totalWeight + article.weight) > maxWeight
				||	(totalVolume + volume) > maxVolume
			)
			{
				livraison.setCreationDate(new Date());
				em.persist(livraison);
				
				livraison = new Livraison();
				totalWeight = article.weight;
				totalVolume = volume;
				totalPrice = article.price;
			}
			
			livraison.addArticle(article);
		}
		
		livraison.setCreationDate(new Date());
		em.persist(livraison);
	}
	

}
