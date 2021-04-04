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
//	//사용자 정보를 담을 arrayList
//	private ArrayList<User> aUser = new ArrayList<>();
	//리스트 연산처리 시 변환에 사용될 linkedList
	private LinkedList<String> lUser = new LinkedList<>();
	//사용자 정보
	public static User curUser ;
	private Scanner sc = new Scanner(System.in);
	
	//0. 회원 정보 입력하기
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
		
		System.out.print("사용자 이름: ");
		name = sc.nextLine();
		System.out.print("주민등록번호(예:123456-7890123): ");
		no   = sc.nextLine();
		tmpYr=no.substring(0,2);
		birthYr = Integer.valueOf(tmpYr);
		//00~21은 2000년대 , 22~99 : 19xx년대
		if(birthYr<=21)
		{
			birthYr = Integer.valueOf("20"+tmpYr);
		}
		else if(birthYr<=99)
		{
			birthYr = Integer.valueOf("19"+tmpYr);
		}
		
		
		age  = cal.get(Calendar.YEAR) - birthYr + 1;//나이
		System.out.print("키(예:155): ");
		height = Double.valueOf(sc.nextLine());
		System.out.print("체중(예:45): ");
		weight = Double.valueOf(sc.nextLine());
		System.out.print("관리자 여부(트레이너: Y, 고객님: N): ");
		managerOpt = sc.nextLine();
		
		curUser = new User(name, no, age, height, weight,managerOpt);
		//회원 추가하기
		addUser(curUser);
	}
	//1.회원 검색
	public boolean userExist(User user) throws IOException
	{
		//파일읽어오는 객체
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
	
	//1.회원 검색(회원 정보를 string으로 반환)
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
	//2.회원 추가, 저장
	public void addUser(User user) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("UserDB.txt"));
		boolean checker = userExist(user);
		if(checker == true)
		{
			System.out.println("기존에 가입하셨습니다!");
			return;
		}
		else
		{
			bw.write(user.toString());
		}
		bw.close();
	}
	//3.회원 탈퇴
	public void withDrawal(User user) throws IOException
	{
		/*
		 * 파일값을 읽어와서 그 값들을 링크드리스트에 저장하고,
		 * 그 요소를 제거 후 반영
		 */
		String line = "";
		String finder =user.toString();//찾고자 하는 사용자
		BufferedReader br = new BufferedReader(new FileReader("UserDB.txt"));
		//덮어쓰기
		BufferedWriter bw = new BufferedWriter(new FileWriter("UserDB.txt"));
		while((line = br.readLine())!=null)
		{
			lUser.add(line);
		}
		
		//인덱스 찾기
		int idx = lUser.indexOf(finder);
		//해당 인덱스 제거
		lUser.remove(idx);
		bw.write(lUser.toString());
		br.close();
		bw.close();
	}
	//4. 요일값 관리
	public HashMap getSimpleDay()
	{
		//1주일치 저장을 위한 변수(시작일 기준 주)
		int idx = (Calendar.getInstance()).get(Calendar.DAY_OF_WEEK);
		String day = "";
		HashMap<Integer, String> days = new HashMap<>();	
		if(idx == 1)
		{
			day = "일";
		}
		else if(idx == 2)
		{
			day = "월";
		}
		else if(idx == 3)
		{
			day = "화";
		}
		else if(idx == 4)
		{
			day = "수";	
		}
		else if(idx ==5)
		{
		    day ="목";
		}
		else if(idx == 6)
		{
			day ="금";
		}
		else
		{
			day ="토";
		}
		days.put(idx, day);
		return days;
	}
	//5.식단 작성 기능
	public void recommendMeal() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("Meal.txt"));
		//추후, 트레이너와 고객을 1:1로 연결해주는 것으로 확장해보아도 좋을 것
		
		//요일 정보
		HashMap<Integer, String> dInfo     = getSimpleDay();
		
		//요일에 대한 인덱스 받아오기
		Set set = dInfo.entrySet();
		Iterator iter = set.iterator();
		int idx = 0;
		String day = "";
		String days[] = {"", "일","월","화","수","목","금","토"};
		while(iter.hasNext())
		{
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)iter.next();
			
			idx = me.getKey();
			day = me.getValue();
		}
		
		//해당 요일~그주 일요일까지 식단 작성
//		while(idx <= 7 || idx != 1)
//		{
//			System.out.print(days[idx]+ "요일 식단을 입력해주세요: (예 : 아침- , 점심- , 저녁- )");
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
				//첫 시작이 일요일인 경우
				rotation = 1;
			}
			if(idx == 2 && rotation == 1)
			{
				break;
			}
			System.out.print(days[idx]+ "요일 식단 프로그램을 입력해주세요: ");
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
	//6.식단파일 확인하기
	public void checkMeal() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Meal.txt"));
		BufferedWriter bw = null;
		//저장 여부 묻기
		System.out.print("트레이너로부터 이번주 일요일까지의 식단파일이 도착하였습니다. 저장하시겠습니까?(Y 또는 N):");
		String saveOpt = sc.nextLine();
		
		if(saveOpt.equalsIgnoreCase("y"))
		{
			//저장
			//파일명은 어떻게 할 지 확인하기
			System.out.print("파일명을 입력해주세요:");
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
			System.out.println("저장하지 않겠습니다");
		}
		br.close();
		bw.close();
	}
	//7.운동 프로그램 처방
	public void recommendExercise() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("Exercise.txt"));
		//추후, 트레이너와 고객을 1:1로 연결해주는 것으로 확장해보아도 좋을 것
		
		//요일 정보
		HashMap<Integer, String> dInfo     = getSimpleDay();
		
		//요일에 대한 인덱스 받아오기
		Set set = dInfo.entrySet();
		Iterator iter = set.iterator();
		int idx = 0;
		String day = "";
		String days[] = {"", "일","월","화","수","목","금","토"};
		while(iter.hasNext())
		{
			Map.Entry<Integer, String> me = (Map.Entry<Integer, String>)iter.next();
			
			idx = me.getKey();
			day = me.getValue();
		}

		//해당 요일~그주 일요일까지 운동 작성
		int rotation = 0 ;
		int start = idx;
		while (/* start != 1 && */rotation !=1)
		{
			if(start == 1)
			{
				//첫 시작이 일요일인 경우
				rotation = 1;
			}
			if(idx == 2 && rotation == 1)
			{
				break;
			}
			System.out.print(days[idx]+ "요일 운동 프로그램을 입력해주세요: ");
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
	//8. 운동 프로그램 파일 읽어오기
	public void checkExercise() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Exercise.txt"));
		BufferedWriter bw = null;
		//저장 여부 묻기
		System.out.print("트레이너로부터 이번주 일요일까지의 운동 프로그램 파일이 도착하였습니다. "
				+ " 저장하시겠습니까?(Y 또는 N):");
		String saveOpt = sc.nextLine();
		
		if(saveOpt.equalsIgnoreCase("y"))
		{
			//저장
			//파일명은 어떻게 할 지 확인하기
			System.out.print("파일명을 입력해주세요:");
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
			System.out.println("저장하지 않겠습니다");
		}
		br.close();
		bw.close();
	}
	//9.모드 안내
	public void printMode(String isManager)
	{
		if(isManager.equalsIgnoreCase("y"))
		{
			System.out.println("1을 입력하시면, 식단을 작성하실 수 있습니다");
			System.out.println("2를 입력하시면, 운동을 작성하실 수 있습니다");
		}
		else if(isManager.equalsIgnoreCase("n"))
		{
			System.out.println("1을 입력하시면, 식단을 확인 및 저장 하실 수 있습니다");
			System.out.println("2를 입력하시면, 운동을 확인 및 저장 하실 수 있습니다");
		}
	}
	//10.옵션에 따른 동작 여부 연결-트레이너
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
			System.out.println("잘못된 접근입니다.");
			break;
		}
	}
	//11.옵션에 따른 동작 여부 연결-고객 
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
			System.out.println("잘못된 접근입니다.");
			break;
		}
	}
	//12.관리자 여부에 따른 접근 기능 제한두기 
	public void makeAccess(String isManager) throws IOException
	{
		int opt = 0;
		if(isManager.equalsIgnoreCase("y"))
		{
			//트레이너인 경우
			System.out.println("트레이너 모드에 진입하셨습니다.");
			/*
			 * 1: 식단작성 2: 운동작성 
			 */
			System.out.print("===모드 선택부탁드립니다. 종료를 원하신다면 q 또는 Q를 입력해주세요. 아니시라면,"
					+ " 진입을 위하여 그 외의 다른 키를 눌러주세요===");
			while(!sc.nextLine().equalsIgnoreCase("q"))
			{
				printMode("y");
				System.out.print("모드를 입력해주세요: ");
				opt = Integer.valueOf(sc.nextLine());
				connectOptionForTrainer(opt);
				System.out.print("===모드 선택부탁드립니다. 종료를 원하신다면 q 또는 Q를 입력해주세요. 아니시라면,"
						+ " 진입을 위하여 그 외의 다른 키를 눌러주세요===");
			}
		}
		else if(isManager.equalsIgnoreCase("n"))
		{
			//고객인 경우
			System.out.println("이용자(고객님) 모드에 진입하셨습니다.");
			/*
			 * 1: 식단확인  2: 운동확인 
			 */
			System.out.print("===모드 선택부탁드립니다. 종료를 원하신다면 q 또는 Q를 입력해주세요. 아니시라면,"
					+ " 진입을 위하여 그 외의 다른 키를 눌러주세요===");
			while(!sc.nextLine().equalsIgnoreCase("q"))
			{
				printMode("n");
				System.out.print("모드를 입력해주세요: ");
				opt = Integer.valueOf(sc.nextLine());
				connectOptionForClient(opt);
				System.out.print("===모드 선택부탁드립니다. 종료를 원하신다면 q 또는 Q를 입력해주세요. 아니시라면,"
						+ " 진입을 위하여 그 외의 다른 키를 눌러주세요===");
			}
		}
	}
 }

