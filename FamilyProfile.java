public class FamilyProfile {
    private int adultMale;
    private int adultFemale;
    private int childrenUnderEight;
    private int childrenOverEight;
    private boolean mobility;

    public FamilyProfile(int adultMale, int adultFemale,  int childrenUnderEight, int childrenOverEight, boolean mobility) {
        this.adultMale = adultMale;
        this.adultFemale = adultFemale;
        this.childrenUnderEight = childrenUnderEight;
        this.childrenOverEight = childrenOverEight;
        this.mobility = mobility;
    }

    public int getAdultMale() {
        return adultMale;
    }

    public int getAdultFemale() {
        return adultFemale;
    }

    public int getChildrenUnderEight() {
        return childrenUnderEight;
    }

    public int getChildrenOverEight() {
        return childrenOverEight;
    }

    public boolean isMobility() {
        return mobility;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (adultMale > 0)
            sb.append(" ").append(adultMale).append(" Adult Male,");
        if (adultFemale > 0)
            sb.append(" ").append(adultFemale).append(" Adult Female,");
        if (childrenUnderEight > 0)
            sb.append(" ").append(childrenUnderEight).append(" Child under 8,");
        if (childrenOverEight > 0)
            sb.append(" ").append(childrenOverEight).append(" Child over 8,");
        if (mobility)
            sb.append(" Weekly Service Needed,");
        
        return sb.toString().replaceAll(",$", "");
    }

}
