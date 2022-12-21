package PartB;

public abstract class AbstractPerson {

//	private int ID;
//	private int age;
//	private String name;
//	private int weightLbs;
//	private int weightLossLbs;
	
	public abstract int getId();
	public abstract void setId(int id);
	public abstract int getAge();
	public abstract String getName();
	public abstract int getWeightLbs();
	public abstract void setWeightLbs(int weightLbs);
	public abstract int getWeightLossLbs();
	public abstract void setWeightLossLbs(int weightLossLbs);
}
