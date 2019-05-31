package meins;

import java.util.EnumSet;

public class FeedLot extends Farm {


	private static final long serialVersionUID = 1L;

	public FeedLot(String name, EnumSet<Animal> animals) {
		super(name, animals);
		
	}
	
	@Override
	public double getVolume() {
		   return super.getVolume() * 10;
	   }

}
