package by.htp.dz6.equipment.entity;

//import java.io.FileOutputStream;
//import java.io.IOException;
import java.text.SimpleDateFormat;

public abstract class Equipment {
	private int id;
	private String category;
	private String title;
	private boolean isAvialible;
	private double rentPrice;
	private double lostPrice;
	private SimpleDateFormat date;
	private SimpleDateFormat timeForRent;

	public Equipment() {
		super();
	}

	public Equipment(int id, String cat, String title, boolean isAvlble, double rentPrice, double lostPrice) {
		this.setId(id);
		this.setCategory(cat);
		this.setTitle(title);
		this.setAvialible(isAvlble);
		this.setRentPrice(rentPrice);
		this.setLostPrice(lostPrice);
	}
	
	public abstract void print();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimpleDateFormat getDate() {
		return date;
	}

	public void setDate(SimpleDateFormat date) {
		this.date = date;
	}

	public SimpleDateFormat getTimeForRent() {
		return timeForRent;
	}

	public void setTimeForRent(SimpleDateFormat timeForRent) {
		this.timeForRent = timeForRent;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public double getLostPrice() {
		return lostPrice;
	}

	public void setLostPrice(double lostPrice) {
		this.lostPrice = lostPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvialible() {
		return isAvialible;
	}

	public void setAvialible(boolean isAvialible) {
		this.isAvialible = isAvialible;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "id=" + id + "[category=" + category + ", title=" + title + ", isAvialible=" + isAvialible
				+ ", rentPrice=" + rentPrice + ", lostPrice=" + lostPrice+"]"; //+ ", date=" + date + ", timeForRent="
				//+ timeForRent + "]";
	}

	public int compareTo(String arg0) {
		return category.compareTo(arg0);
	}

}
