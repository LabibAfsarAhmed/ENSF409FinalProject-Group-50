public class NutrientType {
    private int itemID;
    private String name;
    private int grains;
    private int fruitsVeggies;
    private int protein;
    private int otherContent;
    private String inputFile;
    private int grainsContent;
    private int fruitsVeggiesContent;
    private int proteinContent;
    private int other;
    private int calories;
  
      public NutrientType(int itemID, String name, int grains, int fruitsVeggies, int protein, int otherContent, 
                          String inputFile, int grainsContent, int fruitsVeggiesContent, int proteinContent, int other, int calories) {
          this.itemID = itemID;
          this.name = name;
          this.grains = grains;
          this.fruitsVeggies = fruitsVeggies;
          this.protein = protein;
          this.otherContent = otherContent;
          this.inputFile = inputFile;
          this.grainsContent = grainsContent;
          this.fruitsVeggiesContent = fruitsVeggiesContent;
          this.proteinContent = proteinContent;
          this.other = other;
          this.calories = calories;
      }
  
      public int getItemID() {
          return this.itemID;
      }
  
      public void setItemID(int itemID) {
          this.itemID = itemID;
      }
  
      public String getName() {
          return this.name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getGrains() {
          return this.grains;
      }
  
      public void setGrains(int grains) {
          this.grains = grains;
      }
  
      public int getFruitsVeggies() {
          return this.fruitsVeggies;
      }
  
      public void setFruitsVeggies(int fruitsVeggies) {
          this.fruitsVeggies = fruitsVeggies;
      }
  
      public int getProtein() {
          return this.protein;
      }
  
      public void setProtein(int protein) {
          this.protein = protein;
      }
  
      public int getOtherContent() {
          return this.otherContent;
      }
  
      public void setOtherContent(int otherContent) {
          this.otherContent = otherContent;
      }
  
      public String getInputFile() {
          return this.inputFile;
      }
  
      public void setInputFile(String inputFile) {
          this.inputFile = inputFile;
      }
  
      public int getGrainsContent() {
          return this.grainsContent;
      }
  
      public void setGrainsContent(int grainsContent) {
          this.grainsContent = grainsContent;
      }
  
      public int getFruitsVeggiesContent() {
          return this.fruitsVeggiesContent;
      }
  
      public void setFruitsVeggiesContent(int fruitsVeggiesContent) {
          this.fruitsVeggiesContent = fruitsVeggiesContent;
      }
  
      public int getProteinContent() {
          return this.proteinContent;
      }
  
      public void setProteinContent(int proteinContent) {
          this.proteinContent = proteinContent;
      }
  
      public int getOther() {
          return this.other;
      }
  
      public void setOther(int other) {
          this.other = other;
      }
  
      public int getCalories() {
          return this.calories;
      }
  
      public void setCalories(int calories) {
          this.calories = calories;
      }    
  }