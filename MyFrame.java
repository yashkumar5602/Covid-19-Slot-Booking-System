import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel sepm,help,modi,vcne,guide,blimg,vlimg,logo;
JButton bslot,vslot,lout,close;


MyFrame() 
{
 //f=new Font("serif",Font.BOLD,18);
 setUndecorated( true ); 

ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

// setVisible( true );
 getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.ORANGE));
 getContentPane().setBackground(Color.WHITE);
 setBounds(260,120,800,450);
 setTitle("____");
 setLayout(null);
 setResizable(false);
 //setDefaultCloseOperation(EXIT_ON_CLOSE);

logo = new JLabel(new ImageIcon("img38.png"));
logo.setBounds(30,5,340,80);
add(logo);

modi = new JLabel(new ImageIcon("img32.png"));
modi.setBounds(30,100,140,180);
add(modi);

vcne = new JLabel(new ImageIcon("img35.jpg"));
vcne.setBounds(210,180,100,100);
add(vcne);

guide = new JLabel(new ImageIcon("img33.png"));
guide.setBounds(30,300,340,100);
add(guide);

sepm=new JLabel(new ImageIcon("img31.jpg"));
sepm.setBounds(395,0,5,440);
add(sepm);

close=new JButton(new ImageIcon("img252.jpg"));
close.setBounds(740,5,40,45);
add(close);


bslot=new JButton(new ImageIcon("img36.jpeg"));
bslot.setBounds(600,100,170,35);
bslot.setBackground(new Color(153,204,0));
add(bslot);

blimg = new JLabel(new ImageIcon("img10.jpeg"));
blimg.setBounds(460,100,40,35);
add(blimg);

vslot=new JButton(new ImageIcon("img37.png"));
vslot.setBounds(600,170,170,35);
vslot.setBackground(new Color(0,204,255));
add(vslot);

vlimg = new JLabel(new ImageIcon("img301.jpeg"));
vlimg.setBounds(460,170,40,35);
add(vlimg);

lout=new JButton("Log Out");
lout.setBounds(500,300,200,30);
add(lout);

help = new JLabel(new ImageIcon("img34.png"));
help.setBounds(430,340,340,90);
add(help);

bslot.addActionListener(this);
vslot.addActionListener(this);
lout.addActionListener(this);
close.addActionListener(this);
setVisible( true );
}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==bslot)
	{
         this.dispose();
	 new SlotDate(); 	
	}
        else if(e.getSource()==vslot)
	{
         this.dispose();
	 new VFrame();
	}
       else if(e.getSource()==lout)
	{
         this.dispose();
	 new LoginForm();
	}
       else if(e.getSource()==close)
	{
         System.exit(0);	 
	}
       
      
}

/*
public static void main(String...aa1)
{
MyFrame mf=new MyFrame();
}
*/
}