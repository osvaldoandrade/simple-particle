package particles;

import java.applet.Applet;
import java.awt.*;

public abstract class AbstractScene extends Applet implements Runnable
{
	Thread thd;
	int sleep = 30;
    public MainPanel mainPanel;

	@Override
    public abstract void init();

    public final int getDiameter() {
        return mainPanel.getParticleSystem().diameter;
    }

    public final double getWind() {
        return mainPanel.getParticleSystem().wind;
    }

    public final double getGravity() {
        return mainPanel.getParticleSystem().gravity;
    }

    public final int getMaxAge() {
        return mainPanel.getParticleSystem().maxage;
    }

    public final double getSpeed() {
        return mainPanel.getParticleSystem().speed;
    }

    public final ParticleSystem getParticleSystem() {
        return mainPanel.getParticleSystem();
    }

	@Override
    public void start()
	{
		if(thd==null)
		{
            mainPanel = new MainPanel(new ParticleSystem());
            setLayout(new BorderLayout());
            setVisible(true);

            add(mainPanel, BorderLayout.CENTER);

            thd=new Thread(this);
			thd.start();
		}
	}

	@Override
    public final void stop()
	{
		if(thd!=null)
		{
			thd.stop();
			thd=null;
		}
	}

    public void run()
    {
        while(true)
        {
            game();
            mainPanel.repaint();

            try
            {
                Thread.sleep(sleep);
            }
            catch(InterruptedException e){}
        }
    }

   public abstract void game();

    public static int random(int Value) {
        return (int) (Math.random() * Value);
    }

    public static double random(double Value) {
        return (Math.random() * Value);
    }

    public void setSleepTime(int sleepTime) {
        sleep = sleepTime;
    }

}