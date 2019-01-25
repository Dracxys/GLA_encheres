package ordering;


import java.util.List;
import java.util.ArrayList;



/**
 *
 * @author user
 */
public class Article
{

	
	public Article ()
	{
		this.codes = new ArrayList<>();
	}
	
	
	public String label;
	public String description;
	
	public double price;
	public List<String> codes;
	
	public double weight;
	public double dimX;
	public double dimY;
	public double dimZ;
	

}
