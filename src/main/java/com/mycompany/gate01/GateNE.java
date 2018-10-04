/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gate01;

import gate.Corpus;
import gate.Document;
import gate.Factory;
import gate.Gate;
import gate.LanguageAnalyser;
import gate.Utils;
import gate.creole.ANNIEConstants;
import gate.util.persistence.PersistenceManager;
import java.io.File;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.HashSet;

/**
 *
 * @author Administrator
 */
public class GateNE {
    //the list for named entity 
      ArrayList<String> list=new ArrayList<String>();  
       
    
   public ArrayList<String> findNE(String que) throws Exception {
        
       Gate.setGateHome(new File("C:\\Program Files\\GATE_Developer_8.4.1"));
        Gate.init();

      LanguageAnalyser controller = (LanguageAnalyser) PersistenceManager
                .loadObjectFromFile(new File(new File(Gate.getPluginsHome(),
                        ANNIEConstants.PLUGIN_DIR), ANNIEConstants.DEFAULT_FILE));

        Corpus corpus = Factory.newCorpus("corpus");
        Document document = Factory.newDocument(
               que);
        corpus.add(document); controller.setCorpus(corpus); 
        controller.execute();
//getting all possible named entity and adding them to the list
        document.getAnnotations().get(new HashSet<>(Arrays.asList("Person", "Organization", "Location")))
            .forEach(a ->  list.add(Utils.stringFor(document, a)));

        //Don't forget to release GATE resources 
        Factory.deleteResource(document); Factory.deleteResource(corpus); Factory.deleteResource(controller);
 
 return list;
}
    
}
