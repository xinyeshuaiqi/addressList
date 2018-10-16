package utils;

import java.util.Comparator;

import entity.Person;

public class OrderByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int temp=o1.getName().compareTo(o2.getName());
		//���������ͬ�ٱȽ�����
		return temp==0?o1.getAge()-o2.getAge():temp;
	}

}
