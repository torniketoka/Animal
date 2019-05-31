package meins;

import java.io.Serializable;
import java.util.EnumSet;


public class Farm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private EnumSet<Animal> animals = EnumSet.noneOf(Animal.class);
	
	
	public Farm(String name, EnumSet<Animal> animals) {
        if(name.isEmpty() || name == null || animals.isEmpty() || animals == null)
        {
        	throw new IllegalArgumentException("Darf nicht leer sein");
        } else {
        	this.name = name;
    		this.animals = animals;
        }
		
	}



	public String getName() {
		return name;
	}



	public EnumSet<Animal> getAnimals() {
		return animals;
	}



	public String getAllSounds() {
		String result = "";
		for(Animal a: this.animals)
		{
			result += a.getSpruch() + "-";
		}
		return result.substring(0, result.length()-1);
	}
	
   public double getVolume() {
	   double result = 0;
	   for(Animal a: this.animals)
		{
			result += a.getSpruch().length() / 10;
		}
	   return result;
   }


@Override
public String toString() {
	return "Farm [name=" + name + ", getAllSounds()=" + getAllSounds() + ", getVolume()=" + getVolume() + "]";
}
   
   

}
