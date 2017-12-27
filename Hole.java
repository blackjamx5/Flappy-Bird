import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class Hole extends Shape {
	// FIXME
	int width;
	int height;
	int score = 0;
	Color color;



	public Hole(int x, int y,int width, int height) {
		super(x, y);
		// FIXME
		this.width = 75;
		this.height = 300;
		this.x = x;
		this.y = y;
		this.dx = -0.10;



	}

//	public void update(double total_time,
//					   double delay_ms,
//					   int screen_width,
//					   int screen_height) {
//		this.dx += delay_ms * this.ddx;
//		this.dy += delay_ms * this.ddy;
//
//		// add velocity to position
//		this.x += delay_ms * this.dx;
//		this.y += delay_ms * this.dy;
//
//	}

	public void paint(Graphics g) {


		g.setColor(new Color(58, 157, 101));
		g.fillRect(this.x, this.y - 1050, this.width, this.height + 850); //200, 200 each for height
		//top tube
		g.fillRect(this.x, this.y + 270, this.width, this.height + 850 );//450
		//bottom tube
//		g.setColor(new Color(0, 0, 101));
//		g.fillRect(this.x + 20, ((this.y - 1050) + 1320), this.width, this.height + 850 ); used to diagnose position



	}
}






