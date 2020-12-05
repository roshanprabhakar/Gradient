import java.awt.*;

public class Gradient {

    public static double increment = 0.5; //universal unit of length for measuring gradient length

    public double length;
    public double gradientLength;

    public double[] redSamples, blueSamples, greenSamples; //length/increment samples taken

    public Gradient(Color c1, Color c2) {
        this.length = length(c1, c2);
        this.gradientLength = (int) (length / increment);

        redSamples = new double[(int) gradientLength];
        greenSamples = new double[(int) gradientLength];
        blueSamples = new double[(int) gradientLength];

        for (int t = 0; t < gradientLength; t++) {
            redSamples[t] = (double)(c2.getRed() - c1.getRed()) / gradientLength * t + c1.getRed();
            greenSamples[t] = (double)(c2.getGreen() - c1.getGreen()) / gradientLength * t + c1.getGreen();
            blueSamples[t] = (double)(c2.getBlue() - c1.getBlue()) / gradientLength * t + c1.getBlue();
        }

    }

    public static double length(Color color1, Color color2) {
        double dr = color2.getRed() - color1.getRed();
        double dg = color2.getGreen() - color1.getGreen();
        double db = color2.getBlue() - color1.getBlue();
        return Math.sqrt(dr * dr + dg * dg + db * db);
    }
}
