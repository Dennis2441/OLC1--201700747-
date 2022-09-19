/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author denni
 */
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
  
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Lista {
    
       private Token inicio;
    
    
    private int tamanio;
    
    
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    
       public boolean esVacia(){
        return inicio == null;
    }
       
       public void agregarAlInicio(String type,String lexem,int row, int colm){
        // Define un nuevo nodo.
        Token nuevo = new Token(type, lexem, row, colm);
        // Agrega al valor al nodo.
        
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
        // Caso contrario va agregando los nodos al inicio de la lista.
        } else{
            // Une el nuevo nodo con la lista existente.
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = nuevo;
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }
        public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
        
        public boolean listar(){
        // Verifica si la lista contiene elementoa.
        String file
            = "errorlexico.pdf";
           try {
               PdfDocument pdfDoc= new PdfDocument(new PdfWriter(file));
               Document doc = new Document(pdfDoc);
                 Table table = new Table(3);
        if (!esVacia()) {
            // Crea una copia de la lista.
Token aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            
            // Recorre la lista hasta el final.
            while(aux != null){
                
                table.addCell(new Cell().add(new Paragraph(aux.getLexem())));
                table.addCell(new Cell().add(new Paragraph("Columna: "+String.valueOf(aux.getColm()))));
                table.addCell(new Cell().add(new Paragraph("Fila: "+String.valueOf(aux.getRow()))));
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
               
            }
            doc.add(table);
               doc.close();
               return true;
        } 
        
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
           }
         
          
  
        // Step-3 Creating a table
           return false;
      
    }
      public boolean listar2(){
        // Verifica si la lista contiene elementoa.
        String file
            = "errorsintactico.pdf";
           try {
               PdfDocument pdfDoc= new PdfDocument(new PdfWriter(file));
               Document doc = new Document(pdfDoc);
                 Table table = new Table(3);
        if (!esVacia()) {
            // Crea una copia de la lista.
Token aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            
            // Recorre la lista hasta el final.
            while(aux != null){
                
                table.addCell(new Cell().add(new Paragraph(aux.getLexem())));
                table.addCell(new Cell().add(new Paragraph("Columna: "+String.valueOf(aux.getColm()))));
                table.addCell(new Cell().add(new Paragraph("Fila: "+String.valueOf(aux.getRow()))));
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
               
            }
            doc.add(table);
               doc.close();
               return true;
        } 
        
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
           }
         
          
  
        // Step-3 Creating a table
           return false;
      
    }
      
}
