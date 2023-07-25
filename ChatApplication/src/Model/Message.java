/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author TGDD
 */
public abstract class Message extends JLabel implements Runnable{
    private int ID;
    private String content;
    private Client user;
    private JPanel chatFrame;
    public Message(int ID, String content, Client user, JPanel chatFrame){
        this.ID = ID;
        this.content = content;
        this.user = user;
        this.chatFrame = chatFrame;
    }
    
    public JLabel createMessage(String content, boolean canRecover) {
        
        JLabel label = new JLabel("Bạn có muốn thu hồi tin nhắn này?");
        label.setHorizontalAlignment(JLabel.CENTER);
        
        JButton accept = new JButton("Đồng ý");
        accept.setSize(100, 20);
        accept.setPreferredSize(new Dimension(100, 20));
        accept.setVisible(true);
        
        JButton deny = new JButton("Hủy");
        deny.setSize(100, 20);
        deny.setPreferredSize(new Dimension(100, 20));
        deny.setVisible(true);
        
        JDialog noti = new JDialog();
        noti.setLayout(new BorderLayout());
        noti.add(label, BorderLayout.CENTER);
        noti.setVisible(false);
        noti.setTitle("Thông báo!");
        noti.setLocationRelativeTo(null);
        noti.setSize(300, 150);
        noti.setPreferredSize(new Dimension(300, 150));
        
        JLabel messageBtn = new JLabel(content);
        messageBtn.setBounds(10, 30 * (chatFrame.getComponentCount()) + 10, content.length() * 13, 25);
        if (canRecover == true) {
            messageBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2 && canRecover) {
                        noti.setVisible(true);
                    }
                }
            });
            
            accept.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    noti.setVisible(false);
                    messageBtn.setText("Tin nhắn đã được thu hồi");
                    messageBtn.setSize(180, 25);
                    messageBtn.setEnabled(false);
                }
            });
            
            deny.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    noti.setVisible(false);
                }
            });
        }
        JPanel menu = new JPanel();
        menu.add(accept);
        menu.add(deny);
        noti.add(menu, BorderLayout.PAGE_END);
        return messageBtn;
    }
}
