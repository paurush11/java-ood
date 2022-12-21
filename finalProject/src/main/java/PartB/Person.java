package PartB;

public class Person extends AbstractPerson {
	
	private int ID;
	private int age;
	private String name;
	private int weightLbs;
	private int weightLossLbs;
	
	@Override
	public String toString() {
		return "Person ID=" + ID + ", age=" + age + ", name=" + name + ", weightLbs=" + weightLbs + ", weightLossLbs="
				+ weightLossLbs + "";
	}

	public Person(int age, String name) {
		this.name = name;
		this.age = age;	
	}

	@Override
	public int getId() {
		return this.ID;
	}

	@Override
	public void setId(int id) {
		this.ID = id;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getWeightLbs() {
		return this.weightLbs;
	}

	@Override
	public void setWeightLbs(int weightLbs) {
		this.weightLbs = weightLbs;
	}

	@Override
	public int getWeightLossLbs() {
		return weightLossLbs;
	}

	@Override
	public void setWeightLossLbs(int weightLossLbs) {
		this.weightLossLbs = weightLossLbs;
	}
}
