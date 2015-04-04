/*
 * Class is used to read data from all text files
 *
 */

package photoelectric_effect;

import java.io.*;
import java.util.ArrayList;

public class ReadFiles {
    
    //private final String pathQ;
    //private final String pathCA;
    //private final String pathA;
    File pathQ;
    File pathCA;
    File pathA;
    
    public ReadFiles(File Q, File CA, File A){
        pathQ=Q;
        pathCA=CA;
        pathA=A;
    }
  
    int FindLine(File findPath) throws IOException{
        FileReader fr =new FileReader(findPath);
        BufferedReader br = new BufferedReader(fr);
        
        String stringTest;
        int lines = 0;
        while((stringTest=br.readLine()) !=null){
            lines++;
        }
        return lines;
    }
    
    //reading questions from text file
    public ArrayList ReadQues() throws IOException{
        FileReader fr = new FileReader(pathQ);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList questions = new ArrayList();
        
        for (int i=0; i< FindLine(pathQ); i++){
            questions.add(br.readLine());
        }
        br.close();
        return questions;
    }
    
    //reading Correct Answers from text file
    public ArrayList ReadCA() throws IOException{
        FileReader fr = new FileReader(pathCA);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList correctAnswer = new ArrayList();
        
        for (int i=0; i< FindLine(pathCA); i++){
            correctAnswer.add(br.readLine());
        }
        br.close();
        return correctAnswer;
    }
    
    //reading Dummy answers from text file
    public ArrayList ReadA() throws IOException {
        FileReader fr = new FileReader(pathA);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList dummyAnswers = new ArrayList();
        
        for (int i=0; i< FindLine(pathA); i++){
            dummyAnswers.add(br.readLine());
        }
        br.close();
        return dummyAnswers;
    }
    
}
