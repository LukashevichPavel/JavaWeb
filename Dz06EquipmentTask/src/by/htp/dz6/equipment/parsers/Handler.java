package by.htp.dz6.equipment.parsers;

import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.dz6.equipment.entity.Acsessories;
import by.htp.dz6.equipment.entity.Bike;
import by.htp.dz6.equipment.entity.Equipment;
import by.htp.dz6.equipment.entity.Skis;
import by.htp.dz6.equipment.entity.SnowBoard;

public class Handler extends DefaultHandler{
	private Map<Integer, Equipment> equipmentBase = new TreeMap<Integer, Equipment>();
	private Equipment equipment;
	private String str = "";
	
	public void startDocument() throws SAXException { 
		  System.out.println("Start parse XML..."); 
		} 
	
	public void endDocument() { 
		  System.out.println("Stop parse XML..."); 
		} 
	
	public void startElement(String uri, String localName, String qName, Attributes attr)	throws SAXException {
	
	switch (qName) {
		case "Bike": {
			equipment = new Bike();
		break;
		}
		case "Skis": {
			equipment = new Skis();
		break;
		}
		case "SnowBoard": {
			equipment = new SnowBoard();
		break;
		}
		case "Acsessories": {
			equipment = new Acsessories();
		break;
		}
	}
}

		
	public void characters(char[] ch, int start, int length) throws SAXException {
		str=new String(ch, start, length);
	}

		
		public void endElement(String uri, String localName, String qName) throws SAXException {

			switch (qName) {
			case "id": {
				equipment.setId(Integer.parseInt(str));
				break;
			}

			case "title": {
				equipment.setTitle(str);
				break;
			}

			case "category": {
				equipment.setCategory(str);
				break;
			}

			case "rentPrice": {
				equipment.setRentPrice(Double.valueOf(str));
				//System.out.println(Double.valueOf(str));
				break;
			}

			case "lostPrice": {
				equipment.setLostPrice(Double.valueOf(str));
				//System.out.println(Double.valueOf(str));
				break;
			}
			case "isAvialible":{
				equipment.setAvialible(Boolean.valueOf(str));
			}
			case "Equipment":{
				System.out.println("Считан элемент:");
				equipment.print();
			}
			default:{}
			}
			
		}

		
		public void warning(SAXParseException e) throws SAXException {
			PrintStream printStream = new PrintStream(System.err);
			printStream.println("WARNING: line" + e.getLineNumber() + " : " + e.getMessage());
		}

		
		public void error(SAXParseException e) throws SAXException {
			PrintStream printStream = new PrintStream(System.err);
			printStream.println("ERROR: line" + e.getLineNumber() + " : " + e.getMessage());
		}

		
		public void fatalError(SAXParseException e) throws SAXException {
			PrintStream printStream = new PrintStream(System.err);
			printStream.println("FATAL: line" + e.getLineNumber() + " : " + e.getMessage());
			throw (e);
		}	
	
}
