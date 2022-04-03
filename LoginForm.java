import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class LoginForm extends JFrame implements ActionListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton btn_login,btn_reset,close;
JLabel l1,l2,l3,lbl_username,lbl_password,lbl_message;
JTextField txt_username;
JPasswordField passfield;
JPanel p1;
Font f,f1;

LoginForm()
{
f=new Font("serif",Font.BOLD,24);
f1=new Font("serif",Font.BOLD,20);

setTitle("LoginForm");

ImageIcon p=new ImageIcon("img39.png");
Image ny=p.getImage();
setIconImage(ny);

//setBackground(new Color(214,150,106));
setUndecorated( true );
getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.ORANGE));
setBounds(500,80,380,500);

close=new JButton(new ImageIcon("img25.jpg"));
close.setBounds(330,5,30,40);
add(close);

l3=new JLabel(new ImageIcon("img15.jpg"));
l3.setBounds(240,150,100,150);


lbl_username=new JLabel("UserName");
lbl_password=new JLabel("Password");
lbl_message=new JLabel("");

txt_username=new JTextField();
passfield = new JPasswordField();

btn_login=new JButton("Login");
btn_reset=new JButton("Reset");

lbl_username.setBounds(30,100,140,30);
lbl_username.setFont(f);
l1=new JLabel(new ImageIcon("img13.jpg"));
l1.setBounds(180,100,30,30);
lbl_password.setBounds(30,190,140,30);
lbl_password.setFont(f);
l2=new JLabel(new ImageIcon("img8.jpeg"));
l2.setBounds(180,195,30,30);
lbl_message.setBounds(40,330,250,30);
lbl_message.setForeground(Color.RED);
lbl_message.setFont(f1);

txt_username.setBounds(30,150,200,30);
txt_username.setFont(f);
passfield.setBounds(30,230,200,30);
passfield.setFont(f);
btn_login.setBounds(40,370,130,30);
btn_login.setFont(f);
btn_reset.setBounds(190,370,130,30);
btn_reset.setFont(f);
p1=new JPanel();
p1.setLayout(null);
p1.setSize(300,300);


p1.add(l3);
p1.add(l1);
p1.add(lbl_username);
p1.add(txt_username);
p1.add(lbl_message);
p1.add(lbl_password);
p1.add(l2);
p1.add(passfield);
p1.add(btn_login);
p1.add(btn_reset);
add(p1);

p1.setBackground(Color.WHITE);
btn_login.addActionListener(this);
btn_reset.addActionListener(this);
close.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
				{
				if(e.getSource()==close)
				{
				try{
int a=JOptionPane.showConfirmDialog(LoginForm.this,"Are you sure to close the program?","Confirmation",JOptionPane.YES_NO_OPTION);
if(a==JOptionPane.YES_OPTION)
{
System.exit(0);
}
					}catch(Exception exc){}
			}}});	

		

setVisible(true);
setResizable(false);
}

public void actionPerformed(ActionEvent e)
{
String uname=txt_username.getText();
@SuppressWarnings("deprecation")
String pass=passfield.getText();

if(e.getSource()==btn_login)
	{
	try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");

       		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","kumar");
		Statement stm=con.createStatement();
		ResultSet res=stm.executeQuery("select * from login where username='"+uname+"'and password='"+pass+"'");
	if(res.next())
		{
		new MyFrame();this.dispose();
		}
	else
		{
        	lbl_message.setText("invalid username or password");
		txt_username.setText("");
		passfield.setText("");	
		}
	} 

	catch(Exception e1)
		{e1.printStackTrace();}
	}

if(e.getSource()==btn_reset)
{
txt_username.setText("");
passfield.setText("");
lbl_message.setText(" ");
}
}

public static void main(String...a)
{
new LoginForm();
}
}

	