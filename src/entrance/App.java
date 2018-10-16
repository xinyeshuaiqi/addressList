package entrance;

import java.util.Scanner;

import utils.Menu;
import utils.Operate;
import utils.TelNoteRegex;

public class App {

	public static void main(String[] args) {
		System.out.println("欢迎使用通讯录");
		
		TelNoteRegex t=new TelNoteRegex();
		Operate op=new Operate();
		
		Scanner in=new Scanner(System.in);
		
		while(true){
			Menu.mainMenu();
			
			int n=0;
			n=in.nextInt();
			
			while(!t.menuRegex(n, 1, 6)){
				Menu.mainMenu();
				System.out.println("请输入正确数字，最小是1，最大是6");
				n=in.nextInt();
			}
			
			switch(n){
			case 1:
				op.addLogic();
				break;
			case 2:
				op.searchLogic();
				break;
			case 3:
				op.modifyLogic();
				break;
			case 4:
				op.deleteLogic();
				break;
			case 5:
				op.orderLogic();
				break;
			case 6:
				break;
			}
			if(n==6){
				break;   //退出App
			}
		
		}
		
		
	}

}
