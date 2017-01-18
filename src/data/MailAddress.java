/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * @author ivan
 * 
 * Represents a mail_address.
 */

final public class MailAddress {
    
    private final String address;
    
    public MailAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return "MailAddress{" +"Address='" + address + '\'' + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress address = (MailAddress) o;
        return address.equals(address.address);
    }
    
    @Override
    public int hashCode() {
        return address.hashCode();
    }
    
}
