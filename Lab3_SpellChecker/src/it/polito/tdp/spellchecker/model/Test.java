package it.polito.tdp.spellchecker.model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dictionary d= new Dictionary();
		d.loadDictionary("Italian");
		
		System.out.println(d.cercaParola("calare"));
		System.out.println(d.getS());
	}

}
