package imprimir;

import java.io.*;

/**
* Class declaration
*
*
* @author
* @version 1.10, 08/04/00
*/
public class impresora {
    //Variables de  acceso   al dispositivo
    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter pw;
    private String dispositivo="";
    /** Esta funcion inicia el  dispositivo donde se va a imprimir */
    
    public  void setDispositivo( String texto ) {
    dispositivo=texto;
    
    if(texto.trim().length()<=0){//Si el    dispositivo viene en  blanco el  sistema tratara de definirlo
        OSValidator misession=new OSValidator();
    //    dispositivo=misession.impresora_tiquets();
        if(dispositivo.trim().length()<=0){

//        if(misession.isWindows()){
        if(misession.isWindows()){

            dispositivo="LPT1";//Esto si  es windows
        }else{
            dispositivo="/dev/lp0";//Esto si  es linux
        }
        }
    }
    try{
        fw = new FileWriter(dispositivo);
        bw = new BufferedWriter (fw);
        pw = new PrintWriter (bw);
    }catch(Exception e){
        System.out.print(e);
        System.out.println("Error1");
    }
    }
    public  void escribir( String texto ) {
        try{
          pw.println(texto);
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error2");
        }
    }
    
    public  void cortar( ) {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'm'};
            if(!this.dispositivo.trim().equals("pantalla.txt")){
            pw.write(ESC_CUT_PAPER);
            }
        }catch(Exception e){
         System.out.print(e);
                 System.out.println("Error3");
        }
    }
    
    public  void avanza_pagina( ) {
        try{
            if(!this.dispositivo.trim().equals("pantalla.txt")){
            pw.write(0x0C);
        }
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error4");
        }
    }
    
    public  void setRojo( ) {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B,'r',1};
            if(!this.dispositivo.trim().equals("pantalla.txt")){
                pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error5");
        }
    }
    
    public  void setNegro( ) {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'r',0};
            if(!this.dispositivo.trim().equals("pantalla.txt")){
            pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error6");
        }
    }
    
    public  void setTipoCaracterLatino( ) {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, 'R',18};
            if(!this.dispositivo.trim().equals("pantalla.txt")){
                pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error7");
        }
    }
    
    public  void setFormato(int formato ) {
        try{
            char[] ESC_CUT_PAPER = new char[] { 0x1B, '!',(char)formato};
            if(!this.dispositivo.trim().equals("pantalla.txt")){
                pw.write(ESC_CUT_PAPER);
        }
        }catch(Exception e){
          System.out.print(e);
                  System.out.println("Error8");
        }
    }
    
    public  void correr(int fin){
        try{
            int i=0;
            for(i=1;i<=fin;i++){
                this.salto();
            }
        }catch(Exception e){
             System.out.print(e);
                     System.out.println("Error9");
        }
    }
    
    public  void salto() {
        try{
            pw.println("");
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error10");
        }
    }
    
    public void dividir(){
        escribir("—————————————-");
    }
    
    public  void cerrarDispositivo(  ){
        try{
            pw.close();
                if(this.dispositivo.trim().equals("pantalla.txt")){
                    java.io.File archivo=new java.io.File("pantalla.txt");
                    java.awt.Desktop.getDesktop().open(archivo);
                }
        }catch(Exception e){
            System.out.print(e);
                    System.out.println("Error11");
        }
    }
    public static void main(String args[]) {
        impresora p=new impresora();
        p.setDispositivo("");
        p.escribir((char)27+"m");
        p.setTipoCaracterLatino();
        p.setRojo();
        p.escribir("Esto es una prueba");
        p.setNegro();
        p.escribir("esto es negro"+(char)130);
        p.setFormato(24);
        p.escribir("esto es negro con formato");
        p.setFormato(1);
        p.escribir("esto es negro con formato");
        p.correr(10);
        p.cortar();
        p.cerrarDispositivo();
    }
}    