/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import java.util.ArrayList;
import kiosk.ActivationCard;
import services.ValidationService;

/**
 *
 * @author ivan
 */
public class ValidationsServiceDoble implements ValidationService{
    
    //private ActivationCard targeta;
    
    ArrayList<ActivationCard> list_card = new ArrayList<ActivationCard>();
    
    
    public boolean validate(ActivationCard card){ //Mirem si la "card" esta dintre de la llista list.
        
        if (list_card.contains(card)){
            return true;
        }
        return false;
    }
    
    
    public void deactivate(ActivationCard card){ //Borrar la card de la llista per desactivar-la
        list_card.remove(card);
    }
    
}
