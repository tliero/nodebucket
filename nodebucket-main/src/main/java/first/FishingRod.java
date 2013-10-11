package first;

public class FishingRod implements FishingEquipment {
  
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void use() {
    System.out.println("  Using fishing rod");
  }
}
