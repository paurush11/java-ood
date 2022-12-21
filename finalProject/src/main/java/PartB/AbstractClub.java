package PartB;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractClub {

//	private int ID;
//	private int age;
//	private String name;
//	private int weightLbs;
//	private int weightLossLbs;
	
	public abstract void add(AbstractPerson p);
	
	public abstract void sortAndShow(Comparator<? super AbstractPerson> compare, Consumer<AbstractPerson> action);
	
	public abstract List<Integer> getWeightLossStats();
	
}
