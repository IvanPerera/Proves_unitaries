/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.MailAddress;
import data.Signature;
import data.Vote;
import java.util.List;
import mocks.MailerServiceDoble;
import mocks.SignatureServiceDoble;
import mocks.ValidationsServiceDoble;
import mocks.VotePrinterDoble;
import mocks.VotesDBDoble;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import services.MailerService;
import services.SignatureService;
import services.ValidationService;
import services.VotePrinter;
import services.VotesDB;

/**
 *
 * @author ivan
 */
public class VotingMachineTest {
    
    private VotingMachine vm;
    private ValidationService vali_serv;
    private ActivationCard card_valid;
    private ActivationCard card_novalid;
    private Vote vote;
    private VotesDBDoble votes;
    private VotePrinterDoble voteprint;
    private SignatureServiceDoble sign;
    private Signature signature;
    private MailerServiceDoble mail_serv;
    private MailAddress address;
    

    @Before
    public void setUp() {
        vm = new VotingMachine();
        card_valid = new ActivationCard("a23e1");
        card_novalid = new ActivationCard("xxxx");
        vote = new Vote("Eleccio");
        
        voteprint = new VotePrinterDoble();
        vali_serv = new ValidationsServiceDoble(card_valid);
        votes = new VotesDBDoble();
        mail_serv = new MailerServiceDoble();
        sign = new SignatureServiceDoble();

        vm.setVotesDB(votes);
        vm.setValidationService(vali_serv);
        vm.setVotePrinter(voteprint);
        vm.setMailerService(mail_serv);
        vm.setSignatureService(sign);
    }
    
    @Test
    public void testActivateEmissionValid() { //Comprobem si la targeta es válida.
        System.out.println("activateEmissionValid");
        vm.activateEmission(card_valid);
        vali_serv = new ValidationsServiceDoble(card_valid);
        assertEquals (true, vali_serv.validate(card_valid));
    }

    @Test
    public void testActivateEmissionNoValid() {  //Comprobem que la targeta no es valida.
        System.out.println("activateEmissionNoValid");
        vm.activateEmission(card_novalid);
        assertFalse( vali_serv.validate(card_novalid)); 
    }
    
    @Test
    public void testCanVote() {   //L'usuari pot votar per que la targeta és valida.
        System.out.println("canVote");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
    }
    
    @Test
    public void testCantVote() {   //No passem pel activatEmission ja que no podem votar amb aquesta targeta "card_novalid".
        System.out.println("cantVote");
        assertFalse(vm.canVote());
    }

    @Test(expected = IllegalStateException.class)   //Mentre la maquina esta activa, salta l'excepció.
    public void testMachineIsActivateException(){
        System.out.println("machineIsActive");
        vm.activateEmission(card_valid);
        vm.activateEmission(card_valid);
    }
    
    @Test
    public void testVote() {   //Comprovem que la targeta sigui válida i realitzem la votació.
        System.out.println("vote");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        vm.vote(vote);
        assertTrue(vm.completevoting);
    }

    @Test(expected = IllegalStateException.class)  //Estem en un estat que no pot votar i salta l'excepció.
    public void testCantVoteException(){
        System.out.println("cantVote");
        vm.activateEmission(card_novalid);
        vm.vote(vote);
    }
    
    @Test
    public void testRegisterVote() {  //Un cop realitzat el vot, l'enregistrem i comprovem que estigui a la llista de vots realitzats.
        System.out.println("vote");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        votes.registerVote(vote);
        List<Vote> vot = votes.getVotes();
        assertTrue(vot.contains(vote));
    }
    
    @Test
    public void testRegisterVoteNoValid() {  //No introduïm un vot a la llista de vots enregistrats i comprovem que no hi sigui.
        System.out.println("vote_novalid");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        Vote vot_noregister = new Vote ("Eleccio");
        List<Vote> vot = votes.getVotes();
        assertFalse(vot.contains(vot_noregister));
    }
    
    @Test
    public void testVotePrint() {   //Unicament comprovem que pugui votar i que printe el vot.
        System.out.println("votePrint");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        voteprint.print(vote);
    }
    
    @Test
    public void testDeactivatedCard() {   //Comprovem que desactivem una targeta válida correctament.
        System.out.println("deactivatedCard");
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        vm.vote(vote);
        vali_serv.deactivate(card_valid);
        assertEquals(false, vali_serv.validate(card_valid));
    }
    
    @Test
    public void testSendReceipt() {   //Comprovem que fa totes les accions de enviar el mail d'un vot realitzat.
        System.out.println("sendReceipt");
        address = new MailAddress("ivanpereraq@gmail.com");
        signature = new Signature(vote.toString().getBytes());
        vm.activateEmission(card_valid);
        assertTrue(vm.canVote());
        vm.vote(vote);
        vm.sendReceipt(address);
        mail_serv.send(address, signature);
    }
    
    @Test(expected = IllegalStateException.class)  //Al no poder realitzar el vot, no deixe enviar el mail i llença excepció.
    public void testNoSendReceipt() {
        System.out.println("noSendReceipt");
        vm.activateEmission(card_novalid);
        assertFalse(vm.canVote());
        vm.vote(vote);
        vm.sendReceipt(address);        
    }
}
