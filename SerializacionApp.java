/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializable;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



/**
 *
 * @author jairo
 */
public class SerializacionApp {
    
    public static void main(String[] args) {
        //Creamos el objeto
        Contactos contact1=new Contactos("Ing Erick","Amaya",31405289);
        Contactos contact2=new Contactos("Davianis","Castel",9852740);
        
        try(ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("miscontactos.dat"))){
        //Escribimos en el fichero
            oos.writeObject(contact1);
            oos.writeObject(contact2);
        }catch(IOException e){
        }
        
        
        try(ObjectInputStream ois=new ObjectInputStream (new FileInputStream("miscontactos.dat"))){
           while(true){
           Contactos aux=(Contactos)ois.readObject();
               System.out.println(aux.getNombre());
               System.out.println(aux.getApellido());
               System.out.println(aux.getNumero());
               System.out.println("");
           
           }
        
        }catch(ClassNotFoundException e){
        }catch(EOFException e){
        }catch(IOException e){
        }
    }

}
  