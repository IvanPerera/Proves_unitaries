/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * @author ivan
 * 
 * Represents a signature.
 */

final public class Signature {
    
    private final byte[] signature;
    
    public Signature(byte[] signature) {
        this.signature = signature;
    }
    
    public byte[] getSignature() {
        return signature;
    }
    
    @Override
    public String toString() {
        return "Signature{" +"signature='" + signature + '\'' + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signature signature = (Signature) o;
        return signature.equals(signature.signature);
    }
    
    @Override
    public int hashCode() {
        return signature.hashCode();
    }
    
}
