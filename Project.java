
import javax.media.opengl.GL2; 
import javax.media.opengl.GLAutoDrawable; 
import javax.media.opengl.GLCapabilities; 
import javax.media.opengl.GLEventListener; 
import javax.media.opengl.GLProfile; 
import javax.media.opengl.awt.GLCanvas; 

import javax.swing.JFrame; 

import com.jogamp.opengl.util.FPSAnimator; 
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.abs;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import javax.media.opengl.GLException;

public class Project implements GLEventListener { 
     //for angle of rotation
//    double angle=0;
    double xc=0;
    double yc=1.54;
    double m=10;
    double xmin=0;
    double ymin=0;
    double zoominval=0;
    double zoomoutval=0;
    int end=0;
      double m1=0;
      double m2=0;
      double n1=0;
      double n2=0;
   FPSAnimator animator;
FPSAnimator anim;   
   static int count=-1;
   int zoomin=0;
   int zoomout=0;
    
   GLAutoDrawable draw=null;
    public static void main(String[] args) 
    {

         Scanner sc=new Scanner(System.in);
         final GLProfile profile  = GLProfile.get(GLProfile.GL2 ); 
         GLCapabilities capabilities  = new GLCapabilities( profile );
         final GLCanvas glcanvas = new GLCanvas( capabilities); 
         Project l = new Project(); 
         glcanvas.addGLEventListener( l ); 
         final JFrame frame = new JFrame ("Icecream");
         glcanvas.setSize( 1000, 1000 );  
         frame.getContentPane().add( glcanvas ); 
         frame.setSize(frame.getContentPane() .getPreferredSize());                 
         frame.setVisible( true ); 
         final FPSAnimator a = new FPSAnimator(glcanvas, 400,false);
       //  final FPSAnimator anim = new FPSAnimator(glcanvas, 300,false);
         l.setAnimator(a);
         a.start();
        // anim.start();
         
    }
   public void input()
   {
       Scanner sc=new Scanner(System.in);
        System.out.println("type co-ordinates of the line");
         System.out.println("x1= ");
         m1=sc.nextDouble();
         System.out.println("y1= ");
         n1=sc.nextDouble();
           System.out.println("x2= ");
         m2=sc.nextDouble();
          System.out.println("y2= ");
         n2=sc.nextDouble();
         m=(n2-n1)/(m2-m1);
   }
   public void setDrawable(GLAutoDrawable d)
   {
       draw=d;
   }
  public void drawcircle(double xc,double yc,double r)
  {
       GLAutoDrawable drawable=getDrawable();
        final GL2 gl = drawable.getGL().getGL2();
        xc=xc;
        yc=yc;
        gl.glBegin (GL2.GL_POINTS);

          double x=0;
          double y=r;
          // System.out.println(r);
           gl.glVertex2d(y/(r*4)+xc,x/(r*4)+yc);
            gl.glVertex2d(-y/(r*4)+xc,-x/(r*4)+yc);
            gl.glVertex2d(x/(r*4)+xc,y/(r*4)+yc);
            gl.glVertex2d(-x/(r*4)+xc,-y/(r*4)+yc);
            gl.glVertex2d(x/(r*4)+xc,-y/(r*4)+yc);
            gl.glVertex2d(-x/(r*4)+xc,y/(r*4)+yc);
            gl.glVertex2d(y/(r*4)+xc,-x/(r*4)+yc);
            gl.glVertex2d(-y/(r*4)+xc,x/(r*4)+yc);
          double d=5-(4*r);
          while(x<y)
          {
             
              if(d<0)
              {//de
                  d=d+((2*x+3)*4);
                
                  //x++;
                  x=x+.25;
                  //System.out.println("de");
              }
              else
              {//se
                  d=d+((2*x-2*y+5)*4);
                  x=x+.25;
                  y=y-.25;
                
              }
//              if(x==y)
//              { 
//                  System.out.println("hh"+x);
//                  System.out.println(y);   
//              }
            gl.glVertex2d(y/(r*4)+xc,x/(r*4)+yc);
            gl.glVertex2d(-y/(r*4)+xc,-x/(r*4)+yc);
            gl.glVertex2d(x/(r*4)+xc,y/(r*4)+yc);
            gl.glVertex2d(-x/(r*4)+xc,-y/(r*4)+yc);
            gl.glVertex2d(x/(r*4)+xc,-y/(r*4)+yc);
            gl.glVertex2d(-x/(r*4)+xc,y/(r*4)+yc);
            gl.glVertex2d(y/(r*4)+xc,-x/(r*4)+yc);
            gl.glVertex2d(-y/(r*4)+xc,x/(r*4)+yc);
          }
          gl.glEnd();
  }

       double c=0;
       double x1=0;
       double x2=0;
       double y1=0;
       double y2=0;
       double ycc=3.25;//2.38;
       double ye=0;
          private float angle;
        double rotate=0;
  @Override
   public void display( GLAutoDrawable drawable ) 
   {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        setDrawable(drawable);
     if(count<=232)
     {
        drawcoan();
       
        gl.glColor3d(1.0, 1.0, 1.0);
        drawCircle(xc,yc,.22,0);
        gl.glColor3d(0.89 ,0.47 , 0.20);
        drawCircle(xc,ycc,.25,1);
    
        yc=yc-.006;
        ycc=ycc-.01;
        
            if(yc<=.1 && count==232 )
            {
                drawcoan();
               drawextra(0); 
            }
        }
        if(count>=232)
        {
//            if(count==232)
//            {
//           System.out.println(ycc);
//            }
            drawcoan();
             gl.glColor3d(1.0, 1.0, 1.0);
            drawCircle(xc,.1,.22,0);
            gl.glColor3d(0.89 ,0.47 , 0.20);
            if(ycc<=0.274000000000015)
            {
               
                drawCircle(xc,0.274000000000015,.25,1);
                 drawextra(1); 
               
            }
            else
            {
                drawCircle(xc,ycc,.25,1);
                ycc=ycc-.01;
            }
            drawextra(0);
            if(count>=350)
            {
                draweatenpart();
            }
            gl.glColor3d(1.0, 1.0, 1.0);
            drawCircle(.25,ye,.005,0);
            drawCircle(-.25,ye,.007,0);
            drawCircle(.1,ye,.001,0);
            drawCircle(-.15,ye,.003,0);
           // System.out.println(ye);
            //animator.start();
            ye=ye-.01;
            if(count>=370 && count<=470)
            {
              //  System.out.println(rotate);
              gl.glRotatef( angle, 0.0f, 0.0f, 1.0f );
              gl.glVertex3f(  0.0f,-.75f,0.0f );
              gl.glVertex3f(  -.25f,0f,0.0f );
              gl.glVertex3f(  .25f,0f,0.0f );
              angle += .3f;
              if(count==470)
              {
                  gl.glLoadIdentity();
                  count=-1;
                  yc=1.54;
                  ycc=3.25;
                  angle=0;
                  ye=0;
                 
              }
      
            }
           
        }
        count++;
        
   }
   public void drawcoan()
   {
        GLAutoDrawable drawable=getDrawable();
        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3d( 0.858824,0.576471 ,0.439216);
        gl.glBegin(GL2.GL_TRIANGLES);		// Drawing Using Triangles
	gl.glVertex3f( 0.0f, -0.75f, 0.75f);		// Top
	gl.glVertex3f(-.25f,0.0f, 0.75f);		// Bottom Left
	gl.glVertex3f( .25f,0.0f, 0.75f);		// Bottom Right
        gl.glEnd();
          for(double i=-.25;i<=.25;i=i+.09)
        {
            gl.glColor3d( 0.5, 0.01,0.0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(0,-.75);
            gl.glVertex2d(i,0);
            gl.glVertex2d(0,-.75);
            gl.glVertex2d(i+.001,0);
             gl.glVertex2d(0,-.75);
            gl.glVertex2d(i+.003,0);
               gl.glVertex2d(-.125,-.375);
            gl.glVertex2d(.125,-.375);
            gl.glVertex2d(-.1875,-.1875);
            gl.glVertex2d(.1875,-.1875);
             gl.glVertex2d(-.15625,-.2812);
            gl.glVertex2d(.15625,-.2812);
            gl.glVertex2d(-.21875,-.09375);
            gl.glVertex2d(.21875,-.09375);
            gl.glVertex2d(-.09375,-.46875);
            gl.glVertex2d(.09375,-.46875);
            gl.glVertex2d(-.0625,-.5625);
            gl.glVertex2d(.0625,-.5625);
             gl.glEnd();
           
        }
        gl.glBegin(GL2.GL_QUADS);				// Draw A Quad
	gl.glVertex3f(-.275f, .01f, 0.75f);		// Top Left
	gl.glVertex3f( .275f, .01f, 0.75f);		// Top Right
	gl.glVertex3f( .275f, 0.0f, 0.75f);		// Bottom Right
	gl.glVertex3f(-.275f, 0.0f, 0.75f);		// Bottom Left
        gl.glEnd();
   }
   public void draweatenpart()
   {
       GLAutoDrawable drawable=getDrawable();
      final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3d( 0.0, 0.0,0.0);
         drawCircle(.25,.4,.2,0);
         drawCircle(.25,.4,.2,0);
   }
   public void drawextra(int x)
   {
        GLAutoDrawable drawable=getDrawable();
       final GL2 gl = drawable.getGL().getGL2();
       if(x==0)
       {
        gl.glColor3d( 1.0, 1.0,1.0);
         drawCircle(.25,0,.03,0);
         drawCircle(-.25,0,.05,0);
         drawCircle(-.2,0,.04,0);
         drawCircle(-.24,0,.03,0);
         drawCircle(-.22,0,.06,0);
         drawCircle(-.12,0,.02,0);
         drawCircle(-.19,0,.07,0);
         drawCircle(-.1,0,.04,0);
         drawCircle(-.04,0,.03,0);
         drawCircle(-.03,0,.02,0);
         drawCircle(.2,0,.04,0);
         drawCircle(.24,0,.03,0);
         drawCircle(.22,0,.06,0);
         drawCircle(.12,0,.02,0);
         drawCircle(.19,0,.07,0);
         drawCircle(.1,0,.04,0);
         drawCircle(.04,0,.03,0);
         drawCircle(.03,0,.02,0);
        }
         else
         {
         gl.glColor3d(0.89 ,0.47 , 0.20);
         drawEllipse(.23,.25,.02,.1);
          //drawCircle(.25,.25,.03,0);
         drawEllipse(-.21,.11,.005,.2);
         drawEllipse(-.18,.13,.002,.2);
         drawEllipse(-.2,.12,.005,.2);
         drawEllipse(-.15,.15,.002,.2);
          drawEllipse(.21,.11,.005,.2);
         drawEllipse(.18,.13,.002,.2);
         drawEllipse(.2,.12,.005,.2);
         drawEllipse(.15,.15,.002,.2);
          drawEllipse(-.09,.14,.005,.29);
         drawEllipse(-.1,.16,.002,.29);
         drawEllipse(-.05,.15,.005,.29);
         drawEllipse(-.01,.18,.002,.29);
          drawEllipse(.08,.14,.005,.29);
         drawEllipse(.1,.16,.002,.29);
         drawEllipse(.07,.15,.005,.29);
         drawEllipse(.01,.1,.002,.29);
         
         
         drawCircle(-.24,.25,.03,0);
         drawCircle(-.22,.25,.06,0);
         drawCircle(-.12,.25,.02,0);
         drawCircle(-.19,.25,.07,0);
         drawCircle(-.1,.25,.04,0);
         drawCircle(-.04,.25,.03,0);
         drawCircle(-.03,.25,.02,0);
         drawCircle(-.02,.25,.03,0);
         drawCircle(-.01,.25,.02,0);
         drawCircle(.2,.25,.04,0);
         drawCircle(.24,.25,.03,0);
         drawCircle(.22,.25,.06,0);
         drawCircle(.12,.25,.02,0);
         drawCircle(.19,.25,.07,0);
         drawCircle(.1,.25,.04,0);
         drawCircle(.04,.25,.03,0);
         drawCircle(.03,.25,.02,0);
         drawCircle(.02,.25,.03,0);
         drawCircle(.01,.25,.02,0);
         }
   }
 public  void drawCircle(double x, double y, double radius,int half)
{
    GLAutoDrawable drawable=getDrawable();
    final GL2 gl = drawable.getGL().getGL2();
    int i;
    double twicePi;
    int triangleAmount = 1000; 
    if(half==0)
    {
     twicePi = 2* Math.PI;
    }
    else
    {
       twicePi =Math.PI;
    }
    gl.glBegin(GL2.GL_LINES);

    for(i = 0; i <= triangleAmount; i++)
    {
     gl.glVertex3d( x, y,0);
     gl.glVertex3d(x + (radius * Math.cos(i * twicePi / triangleAmount)), y + (radius * Math.sin(i * twicePi / triangleAmount)),0);
    }
    gl.glEnd();
}
   double degInRad=0;
public void drawEllipse(double x, double y,double xradius, double yradius)
{
        GLAutoDrawable drawable=getDrawable();
        final GL2 gl = drawable.getGL().getGL2();
        int i;
    int triangleAmount = 1000; 
    Double twicePi = Math.PI;
    gl.glBegin(GL2.GL_LINES);

    for(i = 0; i <= triangleAmount; i++)
    {
     gl.glVertex2d( x, y);
     gl.glVertex2d(x + (xradius * Math.cos(i * twicePi / triangleAmount)), y + (yradius * Math.sin(i * twicePi / triangleAmount)));
    }
	gl.glEnd();
}
   public GLAutoDrawable getDrawable()
   {
       return draw;
   }
   @Override 
   public void dispose( GLAutoDrawable arg0 ) { 
      //method body 
   } 
   
   @Override 
   public void init( GLAutoDrawable arg0 ) { 
      // method body 
   }
   
   @Override 
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) { 
   
      
   }
         public void setAnimator(FPSAnimator a){animator = a;}
		
} //end of class