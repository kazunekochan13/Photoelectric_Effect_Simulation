/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package photoelectric_effect;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionSection {
    
    private final String pathQ = "C:\\Users\\Owner\\Documents\\NetBeansProjects\\ZombieTest\\src\\photoelectric_effect\\Resources\\Questions.txt";
    private final String pathCA = "C:\\Users\\Owner\\Documents\\NetBeansProjects\\ZombieTest\\src\\photoelectric_effect\\Resources\\CorrectAnswers.txt";
    private final String pathA = "C:\\Users\\Owner\\Documents\\NetBeansProjects\\ZombieTest\\src\\photoelectric_effect\\Resources\\Answers.txt";
    ReadFiles rf = new ReadFiles(pathQ,pathA,pathA);
    WriteFiles wf = new WriteFiles(pathQ, pathCA, pathA);
    ArrayList QuesList;
    ArrayList CorAns;
    ArrayList Ans;
    
    public QuestionSection(){
            ReadAgain();
    }
    
    private void ReadAgain(){
        try{
        QuesList = rf.ReadQues();
        //CorAns = rf.ReadCA();
        //Ans = rf.ReadA();
        }
        catch (IOException ioe){
        }
    }
    
    public void WriteToFiles(ArrayList Q, ArrayList CA, ArrayList A){
        try{
            wf.EditFiles(Q, CA, A);
        }
        catch (IOException ioe){
        }
        ReadAgain();
    }
    
    public ArrayList returnQuestions(){
        ReadAgain();
        return QuesList;
    }
    
}
