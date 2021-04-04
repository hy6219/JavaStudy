package ver2.controller;

import java.io.IOException;
import java.util.Scanner;

import ver2.model.dao.ManageDB;
import ver2.model.vo.User;

public class HealthController {
	protected ManageDB mDb = new ManageDB();
	protected static User user = null;
	//1.처음 진행할때, 꼭 필요한 입력정보 입력받기
	public void init() throws IOException
	{
		mDb.setInfo();
		user = ManageDB.curUser;
	}
	
	//2.프로그램을 사용할 것인지
	public void execute() throws IOException
	{
		String eOpt = "";
		System.out.print("프로그램을 지금 실행하시겠습니까?(실행하시겠다면 y, 아니시라면 n 을 눌러주세요):");
		eOpt = new Scanner(System.in).nextLine();
		
		if(eOpt.equalsIgnoreCase("y"))
		{
			mDb.makeAccess(user.getIsManager());
		}
		else if(eOpt.equalsIgnoreCase("n"))
		{
			System.out.println("다음에 뵙겠습니다!");
			System.exit(0);
		}
	}
}
