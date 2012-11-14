package particles;

import java.awt.*;

public class MyApplet extends AbstractScene {


    @Override
    public void init() {
        setCursor(Cursor.getPredefinedCursor(1));
    }

    @Override
    public void run() {
        super.run();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void start() {
        super.start();
        getParticleSystem().setup(0.2, 0.2, 10, 80, 2, Color.BLACK, Color.BLACK);
        mainPanel.update(mainPanel.getGraphics());

    }

    @Override
    public void game() {


        if  (getParticleSystem().getTheme() == 1) {
            for(int j=0; j< random(600); j++) {
                getParticleSystem().addParticle(random(this.getSize().getWidth()), random(this.getSize().getHeight()), random(15), random(100), random(2), random(360), Color.RED, Color.BLUE);
            }
            for(int j=0; j< random(600); j++) {
                getParticleSystem().addParticle(random(this.getSize().getWidth()), random(this.getSize().getHeight()), random(15), random(100), random(2), random(360), Color.GREEN, Color.YELLOW);
            }
            for(int j=0; j< random(600); j++) {
                getParticleSystem().addParticle(random(this.getSize().getWidth()), random(this.getSize().getHeight()), random(15), random(100), random(2), random(360), Color.PINK, Color.ORANGE);
            }
        } else if(getParticleSystem().getTheme() == 2){
            for(int j=0; j< random(1500); j++) {
                getParticleSystem().gravity = 0;
                getParticleSystem().addParticle(5, random(this.getSize().getHeight()), 4,200, random(2),90 , Color.BLUE, Color.DARK_GRAY);
            }
            for(int j=0; j< random(600); j++) {
                getParticleSystem().gravity = 0.2;
                getParticleSystem().addParticle(50, random(this.getSize().getHeight()), 6, 200, random(2), 80, Color.GRAY, Color.WHITE);
            }
            for(int j=0; j< random(600); j++) {
                getParticleSystem().gravity = 0;
                getParticleSystem().addParticle(100, random(this.getSize().getHeight()), 15, 200, random(2), 50, Color.WHITE, Color.BLUE);
            }
        } else{
            int x = (int) this.getSize().getWidth() / 2;
            int y = (int) this.getSize().getHeight() - 50;

            for (int j = 0; j < random(800); j++) {
                getParticleSystem().addParticle(x, y, 90);
            }
        }

        getParticleSystem().moveParticles();

    }

}