package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import entity.Person;

public class Operate {
	private Vector<Person> v=null;
	
	public void addLogic(){   //�߼�����
		while(true){
			Menu.addMenu();
			System.out.println("��������ȷ���֣���С��1�������3");
			TelNoteRegex t=new TelNoteRegex();
			Scanner in=new Scanner(System.in);
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 3)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������3");
				n=in.nextInt();
			}			
			
			if(n==1){
				addOperation();
			}
			else if(n==2){
				showAll();
			}
			else if(n==3){
				break;
			}
			
		}
	}
	
	public void searchLogic(){
		while(true){
			Menu.searchMenu();
			System.out.println("��������ȷ���֣���С��1�������7");
			TelNoteRegex t=new TelNoteRegex();
			Scanner in=new Scanner(System.in);
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 7)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������7");
				n=in.nextInt();
			}
			if(n==1){
				searchByName();
			}
			if(n==2){
				searchByAge();
			}
			if(n==3){
				searchBySex();
			}
			if(n==4){
				searchByTelNum();
			}
			if(n==5){
				searchByAdd();
			}
			if(n==6){
				showAll();
			}
			else if(n==7){   //������һ��
				break;
			}
		}
	}
	
	public void modifyLogic(){
		while(true){
			Menu.modifyMenu();
			System.out.println("��������ȷ���֣���С��1�������3");
			TelNoteRegex t=new TelNoteRegex();
			Scanner in=new Scanner(System.in);
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 3)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������3");
				n=in.nextInt();
			}
			
			if(n==1){
				modify();
			}
			if(n==2){
				showAll();
			}
			else if(n==3){
				break;
			}
			
		}
	}
	
	public void deleteLogic(){
		while(true){
			Menu.deleteMenu();
			System.out.println("��������ȷ���֣���С��1�������4");
			TelNoteRegex t=new TelNoteRegex();
			Scanner in=new Scanner(System.in);
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 4)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������4");
				n=in.nextInt();
			}
			
			if(n==1){
				delete();
			}
			if(n==2){
				deleteAll();
			}
			if(n==3){
				showAll();
			}
			else if(n==4){
				break;
			}
			
		}
	}
	
	public void orderLogic(){
		while(true){
			Menu.orderMenu();
			System.out.println("��������ȷ���֣���С��1�������5");
			TelNoteRegex t=new TelNoteRegex();
			Scanner in=new Scanner(System.in);
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 5)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������5");
				n=in.nextInt();
			}
			
			if(n==1){
				orderName();
			}
			if(n==2){
				orderAge();
			}
			if(n==3){
				orderSex();
			}
			if(n==4){
				showAll();
			}
			else if(n==5){
				break;
			}
			
		}
	}
	
	public void addOperation(){  //������û���Ϣ
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		String name=null;
		int age=0;
		String sex=null;
		String telNum=null;
		String address=null;;
				
		System.out.println("��������:1-10λ��ĸ");
		name=in.nextLine();
		while(!t.nameRegex(name)){
			System.out.println("��������:1-10λ��ĸ");
			name=in.nextLine();
		}
		
		System.out.println("��������:1-200");
		age=in.nextInt();
		while(!t.ageRegex(age)){
			System.out.println("��������:1-200");
			age=in.nextInt();
		}
		
		System.out.println("�����Ա�:�л�Ů");
		sex=in.nextLine();
		while(!t.sexRegex(sex)){
			System.out.println("�����Ա�:�л�Ů");
			sex=in.nextLine();
		}
		
		System.out.println("����绰����:6-11λ����");
		telNum=in.nextLine();
		while(!t.telNumRegex(telNum)){
			System.out.println("����绰����:6-11λ����");
			telNum=in.nextLine();
		}
		
		System.out.println("�����ַ:1-50λ�ַ�");
		address=in.nextLine();
		while(!t.addressRegex(address)){
			System.out.println("�����ַ:1-50λ�ַ�");
			address=in.nextLine();
		}
		
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		int num=0;
		try{
			conn=DButil.getConnection();
			String sql="INSERT INTO person(name,age,sex,telNum,address) VALUES(?,?,?,?,?)";
			s=conn.prepareStatement(sql);
			
			s.setString(1, name);
			s.setInt(2, age);
			s.setString(3, sex);
			s.setString(4, telNum);
			s.setString(5, address);
			
			num=s.executeUpdate();
			if(num>0){
				System.out.println("����ϵ�˴����ɹ�");
			}
			else{
				System.out.println("����ϵ�˴���ʧ��");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
	}
	
	public void showAll(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		try{
			conn=DButil.getConnection();
			String sql="SELECT *FROM person";
			s=conn.prepareStatement(sql);		
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
	}
	
	public void searchByName(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		System.out.println("��������:1-10λ��ĸ");
		String name=in.nextLine();
		while(!t.nameRegex(name)){
			System.out.println("��������:1-10λ��ĸ");
			name=in.nextLine();
		}
		try{
			conn=DButil.getConnection();
			String sql="SELECT* FROM person where name=?";
			s=conn.prepareStatement(sql);	
			
			s.setString(1, name);
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
	}
	
	public void searchByAge(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		System.out.println("��������:1-200");
		int age=in.nextInt();
		while(!t.ageRegex(age)){
			System.out.println("��������:1-200");
			age=in.nextInt();
		}
		try{
			conn=DButil.getConnection();
			String sql="SELECT* FROM person where age=?";
			s=conn.prepareStatement(sql);	
			
			s.setInt(1, age);
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
	}
	
	public void searchBySex(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		System.out.println("�����Ա�:�л�Ů");
		String sex=in.nextLine();
		while(!t.sexRegex(sex)){
			System.out.println("�����Ա�:�л�Ů");
			sex=in.nextLine();
		}
		try{
			conn=DButil.getConnection();
			String sql="SELECT* FROM person where sex=?";
			s=conn.prepareStatement(sql);	
			
			s.setString(1, sex);
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
	}
	
	public void searchByTelNum(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		System.out.println("����绰����:6-11λ����");
		String telNum=in.nextLine();
		while(!t.telNumRegex(telNum)){
			System.out.println("����绰����:6-11λ����");
			telNum=in.nextLine();
		}
		try{
			conn=DButil.getConnection();
			String sql="SELECT* FROM person where telNum=?";
			s=conn.prepareStatement(sql);	
			
			s.setString(1, telNum);
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			if(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();			
			System.out.print(p.getId()+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
		}
	}
	
	public void searchByAdd(){
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		System.out.println("�����ַ:1-50λ�ַ�");
		String add=in.nextLine();
		while(!t.addressRegex(add)){
			System.out.println("�����ַ:1-50λ�ַ�");
			add=in.nextLine();
		}
		try{
			conn=DButil.getConnection();
			String sql="SELECT* FROM person where address=?";
			s=conn.prepareStatement(sql);	
			
			s.setString(1, add);
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();			
			System.out.print(p.getId()+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
		}
	}
	
	public void modify(){   //�޸�ָ����¼��Ϣ
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		try {
			conn = DButil.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		
			System.out.println("�������¼��");
			int id=0;
			id=in.nextInt();
		while(true){	
			Menu.subModifyMenu();
			System.out.println("��������ȷ���֣���С��1�������6");
			
			
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 6)){
				Menu.addMenu();
				System.out.println("��������ȷ���֣���С��1�������6");
				n=in.nextInt();
			}
			
			
			if(n==1){
				System.out.println("������������");
				String name=null;
				name=in.next();
				try {					
					s = conn.prepareStatement("UPDATE person SET NAME=? where id=?");
					s.setString(1, name);
					s.setInt(2, id);
					int i = s.executeUpdate();
					if(i>0){
						System.out.println("�޸ĳɹ�");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(n==2){
				int age;
				age=in.nextInt();
				try {					
					s = conn.prepareStatement("UPDATE person SET age=? where id=?");
					s.setInt(1, age);	
					s.setInt(2, id);
					int i = s.executeUpdate();
					if(i>0){
						System.out.println("�޸ĳɹ�");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(n==3){
				String sex;
				sex=in.next();
				try {					
					s = conn.prepareStatement("UPDATE person SET sex=? where id=?");
					s.setString(1, sex);
					s.setInt(2, id);
					int i = s.executeUpdate();
					if(i>0){
						System.out.println("�޸ĳɹ�");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(n==4){
				String telNum;
				telNum=in.next();
				try {					
					s = conn.prepareStatement("UPDATE person SET telNum=? where id=?");
					s.setString(1, telNum);	
					s.setInt(2, id);
					int i = s.executeUpdate();
					if(i>0){
						System.out.println("�޸ĳɹ�");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(n==5){
				String add;
				add=in.next();
				try {					
					s = conn.prepareStatement("UPDATE person SET address=? where id=?");
					s.setString(1, add);
					s.setInt(2, id);
					int i = s.executeUpdate();
					if(i>0){
						System.out.println("�޸ĳɹ�");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(n==6){
				break;
			}
		}
		DButil.closeAll(null, s, conn);
		
	}
	
	public void delete(){   //ɾ��ָ���û���Ϣ
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		
		TelNoteRegex t=new TelNoteRegex();
		Scanner in=new Scanner(System.in);
		
		System.out.println("�������¼��");
		int id=0;
		id=in.nextInt();
		

		try{
			conn=DButil.getConnection();
			String sql="delete FROM person where id=?";
			s=conn.prepareStatement(sql);
			
			s.setInt(1, id);
			int i=s.executeUpdate();
			
			if(i>0){
				System.out.println("ָ����ϵ����ɾ��");
			}
			
			/*String sql1="UPDATE person SET  id=id-1 WHERE id>?";
			s=conn.prepareStatement(sql1);
			s.setInt(1, id);
			i=s.executeUpdate();*/
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(null, s, conn);
		}
	}
	
	public void deleteAll(){   //ɾ�������û���Ϣ
		Connection conn=null;
		PreparedStatement s=null;
		//ResultSet rs=null;
		
		try{
			conn=DButil.getConnection();
			String sql="delete FROM person";
			s=conn.prepareStatement(sql);		
			int i=s.executeUpdate();
			
			if(i>0){
				System.out.println("��ϵ����ȫ�����");
			}						
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(null, s, conn);
		}
	}
	
	public void orderName(){   
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		try{
			conn=DButil.getConnection();
			String sql="SELECT *FROM person";
			s=conn.prepareStatement(sql);		
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		
		Collections.sort(v,new OrderByName());//����
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
		
		
	}
	
	public void orderAge(){   
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		try{
			conn=DButil.getConnection();
			String sql="SELECT *FROM person";
			s=conn.prepareStatement(sql);		
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		
		Collections.sort(v,new OrderByAge());//����
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
		
	}
	
	public void orderSex(){   
		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		
		try{
			conn=DButil.getConnection();
			String sql="SELECT *FROM person";
			s=conn.prepareStatement(sql);		
			rs=s.executeQuery();
			
			v=new Vector<Person>();
			while(rs.next()){
				Person p=new Person();	          	 
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setSex(rs.getString("Sex"));
				p.setTelNum(rs.getString("TelNum"));
				p.setAddress(rs.getString("address"));
				
				v.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DButil.closeAll(rs, s, conn);
		}
		System.out.print("���\t");
		System.out.print("����\t");
		System.out.print("����\t");
		System.out.print("�Ա�\t");		
		System.out.print("סַ\t");
		System.out.print("�绰����\t");
		System.out.println();
		
		Collections.sort(v,new OrderBySex());//����
		int i=1;
		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			
			Person p = (Person) iterator.next();			
			//System.out.print(p.getId()+"\t");
			System.out.print(i+"\t");
			System.out.print(p.getName()+"\t");
			System.out.print(p.getAge()+"\t");
			System.out.print(p.getSex()+"\t");		
			System.out.print(p.getAddress()+"\t");
			System.out.print(p.getTelNum()+"\t");
			System.out.println();
			i++;
		}
		
	}
	
}
