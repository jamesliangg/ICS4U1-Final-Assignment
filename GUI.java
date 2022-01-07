import javax.swing.JOptionPane; //fancy GUI

public class GUI{
  public static int articleChoice(Network[] articleArray){
    String articleChoices[] = new String[articleArray.length];
    for (int temp = 0; temp < articleArray.length; temp++){
      articleChoices[temp] = articleArray[temp].getArticleInfo().getTitle();
    }
    String article = (String) JOptionPane.showInputDialog(null, "Pick an article.", "Article Options", JOptionPane.QUESTION_MESSAGE, null, articleChoices, articleChoices[0]);
    for (int temp = 0; temp < articleArray.length; temp++){
      if (article == articleArray[temp].getArticleInfo().getTitle())
      return temp;
    }
    return 0;
  }
}