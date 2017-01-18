/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Vote;
import java.util.List;

/**
 * @author ivan
 * 
 * Local service that registers votes.
 */
public interface VotesDB {
    
    void registerVote(Vote vote);
    List<Vote> getVotes();
}
