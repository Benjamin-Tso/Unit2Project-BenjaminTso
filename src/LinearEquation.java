import java.text.DecimalFormat;
public class LinearEquation {
    DecimalFormat df = new DecimalFormat("#0.00");
    private String coord1,coord2;
    private double x1,y1,x2,y2;

    public double[] parseCoordinates(String s){
        double[] coords  = { Double.parseDouble(s.substring(1,s.indexOf(","))),Double.parseDouble(s.substring(s.indexOf(",")+1,s.length()-1))};
        return coords;
    }
    public LinearEquation(String c1, String c2){
        coord1 = c1;
        coord2 = c2;
        x1 = parseCoordinates(c1)[0];
        y1 = parseCoordinates(c1)[1];
        x2 = parseCoordinates(c2)[0];
        y2 = parseCoordinates(c2)[1];
    }
    public double[] findSlope(){
        double slope[];
        if (x1==x2) {
            slope = new double[1]; // array length of 1 -> either vertical/horizontal graph
            slope[0] = 0; // value of 0 -> vertical graph
            return slope;
        }
        if (y1==y2){
            slope = new double[1]; // array length of 1 -> either vertical/horizontal graph
            slope[0] = 1; // value of 1-> horizontal graph
            return slope;
        }
        slope = new double[2]; // array length of 2 -> neither vertical/horizontal graph
        slope[0] = (y2-y1)/(x2-x1);
        return slope;
    }
    public String findYIntercept(){
        if (findSlope().length == 1){
            if (findSlope()[0]==0){
                return "Does not Exist"; //  vertical graph either has no or all values for y intercept
            }
            if (findSlope()[0]==1){
                return String.valueOf(y1); // horizontal graph y intercept is the same as all other values
            }
        }
        if (findSlope()[0]*x1 < y1){
            return "+"+(y1-findSlope()[0]*x1);
        }
        return "-" + (findSlope()[0]*x1-y1);
    }
    public double findDistance(){
        return Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
    }
    public String solve(double x){
        if (findSlope().length == 1){ // slope is either horizontal or vertical
            if (findSlope()[0]==0){
                if (x==x1) {
                    return "All real numbers"; //  vertical graph has all y values for one x value
                }
                if (x!=x1){
                    return "does not exist"; // vertical graph only has one possible x value
                }
            }
            if (findSlope()[0]==1){
                return String.valueOf(y1); // horizontal graph all values are the same
            }
        }
        return "with " + x + " as x in " + formEquation() + " y would be " + String.valueOf(findSlope()[0] * x + Double.parseDouble(findYIntercept()));
    }
    public String formEquation() {
        if (findSlope().length == 1) {
            if (findSlope()[0] == 0) {
                return "x = " + x1;
            }
            if (findSlope()[0] == 1) {
                return "y = " + y1;
            }
        }
        return "y="+df.format(findSlope()[0])+" * X + "+df.format(Double.parseDouble(findYIntercept()));
    }
    public String toString(){
        return "Point 1: " + coord1 + "\nPoint 2: " + coord2 + "\nSlope: " + df.format(findSlope()[0]) + "\nY-Intercept: " + df.format(Double.parseDouble(findYIntercept())) +"\nEquation: " + formEquation() + "\nDistance between given points: " + df.format(findDistance());
        }
}
