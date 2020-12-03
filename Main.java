import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
* This program implements a simple GUI for a trivia game
*
* @author Ioana Guna
* @version December 3rd
*/

class Main {
  public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Game();
      }
    });
  }
}