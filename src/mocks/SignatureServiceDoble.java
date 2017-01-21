/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import data.Signature;
import data.Vote;
import services.SignatureService;

/**
 *
 * @author ivan
 */
public class SignatureServiceDoble implements SignatureService{
    
    private Vote vot;
    private Signature sign;
    
    public Signature sign(Vote vote){
        
        this.vot = new Vote ("Eleccio");
        String votacio = vot.getOption();
        Signature sign = new Signature (votacio.getBytes());
        
        return sign;
    }
    
}
