PImage logo;
import processing.pdf.*;
boolean record;

void setup(){
  //size(1280, 800); //<>//
  fullScreen(P2D , SPAN);
  background(245, 252, 245);
  logo = loadImage("coscuplogo.png");
  logo.resize(logo.width/20, logo.height/20);
  smooth();
  noCursor();  
}

void draw(){
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


void keyPressed() {
  if (key == 'r') {
   record = true;
  } else {
  record = false;
  
  }
}
