/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.MailAddress;
import data.Signature;

/**
 * @author ivan
 * 
 * External service for sending mails
 */
public interface MailerService {
    
    void send(MailAddress address, Signature signature);
}
