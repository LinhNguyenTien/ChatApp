package View;

import Controller.MD5;
import Model.Server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends JFrame {

    private String url = "jdbc:mysql://localhost:3306/login";
    private String username = "root";
    private String password = "0398445870";
    public static Connection conn;

    public Login() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPwd = new javax.swing.JPasswordField();
        btnDangnhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Tên người dùng");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu");

        txtUserName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtPwd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwdActionPerformed(evt);
            }
        });

        btnDangnhap.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDangnhap.setText("ĐĂNG NHẬP");
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDangnhap)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(jLabel1)))
                                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(btnDangnhap)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPwdActionPerformed

    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed

        try {
            System.out.println("Connecting to database...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connected to database");
            }
            Statement s = conn.createStatement();
            String userName = txtUserName.getText();
            String password = txtPwd.getText();
            String encryption = MD5.getMd5(password);
            String sql = "select *from informationUser where userName = '" + userName + "'and password='" + encryption + "';";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next() == true) {
                int id = rs.getInt(1);
                Thread threadStartServer = new Thread(new Runnable() {
                @Override
                public void run() {
                    setVisible(false);
                    new Client().setVisible(true);
                }
                });
                threadStartServer.start();
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu, xin nhập lại! ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDangnhapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
