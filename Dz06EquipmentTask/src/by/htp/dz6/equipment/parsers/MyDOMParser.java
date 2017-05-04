package by.htp.dz6.equipment.parsers;

import by.htp.dz6.equipment.entity.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class MyDOMParser {

	public MyDOMParser() {
		super();
	}

	public Map<Integer, Equipment> parse() {
		Map<Integer, Equipment> equipmentBase = new TreeMap<Integer, Equipment>();
		try {
			File inputFile = new File("src\\RentStation.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("Equipment");
			System.out.println("----------------------------");
			
			Equipment equipment = null;
			int temp = 0;
			for (temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					String category = eElement.getElementsByTagName("category").item(0).getTextContent();
					String title = eElement.getElementsByTagName("title").item(0).getTextContent();
					String isAvialible = eElement.getElementsByTagName("isAvialible").item(0).getTextContent();
					String rentPrice = eElement.getElementsByTagName("rentPrice").item(0).getTextContent();
					String lostPrice = eElement.getElementsByTagName("lostPrice").item(0).getTextContent();
					switch (eElement.getElementsByTagName("category").item(0).getTextContent()) {
					case "Bike": {
						equipment = new Bike(Integer.parseInt(id), category, title,
								Boolean.getBoolean(isAvialible), Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						break;
					}
					case "SnowBoard": {
					 equipment = new SnowBoard(Integer.parseInt(id), category, title,
								Boolean.getBoolean(isAvialible), Double.valueOf(rentPrice), Double.valueOf(lostPrice));
					 break;
					}
					case "Skis": {
						 equipment = new Skis(Integer.parseInt(id), category, title,
								Boolean.getBoolean(isAvialible), Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						 break;
					}
					case "Acsessories": {
						 equipment = new Acsessories(Integer.parseInt(id), category, title,
								Boolean.getBoolean(isAvialible), Double.valueOf(rentPrice), Double.valueOf(lostPrice));
						 break;
						 }
					}
					equipment.print();
					equipmentBase.put(equipment.getId(), equipment);
				}
			}
			
			System.out.println();
			System.out.println("Всего найдено " + temp + " элементов:");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipmentBase;
	}
	
}
