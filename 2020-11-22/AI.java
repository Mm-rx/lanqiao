import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y,i,j;
	int leftFlag,rightFlag,upFlag,downFlag;

	/*
	Image heroLeftImg[]=new Image[3];
    Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	*/
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			/*
			//左
			for(int i=0;i<heroLeftImg.length;i++){
			heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
            //右
			for(int i=0;i<heroRightImg.length;i++){
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
            //上
			for(int i=0;i<heroUpImg.length;i++){
			heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
            //下
			for(int i=0;i<heroDownImg.length;i++){
			heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			*/
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
	
			}
            currentImg=heroImg[3][1];
			x=110;
			y=140;

			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,255,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	   
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		//左

		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(leftFlag==1){
			currentImg=heroImg[0][0];
			leftFlag++;
			}
			else if(leftFlag==2){
			currentImg=heroImg[0][2];
			leftFlag=1;
			}
			x=x-2;
			repaint();
		}

		//右

		if(action==RIGHT){
		if(rightFlag==1){
			currentImg=heroImg[1][0];
			rightFlag++;
			}
			else if(rightFlag==2){
			currentImg=heroImg[1][2];
			rightFlag=1;
			}
			x=x+2;
			repaint();
		}

		//上

		if(action==UP){
		if(upFlag==1){
			currentImg=heroImg[2][0];
			upFlag++;
			}
			else if(upFlag==2){
			currentImg=heroImg[2][2];
			upFlag=1;
			}
			y=y-2;
			repaint();;
	}
	//下

	if(action==DOWN){
		if(downFlag==1){
			currentImg=heroImg[3][0];
			downFlag++;
			}
			else if(downFlag==2){
			currentImg=heroImg[3][2];
			downFlag=1;
			}
			y=y+2;
			repaint();;
	}
}
}