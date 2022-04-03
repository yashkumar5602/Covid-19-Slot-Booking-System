import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class MYMouseS extends MouseAdapter
{
SlotDate sd1;
MYMouseS(SlotDate sd)
{
sd1=sd;
}
public void mouseExited(MouseEvent e)
{
if(e.getSource()==sd1.next)
{
sd1.next.setBounds(50,370,260,30);
}
else
{
sd1.l3.setBounds(10,10,40,40);
}
}


public void mouseEntered(MouseEvent e)
{
sd1.next.setBounds(50,370,264,34); 
sd1.l3.setBounds(10,10,43,43);
}

public void mouseClicked(MouseEvent e)
{
sd1.tid.setText("");
//if(sd1.tid.length()>0 || sd1.tid.isEmpty())
//	{
	sd1.next.setVisible(true);
//	}
}
}

@SuppressWarnings("serial")
class SlotDate extends JFrame implements ActionListener
{
Font f,f1,f2;
JButton next,l3;
JLabel ques,date,l1,l2;
JRadioButton fst,scnd;
ButtonGroup bg;
JTextField tid;
@SuppressWarnings("rawtypes")
JComboBox days,months,years;
Connection con;
Statement stm;
ResultSet res;


@SuppressWarnings({ "unchecked", "rawtypes" })
SlotDate()
{
 setUndecorated(true);

ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

 getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
 f=new Font("serif",Font.BOLD,28);
 f1=new Font("serif",Font.BOLD,20);
 f2=new Font("serif",Font.BOLD,16);
 setVisible( true );
 getContentPane().setBackground(Color.WHITE);
 setBounds(500,80,380,500);
 setTitle("BOOK YOUR DATE");

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","kumar");
stm=con.createStatement(); 
res=stm.executeQuery("select * from slotbook");
System.out.println(con);
}
catch(Exception e)
{
System.out.println(e);
}

 setLayout(null);
 setResizable(false);
 setDefaultCloseOperation(EXIT_ON_CLOSE);

l3=new JButton(new ImageIcon("img16.jpg"));
l3.setBounds(10,10,40,40);
add(l3);


l2=new JLabel(new ImageIcon("img20.jpg"));
l2.setBounds(30,10,310,50);
l2.setBackground(Color.RED);
add(l2);

l1=new JLabel(new ImageIcon("helpline.png"));
l1.setBounds(20,390,420,80);
l1.setBackground(Color.RED);
add(l1);

ques=new JLabel("SELECT DOSE ?");
ques.setBounds(70,60,240,40);
ques.setFont(f);
add(ques);

fst= new JRadioButton("First Dose");
fst.setBounds(60,130,100,30);
fst.setBackground(Color.WHITE);
fst.setFont(f2);
add(fst);

scnd= new JRadioButton("Second Dose");
scnd.setBounds(200,130,140,30);
scnd.setBackground(Color.WHITE);
scnd.setFont(f2);
add(scnd);

bg=new ButtonGroup();
bg.add(fst);
bg.add(scnd);
fst.setSelected(true);

tid= new JTextField();
tid.setBounds(50,180,260,30);
add(tid);
tid.setFont(f1);
tid.setText("PlEASE ENTER ADHAR");
tid.setForeground(Color.RED);

date=new JLabel("CHOOSE DATE");
date.setBounds(70,235,240,40);
date.setFont(f);
add(date);


String day[]=new String[31];
for(int i=1;i<=31;i++)
{
	day[i-1]=Integer.toString(i);
}

days=new JComboBox(day);
days.setBounds(50,300,70,30);
add(days);
//days.setEditable(true);

String mon[]={"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
months=new JComboBox(mon);
months.setBounds(140,300,90,30);
add(months);

String year[]=new String[30];
for(int i=2021;i<=2050;i++)
{
	year[i-2021]=Integer.toString(i);
}

years=new JComboBox(year);
years.setBounds(250,300,60,30);
add(years);

next=new JButton("NEXT");
next.setBounds(50,370,260,30);
next.setFont(f1);
add(next);
//next.setEnabled(false);
next.setVisible(false);

next.addActionListener(this);
next.addMouseListener(new MYMouseS(this));
l3.addActionListener(this);
l3.addMouseListener(new MYMouseS(this));
fst.addActionListener(this);
scnd.addActionListener(this);
days.addActionListener(this);
months.addActionListener(this);
years.addActionListener(this);
tid.addMouseListener(new MYMouseS(this));

}

public void actionPerformed(ActionEvent e)
{
		/*		if(tid.length()>0||tid.isEmpty())
				   {
	   				tid.setForeground(Color.BLACK);
	   				next.setEnabled(true);
	   			   }*/


String str=e.getActionCommand();
	if(str=="NEXT")
	{			 
	
					String dose="";
					if(fst.isSelected())
					 {
 					 dose="First";
					 } 

					 else if(scnd.isSelected())
					 {
					 dose="Second";
					 }

					String dob=(String)days.getSelectedItem()+months.getSelectedItem()+years.getSelectedItem();
					String id=tid.getText();
					

		try
	 	{  
		stm.executeUpdate("insert into slotbook values('"+dose+"','"+id+"','"+dob+"')");   
		//lbl_status.setText("                Data Inserted Successfully        ");
		
                System.out.println(id);
   		tid.setText("");	
	 	}
	
		catch(Exception e1)
		{
		e1.printStackTrace();
		}		

	this.dispose();
	new Registration(); 

	}
	else if(e.getSource()==l3)
	{
	this.dispose();
	new MyFrame();
	}

}
	
/*
public static void main(String...a)
{
new SlotDate();
}
*/
}