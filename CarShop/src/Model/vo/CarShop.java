package Model.vo;

import java.util.ArrayList;

public class CarShop {
	private String UserName;
	private String UserSSN;
	private String USerPHONE;
	private String USERADDRESS;
	private String USEREMAIL;
	
	private String BRAND;
	private String MODEL;
	private String TYPE;
	private String GEARTYPE;
	private String COLOR;
	private int DOOR;
	private int CC;
	private int FUEL;
	private int PRICE;

	public CarShop() {
		// TODO Auto-generated constructor stub
	}
	
	public CarShop(String userName, String userSSN, String uSerPHONE, String uSERADDRESS, String uSEREMAIL,
			String bRAND, String mODEL, String tYPE, String gEARTYPE, String cOLOR, int dOOR, int cC, int fUEL,
			int pRICE) {
		super();
		this.UserName = userName;
		this.UserSSN = userSSN;
		this.USerPHONE = uSerPHONE;
		this.USERADDRESS = uSERADDRESS;
		this.USEREMAIL = uSEREMAIL;
		this.BRAND = bRAND;
		this.MODEL = mODEL;
		this.TYPE = tYPE;
		this.GEARTYPE = gEARTYPE;
		this.COLOR = cOLOR;
		this.DOOR = dOOR;
		this.CC = cC;
		this.FUEL = fUEL;
		this.PRICE = pRICE;
	}
	
	
	@Override
	public String toString() {
		return "CarShop [UserName=" + UserName + ", UserSSN=" + UserSSN + ", USerPHONE=" + USerPHONE + ", USERADDRESS="
				+ USERADDRESS + ", USEREMAIL=" + USEREMAIL + ", BRAND=" + BRAND + ", MODEL=" + MODEL + ", TYPE=" + TYPE
				+ ", GEARTYPE=" + GEARTYPE + ", COLOR=" + COLOR + ", DOOR=" + DOOR + ", CC=" + CC + ", FUEL=" + FUEL
				+ ", PRICE=" + PRICE + "]";
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserSSN() {
		return UserSSN;
	}
	public void setUserSSN(String userSSN) {
		UserSSN = userSSN;
	}
	public String getUSerPHONE() {
		return USerPHONE;
	}
	public void setUSerPHONE(String uSerPHONE) {
		USerPHONE = uSerPHONE;
	}
	public String getUSERADDRESS() {
		return USERADDRESS;
	}
	public void setUSERADDRESS(String uSERADDRESS) {
		USERADDRESS = uSERADDRESS;
	}
	public String getUSEREMAIL() {
		return USEREMAIL;
	}
	public void setUSEREMAIL(String uSEREMAIL) {
		USEREMAIL = uSEREMAIL;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}
	public String getMODEL() {
		return MODEL;
	}
	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getGEARTYPE() {
		return GEARTYPE;
	}
	public void setGEARTYPE(String gEARTYPE) {
		GEARTYPE = gEARTYPE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public int getDOOR() {
		return DOOR;
	}
	public void setDOOR(int dOOR) {
		DOOR = dOOR;
	}
	public int getCC() {
		return CC;
	}
	public void setCC(int cC) {
		CC = cC;
	}
	public int getFUEL() {
		return FUEL;
	}
	public void setFUEL(int fUEL) {
		FUEL = fUEL;
	}
	public int getPRICE() {
		return PRICE;
	}
	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}
	
	
	
}
