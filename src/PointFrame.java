import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class PointFrame extends JFrame implements ActionListener{
	
	public static int No_all=0;
	int No;
	CenterFrame cp;
	TextArea t;
	TextArea get;
	JTextField No_f;
	JButton send;
	String msg_get="";
	Label lab;
	Color aaa = null;
	public PointFrame(int R,int G,int B)
	{
		No=No_all++;
		this.setTitle("本节点号：   "+No);
		
		
		setSize(500,300);
		this.setLocation(300,200);
		send=new JButton("发送");
		
		t=new TextArea("", 10,20,TextArea.SCROLLBARS_VERTICAL_ONLY);get=new TextArea("", 10,20,TextArea.SCROLLBARS_VERTICAL_ONLY);No_f=new JTextField("0",10);
		//t.setLineWrap(true);
		//get.setLineWrap(true);
		get.setEditable(false);
		aaa=new Color(R,G,B);
		get.setBackground(aaa);
		
		//get.setWrapStyleWord(true);
		//get.setAutoscrolls(true);
		this.setLayout(new BorderLayout());
		
		send.addActionListener(this);
	add( "North",No_f);add("Center",t);add("East",get);add("South",send);
		pack();
		
		setVisible(true);
	}
	public void setCenter(CenterFrame cp)
	{
		this.cp=cp;
	}
	public void updateMessage(String msg)
	{
		msg=msg+"\n";
		msg_get=msg+msg_get;
		get.setText(msg_get);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String msg="节点"+No+"发来信息："+t.getText();
		t.setText("");
		int n=Integer.parseInt(No_f.getText());
		cp.msg=msg;
		cp.sentTo(n);
		cp.repaint();
	}

}