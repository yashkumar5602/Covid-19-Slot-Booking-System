import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MYMouseV extends MouseAdapter
{
VFrame sd1;
MYMouseV(VFrame sd)
{
sd1=sd;
}
public void mouseExited(MouseEvent e)
{

sd1.b2.setBounds(10,10,40,40);
}

public void mouseEntered(MouseEvent e)
{
sd1.b2.setBounds(10,10,43,43);
}



}


@SuppressWarnings("serial")
class VFrame extends JFrame implements ActionListener
{

JPanel p1;
JButton b1,b2;
JTextField t1;
JLabel l1,l2,l3,l4;
Font f;

VFrame() 
{
 f=new Font("serif",Font.BOLD,22);
 setUndecorated( true ); 

ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

 getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));

 getContentPane().setBackground(Color.WHITE);

setBounds(500,80,380,500);
setTitle("DATA VERIFICATION");
setLayout(null);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

b2=new JButton(new ImageIcon("img16.jpg"));
b2.setBounds(10,10,40,40);
add(b2);


 l3=new JLabel(new ImageIcon("img9.jpeg"));
 l3.setBounds(80,10,200,120);
 add(l3);

 l1 = new JLabel("Please Enter Your ID");
 l1.setBounds(80,120,220,50);
 add(l1);
 l1.setFont(f);

 t1 = new JTextField();
 t1.setBounds(30,200,300,40);
 add(t1);
 t1.setFont(f);

 b1 = new JButton("Submit");
 b1.setBounds(80,300,200,30);
 add(b1);
 b1.setFont(f);

 
 l4=new JLabel(new ImageIcon("img24.jpg"));
 l4.setBounds(120,340,160,140);
 add(l4);

b1.addActionListener(this);
b2.addActionListener(this);
b2.addMouseListener(new MYMouseV(this));
setVisible( true );

}

public void actionPerformed(ActionEvent e)
{
String adhr=t1.getText();


if(e.getSource()==b1)
	{
	try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");

       		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","kumar");
		Statement stm=con.createStatement();
		ResultSet res=stm.executeQuery("select * from slotbook,registration where adharno='"+adhr+"'");
               
		if(res.next())
		{
		new Details(res);this.dispose();
		}
	else
		{
        	t1.setText("invalid adhar");	
		}
	} 

	catch(Exception e1)
		{e1.printStackTrace();}
	}

else if(e.getSource()==b2)
	{
	this.dispose();
        new MyFrame();
	}

//***************************************************************************************************
/*
	String str=e.getActionCommand();
	if(str=="Submit")
	{
	this.dispose();
	new Details(); 	
	}
	else if(e.getSource()==b2)
	{
	this.dispose();
        new MyFrame();
	}
*/
}
/*
public static void main(String... a1)
{
new VFrame();
}
*/

}




