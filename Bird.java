
import java.awt.Color;
import java.awt.Graphics;

class Bird extends Shape {
	// FIXME
	int width;
	int height;
	Color color;


	public Bird(int x, int y) {
		super(x, y);
		// FIXME

		this.x = x;
		this.y = y;
		this.ddy = 0.00019;

	}

	public void update(double total_time,
					   double delay_ms,
					   int screen_width,
					   int screen_height) {

		// add acceleration to velocity
		this.dx += delay_ms * this.ddx;
		this.dy += delay_ms * this.ddy;

		// add velocity to position
		this.x += delay_ms * this.dx;
		this.y += delay_ms * this.dy;

		//if (this.x < 0 || this.x + this.width > screen_width) {
		//   this.dx = -this.dx;
	}





	public void paint(Graphics g) {
		// FIXME
		g.setColor(new Color(255, 0, 0));
		g.drawOval(this.x, this.y, 52, 30);
		g.fillOval(this.x, this.y, 52, 30);
		g.setColor(new Color(0, 0, 0));
		g.drawPolygon(new int[] {this.x + 50, this.x + 50, this.x + 60}, new int[] {this.y + 20, this.y + 10, this.y + 20}, 3);
		g.fillPolygon(new int[] {this.x + 50, this.x + 50, this.x + 60}, new int[] {this.y + 20, this.y + 10, this.y + 20}, 3);
		g.drawPolygon(new int[] {this.x + 10, this.x + 40, this.x + 30}, new int[] {this.y + 10, this.y + 10, this.y + 32}, 3);
		g.setColor(new Color(255, 0, 0));
		g.fillPolygon(new int[] {this.x + 10, this.x + 40, this.x + 30}, new int[] {this.y + 10,this.y + 10, this.y + 32}, 3);
	}
}











// make sure that the Ballons keeps moving in the direction it should


// check if the ballons touch the side of the canvas, invert the speed
// this would make it bounces off

