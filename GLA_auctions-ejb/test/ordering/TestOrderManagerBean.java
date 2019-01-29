package ordering;


//import javax.ejb.EJB;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import org.mockito.junit.MockitoJUnitRunner;



/**
 *
 * @author user 
 */
@RunWith(MockitoJUnitRunner.class)
public class TestOrderManagerBean
{

	
	//@EJB
	private static OrderManagerBean orderManager;
	
	@Before
	public void init ()
	{
		orderManager = mock(OrderManagerBean.class);
	}
	
	@Test
	public void testJMS ()
	{
		long id = 1;
		
		Article styloBleu = new Article();
		styloBleu.label = "Stylo bleu";
		styloBleu.description = "un très beau stylo bleu";
		styloBleu.price = 2;
		styloBleu.weight = 0.1;
		styloBleu.dimX = 1;
		styloBleu.dimY = 1;
		styloBleu.dimZ = 8;
		styloBleu.id = id++;
		
		Article styloVert = new Article();
		styloBleu.label = "Stylo vert";
		styloBleu.description = "un très beau stylo vert";
		styloBleu.price = 2;
		styloBleu.weight = 0.1;
		styloBleu.dimX = 1;
		styloBleu.dimY = 1;
		styloBleu.dimZ = 8;
		styloBleu.id = id++;
		
		Commande cmd = new Commande();
		cmd.articles.add(styloBleu);
		cmd.articles.add(styloVert);
		cmd.addressFacturation = "4 rue gla";
		cmd.addressLivraison = "4 rue gla";
		
		orderManager.sendOrder(cmd);
	}
	

}
