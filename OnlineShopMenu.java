package shophomepage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OnlineShopMenu extends JFrame {

	private String[] clothingName;
    private int[] clothingPrice;
    private JLabel titleLabel;
    private JButton[] categoryButtons;
    private String[] categoryNames = {
            "Men's Clothing",
            "Women's Clothing",
            "Infant Clothing",
            "Kids Wear for Girls",
            "Kids Wear for Boys",
            "Home Merchandise",
            "Gadget",
            "Back to Homepage"
    };
    
    public String[] getClothingName() {
        return clothingName;
    }
    public void setClothingName(String[] clothingName) {
        this.clothingName = clothingName;
    }
    public int[] getClothingPrice() {
        return clothingPrice;
    }
    public void setClothingPrice(int[] clothingPrice) {
        this.clothingPrice = clothingPrice;
    }
    
    public OnlineShopMenu() {
        setTitle("PRODUCTS MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Downloads\\olshoppinglogo.png");    
       setIconImage(icon); 

        titleLabel = new JLabel("Welcome to our Online Shop! Please select a category:");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(categoryNames.length, 1, 0, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 20));

        categoryButtons = new JButton[categoryNames.length];
        for (int i = 0; i < categoryNames.length; i++) {
            categoryButtons[i] = new JButton(categoryNames[i]);
            categoryButtons[i].setFont(new Font("Arial", Font.BOLD, 15));
            categoryButtons[i].setMargin(new Insets(20, 10, 20, 10));
            categoryButtons[i].setBackground(new Color(102, 102, 0));
            categoryButtons[i].setForeground(Color.WHITE);
            categoryButtons[i].addActionListener(new CategoryButtonListener());
            buttonPanel.add(categoryButtons[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) (screenSize.width * 0.5);
        int frameHeight = (int) (screenSize.height * 0.5);
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null); 

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CategoryButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton source = (JButton) event.getSource();
            String selectedCategory = source.getText();
            if (selectedCategory.equals("Men's Clothing")) {
                showMensClothing();
            } else if (selectedCategory.equals("Women's Clothing")) {
                showWomensClothing();
            } else if (selectedCategory.equals("Infant Clothing")) {
                showInfantClothing();
            } else if (selectedCategory.equals("Kids Wear for Girls")) {
                showKidsWearGirls();
            } else if (selectedCategory.equals("Kids Wear for Boys")) {
                showKidsWearBoys();
            } else if (selectedCategory.equals("Home Merchandise")) {
                showHomeMerchandise();
            } else if (selectedCategory.equals("Gadget")) {
                showGadgets();
            } else if (selectedCategory.equals("Back to Homepage")) {
                dispose();
                new Homepage().setVisible(true);
                
            }
        }
    }

    private void showMensClothing() {
        JButton tShirtButton = createClothingButton("T-shirt", 390);
        JButton poloShirtButton = createClothingButton("Polo shirt", 590);
        JButton dressShirtButton = createClothingButton("Dress shirt", 800);
        JButton jeansButton = createClothingButton("Jeans", 420);
        JButton shortsButton = createClothingButton("Shorts", 125);
        JButton underwearButton = createClothingButton("Underwear", 100);

        JPanel mensClothingPanel = new JPanel(new GridLayout(7, 1));

        mensClothingPanel.add(tShirtButton);
        mensClothingPanel.add(poloShirtButton);
        mensClothingPanel.add(dressShirtButton);
        mensClothingPanel.add(jeansButton);
        mensClothingPanel.add(shortsButton);
        mensClothingPanel.add(underwearButton);

        mensClothingPanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, mensClothingPanel, "Men's Clothing", JOptionPane.PLAIN_MESSAGE);
    }

    public JButton createClothingButton(String clothingName, int price) {
         JButton button = new JButton(clothingName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                panel.add(Box.createVerticalStrut(20));

                JLabel nameLabel = new JLabel(clothingName);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
                nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(nameLabel);

                JLabel priceLabel = new JLabel("Price: ₱" + price);
                priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(priceLabel);

                panel.add(Box.createVerticalStrut(30));

                JButton buyButton = new JButton("Buy");
                buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                buyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedClothingName = clothingName;
                        int selectedClothingPrice = price;
                        CheckOut checkout = new CheckOut(selectedClothingName, selectedClothingPrice);
                        dispose();
                        checkout.setVisible(true);
                    }
                });
                panel.add(buyButton);

                panel.add(Box.createVerticalStrut(10));

                JButton cartButton = new JButton("Add to Cart");
                cartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                cartButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	addToCart(clothingName, price);
                    }
                });
                panel.add(cartButton);
                JOptionPane.showMessageDialog(OnlineShopMenu.this, panel, "Product Details", JOptionPane.PLAIN_MESSAGE);
            }
        });
        return button;
    }

    public void showWomensClothing() {
        JButton tShirtButton = createClothingButton("T-shirt", 290);
        JButton blouseButton = createClothingButton("Blouse", 250);
        JButton dressButton = createClothingButton("Dress", 700);
        JButton jeansButton = createClothingButton("Jeans", 500);
        JButton skirtButton = createClothingButton("Skirt", 400);
        JButton underwearButton = createClothingButton("Underwear", 100);

        JPanel womensClothingPanel = new JPanel(new GridLayout(7, 1));
        womensClothingPanel.add(tShirtButton);
        womensClothingPanel.add(blouseButton);
        womensClothingPanel.add(dressButton);
        womensClothingPanel.add(jeansButton);
        womensClothingPanel.add(skirtButton);
        womensClothingPanel.add(underwearButton);

        womensClothingPanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, womensClothingPanel, "Women's Clothing", JOptionPane.PLAIN_MESSAGE);
    }

    private void showInfantClothing() {
        JButton leggingsButton = createClothingButton("Leggings", 180);
        JButton topsButton = createClothingButton("Tops", 200);
        JButton bodysuitsButton = createClothingButton("Bodysuits", 290);
        JButton onepiecesButton = createClothingButton("One-Pieces", 400);
        JButton pajamasButton = createClothingButton("Pajamas", 350);
        JButton innerwearButton = createClothingButton("Innerwear", 260);
        JButton socksButton = createClothingButton("Socks", 100);

        JPanel infantsClothingPanel = new JPanel(new GridLayout(7, 1));
        infantsClothingPanel.add(leggingsButton);
        infantsClothingPanel.add(topsButton);
        infantsClothingPanel.add(bodysuitsButton);
        infantsClothingPanel.add(onepiecesButton);
        infantsClothingPanel.add(pajamasButton);
        infantsClothingPanel.add(innerwearButton);
        infantsClothingPanel.add(socksButton);

        infantsClothingPanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, infantsClothingPanel, "Infants Clothing", JOptionPane.PLAIN_MESSAGE);
    }

    private void showKidsWearGirls() {
        JButton skirtsButton = createClothingButton("Skirts", 200);
        JButton dressesButton = createClothingButton("Dresses", 250);
        JButton jumpsuitsButton = createClothingButton("Jumpsuits", 200);
        JButton topsButton = createClothingButton("Tops", 180);
        JButton bodysuitsButton = createClothingButton("Bodysuits", 250);
        JButton underwearButton = createClothingButton("Underwear", 100);

        JPanel girlsClothingPanel = new JPanel(new GridLayout(7, 1));
        girlsClothingPanel.add(skirtsButton);
        girlsClothingPanel.add(dressesButton);
        girlsClothingPanel.add(jumpsuitsButton);
        girlsClothingPanel.add(topsButton);
        girlsClothingPanel.add(bodysuitsButton);
        girlsClothingPanel.add(underwearButton);

        girlsClothingPanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, girlsClothingPanel, "Kids Wear for Girls", JOptionPane.PLAIN_MESSAGE);
    }

    private void showKidsWearBoys() {
        JButton tshirtButton = createClothingButton("T-shirt", 150);
        JButton poloButton = createClothingButton("Polo", 280);
        JButton joggerButton = createClothingButton("Jogger", 250);
        JButton shortsButton = createClothingButton("Shorts", 120);
        JButton formalsuitsButton = createClothingButton("Formal Suits", 800);
        JButton underwearButton = createClothingButton("Underwear", 100);

        JPanel boysClothingPanel = new JPanel(new GridLayout(7, 1));
        boysClothingPanel.add(tshirtButton);
        boysClothingPanel.add(poloButton);
        boysClothingPanel.add(joggerButton);
        boysClothingPanel.add(shortsButton);
        boysClothingPanel.add(formalsuitsButton);
        boysClothingPanel.add(underwearButton);

        boysClothingPanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, boysClothingPanel, "Kids Wear for Boys", JOptionPane.PLAIN_MESSAGE);
    }

    private void showHomeMerchandise() {
        JButton vacuumButton = createClothingButton("Vacuum Cleaner", 6000);
        JButton mattressButton = createClothingButton("Mattress", 2500);
        JButton coffeeButton = createClothingButton("Coffee Maker", 1850);
        JButton refButton = createClothingButton("Refrigerator", 5500);
        JButton lampsButton = createClothingButton("Lamps", 4000);
        JButton curtainButton = createClothingButton("Curtain", 350);
        JButton stoveButton = createClothingButton("Kitchen Stove", 3300);
        JButton boardButton = createClothingButton("Cutting board", 89);
        JButton storageButton = createClothingButton("Food Storage", 190);
        JButton mopButton = createClothingButton("Mop", 200);

        JPanel homeMerchandisePanel = new JPanel(new GridLayout(7, 1));
        homeMerchandisePanel.add(vacuumButton);
        homeMerchandisePanel.add(mattressButton);
        homeMerchandisePanel.add(coffeeButton);
        homeMerchandisePanel.add(refButton);
        homeMerchandisePanel.add(lampsButton);
        homeMerchandisePanel.add(curtainButton);
        homeMerchandisePanel.add(stoveButton);
        homeMerchandisePanel.add(boardButton);
        homeMerchandisePanel.add(storageButton);
        homeMerchandisePanel.add(mopButton);

        homeMerchandisePanel.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(this, homeMerchandisePanel, "Home Merchandise", JOptionPane.PLAIN_MESSAGE);
    }

    private void showGadgets() {
        JButton redmiButton = createClothingButton("(SmartPhone) Redmi Note 12 Pro", 18203);
        JButton samsungButton = createClothingButton("(SmartPhone) Samsung Galaxy S23 UltraSamsung Galaxy S23 Ultra", 89990);
        JButton huaweiButton = createClothingButton("(SmartPhone) Huawei P60 Pro", 69999);
        JButton iphoneButton = createClothingButton("(SmartPhone) iPhone 14 Pro Max", 77990);
        JButton canonButton = createClothingButton("(Camera) Canon EOS 4000D", 61808);
        JButton nikonButton = createClothingButton("(Camera) Nikon D7500", 123896);
        JButton appleButton = createClothingButton("(Airpods) Apple Airpods Pro 2nd Generation", 17278);
        JButton sonyButton = createClothingButton("(Airpods) Sony WH-1000XM5", 34949);
        JButton macbookButton = createClothingButton("(Laptop) Apple Macbook Air M1 2020", 119268);
        JButton lenovoButton = createClothingButton("(Laptop) Lenovo Legion 5i Pro", 91875);

        JPanel gadgetsPanel = new JPanel(new GridLayout(7, 1));
        gadgetsPanel.add(redmiButton);
        gadgetsPanel.add(samsungButton);
        gadgetsPanel.add(huaweiButton);
        gadgetsPanel.add(iphoneButton);
        gadgetsPanel.add(canonButton);
        gadgetsPanel.add(nikonButton);
        gadgetsPanel.add(appleButton);
        gadgetsPanel.add(sonyButton);
        gadgetsPanel.add(macbookButton);
        gadgetsPanel.add(lenovoButton);

        gadgetsPanel.setPreferredSize(new Dimension(900, 500));

        JOptionPane.showMessageDialog(this, gadgetsPanel, "Gadgets", JOptionPane.PLAIN_MESSAGE);
    }
    
    private void addToCart(String clothingName, int price) {
        try {
            String cartItem = clothingName + ":" + price;

            BufferedWriter writer = new BufferedWriter(new FileWriter("cart.txt", true));
            writer.write(cartItem);
            writer.newLine();
            writer.close();

            String message = "Item '" + clothingName + "' added to cart.";
            JOptionPane.showMessageDialog(this, message, "Added to Cart", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}