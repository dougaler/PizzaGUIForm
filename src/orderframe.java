import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.border.TitledBorder;

public class orderframe extends JFrame
{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel crustPnl;
    JPanel sizePnl;
    JPanel toppingPnl;
    JPanel displayPnl;
    JPanel buttonPnl;
    JTextArea displayTA;
    JScrollPane scroller;
    JLabel titleLbl;
    ImageIcon icon;
    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;
    JRadioButton smButton;
    JRadioButton mdButton;
    JRadioButton lgButton;
    JRadioButton superButton;
    String crustTypes[] = { " ","Thin", "Regular", "Deep-dish"};
    JCheckBox pepTopping;
    JCheckBox cheeseTopping;
    JCheckBox spinchTopping;
    JCheckBox sausTopping;
    JCheckBox lbTopping;
    JCheckBox chefTopping;
    ButtonGroup G1;

    String crustType;
    String mcSize;
    ArrayList<String> allToppings = new ArrayList<String>();
    static JLabel l, l1;
    static JComboBox c1;
    pizzarecipt tisAResult = new pizzarecipt();

    double topperPrice;
    double sizePrice;
    double taxMan;
    double totalSansTax;
    double totalWTax;

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    /**
     *  Method to provide layout for the java swing
     */
    public orderframe()
    {
        mainPnl = new JPanel();
        if (RIGHT_TO_LEFT) {
            mainPnl.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        mainPnl.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        createTitlePanel();
        mainPnl.add(titlePnl);
        createSizePanel();
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        mainPnl.add(sizePnl, c);

        createCrustPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        mainPnl.add(crustPnl, c);

        createToppingPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        mainPnl.add(toppingPnl, c);

        createDisplayPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        mainPnl.add(displayPnl, c);

        createButtonPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        mainPnl.add(buttonPnl, c);

        add(mainPnl);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     *  Method to create the layout for the specific Top Label panel for the swing program
     */
    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        titleLbl = new JLabel("Pizza Order Form", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Courier", Font.BOLD,30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titlePnl.add(titleLbl);
    }
    private void createSizePanel()
    {
        sizePnl = new JPanel();
        sizePnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Size", TitledBorder.CENTER, TitledBorder.TOP));
        smButton = new JRadioButton();
        mdButton = new JRadioButton();
        lgButton = new JRadioButton();
        superButton = new JRadioButton();
        G1 = new ButtonGroup();
        smButton.setText("Small");
        mdButton.setText("Medium");
        lgButton.setText("Large");
        superButton.setText("Super");
        smButton.setBounds(25, 30, 75, 30);
        mdButton.setBounds(100, 30, 75, 30);
        lgButton.setBounds(175, 30, 75, 30);
        superButton.setBounds(250, 30, 75, 30);
        G1.add(smButton);
        G1.add(mdButton);
        G1.add(lgButton);
        G1.add(superButton);

        sizePnl.add(smButton);
        sizePnl.add(mdButton);
        sizePnl.add(lgButton);
        sizePnl.add(superButton);
    }

    private void createCrustPanel()
    {
        crustPnl = new JPanel();
        crustPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Crust", TitledBorder.CENTER, TitledBorder.TOP));


        c1 = new JComboBox(crustTypes);


        // create labels
        l = new JLabel("select crust type ");

        crustPnl.add(l);
        crustPnl.add(c1);
    }

    private void createToppingPanel()
    {
        toppingPnl = new JPanel();
        toppingPnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Toppings", TitledBorder.CENTER, TitledBorder.TOP));

        pepTopping = new JCheckBox("Pepperoni");
        cheeseTopping = new JCheckBox("Extra Cheese");
        spinchTopping = new JCheckBox("Spinach");
        sausTopping = new JCheckBox("Sausage");
        lbTopping = new JCheckBox("Left Beef");
        chefTopping = new JCheckBox("Chef's Choice");

        JPanel p = new JPanel();
        toppingPnl.add(pepTopping);
        toppingPnl.add(cheeseTopping);
        toppingPnl.add(spinchTopping);
        toppingPnl.add(sausTopping);
        toppingPnl.add(lbTopping);
        toppingPnl.add(chefTopping);
    }

    /**
     *  Method that contains the game portion of the project. This is where the player will control the game.
     */
    private void createButtonPanel()
    {
        buttonPnl = new JPanel();
        buttonPnl.setBorder(BorderFactory.createEtchedBorder());

        orderBtn = new JButton("Order");
        clearBtn = new JButton("Clear");
        quitBtn = new JButton("Quit");

        orderBtn.addActionListener((ActionEvent ae) ->{
            displayTA.append("");
            crustType = (String) c1.getSelectedItem();
            mcSize = getSelectedButtonText(G1);
            allToppings.clear();
            if (mcSize == null){
                displayTA.append("Please choose a pizza Size \n");
            } else if (crustType.equals(crustTypes[0])) {
                displayTA.append("Please choose a valid crust");
            } else {

                if (pepTopping.isSelected()) {
                    allToppings.add("Pepperoni");
                }
                if (cheeseTopping.isSelected()) {
                    allToppings.add("Extra Cheese");
                }
                if (spinchTopping.isSelected()) {
                    allToppings.add("Spinach");
                }
                if (sausTopping.isSelected()) {
                    allToppings.add("Sausage");
                }
                if (lbTopping.isSelected()) {
                    allToppings.add("Left Beef");
                }
                if (chefTopping.isSelected()) {
                    allToppings.add("Chef's Choice");
                }
                getOrder(mcSize, crustType, allToppings);
            }
        });
        clearBtn.addActionListener((ActionEvent ae) ->{
            displayTA.setText("");

            smButton.setSelected(true);
            mdButton.setSelected(false);
            lgButton.setSelected(false);
            superButton.setSelected(false);

            c1.setSelectedItem(crustTypes[0]);

            pepTopping.setSelected(false);
            cheeseTopping.setSelected(false);
            spinchTopping.setSelected(false);
            sausTopping.setSelected(false);
            lbTopping.setSelected(false);
            chefTopping.setSelected(false);

            allToppings.clear();

        });
        quitBtn.addActionListener((ActionEvent ae) -> {
            int response = JOptionPane.showConfirmDialog(null,

                    "Are you sure you want to leave?", "Are you sure you want to leave?", JOptionPane.YES_NO_OPTION);

            if(response == JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }

        });

        buttonPnl.add(orderBtn);
        buttonPnl.add(clearBtn);
        buttonPnl.add(quitBtn);

    }
    /**
     *  Method to provide layout and details of the results. It shows all of the win details as well as the results of each game played
     */
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayPnl.setLayout(new GridLayout(1, 2));

        displayTA = new JTextArea(10, 25);

        displayTA.setEditable(false);
        displayTA.setFont(new Font("Courier New", Font.PLAIN, 12));
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);

    }
    public void getOrder(String size, String crustyboy, ArrayList<String> toppers) {
        double sizePrice = tisAResult.getSizePrice(size);
        double totalSansTax = tisAResult.getTotalSansTax(sizePrice, toppers);
        double taxMan = tisAResult.getTaxMan(totalSansTax);
        double totalWTax = tisAResult.getTotalWTax(totalSansTax,taxMan);
        String currentTopper;

        String eqDash = "======================================================";
        String newLine = "\n";
        String crustLine = String.format("%-24s",size + " " + crustyboy);
        String basePrice = String.format(String.valueOf(sizePrice));
        String subLine = String.format("%-24s","Sub-Total");
        String subPrice = String.format(String.valueOf(totalSansTax));
        String taxLine = String.format("%-24s","Tax");
        String taxPrice = String.format("%-24s",(String.format("%.2f",taxMan)));
        String totalLine = String.format("%-24s","Total");
        String totalPrice = String.format("%-24s",totalWTax);
        displayTA.append(eqDash);
        displayTA.append(newLine);
        displayTA.append(crustLine);
        displayTA.append(basePrice);
        displayTA.append(newLine);
        for( int i = 0;i< toppers.size();i++ ){
            currentTopper = toppers.get(i);
            String topperLine = String.format("%-24s", currentTopper);
            String topperPrice = String.format("%-24s", "1.00");
            displayTA.append(topperLine);
            displayTA.append(topperPrice);
            displayTA.append(newLine);
        }
        displayTA.append(newLine);
        displayTA.append(subLine);
        displayTA.append(subPrice);
        displayTA.append(newLine);
        displayTA.append(taxLine);
        displayTA.append(taxPrice);
        displayTA.append(newLine);
        displayTA.append("------------------------------------------------------\n");
        displayTA.append(totalLine);
        displayTA.append(totalPrice);
        displayTA.append(newLine);
        displayTA.append(eqDash);
        displayTA.append(newLine);
    }
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

}
