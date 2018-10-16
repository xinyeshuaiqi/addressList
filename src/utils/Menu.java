package utils;

public class Menu {
	public static void mainMenu(){
		System.out.println("************************");
		System.out.println("**       1 添加纪录              **");
		System.out.println("**       2 查找纪录              **");
		System.out.println("**       3 修改纪录              **");
		System.out.println("**       4 删除纪录              **");
		System.out.println("**       5 排序纪录              **");
		System.out.println("**       6 退出系统              **");
		System.out.println("************************");
	}
	
	public static void addMenu(){
		System.out.println("************************");
		System.out.println("**      1添加新纪录              **");
		System.out.println("**      2查看全纪录              **");
		System.out.println("**      3返回上一级              **");
		System.out.println("************************");
	}
	
	public static void searchMenu(){
		System.out.println("************************");
		System.out.println("**      1按姓名查找              **");
		System.out.println("**      2按年龄查找              **");
		System.out.println("**      3按性别查找              **");
		System.out.println("**      4按号码查找              **");
		System.out.println("**      5按住址查找              **");
		System.out.println("**      6查看全记录              **");
		System.out.println("**      7返回上一级             **");
		System.out.println("************************");
	}
	
	public static void modifyMenu(){
		System.out.println("************************");
		System.out.println("**      1修改指定记录          **");
		System.out.println("**      2查看全纪录              **");
		System.out.println("**      3返回上一级              **");
		System.out.println("************************");
	}
	
	public static void subModifyMenu(){
		System.out.println("************************");
		System.out.println("**      1修改姓名                **");
		System.out.println("**      2修改年龄                **");
		System.out.println("**      3修改性别                **");
		System.out.println("**      4修改号码                **");
		System.out.println("**      5修改住址                **");
		System.out.println("**      6返回上一级             **");
		System.out.println("************************");
	}
	
	public static void deleteMenu(){
		System.out.println("************************");
		System.out.println("**      1删除指定记录          **");
		System.out.println("**      2删除全记录              **");
		System.out.println("**      3查看全纪录              **");
		System.out.println("**      4返回上一级              **");
		System.out.println("************************");
	}
	
	public static void orderMenu(){
		System.out.println("************************");
		System.out.println("**      1按姓名排序              **");
		System.out.println("**      2按年龄排序              **");
		System.out.println("**      3按性别排序              **");
		System.out.println("**      4查看全记录              **");
		System.out.println("**      5返回上一级             **");
		System.out.println("************************");
	}
}
