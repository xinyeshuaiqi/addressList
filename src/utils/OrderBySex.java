package utils;

import java.util.Comparator;

import entity.Person;

public class OrderBySex implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int temp=o1.getSex().compareTo(o2.getSex());
		return temp==0?o1.getAge()-o2.getAge():temp;
	}

}
