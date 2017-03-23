package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {
	
	List<String> dizionario;
	
	private String linguaggio;
	private String s;
	
	public Dictionary() {
		dizionario= new ArrayList<String>();
			}


	public void loadDictionary(String language){
		dizionario.clear();
		linguaggio=language;
		try {
			FileReader fr= new FileReader("rsc/"+language+".txt");
			BufferedReader br= new BufferedReader(fr);
			String word;
			while((word = br.readLine())!= null){
			 dizionario.add(word.toLowerCase());	
			}
			br.close();
		}catch(IOException e){
			System.out.println("Errore nella lettura del file!");
		}
		
		}
	

	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List <RichWord> listaInput= new ArrayList<RichWord>();
	     for(String s:inputTextList){
			
				RichWord r= new RichWord(s,cercaParola(s));
				listaInput.add(r);
			}
			return listaInput;
	
		
	    
	
	
	  }
	
	public boolean cercaParola( String parola){

	
		//int pos= dizionario.indexOf(parola);
//			if(pos!=-1){
//				return true;
//			}else
//				return false;
//			
			int posI=0;
			int posF= dizionario.size()-1;
			int posC=0;
			posC=(posI+posF)/2;
			s= posI+" "+posC+" "+posF+"\n";
			boolean trovata=false;
			while(trovata==false && posI<posF){
				
				
				//s+= posI+" "+posC+" "+posF+"\n";
				if(parola.compareTo(dizionario.get(posC))==0){
					trovata=true;
					
				}
					if(parola.compareTo(dizionario.get(posC))<0){
						posF=posC-1;
						posC=(posI+posF)/2;
						s+= posI+" "+posC+" "+posF+"\n";
						
					}
						if(parola.compareTo(dizionario.get(posC))>0){
							posI= posC+1;
							posC=(posI+posF)/2;
							s+= posI+" "+posC+" "+posF+"\n";
							}
			}
			return trovata;
			
		 }
	public String getS(){
		return s;
	}
	
}
