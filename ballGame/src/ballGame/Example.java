package ballGame;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

//继承swing里的窗口类
public class Example extends JFrame{
	private static final long serialVersionUID = 1L;
	Image huaji = Toolkit.getDefaultToolkit().getImage("image/i_f25.png");
	Image bg = Toolkit.getDefaultToolkit().getImage("image/15557280.jpg");
	
	Random input = new Random();
	
	double x=31+10*input.nextInt(10);
	double y=31+10*input.nextInt(10);
	boolean right=true;
	boolean down=true;
	double degree = Math.PI/3;
	
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("+1");
		g.drawImage(bg, 0, 0, null);
		g.drawImage(huaji, (int)x,(int)y, null);
		x += 10*Math.cos(degree);
		y += 10*Math.sin(degree);
		
		if(x>=970 || x<=30 ) {
			degree = Math.PI-degree;
		}
		if(y>=597 || y<=30) {
			degree = -degree;
		}
			
	}
	
	//窗口加载
	void loadFrame() {
		setSize(1000,627);
		setLocation(550,300);
		setVisible(true);
		
		//重复画窗口
		while(true) {
			repaint();
			try {					//如果正确，运行
				Thread.sleep(40);
			}
			catch(Exception e){		//运行异常！运行catch
				e.printStackTrace();		//在命令行打印异常信息在程序中出错的位置及原因
			}
			
		}
	}
	public static void main(String[] args) {
		Example game = new Example();
		game.loadFrame();
	}

}
