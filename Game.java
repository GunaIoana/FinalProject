import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Game implements ActionListener {
  JFrame frame;
  JLabel welcomeUser;
  JTextField userName;
  JButton startGame;
  JLabel question;
  JButton optionOne;
  JButton optionTwo;
  JButton optionThree;
  JButton optionFour;
  JLabel score;
  JLabel yesno;
  JButton nextQuestion;
  int points = 0;
  int index = -1;

  ArrayList<Question> triviaQuestions = new ArrayList<Question>();

  Game() {
    frame = new JFrame("Ioana's Trivia Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(300, 300);
    userName = new JTextField(13);
    userName.setActionCommand("my TF");
    welcomeUser = new JLabel ("What's your name?");
    startGame = new JButton("Start");

    question = new JLabel("");
    optionOne = new JButton("");
    optionTwo = new JButton("");
    optionThree = new JButton("");
    optionFour = new JButton("");
    nextQuestion = new JButton("");
    score = new JLabel("");
    yesno = new JLabel("");

    optionOne.addActionListener(this);
    optionTwo.addActionListener(this);
    optionThree.addActionListener(this);
    optionFour.addActionListener(this);
    nextQuestion.addActionListener(this);
    userName.addActionListener(this);
    startGame.addActionListener(this);

    frame.add(welcomeUser);
    frame.add(userName);
    frame.add(startGame);

    frame.setVisible(true);

    String questionText = "";
    String answerOne = "";
    String answerTwo = "";
    String answerThree = "";
    String answerFour = "";
    int correctAns = 0;
    int points = 0; 
    try {
      FileReader myFile;
      myFile = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(myFile);

      while(reader.ready()) {
        questionText = reader.readLine();
        answerOne = reader.readLine();
        answerTwo = reader.readLine();
        answerThree = reader.readLine();
        answerFour = reader.readLine();
        correctAns = Integer.parseInt(reader.readLine());
        points = Integer.parseInt(reader.readLine());

        Question theQuestion = new Question(questionText, answerOne, answerTwo, answerThree, answerFour, correctAns, points);

        triviaQuestions.add(theQuestion);
      }
      reader.close();
    }

    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
      }
  }

  void hideQuestionContent() {
    question.setVisible(false);
    optionOne.setVisible(false);
    optionTwo.setVisible(false);
    optionThree.setVisible(false);
    optionFour.setVisible(false);
  }

  void showQuestionContent() {
    question.setVisible(true);
    optionOne.setVisible(true);
    optionTwo.setVisible(true);
    optionThree.setVisible(true);
    optionFour.setVisible(true);
  }

  void endGame() {
    try {
      String result = "User name: " + userName.getText() + "\n" + "Score: " + points;
      File file = new File("scores.txt");
      if(file.exists()) {
        file.delete();
      }
      file.createNewFile();

      FileWriter fileWriter = new FileWriter(file.getName(), true);
      BufferedWriter bw = new BufferedWriter(fileWriter);
      bw.write(result);
      bw.close();
    } catch(IOException e) {
      e.printStackTrace();
    }

    frame.dispose();
  }

  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Start")) {
      String name = userName.getText();
      String welcomeString = "Welcome " + name + "!";
      welcomeUser.setText(welcomeString);
      welcomeUser.setForeground(Color.MAGENTA);
      userName.setVisible(false);
      startGame.setVisible(false);

      index++;

      frame.add(question);
      frame.add(optionOne);
      frame.add(optionTwo);
      frame.add(optionThree);
      frame.add(optionFour);
      frame.add(nextQuestion);
      frame.add(score);
      frame.add(yesno);
    }
    
    if(ae.getSource() == this.nextQuestion || index == 0){
      question.setText(triviaQuestions.get(index).getQuestionText());
      optionOne.setText(triviaQuestions.get(index).getAnswerOne());
      optionTwo.setText(triviaQuestions.get(index).getAnswerTwo());
      optionThree.setText(triviaQuestions.get(index).getAnswerThree());
      optionFour.setText(triviaQuestions.get(index).getAnswerFour());
      nextQuestion.setText("<html><font color='green' size='6'>Next Question</font></html>");
      score.setText("Score " + points);
      showQuestionContent();
      index++;
      if(index == triviaQuestions.size()) {
        endGame();
      }
    } else if(ae.getSource() == this.optionOne && triviaQuestions.get(index-1).getCorrectAns() == 1 ||
              ae.getSource() == this.optionTwo && triviaQuestions.get(index-1).getCorrectAns() == 2 ||
              ae.getSource() == this.optionThree && triviaQuestions.get(index-1).getCorrectAns() == 3 ||
              ae.getSource() == this.optionFour && triviaQuestions.get(index-1).getCorrectAns() == 4) {
      points = points + triviaQuestions.get(index-1).getPoints();
      hideQuestionContent();
      yesno.setText("Correct!");
      score.setText("Score " + points);
    } else {
      hideQuestionContent();
      yesno.setText("Wrong!");
    }
  }
}