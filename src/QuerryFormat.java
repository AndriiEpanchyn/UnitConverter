public class QuerryFormat extends Distance {
    Distance distance;
    String convert_to;

    QuerryFormat (String d, double v, String t){
        super.setUnit(d);
        super.setValue(v);
        this.setConvert_to(t);
    }

    public void setConvert_to(String convert_to) {
        this.convert_to = convert_to;
    }

    public Distance getDistance() {
        return distance;
    }

    public String getConvert_to() {
        return convert_to;
    }


}
