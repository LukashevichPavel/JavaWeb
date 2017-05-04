package by.htp.dz6.equipment.base;

import by.htp.dz6.equipment.entity.Equipment;

public class RentUnit {
	private Equipment[] inRentBase;

	public RentUnit() {
		inRentBase = new Equipment[10];
	}

	/*
	 * public void add(Equipment equipment){ //Equipment[] temp = new
	 * Equipment[this.unit.length+1];
	 * 
	 * for (int i=0; i<this.inRent.length; i++) { if (this.inRent[i]==null)
	 * this.inRent[i]=equipment; break; }
	 * 
	 * }
	 */

	public int getSizeRentBase() {
		int sizeBase = 0;
		for (int i = 0; i < inRentBase.length; i++) {
			if (inRentBase[i] != null)
				sizeBase++;
		}
		return sizeBase;
	}

	public void printInRentBase() {
		for (int i = 0; i < getSizeRentBase(); i++) {
			inRentBase[i].print();
		}
	}

}
