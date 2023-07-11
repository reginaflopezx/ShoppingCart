import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class finalnato extends JFrame implements ActionListener {

	private JPanel mainPanel, itemPanel, pricePanel;
    private JLabel totalLabel;
    private JTextArea totalArea;
    private JButton btnCheckOut, btnBackToHp, btnRemoveItem, btnTotal;
    
    public finalnato(){

    	setTitle("SHOPPING CART");
    	setSize(800,600);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


    	mainPanel = new JPanel();
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
    	mainPanel.setLayout(new GridLayout(1,2));

        JLabel titleLabel = new JLabel("SHOPPING CART");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 25, 0, 0));
        add(titleLabel, BorderLayout.WEST);

    	itemPanel = new JPanel();
    	itemPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "ITEMS",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Times New Roman", Font.BOLD, 16)));
    	itemPanel.setLayout(new GridLayout(0,1));
        itemPanel.setBackground(Color.WHITE);
        JTextArea itemTextArea = new JTextArea();
        Font itemFont = new Font("Calibri", Font.PLAIN, 16); // Specify the desired font and size
            itemTextArea.setFont(itemFont);
        // itemTextArea.setEditable(false);
        JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
            itemPanel.add(itemScrollPane, BorderLayout.CENTER);

    	pricePanel = new JPanel();
    	pricePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "PRICES",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Times New Roman", Font.BOLD, 16)));
    	pricePanel.setLayout(new GridLayout(0,1));
        pricePanel.setBackground(Color.WHITE);
        JTextArea priceTextArea = new JTextArea();
        Font priceFont = new Font("Calibri", Font.PLAIN, 18); // Specify the desired font and size
            priceTextArea.setFont(priceFont);
        // priceTextArea.setEditable(false);
        JScrollPane priceScrollPane = new JScrollPane(priceTextArea);
        pricePanel.add(priceScrollPane, BorderLayout.CENTER);
    
    	//Adding JPanel 1 and 2 to main JPanel
    	mainPanel.add(itemPanel);
    	mainPanel.add(pricePanel);
        

        //Setting up the container ready for the components to be added.
    	Container pane = getContentPane();
    	setContentPane(pane);

        //Add panel to the container
    	pane.add(mainPanel);

        totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalArea = new JTextArea();
        Font totalFont = new Font("Calibri", Font.PLAIN, 16); 
            totalArea.setFont(totalFont);
        totalArea.setEditable(false);
        JScrollPane totalScrollPane = new JScrollPane(totalArea);

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(),
            "RECEIPT",
            TitledBorder.DEFAULT_JUSTIFICATION,
            TitledBorder.DEFAULT_POSITION,
            new Font("Times New Roman", Font.BOLD, 16)));
        totalPanel.setBackground(Color.WHITE);
        totalPanel.add(totalLabel, BorderLayout.SOUTH);
        totalPanel.add(totalScrollPane, BorderLayout.CENTER);
        mainPanel.add(totalPanel, BorderLayout.EAST);
        
        btnCheckOut = new JButton("CHECKOUT");
        btnCheckOut.setFont(new Font("Arial", Font.BOLD, 13));
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itemTextArea.getText().isEmpty() && priceTextArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cart is empty. Please add items to the cart.");
                } 
                else{
                    dispose();
                    // new CheckOut;
                }
            }
        });

        btnBackToHp = new JButton("BACK TO HOMEPAGE");
        btnBackToHp.setFont(new Font("Arial", Font.BOLD, 13));
        btnBackToHp.addActionListener(this);
            
        btnRemoveItem = new JButton("REMOVE ITEM");
        btnRemoveItem.setFont(new Font("Arial", Font.BOLD, 13));
        btnRemoveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = itemTextArea.getSelectedText();
                if (selectedText != null) {
                    String currentItems = itemTextArea.getText();
                    String currentPrices = priceTextArea.getText();

                    String[] items = currentItems.split("\n");
                    String[] prices = currentPrices.split("\n");

                    StringBuilder updatedItems = new StringBuilder();
                    StringBuilder updatedPrices = new StringBuilder();

                    for (int i = 0; i < items.length; i++) {
                        if (!items[i].equals(selectedText)) {
                            updatedItems.append(items[i]).append("\n");
                            updatedPrices.append(prices[i]).append("\n");
                        }
                    }

                    itemTextArea.setText(updatedItems.toString());
                    priceTextArea.setText(updatedPrices.toString());
                }
            }
        });

        btnTotal = new JButton("Total");
        btnTotal.setFont(new Font("Arial", Font.BOLD, 13));
        btnTotal.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                String[] items = itemTextArea.getText().split("\n");
                String[] prices = priceTextArea.getText().split("\n");

                StringBuilder receiptBuilder = new StringBuilder();
                double total = 0.0;
        
                for (int i = 0; i < items.length; i++) {
                    receiptBuilder.append(items[i]).append("\t").append(prices[i]).append("\n");
                    try {
                        double itemPrice = Double.parseDouble(prices[i]);
                        total += itemPrice;
                    } 
                    catch (NumberFormatException ex) {
                // Ignore any non-numeric price values
                    }
                }
        totalArea.setText(receiptBuilder.toString());
        totalLabel.setText("Total: P" + String.format("%.2f", total));
            }
        });

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        buttonPanel.add(btnBackToHp);
        buttonPanel.add(btnCheckOut);
        buttonPanel.add(btnRemoveItem);
        buttonPanel.add(btnTotal);


        // Add the button panel to the main JFrame
        add(buttonPanel, BorderLayout.SOUTH);

    	setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource() == btnBackToHp){
        dispose();
        // new Homepage();
       } 
}

    public static void main (String[] args) {
    
        new finalnato();

	}

}
