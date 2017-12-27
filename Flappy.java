// utility stuff

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

// graphics stuff
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Flappy
        extends JPanel
        implements KeyListener {
    int screenWidth = 1024;
    int screenHeight = 768;
    int timeMs = 0;
    int delayMs = 50;
    Random rand = new Random();
    int score;
    int highScore = 0;
    int birdX = 80;
    int birdY = 400;
    Bird bird;
    Hole hole;

    ArrayList<Hole> holes = new ArrayList<Hole>();
//same code as canvas -- paint 5 holes


    public Flappy() {

        bird = new Bird(birdX, birdY);

        for (int position = 2; position < 5; position++) {
            int n = rand.nextInt(400);

            holes.add(new Hole(position * 350, n, 0, 0));


        }
    }

    /* This function resets the game *except* the high score.
     */
    public void reset() {
        score = 0;


        bird.x = 100;
        bird.y = 400;
        timeMs = 0;
        bird.dy = 0;

        System.out.println(highScore);
        for (Hole hole : this.holes) {
            hole.y = rand.nextInt(400);
            hole.x = 350 * holes.indexOf(hole) + 700;
        }


    }


    /* This function updates the position of all objects, EXCEPT for
     * how the bird moves when you press UP, which is handled in
     * keyReleased()
     */

    public void update() {
        bird.update(timeMs, delayMs, screenWidth, screenHeight);
        for (Hole hole : this.holes) {
            hole.update(timeMs, delayMs, screenWidth, screenHeight);
            while (hole.x == - 75) {
                hole.y = rand.nextInt(400);
                hole.x += 1075;
            }





            if (hole.x == 0) {
                score = score + 1;
                //System.out.println(score);
            }
            if (score > highScore) {highScore ++;}
            if (bird.y <= 0) {
                //System.out.println("YOU HIT TOP");
                reset();
            }
            if (bird.y + 52 >= 768) {
                //System.out.println("YOU HIT BOTTOM");
                reset();
            }
            if (hole.x <= bird.x + 52) { //top left or bottom left part of the hole
                if (bird.x <= hole.x + 75) { //takes care of the two sides of the pipe
                    if (bird.y <= ((hole.y - 1050) + (1150)) || bird.y + 28 >= (hole.y - 1050) + (1320)) {
                        //System.out.println("DEATH 1");
                        reset();
                    }

//                    ((hole.y + 270) + (hole.height + 850))

                }

            }
        }
    }

    /* This function draws all the objects on the screen.
     */
    public void paint(Graphics g) {

        this.bird.paint(g);
        for (Hole hole : this.holes) {
            hole.paint(g);
            g.setColor(Color.BLACK);

            g.drawString("Score: " + score, 100, 100);
            g.drawString("High Score: " + highScore, 100, 110);

        }

    }


    /* This function is called whenever a key is pressed;
     * specifically, it detects the non-keypad up-arrow.
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            bird.dy -= .07;


    }

    // You should not change any code below this line

    public void run() throws InterruptedException {
        this.showCanvas();
        while (true) {
            // update everything
            this.update();

            // redraw the screen
            Graphics g = this.getGraphics();
            g.clearRect(0, 0, this.screenWidth, this.screenHeight);
            this.paint(g);

            // wait for the next timestep
            Thread.sleep(this.delayMs);
            this.timeMs += this.delayMs;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void showCanvas() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.addKeyListener(this);
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.screenWidth, this.screenHeight);
        frame.setVisible(true);
    }

    public static void main(String[] args)
            throws InterruptedException {
        Flappy flappy = new Flappy();
        flappy.run();
    }
}