/*
Matt Coover
CS2050
HW 4
*/

package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mattc
 */
public class HW4 {
//String [] javas;
String [] bubbles;
long WCTimeBubs;
long CPUTimeBubs;
long WCTimeJava;
long CPUTimeJava;

    public static void main(String[] args) {
        
        HW4 good;
        good = new HW4();
        //String [] javas = good.bubbles.clone();
        
        String inputFile = good.inputFile();
        
    try {
        good.withFile(inputFile);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(HW4.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        String [] javas = good.bubbles.clone();
        
        clockBubbles(good);
        
        clockJava(good, javas);
        
        good.output(inputFile);
    }

    private String inputFile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Scanner scnr = new Scanner(System.in);
        String file;
        System.out.println("Enter the file name to be sorted and timed now. "
                + "(Note: be sure to include '.txt')");
        return file = scnr.next();
    }
    
//@SuppressWarnings("empty-statement")
    private void withFile(String nasty) throws FileNotFoundException {
            URL url = getClass().getResource(nasty);
            File file = new File(url.getPath());
            Scanner scnr = new Scanner(file);
            int count = 0;
            
            while (scnr.hasNext()){
                String word = scnr.next().replaceAll("[^a-zA-Z0-9]+", "").trim();
                if(word.length() != 0){
                    count++;
                } // end if
            } // end while
            
            bubbles = new String[count];
            int i = 0;
            //Go through file again and assign words to elements
            scnr = new Scanner(file);
            while (scnr.hasNext()){
                
                String word = scnr.next().replaceAll("[^a-zA-Z0-9]+", "").trim();
                if(word.length() != 0){
                    bubbles[i++] = word;
                }
            }
    } // end method

    private static void clockBubbles(HW4 good) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long startWCB = System.currentTimeMillis();
        long startCPUB = System.nanoTime();
        good.bubbleSort(good.bubbles);
        long endWCB = System.currentTimeMillis();
        long endCPUB = System.nanoTime();
        good.WCTimeBubs = endWCB - startWCB;
        good.CPUTimeBubs = endCPUB - startCPUB;
        
    }

    private static void clockJava(HW4 good, String[] javas) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long startWallClockJava = System.currentTimeMillis();
        long startCPUTimeJava = System.nanoTime();
        
        //HHString[] java = null;
        good.javaSort(javas);
        
        long endWallClockJava = System.currentTimeMillis();
        long endCPUTimeJava = System.nanoTime();
        
        good.CPUTimeJava = endCPUTimeJava - startCPUTimeJava;
        good.WCTimeJava = endWallClockJava - startWallClockJava;
    
    }

    private void output(String inputFile) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Filename: " + inputFile);
        System.out.println("Number of Words: " + bubbles.length);
        System.out.println("Wall Clock: ");
        System.out.printf("%15s%12d\n", "Bubble sort: ", WCTimeBubs );
        System.out.printf("%17s%7d\n", "Internal sort: ", WCTimeJava);
        System.out.println("\nCPU Time: ");
        System.out.printf("%15s%17d\n","Bubble sort: ", CPUTimeBubs);
        System.out.printf("%17s%12d\n", "Internal sort: ", CPUTimeJava);
    
    }

    private void bubbleSort(String[] rando) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String place;
        int n = rando.length;
        for(int i = 0; i < n; i++){
            for(int j = 1; j<(n-i);j++){
                if(rando[j-1].compareTo(rando[j]) > 0){
                    place = rando[j-1];
                    rando[j-1] = rando[j];
                    rando[j] = place;
                } // end if
            } // end for
        } // end for
    } // end method

    private void javaSort(String[] deuce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Arrays.sort(deuce);
    }
    
} // end class