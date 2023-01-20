import javax.swing.*;  
public class Sample2 extends JFrame{//inheriting JFrame  
JFrame f;  
Sample2(){  
JButton b=new JButton("click");//create button  
b.setBounds(130,100,100, 40);  
          
add(b);//adding button on frame  
setSize(1000,500);  
setLayout(null);  
setVisible(true);  
}  

public static void main(String[] args) {  
new Sample2();  

}}  