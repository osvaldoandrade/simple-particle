package particles;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: osvaldoandrade
 * Date: 02/07/12
 * Time: 06:51
 * To change this template use File | Settings | File Templates.
 */
public class ScenePanel extends JPanel {

    private ParticleSystem ps;

    public ScenePanel(ParticleSystem ps) {
        this.ps = ps;
    }

    public ParticleSystem getParticleSystem() {
        return ps;
    }

    @Override
    public void update(Graphics g) {
        Graphics g2;
        Image img;
        int w = (int) (this.getSize().getWidth());
        int h = (int) (this.getSize().getHeight());
        img = createImage(w, h);
        g2 = img.getGraphics();
        paint(g2);

        g.drawImage(img, this.getWidth() / 2 - w / 2, this.getHeight() / 2 - h / 2, w, h, null);
    }


    public double getAngle(double x1, double y1, double x2, double y2) {
        double angle = ((Math.atan2(y1 - y2, x1 - x2)) / (Math.PI / 180) + 90);
        if (angle > 360)
            angle -= 360;
        if (angle < 0)
            angle += 360;
        return angle;
    }

    @Override
    public void paint(Graphics g) {
        ps.drawParticles(g);
    }

}
