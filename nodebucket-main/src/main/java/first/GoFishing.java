package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GoFishing {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("fisher.xml");
    Fisher fisher = (Fisher) context.getBean("fisher");
    fisher.goFishing();
    
    Performer performer = (Performer) context.getBean("juggler");
    performer.perform();
  }
}

