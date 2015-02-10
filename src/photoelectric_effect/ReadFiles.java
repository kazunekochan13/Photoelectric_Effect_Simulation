/*
 * Class is used to read data from all text files
 */

package photoelectric_effect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFiles {
    
    private final String pathQ = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/Questions.txt";
    private final String pathCA = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/CorrectAnswer.txt";
    private final String pathA = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/Answers.txt";
    private final String pathWFN = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/WFName.txt";
    private final String pathWFS = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/WFSymbol.txt";
    private final String pathWFV = "C:/Users/Owner/Documents/NetBeansProjects/ZombieTest/dist/WFValue.txt";
    
    public ReadFiles(){
        
    }
  
    int FindLine(String findPath) throws IOException{
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
    
    public ArrayList ReturnWFName() throws IOException{
        FileReader fr = new FileReader(pathWFN);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList name = new ArrayList();
        
        for (int i=0; i < FindLine(pathWFN); i++){
            name.add(br.readLine());
        }
        br.close();
        
        return name;
    }
    
    public ArrayList ReturnWFSymbol() throws IOException{
        FileReader fr2 = new FileReader(pathWFS);
        BufferedReader br2 = new BufferedReader(fr2);
        
        ArrayList symbol = new ArrayList();
        
        for (int i=0; i<FindLine(pathWFS); i++){
            symbol.add(br2.readLine());
        }
        br2.close();
        return symbol;
    }
    
    public ArrayList ReturnWFValue() throws IOException{
        FileReader fr3 = new FileReader(pathWFV);
        BufferedReader br3 = new BufferedReader(fr3);
        
        ArrayList value = new ArrayList();
        
        for (int i=0; i<FindLine(pathWFV); i++){
            value.add(br3.readLine());
        }
        br3.close();
        return value; 
    }
    
}
