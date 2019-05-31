package meins;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MyMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Farm f1 = new Farm("Little House on the Prairie", EnumSet.of(Animal.CAT, Animal.DOG, Animal.DUCK));
		
		FeedLot fd1 = new FeedLot("Cattle Lot C42", EnumSet.of(Animal.CATTLE, Animal.DOG));
	    
		Farm f2 = new Farm("Puder Rosa Ranch", EnumSet.of(Animal.HORSE, Animal.CAT, Animal.DUCK));
		Farm f3 = new Farm("Maple Leaf Farm", EnumSet.of(Animal.DUCK, Animal.CAT));
		
		FeedLot fd2 = new FeedLot("Pig Feed Lot", EnumSet.of(Animal.PIG, Animal.CAT, Animal.HORSE));
		
		final List<Farm> list = new ArrayList<>();
		list.add(f1);
		list.add(fd1);
		list.add(f2);
		list.add(f3);
		list.add(fd2);
		
		
		 try(ObjectOutputStream  out = new ObjectOutputStream 
				     (new FileOutputStream ("farms.ser"))){
			 out.writeObject(list);
			 }catch(IOException ex)
		     {ex.printStackTrace();
		 }
		
		 List<Farm> listin = new ArrayList<>();
		 
		 try(ObjectInputStream in=new ObjectInputStream 
				  (new FileInputStream("farms.ser"))){
		 listin = (List<Farm>)in.readObject();
		 }catch(Exception ex) {
		  ex . printStackTrace () ;
		  }
		 
		 listin.forEach(item->System.out.println(item));
		 
		 
		 System.out.println("");
		 System.out.println();
		
		 
		 
		 Map<String, List<Farm>> hashmap = listin.stream().collect(Collectors.groupingBy(s-> s.getAnimals().toString()));

		 hashmap.forEach((k,v)-> System.out.println(k + " = " + v));
		 
		 for(Entry<String, List<Farm>> e: hashmap.entrySet()) {
			    Collections.shuffle(e.getValue());
		 }
		 System.out.println("");
		 hashmap.forEach((k,v)-> System.out.println(k + " = " + v));
		 
		 Comparator<Farm> comp = Comparator.comparing(Farm::getVolume);
		 for(Entry<String, List<Farm>> er: hashmap.entrySet()) {
			    Collections.sort(er.getValue(), comp);
		 }
		 System.out.println("");
		 hashmap.forEach((k,v)-> System.out.println(k + " = " + v));
		 
		 }
	}

