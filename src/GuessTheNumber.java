import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Kreira igru gdje korisnik zamisli broj izmedju 1 i 10000, racunar pokusava da
 * pogodi taj broj, gdje korisnik govori da li je ponudjeni broj od racunara
 * veci ili manji od zamisljenog
 * 
 * @author harisarifovic
 *
 */
public class GuessTheNumber extends JPanel implements ActionListener {
	// Kreira komponente potrebne za igru
	private static JButton manje = new JButton("Manje");
	private static JButton vise = new JButton("Vise");
	private static JButton tacno = new JButton("Tacno");
	private static JLabel number;
	private static JLabel counter;
	private static int intCounter = 0;
	private static int start = 0;
	private static int end = 10000;
	private static JFrame success;

	/**
	 * Postavlja listenere za buttone,kreira labele kao i prozor koji ce se
	 * pokrenuti kada racunar pogodi zamisljeni broj
	 */
	public GuessTheNumber() {
		manje.addActionListener(this);
		vise.addActionListener(this);
		tacno.addActionListener(this);
		number = new JLabel(String.valueOf(Binary(start, end)));
		counter = new JLabel();
		success = new JFrame("WIN!");
		success.setSize(200, 100);
		success.setLocation(800, 600);
		success.add(new JButton("SUCCESS!!!"));

	}

	/**
	 * Kreira prozor gdje ce se igrati igra
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame window = new JFrame("GUESS THE NUMBER!!!");
		window.setSize(800, 600);
		window.setLocation(500, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuessTheNumber panel = new GuessTheNumber();
		panel.setLayout(new BorderLayout());
		window.setContentPane(panel);
		panel.add(number, BorderLayout.NORTH);
		panel.add(manje, BorderLayout.WEST);
		panel.add(tacno, BorderLayout.CENTER);
		panel.add(vise, BorderLayout.EAST);
		panel.add(counter, BorderLayout.SOUTH);
		window.setVisible(true);

	}

	@Override
	/**
	 * provjerava koji je button pritisnut, tako da program
	 * reaguje ispravno
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == manje) {
			end = (start + end) / 2;

		} else if (e.getSource() == vise) {
			start = (start + end) / 2;
		}
		// postavlja novi broj za pokusaj pogotka
		number.setText(String.valueOf(Binary(start, end)));
		// Pokazuje broj pokusaja
		counter.setText(String.valueOf(++intCounter));
		if (e.getSource() == tacno) {
			success.setVisible(true);
		}
	}

	/**
	 * Racuna srednju vrijednost dva broja
	 * 
	 * @param start
	 *            prvi broj
	 * @param end
	 *            drugi broj
	 * @return srednju vrijednost dva broja
	 */
	private static int Binary(int start, int end) {
		return (start + end) / 2;

	}
}
