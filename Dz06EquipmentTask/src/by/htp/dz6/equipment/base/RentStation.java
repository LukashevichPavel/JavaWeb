package by.htp.dz6.equipment.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import by.htp.dz6.equipment.entity.Acsessories;
import by.htp.dz6.equipment.entity.Bike;
import by.htp.dz6.equipment.entity.Client;
import by.htp.dz6.equipment.entity.Equipment;
import by.htp.dz6.equipment.entity.Skis;
import by.htp.dz6.equipment.entity.SnowBoard;
import by.htp.dz6.equipment.parsers.MyDOMParser;
import by.htp.dz6.equipment.parsers.MySAXParser;

public class RentStation {
	private Map<Integer, Equipment> equipmentBase = new TreeMap<Integer, Equipment>();
	private Map<Integer, Client> clientBase = new TreeMap<Integer, Client>();
	private Map<Integer, Equipment> rentUnit = new TreeMap<Integer, Equipment>();

	enum catList {
		Bike, Skiss, Snow, Acsessories
	};

	public void start() throws IOException {
		Client client;
		// ��������� ���� ��������
		client = new Client(0, "Ivanov", "Ivan", "MP111111", "Burdeynogo 1-15", "3101010");
		clientBase.put(client.getId(), client);
		client = new Client(1, "Petrov", "Petr", "MP222222", "Burdeynogo 2-30", "3202020");
		clientBase.put(client.getId(), client);
		client = new Client(2, "Sidorov", "Sidor", "MP333333", "Burdeynogo 3-45", "5303030");
		clientBase.put(client.getId(), client);
		client = new Client(3, "Putin", "Vladimir", "TopSecret", "Kreml", "SecretNumber");
		clientBase.put(client.getId(), client);
		client = new Client(4, "Batka", "Sashok", "��� ���� �������?", "Drozdi", "������� �� ���?");
		clientBase.put(client.getId(), client);
		// ������� ���� ��������
		// printClientBase();

		// ��������� ���� ����������
		Equipment equipment;
		equipment = new Bike(0, "Bike", "Aist", true, 25.15, 150);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new Bike(1, "Bike", "Stells", true, 27.15, 250);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new Bike(2, "Bike", "Fuji", true, 28.10, 195);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new SnowBoard(3, "SnowBoard", "Flow", true, 22.15, 75.35);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new SnowBoard(4, "SnowBoard", "Capita", true, 18.2, 68.78);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new SnowBoard(5, "SnowBoard", "Alyaska", true, 19.34, 64.17);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new Skis(6, "Skis", "Fischer", true, 15.1, 50.05);
		equipmentBase.put(equipment.getId(), equipment);
		equipment = new Skis(7, "Skis", "RC4", true, 19.8, 70.85);
		equipmentBase.put(equipment.getId(), equipment);
		Equipment acsessories;
		acsessories = new Acsessories(8,"Bike","Helmet",true,25.7,45.8);
		equipmentBase.put(acsessories.getId(),acsessories); 
		acsessories = new Acsessories(9,"Skis","Helmet",true,18.2,42.9);
		equipmentBase.put(acsessories.getId(),acsessories); 
		acsessories = new Acsessories(10,"SnowBoard","Glass",true,19.1,35.2);
		equipmentBase.put(acsessories.getId(),acsessories); 
		// ������� ���� ������������
		// printEquipmentBase();
		//MyDOMParser domParser = new MyDOMParser();
		//equipmentBase=domParser.parse();
		//printEquipmentBase();
		MySAXParser saxParser = new MySAXParser();
		//equipmentBase=
		saxParser.parse();
		// getRandomBaseEquipment(); //

		// printAllEquipment();
		// takeToRent();
		// inRentBase.printInRentBase();
		// String filename = "C:\\Workspace\\equipment_list.txt";
		// saveToFile(filename);
	}

	public void mainMenu() throws IOException {
		String option = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!option.equals("stop")) {
			System.out.println(
					"������� ����: 1.���� ������������ 2.���� �������� 3.���� ������������� ������������ 4.���������� 5.������� 6.��������� 7.��������� 8.�����");
			try {
				option = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * try {option=""+Integer.parseInt(option);} catch
			 * (NumberFormatException e) {
			 * System.out.println("������������ ������"); }
			 */
			switch (option) {
			case "1": {
				printEquipmentBase();
				break;
			}
			case "2": {
				printClientBase();
				break;
			}

			case "3": {
				printRentBase();
				break;
			}

			case "4": {
				rentMenu();
				break;
			}
			case "5": {
				Client currentClient;
				printClientBase();
				System.out.println("������� ID �������: ");
				option = reader.readLine();
				if (getClientBase().containsKey(Integer.parseInt(option))) {
					currentClient = getClientBase().get(Integer.parseInt(option));
					System.out.println("������� ID ������������, ������� ������ �������: ");
					option = reader.readLine();
					if (currentClient.getTakeEquipment().containsKey(Integer.parseInt(option))) {
						currentClient.getTakeEquipment().remove(Integer.parseInt(option));
						getEquipmentBase().get(Integer.parseInt(option)).setAvialible(true);
						getRentUnit().remove(Integer.parseInt(option),
								getEquipmentBase().get(Integer.parseInt(option)));
						System.out.println("�������");
					} else {
						System.out.println("��� ������ ������������");
					}
				}
				break;
			}

			case "6": {
				saveMenu();
				break;
			}

			case "7": {
				loadMenu();
				break;
			}

			case "8": {
				option = "stop";
				System.out.println("��������� ���������");
				break;
			}
			default: {
				System.out.println("������� �� ���������� ������");
			}
			}
		}
	}

	public void rentMenu() throws IOException {
		String option = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!option.equals("stop")) {
			System.out.println(
					"����������: 1.������ ������ ������� 2.������� ������� �� ���� 3.�������� ������������ 4.�������� ��������� 7.������� � ������� ����");
			option = reader.readLine();
			switch (option) {
			case "1": {
				Client newClient = newClient();
				getClientBase().put(newClient.getId(), newClient);
				System.out.println("����� ������ ������� ��������");
				takeToRent(newClient.getId());
				break;
			}
			case "2": {
				printClientBase();
				System.out.println("������� ID �������: ");
				option = reader.readLine();
				if (getClientBase().containsKey(Integer.parseInt(option))) {
					takeToRent(Integer.parseInt(option));

				}

				break;
			}
			case "3": {
				printEquipmentBase(true);
				break;
			}

			case "4": {
				System.out.println("������� �������� ����������");
				break;
			}

			case "7": {
				option = "stop";
				System.out.println("������� � ������� ����");
				break;
			}
			default: {
				System.out.println("������� �� ���������� ������");
			}
			}

		}
	}

	public void saveMenu() throws IOException {
		String option = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!option.equals("stop")) {
			System.out.println(
					"���������: 1.���� ������������ 2.���� �������� 3.���� ����������� 4.���� ������������� ������������ 7.������� � ������� ����");
			option = reader.readLine();
			switch (option) {
			case "1": {
				Writer out;
				try {
					//������� ����� ����������� ��� � �����
					//file = new FileOutputStream("outfilename"), "UTF8"); //��������� �������� ����� � ������
					//stream = new OutputStreamWriter(file); //����������� �������� ����� ��� ������ � ����� Writer
					//out = new BufferedWriter(stream); //������� ����� ��� ������
					
					//���� �������� ��� � ���� ������ �� ���������:
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("equipmentBase.txt"), "UTF8"));
					if (getEquipmentBase().size() > 0) {
						for (Map.Entry<Integer, Equipment> e : equipmentBase.entrySet()) {
							out.write(e.getValue().toString()+"\n");
						}
					} else
						System.out.println("� ���� ��� �� ����� ������");
					out.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				System.out.println("��������� � equipmentBase.txt");
				break;
			}
			case "2": {
				
				Writer out;
				try {
					out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("clientBase.txt"), "UTF8"));
					if (getClientBase().size() > 0) {
						for (Map.Entry<Integer, Client> e : clientBase.entrySet()) {
							out.write(e.getValue().toString()+"\n");
						}
					} else
						System.out.println("� ���� ��� �� ����� ������");
					out.close();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				
				
				System.out.println("��������� � clientBase.txt");
				break;
			}
			case "3": {
				System.out.println("��������� � acsessoriesBase.txt");
				break;
			}
			case "4": {
				System.out.println("��������� � rentBase.txt");
				break;
			}
			case "7": {
				option = "stop";
				System.out.println("������� � ������� ����");
				break;
			}
			default:{System.out.println("������� ������������ ������");}
			}
		}
	}

	public void loadMenu() {
		
		
		
		
	}

	public void printClientBase() {
		if (getClientBase().size() > 0) {
			for (Map.Entry<Integer, Client> e : clientBase.entrySet()) {
				e.getValue().print();
			}
		} else
			System.out.println("� ���� ��� �� ����� ������");
	}

	public void printEquipmentBase() {
		if (getEquipmentBase().size() > 0) {
			for (Map.Entry<Integer, Equipment> e : equipmentBase.entrySet()) {
				e.getValue().print();
			}
		} else
			System.out.println("� ���� ��� �� ����� ������");
	}

	public void printEquipmentBase(boolean option) {
		if (getEquipmentBase().size() > 0) {
			for (Map.Entry<Integer, Equipment> e : equipmentBase.entrySet()) {
				if (e.getValue().isAvialible())
					e.getValue().print();
			}
		} else
			System.out.println("� ���� ��� �� ����� ������");
	}

	public void printRentBase() {
		if (getRentUnit().size() > 0) {
			for (Map.Entry<Integer, Equipment> e : rentUnit.entrySet()) {
				e.getValue().print();
			}
		} else
			System.out.println("� ���� ��� �� ����� ������");
	}

	public void takeToRent(int id) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String key;
		Client currentClient = getClientBase().get(id);
		System.out.println("������:");
		currentClient.print();
		if (currentClient.getTakeEquipment().size() < 3) {
			printEquipmentBase();
			System.out.println("������� ID ������������ ������� ������ ����� � ������: ");
			key = reader.readLine();
			System.out.println(getEquipmentBase().containsKey(Integer.parseInt(key)));
			System.out.println(getEquipmentBase().get(Integer.parseInt(key)).isAvialible());
			if (getEquipmentBase().containsKey(Integer.parseInt(key))
					&& getEquipmentBase().get(Integer.parseInt(key)).isAvialible()) {
				getEquipmentBase().get(Integer.parseInt(key)).setAvialible(false);
				getRentUnit().put(Integer.parseInt(key), getEquipmentBase().get(Integer.parseInt(key)));
				currentClient.getTakeEquipment().put(getRentUnit().get(Integer.parseInt(key)).getId(),
						getEquipmentBase().get(Integer.parseInt(key)));
				System.out.println("�������");
			} else {
				System.out.println("��� ������ ������������, ��� ��� ��������� � ������");
			}
		} else {
			System.out.println("�� ��� ����� 3 ������� ������������");
		}
		// client.setTakeEquipment(takeEquipment = new TreeMap<Integer,
		// Equipment>());
	}

	public Client newClient() throws IOException {
		Client newClient = new Client();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("������� �������: ");
		newClient.setFirstname(reader.readLine());
		
		System.out.print("������� ���: ");
		newClient.setLastname(reader.readLine());
		
		System.out.print("������� ����� ���������: ");
		newClient.setPassport(reader.readLine());
		
		System.out.print("������� �����: ");
		newClient.setAdress(reader.readLine());
		
		System.out.print("������� ����� ��������: ");
		newClient.setTelNumber(reader.readLine());
		
		newClient.setTakeEquipment(null);
		newClient.setTakeAcsessories(null);
		boolean check=true;
		while (check){
			newClient.setId((int) Math.random() * 100);
			if (clientBase.containsKey(newClient.getId())){
				
				check=false;
				break;
			}
			else {newClient.setId((int) Math.random() * 100);}
		}
		
		reader.close();
		return newClient;
	}

	/*
	 * public void saveToFile(String filename) { try (FileOutputStream fos = new
	 * FileOutputStream(filename)) { for (int i = 0; i < base.length; i++) {
	 * String text = this.base[i].toString(); text += "\n"; //
	 * System.out.println(text); // ������� ������ � ����� byte[] buffer =
	 * text.getBytes();
	 * 
	 * fos.write(buffer, 0, buffer.length);
	 * 
	 * } } catch (IOException ex) {
	 * 
	 * System.out.println(ex.getMessage()); } catch (NullPointerException e) {
	 * System.out.println(e.getMessage()); }
	 * 
	 * 
	 * }
	 */

	public Map<Integer, Equipment> getEquipmentBase() {
		return equipmentBase;
	}

	public void setEquipmentBase(Map<Integer, Equipment> equipmentBase) {
		this.equipmentBase = equipmentBase;
	}

	public Map<Integer, Client> getClientBase() {
		return clientBase;
	}

	public void setClientBase(Map<Integer, Client> clientBase) {
		this.clientBase = clientBase;
	}

	public Map<Integer, Equipment> getRentUnit() {
		return rentUnit;
	}

	public void setRentUnit(Map<Integer, Equipment> rentUnit) {
		this.rentUnit = rentUnit;
	}
}
