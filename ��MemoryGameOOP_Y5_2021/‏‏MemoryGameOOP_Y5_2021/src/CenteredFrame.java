import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CenteredFrame extends Frame
{
	int shura; 
	int amuda;
	//
	public Button prev;
	public String pb;
	private int matches;
	//
	AePlayWave voice;
	public int SIZE;
	public int SIZE1; 
	//
	
	public static void confirmExit(String question, String framei, String message, AePlayWave voice, boolean isMainFrame)
	{
		// To confirm closing window.
		Frame f = new Frame();
		Object[] options = {"Yes", "No"};
		int n = JOptionPane.showOptionDialog(f, question, "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		boolean flag=false;
		switch (n) {
        	case 1:
        		flag = true;
        		break;
        	default:
        		flag = false;
        		break;
		}
		if (!flag)
		{
			System.out.println(framei+"Frame is Dead!");
			if (isMainFrame)
			{
				JOptionPane.showMessageDialog(null, message);
				voice=new AePlayWave("Bang1.wav");
				voice.start(); // run()
				Logical.wait(4);
			}
			else
				Logical.wait(1);
			System.exit(0);
		}
	}
	public CenteredFrame(int N, int M)
	{
		this.SIZE=N;
		this.SIZE1=M;

		Panel p=new Panel();
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{	
				confirmExit("Want get out of this game?", "", "Frame is Dead!", voice, true);
			}
		});
		p.setLayout(new GridLayout(SIZE,SIZE1));
		
		for (shura=0 ; shura<SIZE ; shura++)
			for (amuda=0 ; amuda<SIZE1 ; amuda++)
			{
				Button butt; // null null
				butt=new Button();
				butt.setBackground(Color.CYAN.brighter());
				butt.getAccessibleContext().setAccessibleName(Rashi.logical[shura][amuda]+"");
				p.add(butt);
				// מאזין על כל כפתור
				butt.addActionListener((ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int buttonValue = getButtonValue(butt);
						String buttonValueStr = String.valueOf(buttonValue);
						if (prev == null) // the first value of the pair
						{
							butt.setBackground(Color.WHITE);
							butt.setLabel(buttonValueStr);
							prev = butt;
						} else { // the second value of the pair
							butt.setBackground(Color.WHITE);
							if ((buttonValue == getButtonValue(prev)) && (prev != butt)) { // there is a match
								butt.setLabel(buttonValueStr);
								Logical.wait(1);
								butt.setBackground(Color.WHITE);
								
								matches++;
								
								voice=new AePlayWave("match.wav");
								voice.start(); // run()
								Logical.wait(1);
								
								System.out.println("match found");
								
								butt.getLabel();
								
								butt.setVisible(false);
								prev.setVisible(false);
								
								butt.setLabel(buttonValueStr);
								double pr = (double)(matches)/((SIZE * SIZE1) / 2);
								JOptionPane.showMessageDialog(null, "matches found: "+(pr*100)+"%");
								if (matches == (SIZE * SIZE1) / 2) {
									JOptionPane.showMessageDialog(null, "You are the champion");
									
									voice=new AePlayWave("winner.wav");
									voice.start(); // run()
									Logical.wait(4);
									
									System.exit(0);
								}
							} else {
								butt.setLabel(buttonValueStr);
								Logical.wait(1);
								butt.setLabel("");
								prev.setLabel("");
								
								voice=new AePlayWave("No.wav");
								voice.start(); // run()
								Logical.wait(4);
								
								butt.setBackground(Color.CYAN.brighter());
								prev.setBackground(Color.CYAN.brighter());
							}
							prev = null;
						}
						if (butt.isVisible())
							System.out.println("button pressed: "+getButtonValue(butt));

					}

				});
			}
		add(p);
		setSize(SIZE*60,SIZE*60);
	}
	
	private static int getButtonValue(Button butt) {
		return Integer.parseInt(butt.getAccessibleContext().getAccessibleName());
	}

}
// 