import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle[] Trippy;


//OddballParticle[] Cai;//your code here
public void setup()
{
	size(500,500);
	Trippy = new Particle [1000];
	for(int i = 0; i< Trippy.length; i++){
		Trippy[i] = new NormalParticle();
		
	}
	Trippy[1] = new OddballParticle();
	
}
public void draw()
{
		Trippy[1].move();
		Trippy[1].show();

	background(0);

	for (int i = 0; i< Trippy.length; i++){
		
		Trippy[i].move();
		Trippy[i].show();
	} 

	//fill(250,250,250); 
	//rect(0,250,500,250);
	//your code here
}


class NormalParticle implements Particle
{
	double X, Y, Speed, Angle;
	NormalParticle(){
		X =  250;
		Y =  250;
		Speed = Math.random() * 5;
		Angle = Math.random() * 180;
		

	}
	public void move(){
		double randomloc = Math.random()*20;
		X = X + Math.sin(Angle) * Speed;
		Y = Y + Math.cos(Angle) * Speed;
		/*if(X <0 || X> 500 || Y <0 || Y>500){
			X = 250+-randomloc;
			Y = 250+-randomloc;
		}*/
		if(X <0 || X> 500 || Y <0 || Y>500){
			X = 250;
			Y = 250;
		}
	}
	public void show(){
		double A = Math.random()*200;
		double B = Math.random()*200;
		double C = Math.random()*200;
		fill((float)A, (float)B, (float)C);
		ellipse((float)X, (float)Y, 5, 5);
	}
	//your code here
}


class OddballParticle implements Particle
{
	double OddX, OddY, OddSpeed, OddAngle;
	OddballParticle(){
		OddX = 250;
		OddY = 250;
		OddSpeed = Math.random()* 20;
		OddAngle = Math.random() * 360;
	}
	public void move(){
		OddX = OddX + Math.cos(OddAngle) * OddSpeed;
		OddY = OddY + Math.sin(OddAngle) * OddSpeed;
		if(OddX <0 || OddX> 500 || OddY <0 || OddY>500){
			OddX = 250;
			OddY = 250;
		}
		OddAngle++;
	}
	public void show(){
 		fill(255,255,255);
 		ellipse((float)OddX, (float)OddY, 20,20);
	}//your code here
}

interface Particle
{
	public void show();
	public void move();//your code here
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
