import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StartFrame extends Frame {
	
	AePlayWave voice; 
	public StartFrame(int size0, int size1) {
		Panel p=new Panel();
	
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
			CenteredFrame.confirmExit("Don't you want to play?", "Start ", "canceling game", null, true);
			}
	});
		
	p.setLayout(new GridLayout(6,6));
	p.setBackground(Color.YELLOW.brighter()); // Color it's static final variable from class Color. (pay attention - delete afterwards)
	JLabel label1 = new JLabel("Start");
	JLabel label2 = new JLabel("-----");
	p.add(label1);
	p.add(label2);
	
	for(int i =0; i<4; i++) {
		Button b = new Button();
		p.add(b);
		
		if(i==0)
		b.setLabel("2X2");
		else if(i==1)
			b.setLabel("4X4");
		else if(i==2)
			b.setLabel("6X6");
		else
			b.setLabel("8X8");
	
		b.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rashi.N=Character.getNumericValue(b.getLabel().charAt(0)); //first num
				Rashi.M=Character.getNumericValue(b.getLabel().charAt(2));//second num
				JOptionPane.showMessageDialog(null, "Opening board window");
				Logical.wait(1);
				dispose();
				Rashi.rand = new int[Rashi.N*Rashi.M];
				Rashi.logical=new int[Rashi.N][Rashi.M];
				Logical.makeBoard();
				CenteredFrame board = new CenteredFrame(Rashi.N,Rashi.M);
				board.setVisible(true);
			}
		});
	}
	add(p);
	setSize(size0*60,size1*60);
	}
}
