import javax.swing.*;  
import java.util.ArrayList;

public class GUI{
  public static int articleChoice(ArrayList<Network> articleArray){
    String articleChoices[] = new String[articleArray.size()];
    for (int temp = 0; temp < articleArray.size(); temp++){
      articleChoices[temp] = articleArray.get(temp).getArticleInfo().getTitle();
    }
    String article = (String) JOptionPane.showInputDialog(null, "Pick an article.", "Article Options", JOptionPane.QUESTION_MESSAGE, null, articleChoices, articleChoices[0]);
    for (int temp = 0; temp < articleArray.size(); temp++){
      if (article == articleArray.get(temp).getArticleInfo().getTitle())
      return temp;
    }
    return 0;
  }
  public static void articleSplashScreen(ArrayList<Network> articleArray, int articleNum){
    JFrame f = new JFrame("Article Information");
    JLabel l1;
    l1 = new JLabel(articleArray.get(articleNum).getArticleInfo().getTitle());
    l1.setBounds(50,50,200,30);
    f.add(l1);
    f.setSize(300,300);
    f.setLayout(null);
    f.setVisible(true);
  }
}