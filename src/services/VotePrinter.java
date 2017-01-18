/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.Vote;

/**
 * @author ivan
 * 
 * This service prints physically the vote to allow checking.
 */
public interface VotePrinter {
    
    void print(Vote vote);
}
