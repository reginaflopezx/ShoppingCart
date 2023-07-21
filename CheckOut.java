package shophomepage;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckOut extends JFrame implements ActionListener {

    private String clothingName;
    private int clothingPrice;
    public JTextField txtname, txtaddress, txtmobile, txttotal, txtclothingname;
    private final JButton back, pay;
    private final JLabel name, address, mobile, title, total;
    private final JPanel panel1;
    private final JScrollPane jspane2;
    public JTextArea summ;

    public CheckOut(String clothingName, int clothingPrice) {
        this.clothingName = clothingName;
        this.clothingPrice = clothingPrice;
        
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Downloads\\olshoppinglogo.png");    
        setIconImage(icon); 
        setTitle("Payment Order");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        panel1 = new JPanel();
        title = new JLabel();
        back = new JButton();
        name = new JLabel();
        address = new JLabel();
        mobile = new JLabel();
        txtname = new JTextField();
        txtclothingname = new JTextField();
        txtaddress = new JTextField();
        txtmobile = new JTextField();
        total = new JLabel();
        txttotal = new JTextField();
        pay = new JButton();
        jspane2 = new javax.swing.JScrollPane();
        summ = new javax.swing.JTextArea();

        panel1.setBackground(new java.awt.Color(102, 102, 0));

        title.setFont(new java.awt.Font("Arial", 1, 14));
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Checkout");

        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setFont(new java.awt.Font("Arial Black", 1, 12));
        back.setLabel("<");
        back.setBackground(new java.awt.Color(102, 102, 0));
        back.setName("");
        back.addActionListener(this);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        name.setFont(new java.awt.Font("Arial", 0, 12));
        name.setText("Name:");

        address.setText("Address:");

        mobile.setText("Mobile#:");

        total.setText("Total:");

        pay.setBackground(new java.awt.Color(255, 153, 153));
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pay.setFont(new java.awt.Font("Arial", 1, 12));
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setLabel("Place Order");
        pay.addActionListener(this);

        summ.setColumns(20);
        summ.setRows(5);
        summ.setEditable(false);
        jspane2.setViewportView(summ);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtclothingname, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jspane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtclothingname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jspane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        showSelectedClothing();
    }

    private void showSelectedClothing() {
        txttotal.setText(String.valueOf(clothingPrice));

        summ.setText("Selected Item:\n" + clothingName + "\t\t" + clothingPrice);
    }

    public void setClothingName(String cname) {
        this.clothingName = cname;
    }

    public void setClothingPrice(int price) {
        this.clothingPrice = price;
    }
    
     private void SqlDatabase() {
        String customerName = txtclothingname.getText();
        String customerAddress = txtaddress.getText();
        String mobileNumber = txtmobile.getText();

        if (customerName.isEmpty() || customerAddress.isEmpty() || mobileNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the customer details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!mobileNumber.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Mobile number should contain exactly 11 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/onlineshopping","root","");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO olshop (clothingName, clothingPrice, customerName, customerAddress, mobileNumber) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, clothingName);
            stmt.setInt(2, clothingPrice);
            stmt.setString(3, customerName);
            stmt.setString(4, customerAddress);
            stmt.setString(5, mobileNumber);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Order placed successfully!", "Payment", JOptionPane.PLAIN_MESSAGE);
                txtclothingname.setText("");
                txtaddress.setText("");
                txtmobile.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error while saving the order. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        stmt.close();
        conn.close();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
}

  @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
        dispose();
        new Homepage();
    } else if (e.getSource() == pay) {
        if (txtclothingname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(CheckOut.this, "Name field is empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (txtaddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(CheckOut.this, "Address field is empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!txtmobile.getText().matches("\\d{11}")) {
            JOptionPane.showMessageDialog(CheckOut.this, "Mobile number should contain exactly 11 digits", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            SqlDatabase(); 
            String fileName = "OrderDetails.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(clothingName + "\t\t" + clothingPrice);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace(); 
            }
        }
            dispose();
            new Homepage();
            JOptionPane.showMessageDialog(CheckOut.this, "Thank you for purchasing our product!",
                    "Payment", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
