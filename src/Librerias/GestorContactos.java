/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Librerias;

/**
 *
 * @author kp720
 */
import java.util.stream.*;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GestorContactos {
    List<Contacto> contactos = new ArrayList<>();
    private String ruta;
    public boolean agregarContacto(Contacto c){
        if(!numeroRepetido(c.getNumero())){
            if(!correoRepetido(c.getCorreo())){
                contactos.add(c);
                return true;
            }
        }
        return false;
    }
    
    public void crearContacto(String nom, String num, String dir, String corr, boolean blo){
        Contacto c = new Contacto(nom,num,dir,corr,blo);
        if(!numeroRepetido(c.getNumero())){
            if(!correoRepetido(c.getCorreo())){
                contactos.add(c);   
            }
        }
    }
    
    public void getRuta(String r){
        ruta = r;
    }
    //Metodos de guardado por excel
    public boolean guardarContactos(){
        if(!contactos.isEmpty()){
            
            //Creación de una hoja
            Workbook libro = new XSSFWorkbook();
            Sheet hoja = libro.createSheet("Contactos");

            //Creación de los encabezados
            String[] encabezados = {"Nombre", "Número","Dirección","Correo","Bloqueado","Segundo Nombre","Segundo Número","Segunda Dirección"};
            Row headerRow = hoja.createRow(0);
            for (int i = 0; i < encabezados.length; i++) {
                Cell celda = headerRow.createCell(i);
                celda.setCellValue(encabezados[i]);
            }

            //Creacion del contacto dentro del archivo 
            int numFila = 1;
            for (Contacto contacto : contactos) {
                Row fila = hoja.createRow(numFila++);
                fila.createCell(0).setCellValue(contacto.getNombre());
                fila.createCell(1).setCellValue(contacto.getNumero());
                fila.createCell(2).setCellValue(contacto.getDireccion());
                fila.createCell(3).setCellValue(contacto.getCorreo());
                fila.createCell(4).setCellValue(contacto.getBloqueo()? "Sí" : "No");
                fila.createCell(5).setCellValue(contacto.getSegundoNombre());
                fila.createCell(5).setCellValue(contacto.getSegundoNumero());
                fila.createCell(5).setCellValue(contacto.getSegundaDireccion());
            }
            
            //Ruta actual del archivo 
            File archivo = new File(ruta);//Modificar ruta de guardado
            archivo.getParentFile().mkdirs();
            
            //Guardado del archivo
            try (FileOutputStream fileOut = new FileOutputStream(archivo)) {
                libro.write(fileOut);
                libro.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    //Metodo al inicio del programa para cargar los datos del excel
    public void cargarContactos(){
        //Modificar ruta de carga
        try(FileInputStream archivo = new FileInputStream(new File(ruta))){
            Workbook libro = new XSSFWorkbook(archivo);
            Sheet hoja = libro.getSheetAt(0);
            
            for(int i = 1; i <= hoja.getLastRowNum(); i++){
                Row fila = hoja.getRow(i);
                if(fila != null){
                    String nombre = fila.getCell(0).getStringCellValue();
                    String numero = fila.getCell(1).getStringCellValue();
                    String direccion = fila.getCell(2).getStringCellValue();
                    String correo = fila.getCell(3).getStringCellValue();
                    boolean bloqueo = fila.getCell(4).getStringCellValue().equalsIgnoreCase("Si");
                    String sNombre = fila.getCell(5).getStringCellValue();
                    String sNum = fila.getCell(6).getStringCellValue();
                    String sDirec = fila.getCell(7).getStringCellValue();
                    
                    Contacto contacto = new Contacto(nombre,numero, direccion, correo, bloqueo, sNombre, sNum, sDirec);
                    agregarContacto(contacto);
                }
            }
            libro.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //metodos de guardado por txt
    public void leerContactos(String ruta) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            String lector;
            while ((lector = buffer.readLine()) != null) {
                String[] partes = lector.split(",");
                String nombre = partes[0].trim();
                String numero = partes[1].trim();
                String direccion = partes[2].trim();
                String correo = partes[3].trim();
                boolean bloqueado = Boolean.parseBoolean(partes[4]);
                String sNombre = partes[5].trim();
                String sNumero = partes[6].trim();
                String sDire = partes[7].trim();
                contactos.add(new Contacto(nombre,numero,direccion,correo,bloqueado,sNombre,sNumero,sDire));
            }
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    public void almacenarContactos() {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta))) {
            Set<Contacto> productosSet = new HashSet<>(contactos);
            for (Contacto contacto : productosSet) {
                escribir.write(contacto.toString());
                escribir.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
    //Filtros de busqueda
    public List<Contacto> filtrarNombre(String nombre) {
        return contactos.stream()
                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
    public List<Contacto> filtrarDireccion(String direccion) {
        return contactos.stream()
                .filter(contacto -> contacto.getDireccion().equalsIgnoreCase(direccion))
                .collect(Collectors.toList());
    }
    public List<Contacto> filtrarCorreo(String correo){
        return contactos.stream()
                .filter(contacto -> contacto.getCorreo().equalsIgnoreCase(correo))
                .collect(Collectors.toList());
    }
    public List<Contacto> filtrarBloqueos() {
        return contactos.stream()
                .filter(contacto -> contacto.getBloqueo() == true)
                .collect(Collectors.toList());
    }
    
    //Metodos de eliminación
    public void eliminarNumero(String numero) {
        contactos.removeIf(contacto -> contacto.getNumero().equals(numero));
    }
    public void eliminarCorreo(String correo) {
        contactos.removeIf(contacto -> contacto.getCorreo().equals(correo));
    }
    
    //Metodos de verificación
    private boolean numeroRepetido(String numero) {
        return contactos.stream().anyMatch(contacto -> contacto.getNumero().equals(numero));
    }
    private boolean correoRepetido(String correo) {
        return contactos.stream().anyMatch(contacto -> contacto.getCorreo().equals(correo));
    }
}

class Contacto{
    //Datos principales
    String nombre, numero, direccion,correo;
    boolean bloqueado;

    //Contructores
    public Contacto(){
        nombre = "";
        numero="";
        direccion="";
        correo="";
        bloqueado = false;
        segundoNom = "";
        segundoNum = "";
        segundaDirec = "";
    }
    public Contacto(String nom, String num, String dir, String corr, boolean blo){
        nombre = nom;
        numero = num;
        direccion = dir;
        correo = corr;
        bloqueado = blo;
        segundoNom = "";
        segundoNum = "";
        segundaDirec = "";
    }
    public Contacto(String nom, String num, String dir, String corr, boolean blo, String sNom, String sNum, String sDir){
        nombre = nom;
        numero = num;
        direccion = dir;
        correo = corr;
        bloqueado = blo;
        segundoNom = sNom;
        segundoNum = sNum;
        segundaDirec = sDir;
    }
    
    
    //Setters
    public void setNombre(String n){
        nombre = n;
    }
    public void setNum(String num){
        numero = num;
    }
    public void setDireccion(String dir){
        direccion = dir;
    }
    public void setCorreo(String cor){
        correo = cor;
    }
    public void setBloqueado(boolean b){
        bloqueado = b;
    }
    
    //datos opcionales
    
    String segundoNom="",segundoNum="",segundaDirec;
    
    //Datos opcionales
    public void setSegundoNombre(String sNom){
        segundoNom = sNom;
    }
    public void setSegundoNumero(String sNum){
        segundoNum = sNum;
    }
    public void setSegundaDireccion(String sDire){
        segundaDirec = sDire;
    }
    //Otros datos...
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getCorreo(){
        return correo;
    }
    public String getNumero(){
        return numero;
    }
    public boolean getBloqueo(){
        return bloqueado;
    }
    public String getSegundoNombre(){
        return segundoNom;
    }
    public String getSegundoNumero(){
        return segundoNum;
    }
    public String getSegundaDireccion(){
        return segundaDirec;
    }       
    
    @Override
    public String toString(){
        return nombre+","+numero+","+direccion+","+correo+","+bloqueado+","+segundoNom+","+segundoNum+","+segundaDirec; 
    }
}

