import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class COSCUPReThink extends PApplet {

PImage logo;

boolean record;

public void setup(){
  //size(1280, 800);
  
  background(245, 252, 245);
  logo = loadImage("coscuplogo.png");
  logo.resize(logo.width/20, logo.height/20);
  
  noCursor();  
}

public void draw(){
  if (record) {
    // Note that #### will be replaced with the frame number. Fancy!
    beginRecord(PDF, "frame-####.pdf"); 
  }
  background(245, 252, 245);
  stroke(59, 156, 96, 40);
  for(int i = width/16; i< width/4 ; i+=6) line(i, 0, mouseX, mouseY);
  for(int i = width/8 - 3; i< width/8*3 ; i+=6) line(i, 0, mouseX, mouseY);
  stroke(59, 156, 96, 20);
  for(int i = height/16; i< height/4 ; i+=6) line(width, height - i , mouseX, mouseY);
  for(int i = height/8 - 3; i< height/8*3 ; i+=6) line(width, height - i, mouseX, mouseY);
  stroke(59, 156, 96, 80);
  for(int i = width/16; i< width/16*4 ; i+=6) line(i, height, mouseX, mouseY);
  for(int i = width/16*2 -3 ; i< width/16*6 ; i+=6) line(i, height, mouseX, mouseY);
  noStroke();
  for(int i = 0; i <= 20; i++ ){
    fill(245, 252, 245, 5*i);
  ellipse(mouseX , mouseY  , logo.width/8*i, logo.width/8*i);}
  image(logo, mouseX - logo.width/2, mouseY - logo.height/2);
   if (record) {
    endRecord();
    }
  }


public void keyPressed() {
  if (key == 'r') {
   record = true;
  } else {
  record = false;
  
  }
}
  public void settings() {  fullScreen(P2D , SPAN);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "COSCUPReThink" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
