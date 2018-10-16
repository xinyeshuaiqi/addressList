package utils;

import java.util.Comparator;

import entity.Person;

public class OrderByAge implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int temp=o1.getAge()-o2.getAge();
		//���������ͬ�ٱȽ�����
		return temp==0?o1.getName().compareTo(o2.getName()):temp;
	}

}
