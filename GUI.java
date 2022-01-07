import javax.swing.*;  

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
  public static void articleSplashScreen(){
    JFrame f = new JFrame("Article Information");
    JLabel l1;
    l1 = new JLabel("Test Title");
    l1.setBounds(50,50,100,30);
    f.add(l1);
    f.setSize(300,300);
    f.setLayout(null);
    f.setVisible(true);
  }
}