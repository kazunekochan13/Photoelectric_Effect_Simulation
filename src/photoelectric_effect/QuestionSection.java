/*
 *
 * Reading and Writing Files for question section
 */

package photoelectric_effect;

import java.io.*;
import java.util.ArrayList;

public class QuestionSection {
    
    private final File pathQ = new File("Resources/Questions.txt");
    private final File pathCA = new File("Resources/CorrectAnswers.txt");
    private final File pathA = new File("Resources/Answers.txt");
    ReadFiles rf = new ReadFiles(pathQ,pathCA,pathA);
    WriteFiles wf = new WriteFiles(pathQ, pathCA, pathA);
    private ArrayList QuesList;
    private ArrayList CorAns;
    private ArrayList Ans;
    
    public QuestionSection(){
            ReadAgain();
    }
    
    private void ReadAgain(){
        try{
        QuesList = rf.ReadQues();
        CorAns = rf.ReadCA();
        Ans = rf.ReadA();
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
    
    public ArrayList returnAnswers(){
        ReadAgain();
        return Ans;
    }
    
    public ArrayList returnCorAnswers(){
        ReadAgain();
        return CorAns;
    }
}
