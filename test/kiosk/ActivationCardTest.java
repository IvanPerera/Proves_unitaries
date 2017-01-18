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
    
                
    public ActivationCardTest() {
    }
    
    @Before
    public void setUp() {
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
}
