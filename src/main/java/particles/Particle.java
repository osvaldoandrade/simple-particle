package particles;

import java.awt.Color;
import java.util.ArrayList;

public class Particle
{
	public double x;
	public double y;
	public double ox;
	public double oy;
	public int diameter;
	public int age = 0;
	public int maxage;
	public double speed;
	public double angle;
    public double density = 1.2;
	public double rotation;
	public Color color;
	public ArrayList<Color> colorList = new ArrayList();
	
	public Particle(Particle particle)
	{
		this.x = particle.x;
		this.y = particle.y;
		this.ox = particle.ox;
		this.oy = particle.oy;
		this.diameter = particle.diameter;
		this.age = particle.age;
		this.speed = particle.speed;
		this.angle = particle.angle;
		this.rotation = particle.rotation;
		this.color = particle.color;
		this.colorList = particle.colorList;
	}
	
	public Particle(double x, double y, int diameter, int maxage, double speed, double angle, Color start, Color end)
	{
		this.x = x;
		this.y = y;
		this.ox = x;
		this.oy = y;
		this.diameter = diameter+1;
		this.maxage = maxage;
		this.speed = speed;
		this.angle = angle;
		this.rotation = angle;
		this.color = start;
		int red = (start.getRed() - end.getRed()) / (maxage + 1);
		int green = (start.getGreen() - end.getGreen()) / (maxage + 1);
		int blue = (start.getBlue() - end.getBlue()) / (maxage + 1);
		for (int i = 0; i < maxage; i++)
			colorList.add(new Color(start.getRed()-(i*red), start.getGreen()-(i*green), start.getBlue()-(i*blue)));
	}
	
	public Particle(double x, double y, int diameter, int maxage, double speed, double angle, double rotation, Color start, Color end)
	{
		this.x = x;
		this.y = y;
		this.ox = x;
		this.oy = y;
		this.diameter = diameter+1;
		this.maxage = maxage;
		this.speed = speed;
		this.angle = angle;
		this.rotation = rotation;
		this.color = start;
		int red = (start.getRed() - end.getRed()) / (maxage + 1);
		int green = (start.getGreen() - end.getGreen()) / (maxage + 1);
		int blue = (start.getBlue() - end.getBlue()) / (maxage + 1);
		for (int i = 0; i < maxage; i++)
			colorList.add(new Color(start.getRed()-(i*red), start.getGreen()-(i*green), start.getBlue()-(i*blue)));
	}
}