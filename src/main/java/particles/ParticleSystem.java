package particles;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

public class ParticleSystem extends ArrayList<Particle>
{
	public double gravity;
	public double wind;
    public int diameter;
    public int maxage;
    public double speed;
    public double density = 2;
    private int theme;

    Color start = Color.BLACK;
    Color end = Color.darkGray;

	public ParticleSystem()
	{
        this(0.2, 0.2, 4, 80, 2, Color.BLACK, Color.DARK_GRAY);
	}

    public ParticleSystem(double gravity, double wind, int diameter, int maxage, double speed, Color start, Color end) {
        this.gravity = gravity;
        this.wind = wind;
        this.diameter = diameter;
        this.maxage = maxage;
        this.speed = speed;
        this.start = start;
        this.end = end;
        this.theme = 0;
    }

    public synchronized  int getTheme() {
        return this.theme;
    }
    public synchronized void setTheme(int theme) {
        this.theme = theme;
    }

    public void setup(double gravity, double wind, int diameter, int maxage, double speed, Color start, Color end){
        this.gravity = gravity;
        this.wind = wind;
        this.diameter = diameter;
        this.maxage = maxage;
        this.speed = speed;
        this.start = start;
        this.end = end;
    }

	public void addParticle(Particle p)
	{
		this.add(p);
	}

	public void addParticle(double x, double y, int diameter, int maxage, double speed, double angle, Color start, Color end)
	{
		this.diameter = diameter;
        this.maxage = maxage;
        this.speed = speed;
        this.start = start;
        this.end = end;

        this.add(new Particle(x, y, diameter, maxage, speed, angle, start, end));
	}

    public void addParticle(double x, double y, double angle, Color start, Color end) {
        this.addParticle(x,y,diameter,maxage,speed, angle, start, end);
    }

    public void addParticle(double x, double y, double angle) {
        this.addParticle(x, y, angle, start,end);
    }
	
	public void moveParticles()
	{
		for ( int j = 0; j < this.size(); ++j )
		{
			Particle p = this.get(j);
			if (p.age < p.maxage)
			{
				p.x += p.speed * (Math.cos(p.angle * (Math.PI / 180))) + (wind * random(1.2))* p.age;
				p.y += p.speed * (Math.sin(p.angle * (Math.PI / 180))) + gravity * (p.density - density) * p.age ;
				p.age++;
				p.color = (Color)p.colorList.remove(0);
				this.set(j, p);
			}
			else
			this.remove(j);
		}
	}

    public static double random(double Value)
    {
        return (Math.random() * Value);
    }
	
	public void moveParticlesO()
	{
		for ( int j = 0; j < this.size(); ++j )
		{
			Particle p = this.get(j);
			if (p.age < p.maxage)
			{
				p.ox = p.x;
				p.oy = p.y;
				double piRad = (Math.PI / 180);
				p.x += p.speed * (Math.cos(p.angle *piRad)) + wind * p.age;
				p.y += p.speed * (Math.sin(p.angle *piRad)) + gravity * p.age;
				p.age++;
				p.color = (Color)p.colorList.remove(0);
				this.set(j, p);
			}
			else
			this.remove(j);
		}
	}
	
	public void drawParticles(Graphics g)
	{
		for ( int i = 0; i < this.size(); ++i )
		{
			Particle p = this.get(i);
			g.setColor(p.color);
			g.fillOval ((int)(p.x), (int)(p.y), (int)(p.diameter), (int)(p.diameter));
		}
	}
	
	public void drawParticlesO(Graphics g)
	{
		for ( int i = 0; i < this.size(); ++i )
		{
			Particle p = this.get(i);
			g.setColor(p.color);
			g.drawLine((int)p.ox, (int)p.oy, (int)p.x, (int)p.y);
			g.fillOval ((int)p.x, (int)p.y, p.diameter, p.diameter);
		}
	}
	
	public void drawParticles(Graphics g, Image img, Component comp)
	{
		for ( int i = 0; i < this.size(); ++i )
		{
			Particle p = this.get(i);
			AffineTransform at = new AffineTransform();
			Graphics2D g2d = (Graphics2D)g;
			at.translate((p.x-img.getWidth(comp)/2)-500,(p.y-img.getHeight(comp)/2)-500);
			at.rotate(p.rotation*(Math.PI/180), img.getWidth(comp)/2, img.getHeight(comp)/2);
			g2d.drawImage(img, at, comp);
		}
	}
}