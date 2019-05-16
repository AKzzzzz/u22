import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*	<applet code="App25.class" width="300"height="300">
 	</applet>
*/

public class keytest extends Applet {
	char ch = 65;
	FontMetrics fo;
	public void init() {
		setBackground(Color.blue);
		setFont(new Font("Serif" , Font.BOLD , 100));
		fo = getFontMetrics(getFont());

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				ch = e.getKeyChar();
				repaint();
			}
		});
	}
	public void paint(Graphics g) {
		Dimension dim = getSize();
		g.drawString("" + ch , (dim.width / 2) - (fo.charWidth(ch) / 2) , (dim.height / 2));
	}
}