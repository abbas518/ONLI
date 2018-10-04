/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gate01;

import java.io.FileInputStream;
import java.util.ArrayList;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.dictionary.Dictionary;

/**
 *
 * @author Administrator
 */
public class Wordnet {
  //the list for Synonyms  
      ArrayList<String> list=new ArrayList<>();  
       public ArrayList<String> getSynonyms(String que) throws Exception {   
           try{
            /*
             * Read properties file and initialize the dictionary for lookup
             */
            JWNL.initialize(new FileInputStream("src/main/resources/properties.xml"));
            final Dictionary dictionary = Dictionary.getInstance();


            final IndexWord indexWord = dictionary.lookupIndexWord(POS.NOUN, que);
             Synset synset[] = indexWord.getSenses();
          
            for(int j=0;j<synset[0].getWords().length;j++){
              list.add(synset[0].getWord(j).getSynset().getWord(j).getLemma());
            }}catch(Exception e){
                
            }   

 return list;}
}
