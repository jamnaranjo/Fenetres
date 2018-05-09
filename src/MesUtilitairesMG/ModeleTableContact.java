/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesUtilitairesMG;

import java.util.Vector;

/**
 *
 * @author jalvaro
 */
public class ModeleTableContact extends ModeleTable {
    
    public ModeleTableContact(Vector<Contact> listeContacts,
                                Vector<Colonne> listeColonnes) {
        Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();
        for(Contact c : listeContacts) {
            listeLignes.add(contactALigne(c));
        }
        setListeLignes(listeLignes);
        setListeColonnes(listeColonnes);
    }
    
    public Vector<Contact> getListeContacts() {
        Vector<Contact> contacts = new Vector<Contact>(); 
        
        Vector<Vector<Object>> lignes = getListeLignes();
        for(Vector<Object> ligne : lignes) {
            contacts.add(ligneAContact(ligne));
        }
        return contacts;
    }
    
    public Vector<Contact> getListeContactsSupprimes() {
        Vector<Vector<Object>> lignesSupprimes = getListeLignesSupprimes();
        
        Vector<Contact> contactsSupprimes = new Vector<Contact>();
        for(Vector<Object> ligne : lignesSupprimes) {
            contactsSupprimes.add(ligneAContact(ligne));
        }
        return contactsSupprimes;
    }
    
    public Vector<Contact> getListeContactsModifies() {
        Vector<Contact> contacts = getListeContacts();
        Vector<Character> modificationLignes = getModificationLignes();
        Vector<Contact> modifies = new Vector<Contact>();
        
        for(int i = 0; i < contacts.size(); i++) {
            if(modificationLignes.get(i) == 'M') {
                modifies.add(contacts.get(i));
            }
        }
        return modifies;
    }
    
    public Vector<Contact> getListeContactsInseres() {
        Vector<Contact> contacts = getListeContacts();
        Vector<Character> modificationLignes = getModificationLignes();
        Vector<Contact> inseres = new Vector<Contact>();
        
        for(int i = 0; i < contacts.size(); i++) {
            if(modificationLignes.get(i) == 'I') {
                inseres.add(contacts.get(i));
            }
        }
        return inseres;
    }
    
    private Vector<Object> contactALigne(Contact contact) {
        Vector<Object> ligne = new Vector<Object>();
        ligne.add(contact.getNumero());
        ligne.add(contact.getNom());
        ligne.add(contact.getAdresse());
        ligne.add(contact.getCodePostal());
        ligne.add(contact.getVille());
        ligne.add(contact.getCodeSecteur());
        
        return ligne;
    }
    
    private Contact ligneAContact(Vector<Object> ligne) {
        return new Contact((Integer)ligne.get(0),
                            (String)ligne.get(1),
                            (String)ligne.get(2),
                            (String)ligne.get(3),
                            (String)ligne.get(4),
                            (Integer)ligne.get(5));
    }
}
