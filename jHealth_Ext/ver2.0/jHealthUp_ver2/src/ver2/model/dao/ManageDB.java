package ver2.model.dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ver2.model.vo.User;

public class ManageDB {
//	//����� ������ ���� arrayList
//	private ArrayList<User> aUser = new ArrayList<>();
	//����Ʈ ����ó�� �� ��ȯ�� ���� linkedList
	private LinkedList<String> lUser = new LinkedList<>();
	//����� ����
	public static User curUser ;
	private Scanner sc = new Scanner(System.in);
	
	//0. ȸ�� ���� �Է��ϱ�
	public void setInfo() throws IOException
	{
		String name = "";
		String no = "";
		int age = 0;
		double height = 0;
		double weight = 0;
		String managerOpt = "";
		int birthYr = 0;
		String tmpYr = "";
		Calendar cal = Calendar.getInstance();
		
		System.out.print("����� �̸�: ");
		name = sc.nextLine();
		System.out.print("�ֹε�Ϲ�ȣ(��:123456-7890123): ");
		no   = sc.nextLine();
		tmpYr=no.substring(0,2);
		birthYr = Integer.valueOf(tmpYr);
		//00~21�� 2000��� , 22~99 : 19xx���
		if(birthYr<=21)
		{
			birthYr = Integer.valueOf("20"+tmpYr);
		}
		else if(birthYr<=99)
		{
			birthYr = Integer.valueOf("19"+tmpYr);
		}
		
		
		age  = cal.get(Calendar.YEAR) - birthYr + 1;//����
		System.out.print("Ű(��:155): ");
		height = Double.valueOf(sc.nextLine());
		System.out.print("ü��(��:45): ");
		weight = Double.valueOf(sc.nextLine());
		System.out.print("������ ����(Ʈ���̳�: Y, ����: N): ");
		managerOpt = sc.nextLine();
		
		curUser = new User(name, no, age, height, weight,managerOpt);
		//ȸ�� �߰��ϱ�
		addUser(curUser);
	}
	//1.ȸ�� �˻�
	public boolean userExist(User user) throws IOException
	{
		//�����о���� ��ü
		BufferedReader fin = new BufferedReader(
				new FileReader(
				"UserDB.txt"));
		String val = null;
		while((val = fin.readLine())!=null)
		{
			if(val.equals(user.toString()))
			{
				fin.close();
				return true;
			}
		}
		fin.close();
		return false;
	}
	
	//1.ȸ�� �˻�(ȸ�� ������ string���� ��ȯ)
	public String userCheck(User user) throws IOException
	{
		boolean check = userExist(user);
		String val = null;
		if(check == true)
		{
			return user.toString();
		}
		return "ERR";
	}
	//2.ȸ�� �߰�, ����
	public void addUser(User user) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("UserDB.txt"));
		boolean checker = userExist(user);
		if(checker == true)
		{
			System.out.println("������ �����ϼ̽��ϴ�!");
			return;
		}
		else
		{
			bw.write(user.toString());
		}
		bw.close();
	}
	//3.ȸ�� Ż��
	public void withDrawal(User user) throws IOException
	{
		/*
		 * ���ϰ��� �о�ͼ� �� ������ ��ũ�帮��Ʈ�� �����ϰ�,
		 * �� ��Ҹ� ���� �� �ݿ�
		 */
		String line = "";
		String finder =user.toString();//ã���� �ϴ� �����
		BufferedReader br = new BufferedReader(new FileReader("UserDB.txt"));
		//�����
		BufferedWriter bw = new BufferedWriter(new FileWriter("UserDB.txt"));
		while((line = br.readLine())!=null)
		{
			lUser.add(line);
		}
		
		//�ε��� ã��
		int idx = lUser.indexOf(finder);
		//�ش� �ε��� ����
		lUser.remove(idx);
		bw.write(lUser.toString());
		br.close();
		bw.close();
	}
	//4. ���ϰ� ����
	public HashMap getSimpleDay()
	{
		//1����ġ ������ ���� ����(������ ���� ��)
		int idx = (Calendar.getInstance()).get(Calendar.DAY_OF_WEEK);
		String day = "";
		HashMap<Integer, String> days = new HashMap<>();	
		if(idx == 1)
		{
			day = "��";
		}
		else if(idx == 2)
		{
			day = "��";
		}
		else if(idx == 3)
		{
			day = "ȭ";
		}
		else if(idx == 4)
		{
			day = "��";	
		}
		else if(idx ==5)
		{
		    day ="��";
		}
		else if(idx == 6)
		{
			day ="��";
		}
		else
		{
			day ="��";
		}
		days.put(idx, day);
		return days;
	}
	//5.�Ĵ� �ۼ� ���
	public void recommendMeal() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("Meal.txt"));
		//����, Ʈ���̳ʿ� ���� 1:1�� �������ִ� ������ Ȯ���غ��Ƶ� ���� ��
		
		//���� ����
		HashMap<Integer, String> dInfo     = getSimpleDay();
		
		//���Ͽ� ���� �ε��� �޾ƿ���
		Set set = dInfo.entrySet();
		Iterator iter = set.iterator();
		int idx = 0;
		String day = "";
		String days[] = {"", "��","��","ȭ","��","��","��","��"};
		while(iter.hasNext())
		{
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)iter.next();
			
			idx = me.getKey();
			day = me.getValue();
		}
		
		//�ش� ����~���� �Ͽ��ϱ��� �Ĵ� �ۼ�
//		while(idx <= 7 || idx != 1)
//		{
//			System.out.print(days[idx]+ "���� �Ĵ��� �Է����ּ���: (�� : ��ħ- , ����- , ����- )");
//			bw.write(sc.nextLine());
//			if(idx != 1)
//			{
//				idx ++;
//			}
//			if(idx == 7)
//			{
//				idx = 1;
//			}
//		}
		int rotation = 0 ;
		int start = idx;
		while(rotation !=1)
		{
			if(start == 1)
			{
				//ù ������ �Ͽ����� ���
				rotation = 1;
			}
			if(idx == 2 && rotation == 1)
			{
				break;
			}
			System.out.print(days[idx]+ "���� �Ĵ� ���α׷��� �Է����ּ���: ");
			bw.write(sc.nextLine());
			if(idx != 1)
			{
				idx ++;
			}
			if(idx == 7)
			{
				idx = 1;
				rotation = 1;
			}
		}
		bw.close();
	}
	//6.�Ĵ����� Ȯ���ϱ�
	public void checkMeal() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Meal.txt"));
		BufferedWriter bw = null;
		//���� ���� ����
		System.out.print("Ʈ���̳ʷκ��� �̹��� �Ͽ��ϱ����� �Ĵ������� �����Ͽ����ϴ�. �����Ͻðڽ��ϱ�?(Y �Ǵ� N):");
		String saveOpt = sc.nextLine();
		
		if(saveOpt.equalsIgnoreCase("y"))
		{
			//����
			//���ϸ��� ��� �� �� Ȯ���ϱ�
			System.out.print("���ϸ��� �Է����ּ���:");
			String fileName = sc.nextLine().trim();
			
			bw = new BufferedWriter(new FileWriter(fileName+".txt"));
			String line = "";
			while((line = br.readLine())!=null)
			{
				bw.write(line);
			}
		}
		else
		{
			System.out.println("�������� �ʰڽ��ϴ�");
		}
		br.close();
		bw.close();
	}
	//7.� ���α׷� ó��
	public void recommendExercise() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("Exercise.txt"));
		//����, Ʈ���̳ʿ� ���� 1:1�� �������ִ� ������ Ȯ���غ��Ƶ� ���� ��
		
		//���� ����
		HashMap<Integer, String> dInfo     = getSimpleDay();
		
		//���Ͽ� ���� �ε��� �޾ƿ���
		Set set = dInfo.entrySet();
		Iterator iter = set.iterator();
		int idx = 0;
		String day = "";
		String days[] = {"", "��","��","ȭ","��","��","��","��"};
		while(iter.hasNext())
		{
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)iter.next();
			
			idx = me.getKey();
			day = me.getValue();
		}

		//�ش� ����~���� �Ͽ��ϱ��� � �ۼ�
		int rotation = 0 ;
		int start = idx;
		while (/* start != 1 && */rotation !=1)
		{
			if(start == 1)
			{
				//ù ������ �Ͽ����� ���
				rotation = 1;
			}
			if(idx == 2 && rotation == 1)
			{
				break;
			}
			System.out.print(days[idx]+ "���� � ���α׷��� �Է����ּ���: ");
			bw.write(sc.nextLine());
			if(idx != 1)
			{
				idx ++;
			}
			if(idx == 7)
			{
				idx = 1;
				rotation = 1;
			}
		}
		bw.close();
	}
	//8. � ���α׷� ���� �о����
	public void checkExercise() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Exercise.txt"));
		BufferedWriter bw = null;
		//���� ���� ����
		System.out.print("Ʈ���̳ʷκ��� �̹��� �Ͽ��ϱ����� � ���α׷� ������ �����Ͽ����ϴ�. "
				+ " �����Ͻðڽ��ϱ�?(Y �Ǵ� N):");
		String saveOpt = sc.nextLine();
		
		if(saveOpt.equalsIgnoreCase("y"))
		{
			//����
			//���ϸ��� ��� �� �� Ȯ���ϱ�
			System.out.print("���ϸ��� �Է����ּ���:");
			String fileName = sc.nextLine().trim();
			
			bw = new BufferedWriter(new FileWriter(fileName+".txt"));
			String line = "";
			while((line = br.readLine())!=null)
			{
				bw.write(line);
			}
		}
		else
		{
			System.out.println("�������� �ʰڽ��ϴ�");
		}
		br.close();
		bw.close();
	}
	//9.��� �ȳ�
	public void printMode(String isManager)
	{
		if(isManager.equalsIgnoreCase("y"))
		{
			System.out.println("1�� �Է��Ͻø�, �Ĵ��� �ۼ��Ͻ� �� �ֽ��ϴ�");
			System.out.println("2�� �Է��Ͻø�, ��� �ۼ��Ͻ� �� �ֽ��ϴ�");
		}
		else if(isManager.equalsIgnoreCase("n"))
		{
			System.out.println("1�� �Է��Ͻø�, �Ĵ��� Ȯ�� �� ���� �Ͻ� �� �ֽ��ϴ�");
			System.out.println("2�� �Է��Ͻø�, ��� Ȯ�� �� ���� �Ͻ� �� �ֽ��ϴ�");
		}
	}
	//10.�ɼǿ� ���� ���� ���� ����-Ʈ���̳�
	public void connectOptionForTrainer(int option) throws IOException
	{
		switch(option)
		{
		case 1:
			recommendMeal();
			break;
		case 2:
			recommendExercise();
			break;
		default:
			System.out.println("�߸��� �����Դϴ�.");
			break;
		}
	}
	//11.�ɼǿ� ���� ���� ���� ����-�� 
	public void connectOptionForClient(int option) throws IOException
	{
		switch(option)
		{
		case 1:
			checkMeal();
			break;
		case 2:
			checkExercise();
			break;
		default:
			System.out.println("�߸��� �����Դϴ�.");
			break;
		}
	}
	//12.������ ���ο� ���� ���� ��� ���ѵα� 
	public void makeAccess(String isManager) throws IOException
	{
		int opt = 0;
		if(isManager.equalsIgnoreCase("y"))
		{
			//Ʈ���̳��� ���
			System.out.println("Ʈ���̳� ��忡 �����ϼ̽��ϴ�.");
			/*
			 * 1: �Ĵ��ۼ� 2: ��ۼ� 
			 */
			System.out.print("===��� ���ú�Ź�帳�ϴ�. ���Ḧ ���ϽŴٸ� q �Ǵ� Q�� �Է����ּ���. �ƴϽö��,"
					+ " ������ ���Ͽ� �� ���� �ٸ� Ű�� �����ּ���===");
			while(!sc.nextLine().equalsIgnoreCase("q"))
			{
				printMode("y");
				System.out.print("��带 �Է����ּ���: ");
				opt = Integer.valueOf(sc.nextLine());
				connectOptionForTrainer(opt);
				System.out.print("===��� ���ú�Ź�帳�ϴ�. ���Ḧ ���ϽŴٸ� q �Ǵ� Q�� �Է����ּ���. �ƴϽö��,"
						+ " ������ ���Ͽ� �� ���� �ٸ� Ű�� �����ּ���===");
			}
		}
		else if(isManager.equalsIgnoreCase("n"))
		{
			//���� ���
			System.out.println("�̿���(����) ��忡 �����ϼ̽��ϴ�.");
			/*
			 * 1: �Ĵ�Ȯ��  2: �Ȯ�� 
			 */
			System.out.print("===��� ���ú�Ź�帳�ϴ�. ���Ḧ ���ϽŴٸ� q �Ǵ� Q�� �Է����ּ���. �ƴϽö��,"
					+ " ������ ���Ͽ� �� ���� �ٸ� Ű�� �����ּ���===");
			while(!sc.nextLine().equalsIgnoreCase("q"))
			{
				printMode("n");
				System.out.print("��带 �Է����ּ���: ");
				opt = Integer.valueOf(sc.nextLine());
				connectOptionForClient(opt);
				System.out.print("===��� ���ú�Ź�帳�ϴ�. ���Ḧ ���ϽŴٸ� q �Ǵ� Q�� �Է����ּ���. �ƴϽö��,"
						+ " ������ ���Ͽ� �� ���� �ٸ� Ű�� �����ּ���===");
			}
		}
	}
 }

