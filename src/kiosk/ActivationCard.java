/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

/**
 * @author ivan
 * 
 * Represents a activation_card.
 * 
 */
public class ActivationCard {
    
    private ActivationCard card;
    private String code;
    
    public ActivationCard(String code){
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public String toString() {
        return "AcivationCard{" +"code='" + code + '\'' + '}';
    }

    public boolean isActive(){
        //boolean status_card;
        
        if (code != null){
            return false;
        }
        //ActivationCard card = new ActivationCard("as23e");
        return true;
    }
    
    public void erase() {
        card.code = null;
    }
}
