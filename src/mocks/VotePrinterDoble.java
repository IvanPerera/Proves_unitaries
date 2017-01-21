/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import data.Vote;
import services.VotePrinter;

/**
 *
 * @author ivan
 */
public class VotePrinterDoble implements VotePrinter{
    
    private Vote vot;
    
    public void print(Vote vote){
        
        vot = new Vote ("Eleccio");
        String voteprint = vot.toString();
        
        System.out.println(voteprint);
    }
    
}
