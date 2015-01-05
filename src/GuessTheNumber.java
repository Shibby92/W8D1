import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuessTheNumber extends JPanel implements ActionListener {
	private static JButton manje = new JButton("Manje");
	private static JButton vise = new JButton("Vise");
	private static JButton tacno = new JButton("Tacno");
	private static JLabel number;
	private static JLabel counter;
	private static int intCounter = 0;
	private static int start = 0;
	private static int end = 10000;
	private static JFrame success;

	public GuessTheNumber() {
		manje.addActionListener(this);
		vise.addActionListener(this);
		tacno.addActionListener(this);
		number = new JLabel(String.valueOf(Binary(start, end)));
		counter = new JLabel();
		success= new JFrame("WIN!");
		success.setSize(200, 100);
		success.setLocation(800, 600);
		success.add(new JButton("SUCCESS!!!"));
		
	}

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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == manje) {
			end = (start + end) / 2;

		} else if (e.getSource() == vise) {
			start = (start + end) / 2;
		}
		number.setText(String.valueOf(Binary(start, end)));
		counter.setText(String.valueOf(++intCounter));
		if(e.getSource()==tacno){
			success.setVisible(true);
		}
	}

	private static int Binary(int start, int end) {
		return (start + end) / 2;

	}
}
