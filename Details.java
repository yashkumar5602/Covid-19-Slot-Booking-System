import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MYMouseD extends MouseAdapter
{
Details sd1;
MYMouseD(Details sd)
{
sd1=sd;
}
public void mouseExited(MouseEvent e)
{

sd1.b1.setBounds(20,0,40,40);
}

public void mouseEntered(MouseEvent e)
{
sd1.b1.setBounds(20,0,43,43);
}
}


@SuppressWarnings("serial")
class Details extends JFrame implements ActionListener
{

JButton b1,b2;
JTextArea t1;
JLabel ldtil,ldtil1,lname,tname,fname,tfname,lgender,tgender,ldob,tdob,ldose,tdose,lnation,tnation,ladhar,tadhar,ladrs,tadrs;
Font f;
Connection con;
Statement stm;
ResultSet res,res2,res3;
String nyk,fy,gy,dy,nty,iy,ay,dsy;

Details(ResultSet res1)
{
 res3=res1;
f=new Font("serif",Font.BOLD,20);
 setUndecorated(true); 
 
ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

 getContentPane().setBackground(Color.WHITE);
 setBounds(500,80,380,500);
 getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.ORANGE));
 setTitle("DETAILS");

try
{
nyk=res3.getString("name");
fy=res3.getString("fathername");
gy=res3.getString("gender");
dy=res3.getString("dob");
nty=res3.getString("nationality");
iy=res3.getString("sdob");
ay=res3.getString("address");
dsy=res3.getString("dose");

}
catch(Exception e)
{
System.out.println(e);
}

 setLayout(null);
 setResizable(false);
 setDefaultCloseOperation(EXIT_ON_CLOSE);

b1=new JButton(new ImageIcon("img16.jpg"));
b1.setBounds(20,0,40,40);
add(b1);
/*
t1=new JTextArea();
t1.setBounds(20,40,330,400);
add(t1);
t1.setFont(f);
t1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
*/

ldtil=new JLabel(new ImageIcon("img292.jpeg"));
ldtil.setBounds(160,0,60,60);
add(ldtil);
//ldtil.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

ldtil1=new JLabel(new ImageIcon("img30.jpeg"));
ldtil1.setBounds(220,20,40,40);
add(ldtil1);
//ldtil1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));


lname=new JLabel(" Name->");
lname.setBounds(10,70,90,30);
lname.setForeground(new Color(128,0,64));
add(lname);
lname.setFont(f);

tname=new JLabel(nyk);
tname.setBounds(150,70,200,30);
add(tname);
tname.setFont(f);
tname.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

fname=new JLabel("Father Name->");
fname.setBounds(10,110,140,30);
fname.setForeground(new Color(128,0,64));
add(fname);
fname.setFont(f);

tfname=new JLabel(fy);
tfname.setBounds(150,110,200,30);
add(tfname);
tfname.setFont(f);
tfname.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

lgender=new JLabel("Gender->");
lgender.setBounds(10,150,140,30);
lgender.setForeground(new Color(128,0,64));
add(lgender);
lgender.setFont(f);

tgender=new JLabel(gy);
tgender.setBounds(150,150,200,30);
add(tgender);
tgender.setFont(f);
tgender.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

ldob=new JLabel("DOB->");
ldob.setBounds(10,190,140,30);
ldob.setForeground(new Color(128,0,64));
add(ldob);
ldob.setFont(f);

tdob=new JLabel(dy);
tdob.setBounds(150,190,200,30);
add(tdob);
tdob.setFont(f);
tdob.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

lnation=new JLabel("Nationalty->");
lnation.setBounds(10,230,140,30);
lnation.setForeground(new Color(128,0,64));
add(lnation);
lnation.setFont(f);

tnation=new JLabel(nty);
tnation.setBounds(150,230,200,30);
add(tnation);
tnation.setFont(f);
tnation.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

ladhar=new JLabel("Book Date->");
ladhar.setBounds(10,270,140,30);
ladhar.setForeground(new Color(128,0,64));
add(ladhar);
ladhar.setFont(f);

tadhar=new JLabel(iy);
tadhar.setBounds(150,270,200,30);
add(tadhar);
tadhar.setFont(f);
tadhar.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

ladrs=new JLabel("Dose->");
ladrs.setBounds(10,310,140,30);
ladrs.setForeground(new Color(128,0,64));
add(ladrs);
ladrs.setFont(f);

tadrs=new JLabel(dsy);
tadrs.setBounds(150,310,200,30);
add(tadrs);
tadrs.setFont(f);
tadrs.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));


ladrs=new JLabel("Address:-");
ladrs.setBounds(10,340,140,30);
ladrs.setForeground(new Color(128,0,64));
add(ladrs);
ladrs.setFont(f);

tadrs=new JLabel(ay);
tadrs.setBounds(0,375,370,60);
add(tadrs);
tadrs.setFont(f);
tadrs.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

b2=new JButton(new ImageIcon("img26.jpeg"));
b2.setBounds(70,440,225,40);
add(b2);

b1.addActionListener(this);
b1.addMouseListener(new MYMouseD(this));
b2.addActionListener(this);
setVisible( true ); 
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
	this.dispose();
        new VFrame();
	}
	else if(e.getSource()==b2)
	{
	this.dispose();
	new MyFrame();
	}
}

/*public static void main(String...a1)
{
new Details();
}*/
}