package Other;
public class P3WindowToViewport {
    private double minX = 0;
    private double minY = 0;
    private double winWidth = 0;
    private double winHeight = 0;
    private int vpWidth = 0;
    private int vpHeight = 0;

    /**
     * 
     * @param refPoint Referenzpunkt
     * @param winWidth  Größe der Abbildung
     * @param winHeight Größe der Abbildung
     * @param vpWidth   Breite des JPanels
     * @param vpHeight  Höhe des JPanels
     */
    public P3WindowToViewport(double[] refPoint, double winWidth,
            double winHeight, int vpWidth, int vpHeight) {
        minX = refPoint[0];
        minY = refPoint[1];
        this.winHeight = winHeight;
        this.winWidth = winWidth;
        this.vpHeight = vpHeight;
        this.vpWidth = vpWidth;
    }

    // Map point
    private double[] map(double[] x) {
        return new double[] { vpWidth / winWidth * (x[0] - minX),
                vpHeight / winHeight * (minY - x[1]) + vpHeight };
    }

    // Round double value
    private int[] round(double[] x) {
        return new int[] { (int) Math.round(x[0]), (int) Math.round(x[1]) };
    }

    // Combine map and round
    public int[] mapAndRound(double[] x) {
        return round(map(x));
    }
    
}
