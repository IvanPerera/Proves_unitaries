/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import data.Vote;
import java.util.ArrayList;
import java.util.List;
import services.VotesDB;

/**
 *
 * @author ivan
 */
public class VotesDBDoble implements VotesDB{
    
    private final ArrayList<Vote> votes = new ArrayList<Vote>();
    
    public void registerVote(Vote vote){
        
        votes.add(vote);
    }
    
    public List<Vote> getVotes(){
        
        return votes;
    }
    
}
