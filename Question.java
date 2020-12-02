class Question {
  String questionText;
  String answerOne;
  String answerTwo;
  String answerThree;
  String answerFour;
  int correctAns;
  int points;

  Question (String aQuestionText, String aAnswerOne, String aAnswerTwo, String aAnswerThree, String aAnswerFour, int aCorrectAns, int aPoints) {
    questionText = aQuestionText;
    answerOne = aAnswerOne;
    answerTwo = aAnswerTwo;
    answerThree = aAnswerThree;
    answerFour = aAnswerFour;
    correctAns = aCorrectAns;
    points = aPoints;
  }

  String getQuestionText() {
    return questionText;
  }

  String getAnswerOne() {
    return answerOne;
  }

  String getAnswerTwo() {
    return answerTwo;
  }

  String getAnswerThree() {
    return answerThree;
  }

  String getAnswerFour() {
    return answerFour;
  }

  int getCorrectAns() {
    return correctAns;
  }

  int getPoints() {
    return points;
  }
}