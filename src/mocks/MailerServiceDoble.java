/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import data.MailAddress;
import data.Signature;
import services.MailerService;

/**
 *
 * @author ivan
 */
public class MailerServiceDoble implements MailerService{
    
    private MailAddress adr;
    private Signature sign;
    
    public void send(MailAddress address, Signature signature){
        
        this.adr = new MailAddress("ivanpereraq@gmail.com");
        this.sign = new Signature("sign".getBytes());
        System.out.println("Correu enviat satisfactoriament!");
    }
}
