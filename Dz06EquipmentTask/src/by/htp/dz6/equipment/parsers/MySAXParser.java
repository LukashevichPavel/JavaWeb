package by.htp.dz6.equipment.parsers;

import by.htp.dz6.equipment.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MySAXParser {
	
	
	public MySAXParser() {
		super();
	}
	
	public void parse() {
		//Map<Integer, Equipment>
		SAXParserFactory parserF = SAXParserFactory.newInstance(); 
		SAXParser saxparser = null;
		try {
			saxparser = parserF.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Handler handler = new Handler();
		try {
			saxparser.parse(new File("src//RentStation.xml"), handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	//	return equipmentBase;
	}

	
	
		
}

