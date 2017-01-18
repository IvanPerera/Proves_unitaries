/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import kiosk.ActivationCard;

/**
 * @author ivan
 * 
 * Local service for validating activation cards
 */
public interface ValidationService {
    
    boolean validate(ActivationCard card);
    void deactivate(ActivationCard card);
}
