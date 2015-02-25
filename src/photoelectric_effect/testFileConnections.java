/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package photoelectric_effect;

import java.util.ArrayList;


public class testFileConnections {
    
    
    public static void main(String[] args){
         testFileConnections tfc = new testFileConnections();
         QuestionSection QS = new QuestionSection();
         ArrayList test = QS.returnQuestions();
         System.out.println(test.size());
         for (int i=0;i<test.size();i++){
             System.out.println(test.get(i));
         }
    }
    
}
