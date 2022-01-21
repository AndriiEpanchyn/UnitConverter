public class Distance {
    private String unit;
   private Double value;

    public Distance() {
        this.unit = "";
        this.value=null;
    }
    public Distance(String unit, Double v){
        this.unit=unit;
        this.value=v;
    }

    public String getUnit() {
        return unit;
    }

    public Double getValue() {
        return value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
