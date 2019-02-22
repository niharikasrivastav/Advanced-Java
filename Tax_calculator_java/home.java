import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.io.*;

public class home implements ActionListener
{
	JFrame f1;
	JButton b1,b2,b3;
	JLabel l;

	home()
	{
		f1=new JFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l=new JLabel("Calculate Tax");
		l.setBounds(250,50,100,50);

		b1=new JButton("Income Tax");
		b1.setBounds(250,100,200,100);
		b2=new JButton("Corporate Tax");
		b2.setBounds(250,300,200,100);
		b3=new JButton("GST");
		b3.setBounds(250,500,200,100);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(l);

		f1.setSize(700,700);
		f1.setLayout(null);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			f1.setVisible(false);
			new itax();
		}

		else if(e.getSource()==b2)
		{
			f1.setVisible(false);
			new ctax();
		}

		else if(e.getSource()==b3)
		{
			f1.setVisible(false);
			new gst();
		}
	}

	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		new login();
		}
		});
	}
}

class itax implements ItemListener,ActionListener
{
	JFrame f2;
	JComboBox c;
	JTextField t;
	JButton b1,b2;
	JLabel l,l2,l3;
	String tax[]= {"Upto 2.5 lakhs per annum", "Between 2.5 lakhs and 5 lakhs per annum", "Between 5 lakhs and 10 lakhs", "Above 10 Lakhs"};
	double ta=0;

	itax()
	{
		f2=new JFrame();
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l=new JLabel("Income Tax Calculator");
		l.setBounds(50,50,200,50);

		c= new JComboBox(tax);
		c.setBounds(50,150,200,50);

		t= new JTextField();
		t.setBounds(50,300,100,20);

		l2= new JLabel("Enter Amount");
		l2.setBounds(50,250,100,20);

		f2.add(l);
		f2.add(c);
		c.addItemListener(this);

		b1= new JButton("Calculate");
		b1.setBounds(50,350,100,20);
		b1.addActionListener(this);

		l3=new JLabel();
		l3.setBounds(50,450,200,20);

		b2= new JButton("Go Home");
		b2.setBounds(350,500,100,20);
		b2.addActionListener(this);

		f2.add(t);
		f2.add(l2);
		f2.add(b1);
		f2.add(l3);
		f2.add(b2);

		f2.setSize(700,700);
		f2.setLayout(null);
		f2.setVisible(true);

	}

	public void itemStateChanged(ItemEvent e)
	{
		if(c.getSelectedIndex()==0)
		{
			ta=0;
		}
		else if(c.getSelectedIndex()==1)
		{
			ta=0.05;
		}
		else if(c.getSelectedIndex()==2)
		{
			ta=0.2;
		}
		else if(c.getSelectedIndex()==3)
		{
			ta=0.3;
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			f2.setVisible(false);
			new home();
		}
		else if(e.getSource()==b1)
		{
			String s=t.getText();
			double a=Double.parseDouble(s);
			double calc;
			calc=ta*a;
			String s1=String.valueOf(calc);
			l3.setText("Tax Payable= " + s1);
		}

	}
}

class ctax implements ActionListener,ItemListener
{
	JFrame f3;
	JTextField t;
	JComboBox c1,c2;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5;
	String com[]={"Domestic","Foreign"};
	String con[]={"USA","France","Germany","Spain","United Kingdom"};
	double tc=0;

	ctax()
	{
		f3= new JFrame();
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l5=new JLabel("Corporate Tax Calculator");
		l5.setBounds(300,50,200,20);

		l1=new JLabel("Type of Company:");
		l1.setBounds(50,100,200,20);

		c1= new JComboBox(com);
		c1.setBounds(50,150,150,20);
		c1.addItemListener(this);

		l2= new JLabel("Country:");
		l2.setBounds(250,150,200,20);

		c2= new JComboBox(con);
		c2.setBounds(400,150,150,20);
		c2.addItemListener(this);

		l3= new JLabel("Enter Amount:");
		l3.setBounds(50,200,150,20);

		t= new JTextField();
		t.setBounds(50,250,150,20);

		l4=new JLabel();
		l4.setBounds(50,300,250,20);

		b1=new JButton("Calculate");
		b1.setBounds(50,350,100,50);
		b1.addActionListener(this);

		b2=new JButton("Home");
		b2.setBounds(250,450,100,50);
		b2.addActionListener(this);

		f3.add(l1);
		f3.add(l3);
		f3.add(c1);
		f3.add(l4);
		f3.add(t);
		f3.add(b1);
		f3.add(b2);
		f3.add(l5);

		f3.setSize(600,600);
		f3.setLayout(null);
		f3.setVisible(true);
	}

	public void itemStateChanged(ItemEvent e)
	{
		if(c1.getSelectedIndex()==0)
		{
			f3.remove(l2);
			f3.remove(c2);
			f3.repaint();
			tc=0.3;
		}

		else if(c1.getSelectedIndex()==1)
		{
			f3.add(l2);
			f3.add(c2);

			if(c2.getSelectedIndex()==0)
				tc=0.35;
			else if(c2.getSelectedIndex()==1)
				tc=0.2;
			else if(c2.getSelectedIndex()==2)
				tc=0.2965;
			else if(c2.getSelectedIndex()==3)
				tc=0.25;
			else if(c2.getSelectedIndex()==4)
				tc=0.19;
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			f3.setVisible(false);
			new home();
		}
		else if(e.getSource()==b1)
		{
			String s1=t.getText();
			double d=Double.parseDouble(s1);
			double cal=d*tc;
			l4.setText("Tax Payable= " + String.valueOf(cal));
		}
	}
}

class gst implements ActionListener, ItemListener
{
	JFrame f4;
	JTextField t;
	JButton b1,b2;
	JComboBox c1,c2,c3,c4,c5,c6;
	String cat1[]={"Milk","Eggs","Curd","Lassi","Unpacked Foodgrains","Unpacked Paneer","Gur","Unbranded Natural Honey","Fresh Vegetables","Salt","Kajal","Educations Services","Health Services","Children’s Drawing & Colouring Books","Unbranded Atta","Unbranded Maida","	Besan","Prasad","Palmyra Jaggery","Phool Bhari Jhadoo"};
	String cat2[]={"Sugar","Tea","Edible Oils","Domestic LPG","PDS Kerosene","Cashew Nuts","Milk Food for Babies","Fabric","Spices","Coal","Life-saving drugs","Packed Paneer","Coal","Raisin","Roasted Coffee Beans","Skimmed Milk Powder","Footwear (< Rs.500)","Apparels (< Rs.1000)","Coir Mats, Matting & Floor Covering","Agarbatti","Mishti/Mithai (Indian Sweets)","Coffee (except instant)"};
	String cat3[]={"Butter","Ghee","Almonds","Fruit Juice","Packed Coconut Water","Computers","Processed food","Mobiles","	Preparations of Vegetables, Fruits, Nuts or other parts of Plants including Pickle Murabba, Chutney, Jam, Jelly","Umbrella"};
	String cat4[]={"Hair Oil","Toothpaste","Soap","Pasta","Corn Flakes","Soups","Capital goods","Industrial Intermediaries","Ice-cream","	Toiletries","Computers","Printers"};
	String cat5[]={"Small cars","High-end motorcycles","Consumer durables such as AC and fridge","Luxury & sin items like BMWs, cigarettes and aerated drinks"};
	String cat[]={"Category I","Category II","Category III","Category IV","Category V"};
	JLabel l1,l2,l3,l4,l5,l6;
	double tg=0;

	gst()
	{
		f4=new JFrame();
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1=new JLabel("GST Calculator");
		l1.setBounds(350,50,200,20);

		l2=new JLabel("Category:");
		l2.setBounds(50,120,150,20);

		c1=new JComboBox(cat);
		c1.setBounds(50,170,150,20);
		c1.addItemListener(this);

		l3=new JLabel("Item:");
		l3.setBounds(250,120,100,20);

		c2=new JComboBox(cat1);
		c2.setBounds(250,170,200,20);

		c3=new JComboBox(cat2);
                c3.setBounds(250,170,200,20);

		c4=new JComboBox(cat3);
                c4.setBounds(250,170,200,20);

		c5=new JComboBox(cat4);
                c5.setBounds(250,170,200,20);

		c6=new JComboBox(cat5);
                c6.setBounds(250,170,500,20);

		l4= new JLabel();
		l4.setBounds(50,230,200,20);

		l5= new JLabel("Enter Amount:");
		l5.setBounds(50,270,200,20);

		t=new JTextField();
		t.setBounds(50,330,200,20);

		b1=new JButton("Calculate");
		b1.setBounds(50,370,100,20);
		b1.addActionListener(this);

		l6=new JLabel();
		l6.setBounds(50,430,600,20);

		b2=new JButton("Go Home");
                b2.setBounds(350,500,100,20);
                b2.addActionListener(this);

		f4.add(l1);
	        f4.add(l2);
	        f4.add(c1);
	        f4.add(l4);
		 f4.add(l5);
		 f4.add(t);
		 f4.add(b1);
		 f4.add(b2);
		f4.add(l6);
		f4.add(l3);

		f4.setLayout(null);
		f4.setSize(1000,700);
		f4.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			f4.setVisible(false);
			new home();
		}
		else if(e.getSource()==b1)
		{
			String s=t.getText();
			double d=Double.parseDouble(s);
			double ca=d+(tg*d);
			l6.setText("Total Amount Payable= " + String.valueOf(ca));
		}
	}

	public void itemStateChanged(ItemEvent e)
	{
		if(c1.getSelectedIndex()==0)
		{
			f4.remove(c2);
			f4.add(c2);
			f4.remove(c3);
			f4.remove(c4);
			f4.remove(c5);
			f4.remove(c6);
			f4.repaint();
			f4.add(l3);
			l4.setText("Tax: 0%");
			tg=0;
		}

		else if(c1.getSelectedIndex()==1)
                {
			f4.remove(c2);
                        f4.remove(c3);
                        f4.remove(c4);
                        f4.remove(c5);
                        f4.remove(c6);
                        f4.repaint();
                        f4.add(c3);
                        l4.setText("Tax: 5%");
                        tg=0.05;
                }

		else if(c1.getSelectedIndex()==2)
                {
			f4.remove(c2);
                        f4.remove(c3);
                        f4.remove(c4);
                        f4.remove(c5);
                        f4.remove(c6);
                        f4.repaint();
                        f4.add(c4);
                        l4.setText("Tax: 12%");
                        tg=0.12;
                }

		else if(c1.getSelectedIndex()==3)
                {
			f4.remove(c2);
                        f4.remove(c3);
                        f4.remove(c4);
                        f4.remove(c5);
                        f4.remove(c6);
                        f4.repaint();
                        f4.add(c5);
                        l4.setText("Tax: 18%");
                        tg=0.18;
                }

		else if(c1.getSelectedIndex()==4)
                {
			f4.remove(c2);
                        f4.remove(c3);
                        f4.remove(c4);
                        f4.remove(c5);
                        f4.remove(c6);
                        f4.repaint();
                        f4.add(c6);
                        l4.setText("Tax: 28%");
                        tg=0.28;
                }

	}
}

class login implements ActionListener
{
	JFrame f5;
	JTextField te1;
	JPasswordField te2;
	JButton log;
	JLabel u,p,top,fail;
	
	login()
	{
		f5=new JFrame();
		f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		top=new JLabel("Please login");
		top.setBounds(200,50,200,50);

		u=new JLabel("Username:");
		u.setBounds(50,150,100,50);

		te1=new JTextField();
		te1.setBounds(200,150,200,20);

		p=new JLabel("Password:");
		p.setBounds(50,250,100,50);

		te2=new JPasswordField();
		te2.setBounds(200,250,200,20);

		log=new JButton("Login");
		log.setBounds(200,400,100,20);
		log.addActionListener(this);
		
		fail=new JLabel();
		fail.setBounds(200,500,200,50);

		f5.add(te1);
		f5.add(te2);
		f5.add(log);
		f5.add(u);
		f5.add(p);
		f5.add(top);
		f5.add(fail);
		
		f5.setLayout(null);
		f5.setVisible(true);
		f5.setSize(700,700);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String c1= "nikkubhaiya";
		String c2= "bhaiyaisasuxx";
		String tx1=te1.getText();
		String tx2=String.valueOf(te2.getPassword()); 
		if(e.getSource()==log)
		{
			try{
				if(tx1.equals(c1))
					{
						if(tx2.equals(c2))
						{
							f5.setVisible(false);
							new home();
						}
						else
							fail.setText("Password is wrong");
					}
				else
					fail.setText("Username or Password is wrong");
				}catch(Exception ae){fail.setText("Error");}
	
}
}	
}