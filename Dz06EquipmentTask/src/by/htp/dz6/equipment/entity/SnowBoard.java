package by.htp.dz6.equipment.entity;



public class SnowBoard extends Equipment {
//	private final String[] catListSnowBoard = { "Flow", "Capita", "Alaska" };
//	private final String[] acsListSnowBoard = { "SnowBoard Helmet", "SnowBoard Bag", "SnowBoard skirt" };

	public SnowBoard() {
		super();
	}

	public SnowBoard(int id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
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

}
