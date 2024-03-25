/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import classes.Gestion;
import static classes.Gestion.loadStudents;

import classes.Students;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author damia
 */
public class Mavenproject4 {
    /**
     * The main method is the entry point of the program.
     * It loads the list of students and displays the management menu.
     *
     * @param args The command-line arguments (not used in this program).
     * @throws IOException If an error occurs while loading student data.
     */
    public static void main(String[] args) throws IOException {
        
        LinkedList<Students> estudiantes = loadStudents();
      Gestion gestion = new Gestion();
      
      gestion.menu(estudiantes);
        
    }
}
