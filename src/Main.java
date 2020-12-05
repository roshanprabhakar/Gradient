import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        display(renderedGradient(new Gradient(new Color(42, 42, 184), new Color(188, 209, 31))));
    }

    public static BufferedImage renderedGradient(Gradient g) {
        int height = 10;
        BufferedImage image = new BufferedImage((int) g.gradientLength, height, BufferedImage.TYPE_INT_RGB);
        for (int r = 0; r < (int) g.gradientLength; r++) {
            for (int c = 0; c < height; c++) {
                image.setRGB(r, c, new Color((int) g.redSamples[r], (int) g.greenSamples[r], (int) g.blueSamples[r]).getRGB());
            }
        }
        return image;
    }

    public static void display(BufferedImage image) {
        JFrame frame = new JFrame("image");
        frame.setLocation(new Point(100, 100));
        frame.setMinimumSize(new Dimension(1000, 500));
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
