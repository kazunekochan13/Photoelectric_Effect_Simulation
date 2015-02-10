/*
 * Class is used to write data to all text files
 */

package photoelectric_effect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFiles {
    
    private final String pathQ;
    private final String pathCA;
    private final String pathA;
    
    //private boolean appendToFile = false;
    
    public WriteFiles(String question, String corAnswer, String answer){
        pathQ = question;
        pathCA = corAnswer;
        pathA = answer;
    }
    
    
    
    public void EditFiles(ArrayList questions, ArrayList corAnswer, ArrayList answers) throws IOException{ //overwrite files
        
        FileWriter fw = new FileWriter(pathQ);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i=0; i < questions.size();i++){
            bw.write((String)questions.get(i));
        }
        bw.close();
        
        FileWriter fw2 = new FileWriter(pathCA);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        for (int i=0; i< corAnswer.size(); i++){
            bw2.write((String)corAnswer.get(i));
        }
        bw2.close();
        
        FileWriter fw3 = new FileWriter(pathA);
        BufferedWriter bw3 = new BufferedWriter(fw3);
        for (int i=0; i < answers.size(); i++){
            bw3.write((String)answers.get(i));
        }
        bw3.close();
        
    }
    
    public void AppendFiles(String question, String corAnswer, ArrayList answers) throws IOException{ //add new 
        
        FileWriter fw1 = new FileWriter(pathQ, true);
        PrintWriter pw1 = new PrintWriter(fw1);
        
        pw1.printf("%s" + "%n", question);
        pw1.close();
        
        FileWriter fw2 = new FileWriter (pathCA, true);
        PrintWriter pw2 = new PrintWriter (fw2);
        
        pw2.printf("%s" + "%n" + corAnswer);
        pw2.close();
        
        FileWriter fw3 = new FileWriter(pathA, true);
        PrintWriter pw3 = new PrintWriter(fw3);
        
        for(int i=0; i< answers.size();i++){
            pw3.printf("%s" + "%n" + answers.get(i));
        }
        pw3.close();
    }
    
}
