/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imprimir;

/**
 *
 * @author Casa
 */
public class Imprimir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

impresora tiquete=new impresora();

tiquete.escribir("    Esto es una linea    ");
tiquete.escribir("Esto es otra linea");
tiquete.escribir("Otra linea ma");
//Esto es para escribir una linea divisoria
tiquete.dividir();

//esto cambia el formato de acuerdo a las especificaciones de epson

tiquete.setFormato(1);
tiquete.escribir("    Mas texto con letra mas grande      ");
tiquete.setFormato(1);

tiquete.escribir("texto con letra normal");
tiquete.dividir();

tiquete.setRojo();
tiquete.escribir("Texto en rojo");
tiquete.setNegro();

tiquete.escribir("Texto en negro");

tiquete.correr(10);//Esto baja 10 lineas en blanco
tiquete.cortar();//Esto corta el papel de la impresora
tiquete.cerrarDispositivo();//Cierra el dispositivo y aplica el texto

    }
    
}
