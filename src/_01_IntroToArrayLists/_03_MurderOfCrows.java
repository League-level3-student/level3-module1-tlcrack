package _01_IntroToArrayLists;


/** Copyright The League of Amazing Programmers 2013-2017
 *    Level 3
 *    A Murder of Crows
 *    Duration=.00
 *    Platform=Eclipse
 *    Type=Recipe
 *    Objectives=n/a
*/

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class _03_MurderOfCrows {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();
    int deadCrows = 0;
    String guiltyCrow = null;
    public static void main(String[] args) {
        _03_MurderOfCrows murderOfCrows = new _03_MurderOfCrows();
        murderOfCrows.initializeCrows();
        murderOfCrows.findTheDiamond();
    }

    private void findTheDiamond() {
        /*
         * 1. One of the Crows has eaten the diamond. You need to search through the stomach of each Crow, 
         * then print the name of the guilty Crow.
         */
        for(int i = 0; i < theMurder.size(); i++ ) {
        	for(int n = 0; n < theMurder.get(i).getStomachContents().size(); n++ ) {
        		if(theMurder.get(i).getStomachContents().get(n).equalsIgnoreCase("diamond")) {
        			guiltyCrow = theMurder.get(i).getName();
        			System.out.println(theMurder.get(i).getName());
        			break;
        		}
        	}
        	if(guiltyCrow!=null) {
        		break;
        	}
        	deadCrows+=1;
        }
        /* 2. How many innocent crows had to die before the diamond was found? */
    	System.out.println(deadCrows + " innocent crows had to die before the diamond was found. " + "\n" + "You did this, " + guiltyCrow);
    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }

}

