/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author denni
 */
public class Token {
    private String type;
    private String lexem;
    private int row;
    private int colm;
    private Token siguiente;

   
    public Token(String type, String lexem, int row, int colm) {
        this.type = type;
        this.lexem = lexem;
        this.row = row;
        this.colm = colm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLexem() {
        return lexem;
    }

    public void setLexem(String lexem) {
        this.lexem = lexem;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColm() {
        return colm;
    }

    public void setColm(int colm) {
        this.colm = colm;
    }
     public Token getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Token siguiente) {
        this.siguiente = siguiente;
    }
}
