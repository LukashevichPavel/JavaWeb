package by.htp.dz6.equipment.base;

import by.htp.dz6.equipment.entity.Client;

public class ClientBase {
Client clientBase[];

public ClientBase(){//konstructor
clientBase = new Client[10];	
}

public void addClient(Client client){//metod kot. dobavlyaet novogo clienta
	for (int i=0;i<getSizeBase();i++){
		if (getClient(i)==null){this.clientBase[i]=client; break;}
	}
}
public void printClientBase(){
	for (int i=0;i<getSizeBase();i++){
		if (this.clientBase[i]!=null) System.out.println(this.clientBase[i].toString());
	}
}
	
public int getSizeBase(){
	int sizeBase=this.clientBase.length;
	return sizeBase;
}

public Client getClient(int index){
	Client client;
	client=this.clientBase[index];
	return client;
}


}
