import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
 
 
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
 
public class MyFrame extends JFrame{ 
	
    private JTextField input1=new JTextField(3);
    private JButton funcShow=new JButton("+");
    private JTextField input2=new JTextField(3);
    private JButton show=new JButton();
    private JButton equal=new JButton("="); 
   
    
    private JButton btn_sum=new JButton("+");
    private JButton btn_sub=new JButton("-");
    private JButton btn_mul=new JButton("*");
    private JButton btn_div=new JButton("/");
    private JButton btn_OK=new JButton("OK");
    
    public MyFrame(String title)
    {
        this();
        setTitle(title);
    }
    
    private double geiResult(double a, double b, String func) {
    	double sum = 0;
    	switch(func.charAt(0)) {
    	case '+':
    		sum = a + b;
    		break;
    	case '-':
    		sum = a - b;
    		break;
    	case '*':
    		sum = a * b;
    		break;
    	case '/':
    		sum = a / b;
    		break;
    	default:
    		break;
    	}
    	return sum;
    }
    
    
    private MyFrame(){
        setLayout(new GridLayout(2, 5));
        setSize(500,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        funcShow.setEnabled(false);
        show.setEnabled(false);
        equal.setEnabled(false);
        add(input1);
        add(funcShow);
        add(input2);
        add(equal);
        add(show);
        add(btn_sum);
        add(btn_sub);
        add(btn_mul);
        add(btn_div);
        add(btn_OK);
        show.setAlignmentX(show.CENTER_ALIGNMENT);
        show.setAlignmentY(show.CENTER_ALIGNMENT);
        input1.setHorizontalAlignment(input1.CENTER);
        input2.setHorizontalAlignment(input2.CENTER);
        
        btn_OK.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(input1.getText());
                double b = Double.parseDouble(input2.getText());
                String func = funcShow.getText();
                Double sum = geiResult(a, b, func);
                show.setText("" + sum);
        	}
        });
        
        //控制字符输入长度
        input1.addKeyListener(new KeyAdapter(){
        	@Override
        	public void keyTyped(KeyEvent e) {
        		int length = input1.getText().length();
        		if (length < 3) {
        			String num = (length == 0 ? "123456789": "0123456789");
        			if (num.indexOf(e.getKeyChar()) < 0)
        				e.consume();
        		} else {
        			e.consume();
        		}
        	}
        });
        
        input2.addKeyListener(new KeyAdapter(){
        	@Override
        	public void keyTyped(KeyEvent e) {
        		int length = input2.getText().length();
        		if (length < 3) {
        			String num = (length == 0 ? "123456789": "0123456789");
        			if (num.indexOf(e.getKeyChar()) < 0)
        				e.consume();
        		} else {
        			e.consume();
        		}
        	}
        });
        
        btn_sum.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		funcShow.setText("+");
        	}
        });
        
        btn_sub.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		funcShow.setText("-");
        	}
        });
        
        btn_mul.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		funcShow.setText("*");
        	}
        });
        
        btn_div.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		funcShow.setText("/");
        	}
        });
    }
    
    public static void main(String[] args) {
        MyFrame mf=new MyFrame("简单计算器（限制输入3位，限制输入数字, 限制第一个数字不为0）");
        mf.setVisible(true);
    }
}