import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * 创建日期 2008-12-14
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */

/**
 * @author xxzxxz
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class CenterFrame extends JFrame implements ActionListener{
	JMenuBar jb=new JMenuBar();
	JMenu add=new JMenu("操作");
	
	JMenuItem exit=new JMenuItem("退出");
	JMenuItem add1=new JMenuItem("添加节点");
	JMenuItem add2=new JMenuItem("添加第二个节点");
	//CenterPanel cp;
	ArrayList points=new ArrayList();
	String msg="";
	public CenterFrame()
	{
		this.setJMenuBar(jb);
		jb.add(add);
		
		add.add(add1);add.add(add2);add.add(exit);
		setSize(500,300);
		exit.addActionListener(this);
		add1.addActionListener(this);
		add2.addActionListener(this);
		//cp=new CenterPanel();
		//getContentPane().add(cp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawString(msg,100,150);
		g.drawString("这是中心窗口,客户窗口发送信息如下：",100,130);
		
	}
	public void addPoint(PointFrame p)
	{
		p.setCenter(this);
		points.add(p);
	}
	public void sentTo(int n)
	{
		Iterator i=points.iterator();
		while(i.hasNext())
		{
			PointFrame p=(PointFrame)i.next();
			if(p.No==n)
			{
				p.updateMessage(msg);
			}
		}
	}
	public static void main(String[] args) {
		CenterFrame m=new CenterFrame();
		
	}

	/* （非 Javadoc）
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成方法存根
		if(arg0.getSource()==exit)System.exit(0);
		else if(arg0.getSource()==add1) 
			{
			PointFrame f=new PointFrame(100,255,100);			
			addPoint(f);						
			}
		else if(arg0.getSource()==add2) 
			{
			PointFrame f=new PointFrame(50,100,150);		
			addPoint(f);		
			}
	}
	
}
