import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MYMouseR extends MouseAdapter
{
Registration rg1;
MYMouseR(Registration rg)
{
rg1=rg;
}
public void mouseExited(MouseEvent e)
   {
   if(e.getSource()==rg1.close)
	{
	rg1.close.setBounds(550,5,30,40);
	}
   else
	{
	rg1.bsubmit.setBounds(180,640,220,30);
	}
   }


public void mouseEntered(MouseEvent e)
{
rg1.close.setBounds(550,5,33,43); 
rg1.bsubmit.setBounds(177,637,223,33);

}
}


@SuppressWarnings("serial")
class Registration extends JFrame implements ActionListener 
{

static Registration r1;
JPanel p1;
JButton bsubmit,close;
JTextField tname,tfname,tid;
JTextArea tadd;
JLabel lmen,ldetail,lsubmit,lname,lfname,lgender,ldob,lage,lnation,lid,laddres;
JRadioButton R_indian,R_1other,R_male,R_female,R_transgender;
JScrollPane sp2;
JOptionPane op;
@SuppressWarnings("rawtypes")
JComboBox days,months,years,ages;
ButtonGroup nationality,gender1;
Connection con;
Statement stm;
ResultSet res;
Font f;
@SuppressWarnings({ "rawtypes", "unchecked" })
//String gender,nation;


//Registration(Registration r2)
Registration()
{ 
 f=new Font("serif",Font.BOLD,22);
 setUndecorated( true ); 

ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

 

 getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));

 getContentPane().setBackground(Color.WHITE);

 setBounds(380,20,600,700);
 setTitle("ENTER YOUR DETAIL");

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");

con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","kumar");
stm=con.createStatement(); 
res=stm.executeQuery("select * from registration");
System.out.println(con);
}
catch(Exception e)
{
System.out.println(e);
}


 setLayout(null);
 setResizable(false);
 setDefaultCloseOperation(EXIT_ON_CLOSE);

 lmen=new JLabel(new ImageIcon("img29.jpeg"));
 lmen.setBounds(230,5,80,80);
 add(lmen);
 
 ldetail=new JLabel(new ImageIcon("img30.jpeg"));
 ldetail.setBounds(310,40,30,30);
 add(ldetail);
  

 close=new JButton(new ImageIcon("img25.jpg"));
 close.setBounds(550,5,30,40);
 add(close);
 
 lname = new JLabel("NAME");
 lname.setBounds(60,100,100,30);
 add(lname);
 lname.setFont(f);
 

 lfname = new JLabel("FATHER NAME");
 lfname.setBounds(60,150,180,30);
 add(lfname);
 lfname.setFont(f);
 

 lgender = new JLabel("GENDER");
 lgender.setBounds(60,200,100,30);
 add(lgender);
 lgender.setFont(f);

gender1=new ButtonGroup();
R_male=new JRadioButton("Male");
R_male.setBackground(Color.WHITE);
R_male.setBounds(190,200,80,30);
add(R_male);
gender1.add(R_male);
R_male.setFont(f);
//R_male.setSelected(true);

R_female=new JRadioButton("Female");
R_female.setBackground(Color.WHITE);
R_female.setBounds(275,200,100,30);
add(R_female);
gender1.add(R_female);
R_female.setFont(f);

R_transgender=new JRadioButton("Transgender");
R_transgender.setBackground(Color.WHITE);
R_transgender.setBounds(380,200,150,30);
add(R_transgender);
gender1.add(R_transgender);
R_transgender.setFont(f);


 ldob = new JLabel("DOB");
 ldob.setBounds(60,250,50,30);
 add(ldob);
 ldob.setFont(f);

//*********************

String day[]=new String[31];
for(int i=1;i<=31;i++)
{
	day[i-1]=Integer.toString(i);
}

days=new JComboBox(day);
days.setBounds(130,250,50,30);
add(days);
//days.setEditable(true);

String mon[]={"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
months=new JComboBox(mon);
months.setBounds(185,250,90,30);
add(months);

String year[]=new String[100];
for(int i=1951;i<=2050;i++)
{
	year[i-1951]=Integer.toString(i);
}

years=new JComboBox(year);
years.setBounds(280,250,60,30);
add(years);

//***********************************


 lage = new JLabel("AGE");
 lage.setBounds(400,250,60,30);
 add(lage);
 lage.setFont(f);

String age[]=new String[100];
for(int i=1;i<=100;i++)
{
	age[i-1]=Integer.toString(i);
}

ages=new JComboBox(age);
ages.setBounds(480,250,50,30);
add(ages);

 lnation = new JLabel("NATIONALITY");
 lnation.setBounds(60,300,160,30);
 add(lnation);
 lnation.setFont(f);

nationality=new ButtonGroup();
R_indian=new JRadioButton("Indian");
R_indian.setBackground(Color.WHITE);
R_indian.setBounds(300,300,110,30);
add(R_indian);
nationality.add(R_indian);
R_indian.setFont(f);
R_indian.setSelected(true);

R_1other=new JRadioButton("Other's");
R_1other.setBackground(Color.WHITE);
R_1other.setBounds(430,300,100,30);
add(R_1other);
nationality.add(R_1other);
R_1other.setFont(f);


 lid = new JLabel("AADHAR NUMBER*");
 lid.setBounds(60,350,220,30);
 add(lid);
 lid.setFont(f);

 laddres = new JLabel("ADDRESS");
 laddres.setBounds(60,400,120,30);
 add(laddres);
 laddres.setFont(f);

 tname = new JTextField();
 tname.setBounds(300,100,230,30);
 add(tname);
 tname.setFont(f);

 tfname = new JTextField();
 tfname.setBounds(300,150,230,30);
 add(tfname);
 tfname.setFont(f);

 tid = new JTextField();
 tid.setBounds(300,350,230,30);
 add(tid);
 tid.setFont(f);


 tadd = new JTextArea();
 tadd.setBounds(60,440,460,120);
 tadd.setLineWrap(true);
 sp2=new JScrollPane(tadd);
 add(sp2);
 add(tadd);
 
 tadd.setFont(f);
 tadd.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

 lsubmit=new JLabel(new ImageIcon("img28.jpg"));
 lsubmit.setBounds(260,570,70,70);
 add(lsubmit);


 bsubmit = new JButton("SUBMIT");
 bsubmit.setBounds(180,640,220,30);
 add(bsubmit);
 bsubmit.setFont(f);

bsubmit.addMouseListener(new MYMouseR(this));
bsubmit.addActionListener(this);
R_male.addActionListener(this);		
R_female.addActionListener(this);
R_transgender.addActionListener(this);
R_indian.addActionListener(this);
R_1other.addActionListener(this);	
ages.addActionListener(this);
days.addActionListener(this);
months.addActionListener(this);
years.addActionListener(this);
close.addActionListener(this);
close.addMouseListener(new MYMouseR(this));
setVisible( true );	

}

	
@SuppressWarnings("static-access")
public void actionPerformed(ActionEvent e)
 {
                                    
				if(e.getSource()==close)
				 {
				try{
				   int a=JOptionPane.showConfirmDialog(Registration.this,"Are you sure to close the program?","Confirmation",JOptionPane.YES_NO_OPTION);
				if(a==JOptionPane.YES_OPTION)
					{
					this.dispose();
					}
				else if(a==JOptionPane.NO_OPTION)
					{

					}

				    }
				catch(Exception exc){}
				}






//******************************************************************************************************************************
					String gender="";
					if(R_male.isSelected())
					 {
 					 gender="Male";
					 } 

					 else if(R_female.isSelected())
					 {
					 gender="Female";
					 }
              				 else if(R_transgender.isSelected())
					 {
					 gender="Transgender";
					 }	
				

					String nation="";

					 if(R_indian.isSelected())
 					{
 					nation="Indian";
					 } 

					 else if(R_1other.isSelected())
 					{
 						nation="Others";
					 } 
//*****************************************************************************************************************************************                                           
	String str=e.getActionCommand();
	if(str=="SUBMIT")
	{			 
 					String name=tname.getText();
				 	String fathername=tfname.getText();
					String dob=(String)days.getSelectedItem()+months.getSelectedItem()+years.getSelectedItem();
					int ag=Integer.parseInt((String)ages.getSelectedItem());
					String id=tid.getText();
					String address=tadd.getText();

		try
	 	{  
		stm.executeUpdate("insert into registration values('"+name+"','"+fathername+"','"+gender+"','"+dob+"',"+ag+",'"+nation+"','"+id+"','"+address+"')");   
		//lbl_status.setText("                Data Inserted Successfully        ");
		
                System.out.println(name);
		tname.setText("");	
		tfname.setText("");
   		tid.setText("");
   		tadd.setText("");	
	 	}
	
		catch(Exception e1)
		{
		e1.printStackTrace();
		}
	op.showMessageDialog(null,"Form Submited Successfully");		

	}
}
//*********************************************************************************************************************************************************************
		
					
/*
public static void main(String... a1)
{

r1=new Registration();
}

*/
}


