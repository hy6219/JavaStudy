package ver2.controller;

import java.io.IOException;
import java.util.Scanner;

import ver2.model.dao.ManageDB;
import ver2.model.vo.User;

public class HealthController {
	protected ManageDB mDb = new ManageDB();
	protected static User user = null;
	//1.ó�� �����Ҷ�, �� �ʿ��� �Է����� �Է¹ޱ�
	public void init() throws IOException
	{
		mDb.setInfo();
		user = ManageDB.curUser;
	}
	
	//2.���α׷��� ����� ������
	public void execute() throws IOException
	{
		String eOpt = "";
		System.out.print("���α׷��� ���� �����Ͻðڽ��ϱ�?(�����Ͻðڴٸ� y, �ƴϽö�� n �� �����ּ���):");
		eOpt = new Scanner(System.in).nextLine();
		
		if(eOpt.equalsIgnoreCase("y"))
		{
			mDb.makeAccess(user.getIsManager());
		}
		else if(eOpt.equalsIgnoreCase("n"))
		{
			System.out.println("������ �˰ڽ��ϴ�!");
			System.exit(0);
		}
	}
}
