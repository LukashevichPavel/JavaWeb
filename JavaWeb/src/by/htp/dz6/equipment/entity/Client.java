package by.htp.dz6.equipment.entity;

import java.util.Map;
import java.util.TreeMap;

public class Client {
	private int id;
	private String firstname;
	private String lastname;
	private String passport;
	private String adress;
	private String telNumber;
	private Map<Integer, Equipment> takeEquipment;
	private Map<Integer, Acsessories> takeAcsessories;
	

	public Client() {
		super();
	}

	public Client(int id, String firstname, String lastname, String passport, String adress, String telNumber) {
		this.setId(id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPassport(passport);
		this.setAdress(adress);
		this.setTelNumber(telNumber);
		this.takeEquipment = new TreeMap<Integer,Equipment>();
		this.takeAcsessories = new TreeMap<Integer,Acsessories>();
	}

	public void print(){
		String infoClient="";
		infoClient="[Client:"+getId()+"]: "+getFirstname()+", "+getLastname()+", "+getPassport()+", "+getAdress()+", "+getTelNumber();
		System.out.println(infoClient);
		if (getTakeEquipment().size()>0){
			System.out.println("Арендованное оборудование:");
			for(Map.Entry<Integer,Equipment> e : getTakeEquipment().entrySet()){ 
			    e.getValue().print();
			}
		}
		else {System.out.println("Пока нет арендованного оборудования");}
		
		if (getTakeAcsessories().size()>0){
			System.out.println("Арендованные аксессуары:");
			for(Map.Entry<Integer,Acsessories> e : getTakeAcsessories().entrySet()){ 
			    e.getValue().print();
			}
		}
		else {System.out.println("Пока нет арендованных аксессуаров");}
	}
	
	public void setTakeEquipment(Map<Integer, Equipment> takeEquipment) {
		this.takeEquipment = takeEquipment;
	}

	public void setTakeAcsessories(Map<Integer, Acsessories> takeAcsessories) {
		this.takeAcsessories = takeAcsessories;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Map<Integer, Equipment> getTakeEquipment() {
		return takeEquipment;
	}

	public Map<Integer, Acsessories> getTakeAcsessories() {
		return takeAcsessories;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassport() {
		return passport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "id=" + id + "[firstname=" + firstname + ", lastname=" + lastname + ", passport=" + passport
				+ ", adress=" + adress + ", telNumber=" + telNumber + ", takeEquipment=" + takeEquipment.toString()
				+ ", takeAcsessories=" + takeAcsessories.toString() + "]";
	}


}
