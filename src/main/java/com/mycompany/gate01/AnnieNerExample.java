package com.mycompany.gate01;


import java.util.Iterator;
import java.util.ArrayList;
 

public class AnnieNerExample {
    //list to retrieve named entity 
  static ArrayList<String> NameEntitylist=new ArrayList<String>();  
  static ArrayList<String> SynonymsList=new ArrayList<String>();  
  static ArrayList<String> PossibleQues=new ArrayList<String>();  
   
  static Iterator itr;
  static String question="obama is from America";
 
  public static void main(String[] args) throws Exception{
     GateNE gateNe = new GateNE();
     Wordnet wordnet =new Wordnet();
  
     //reciving list returned by th GateNe class
     NameEntitylist=gateNe.findNE(question);
   
     //each named entity is replaced by its synonyps to produce list of possible questions 
     for(int i=0;i<NameEntitylist.size();i++){
         SynonymsList=wordnet.getSynonyms(NameEntitylist.get(i));
         
         for(int j=0;j<SynonymsList.size();j++){
             String syn =SynonymsList.get(j);
             String ques =question;
             
             PossibleQues.add(ques.replace(NameEntitylist.get(i),syn));
         }
      SynonymsList.clear();
     }
    //printing the Name Enitity lists
    itr=NameEntitylist.iterator();
     while(itr.hasNext()){  
     System.out.println(itr.next());  
     }  
  
    
     //printing the possible question  lists
    itr=PossibleQues.iterator();
     while(itr.hasNext()){  
     System.out.println(itr.next());  
     }  
   
  }
      
  }
