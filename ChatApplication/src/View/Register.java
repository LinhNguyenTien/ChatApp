package View;

import Controller.MD5;
import Controller.PasswordFormat;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {
    private String url="jdbc:mysql://localhost:3306/login";
    private String username="root";
    private String password="0398445870";
    private JPanel contentPane;
    private JTextField txtdisplayNm;
    private JTextField txtName;
    private JTextField txtPassword;
    private JTextField retypePassword;
    private String secretkey = "Aa@123456";

    public Register() {
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel.setBounds(151, 11, 225, 32);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Tên hiển thị");
        lblNewLabel_1.setBounds(39, 57, 86, 16);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Tên người dùng");
        lblNewLabel_2.setBounds(39, 85, 104, 16);
        contentPane.add(lblNewLabel_2);

        txtdisplayNm = new JTextField();

        txtdisplayNm.setForeground(new Color(0, 0, 0));
        txtdisplayNm.setBounds(161, 55, 263, 20);
        contentPane.add(txtdisplayNm);
        txtdisplayNm.setColumns(10);

        txtName = new JTextField();
        txtName.setForeground(new Color(0, 0, 0));
        txtName.setBounds(161, 83, 263, 20);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JButton btnSave = new JButton("Đăng ký");
        btnSave.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                String dn = txtdisplayNm.getText();
                String nm = txtName.getText();
                String pw = txtPassword.getText();
                String pwEncryption = MD5.getMd5(pw);
                PasswordFormat strong = new PasswordFormat();
                Connection conn = null;
                try {
                    //Kết nối CSDL mySQL
                    System.out.println("Connecting to database...");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(url, username, password);
                    if (conn != null) {
                        System.out.println("Connected to database");
                    }
                    Statement statement = conn.createStatement();
                    StringBuilder sb = new StringBuilder();
                    JFrame frame = new JFrame("JOptionPane");
                    String checkuserName = "select * from informationuser where userName = '" + nm + "';";
                    ResultSet rs = statement.executeQuery(checkuserName);
                    if (strong.checkPasswordStrength(pw) == false) {
                        sb.append("MẬT KHẨU KHÔNG ĐÚNG ĐỊNH DẠNG \n");
                        sb.append("Mật khẩu phải tối thiểu 8 ký tự, có chữ hoa, chữ thường, ký tự đặc biệt và số tự nhiên.");
                    }
                    if (rs.next() == true) {
                        sb.append("Tên người dùng này đã được sử dụng, vui lòng thử lại");
                    }
                    if (!txtPassword.getText().equals(retypePassword.getText())) {
                        sb.append("Mật khẩu không trùng khớp!");
                    }
                    if (txtdisplayNm.getText().equals("")) {
                        sb.append("Vui lòng nhập tên hiển thị \n");
                    }
                    if (txtName.getText().equals("Tên sẽ được dùng để đăng nhập")) {
                        sb.append("Vui lòng nhập tên người dùng \n");
                    }
                    if (txtPassword.getText().equals("")) {
                        sb.append("Vui lòng nhập mật khẩu \n");
                    }
                    if (retypePassword.getText().equals("")) {
                        sb.append("Vui lòng nhập mật khẩu xác nhận! \n");
                    }
                    if (sb.length() > 0) {
                        JOptionPane.showMessageDialog(frame, sb, "Không thể thực hiện!", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(frame, "Bạn có chắc muốn đăng ký với thông tin đã cung cấp?", "Cần xác nhận!",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirm == JOptionPane.YES_OPTION) {
                            String sql = "INSERT into informationUser (displayName, userName, password) VALUES (?,?,?)";
                            PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                            pstm.setString(1, dn);
                            pstm.setString(2, nm);
                            pstm.setString(3, pwEncryption);
                            pstm.executeUpdate();
//							System.out.println("Added Account");
                            JOptionPane.showMessageDialog(frame, "Bạn đã đăng ký thành công! Vui lòng đăng nhập", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//							System.out.println(AES.encrypt(secretkey, pw));
//							System.out.println(AES.decrypt(pw, secretkey));
                        } else if (confirm == JOptionPane.NO_OPTION) {
                            return;
                        }
                    }
                }
                catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnSave.setBounds(39, 204, 99, 26);
        contentPane.add(btnSave);

        JButton btnDelete = new JButton("Xóa tất cả");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtdisplayNm.setText("");
                txtName.setText("");
                txtPassword.setText("");
                retypePassword.setText("");

            }
        });
        btnDelete.setBounds(162, 204, 99, 26);
        contentPane.add(btnDelete);

        JLabel labelPassword = new JLabel("Mật khẩu");
        labelPassword.setBounds(39, 117, 55, 16);
        contentPane.add(labelPassword);

        txtPassword = new JPasswordField();
        txtPassword.setToolTipText("Vui lòng nhập mật khẩu");
        txtPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        txtPassword.setBounds(161, 115, 161, 20);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);

        JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
        lblNhpLiMt.setBounds(39, 147, 104, 16);
        contentPane.add(lblNhpLiMt);

        retypePassword = new JPasswordField();
        retypePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        retypePassword.setToolTipText("Nhập lại đúng với mật khẩu ở trên");
        retypePassword.setColumns(10);
        retypePassword.setBounds(161, 149, 161, 20);
        contentPane.add(retypePassword);

        JButton btnNewButton = new JButton("Chuyển sang Đăng nhập");
        JFrame frame = new JFrame("JOptionPane");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
            }
        });
        btnNewButton.setBounds(288, 204, 180, 26);
        contentPane.add(btnNewButton);
    }

    public JTextField getTxtdisplayNm() {
        return txtdisplayNm;
    }

    public void setTxtdisplayNm(JTextField txtdisplayNm) {
        this.txtdisplayNm = txtdisplayNm;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

}
