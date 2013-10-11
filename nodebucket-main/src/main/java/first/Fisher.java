package first;

public class Fisher {
  
  private int height;
  private FishingEquipment equipment;

  public Fisher() {
    // Warum benötigt man den Standard-Konstruktor für AOP? Warum werden zwei Exemplare von 'Fisher' erzeugt?
    System.out.println("Fisher: Waking up");
  }

  public Fisher(int height) {
    this.height = height;
    System.out.println("Fisher: Howdy, I'm a fisher and I'm " + height + " cm tall");
  }

  public void setEquipment(FishingEquipment equipment) {
    System.out.println("Fisher: Taking equipment " + equipment.getName());
    this.equipment = equipment;
  }

  public void goFishing() {
    System.out.println("Fisher: Goin' fishing!");
    equipment.use();
  }

  public void searchForLicense() {
    System.out.println("Fisher: 'Heck, where in the world is this license...'");
  }

  public void cleanEquipment() {
    System.out.println("Fisher: Cleaning fishing equipment...");
  }
}
