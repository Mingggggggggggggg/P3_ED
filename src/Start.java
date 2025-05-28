import FMainWindow.MainWindow;

// discData gesammelt aus 50 Würfelwürfen in Google: https://g.co/kgs/kwKWKJx
// contData aus: https://www.wetter.com/wetter_aktuell/rueckblick/deutschland/wilhelmshaven/DE0011631.html?sid=E043&timeframe=30d

public class Start {
    public static void main(String[] args) throws Exception {
        MainWindow window = new MainWindow("Main");
        window.setVisible(true);
    }
}