/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.MailAddress;
import data.Vote;
import services.MailerService;
import services.SignatureService;
import services.ValidationService;
import services.VotePrinter;
import services.VotesDB;

/**
 * 
 * @author Ivan
 * 
* Implements a simplification of Use Case: Emit Vote
*/
public class VotingMachine {
        
    private ValidationService vali_serv;
    private MailerService mail_serv;
    private SignatureService sign_serv;
    private VotePrinter vote_print;
    private VotesDB vot_DB;
    
    private ActivationCard card;
    private boolean machineOk = false;
    private Vote vote;
    private boolean completevoting;
    
    public VotingMachine() {}
    
    public void setMailerService(MailerService mailerservice) {
        this.mail_serv = mailerservice;
    }
    
    public void setSignatureService(SignatureService signatureservice){
        this.sign_serv = signatureservice;
    }
    
    public void setValidationService(ValidationService validationService) {
        this.vali_serv = validationService;
    }
    
    public void setVotePrinter(VotePrinter votePrinter) {
        this.vote_print = votePrinter;
    }
    
     public void setVotesDB(VotesDB votesDB) {
        this.vot_DB = votesDB;
    } 

    public void activateEmission(ActivationCard card) throws IllegalStateException {
        
        if (this.vali_serv.validate(card) && machineOk == false ){ //Per saber si la maquina esta sent utilitzada i la targeta és valida.
            machineOk = true;
        }
        else {
            throw new IllegalStateException();
        }
        
    }
    
    public boolean canVote(){
        
        if (this.vali_serv.validate(card) && machineOk == true){
            return true;   
        }
        else{
            return false;
        }
    }

    public void vote(Vote vote) throws IllegalStateException {
        
        this.vote = vote;
        
        if (canVote() == false){
            throw new IllegalStateException();
        }
        else {
            int process_complete = 0;
            
            this.vot_DB.registerVote(vote); 
            process_complete+=1;
            this.vote_print.print(vote);
            process_complete+=1;
            this.vali_serv.deactivate(card);
            process_complete+=1;
            
            if(process_complete == 3){
                completevoting = true;   
            }
        }
    }

    public void sendReceipt(MailAddress address) throws IllegalStateException {
        if(canVote() == false || completevoting == false){
            throw new IllegalStateException();
        }
        else {
            this.sign_serv.sign(vote);
        }
    }

}
