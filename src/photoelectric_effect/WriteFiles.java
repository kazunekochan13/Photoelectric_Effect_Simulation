/*
 *class is used to write data to all text files
 *
 */

package photoelectric_effect;

import java.io.*;
import java.util.ArrayList;

public class WriteFiles {
    
    File pathQ;
    File pathCA;
    File pathA;
    
    public WriteFiles(File question, File corAnswer, File answer){
        pathQ = question;
        pathCA = corAnswer;
        pathA = answer;
    }
    
    public void EditFiles(ArrayList questions, ArrayList corAnswer, ArrayList answers) throws IOException{ //overwrite files
        FileWriter fw = new FileWriter(pathQ);
        PrintWriter pt = new PrintWriter(fw);
        for (int i=0; i < questions.size();i++){
            pt.printf("%s" + "%n", (String)questions.get(i));
        }
        pt.close();
        
        FileWriter fw2 = new FileWriter(pathCA);
        PrintWriter pt2 = new PrintWriter(fw2);
        for (int i=0; i< corAnswer.size(); i++){
            pt2.printf("%s" + "%n", (String)corAnswer.get(i));
        }
        pt2.close();
        
        FileWriter fw3 = new FileWriter(pathA);
        PrintWriter pt3 = new PrintWriter(fw3);
        for (int i=0; i < answers.size(); i++){
            pt3.printf("%s" + "%n", (String)answers.get(i));
        }
        pt3.close();
        
    }
}
