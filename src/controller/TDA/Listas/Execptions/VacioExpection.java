/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controller.TDA.Listas.Execptions;

/**
 *
 * @author Jhostin
 */
public class VacioExpection  extends Exception{

    /**
     * Creates a new instance of <code>VacioExpection</code> without detail
     * message.
     */
    public VacioExpection() {
    }

    /**
     * Constructs an instance of <code>VacioExpection</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public VacioExpection(String msg) {
        super(msg);
    }
}
