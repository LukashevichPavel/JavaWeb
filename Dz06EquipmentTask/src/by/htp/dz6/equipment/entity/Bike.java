package by.htp.dz6.equipment.entity;

//import java.math.BigDecimal;
//import java.math.RoundingMode;

public class Bike extends Equipment {
//	private String [] nameListBike = {"Stels", "Fuji", "Stark", "LTD", "Aist"};
//	private String [] acsListBike = {"Helmet", "Spidometr", "Light", "BackPack"};

	public Bike() {
		super();
	}

	public Bike(int id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
		//public Equipment(int id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
		super.setId(id);
		super.setCategory(cat);
		super.setTitle(title);
		super.setAvialible(isAvlble);
		super.setRentPrice(rentPrice);
		super.setLostPrice(lostPrice);
	}

	public void print() {
		String infoEquipment="";
		infoEquipment="[id:"+getId()+"]"+getCategory()+", "+getTitle() +", ";
		if (!isAvialible())	infoEquipment+="Арендовано";	
		else  infoEquipment+="Доступно";
		infoEquipment+=", цена аренды: "+getRentPrice()+", цена порчи/потери: "+getLostPrice();
		System.out.println(infoEquipment);
	}

	
	
	/*public Bike random() {
		Bike randomBike=null;
		System.out.println(nameListBike.values());
		double rentPrice = new BigDecimal(15 + Math.random() * 25).setScale(2, RoundingMode.UP).doubleValue();
		double lostPrice = new BigDecimal(50 + Math.random() * 100).setScale(2, RoundingMode.UP).doubleValue();
		//Bike newBike = new Bike((int)Math.random() * 100),"Bike", tempName, tempAcs, true, tempRentPrice, tempLostPrice);
		return randomBike;
	}*/

}
