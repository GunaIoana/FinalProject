/**
* This program implements a simple GUI for a trivia game
*
* @author Ioana Guna
* @version December 3rd
*/


class Question {
  String questionText;
  String answerOne;
  String answerTwo;
  String answerThree;
  String answerFour;
  int correctAns;
  int points;

  //Question constructor method with paramenters
  Question (String aQuestionText, String aAnswerOne, String aAnswerTwo, String aAnswerThree, String aAnswerFour, int aCorrectAns, int aPoints) {
    questionText = aQuestionText;
    answerOne = aAnswerOne;
    answerTwo = aAnswerTwo;
    answerThree = aAnswerThree;
    answerFour = aAnswerFour;
    correctAns = aCorrectAns;
    points = aPoints;
  }

  /**
  * Accesor method for the text question
  * @return the text question
  */
  String getQuestionText() {
    return questionText;
  }

  /**
  * Accesor method for answer one
  * @return the first answer
  */
  String getAnswerOne() {
    return answerOne;
  }

  /**
  * Accesor method for answer two 
  * @return the second answer
  */
  String getAnswerTwo() {
    return answerTwo;
  }

  /**
  * Accesor method for answer three
  * @return the third answer
  */
  String getAnswerThree() {
    return answerThree;
  }

  /**
  * Accesor method for answer four
  * @return the fourth answer
  */
  String getAnswerFour() {
    return answerFour;
  }

  /**
  * Accesor method for the correct answer
  * @return the correct answer
  */
  int getCorrectAns() {
    return correctAns;
  }

  /**
  * Accesor method for the accumulated points
  * @return the points accumulated
  */
  int getPoints() {
    return points;
  }
}