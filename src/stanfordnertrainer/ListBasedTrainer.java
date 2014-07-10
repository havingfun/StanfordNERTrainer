/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stanfordnertrainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rajesh
 */
public class ListBasedTrainer {
    
    public static Map<String,Integer> ListVals;
    public static void loadList(String path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        ListVals = new HashMap<String, Integer>();
        String line = "";
        while((line = br.readLine())!=null)
        {
            ListVals.put(line.toLowerCase(),1);
        }
    }
    public static void createTSVfile(String path,String EnitityType) throws Exception
    {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pr = new PrintWriter(file.getName()+"_Trained.tsv");
        String line = "";
        while((line = br.readLine())!=null)
        {
            String first = line.split("\t")[0].toLowerCase();
            if(ListVals.containsKey(first))
            {
                pr.println(line.split("\t")[0] + "\t" + EnitityType);
            }
            else
            {
                pr.println(line);
            }
        }
    }
    
    public static void main(String args[]) throws Exception
    {
        loadList("");
        createTSVfile("","");
    }
}
