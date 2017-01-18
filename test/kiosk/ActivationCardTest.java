/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class ActivationCardTest {
    
    ActivationCard card_null;
                
    public ActivationCardTest() {
    }
    
    @Before
    public void setUp() {
        card_null = new ActivationCard("");
    }

    /**
     * Test of isActive method, of class ActivationCard.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        ActivationCard card = new ActivationCard("a23e1");
        boolean card_true = true;
        boolean card_expect = card.isActive();
        assertEquals(card_true, card_expect);
        
    }

    /**
     * Test of erase method, of class ActivationCard.
     */
    @Test
    public void testErase() {
        System.out.println("erase");
        this.card_null.erase();
        assertEquals(true, this.card_null.getCode()==null);
    }
    
}
