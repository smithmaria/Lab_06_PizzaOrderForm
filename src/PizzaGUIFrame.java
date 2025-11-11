import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {
    // CUSTOMIZATIONS
    private String crust = "";
    private String size = "";
    private String[] toppings;

    // TOTALS
    private int subtotalPrice = 0;
    private double tax = subtotalPrice * .07;
    private double totalPrice = 0;

    // GUI COMPONENTS
    // Crust
    private JRadioButton thinCrustButton;
    private JRadioButton regularCrustButton;
    private JRadioButton deepDishButton;

    // Size
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;
    private JRadioButton superButton;

    // Toppings
    private JCheckBox cheeseCheckBox;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox onionsCheckBox;
    private JCheckBox mushroomsCheckBox;
    private JCheckBox sausageCheckBox;
    private JCheckBox olivesCheckBox;

    // Order Details
    private JTextArea orderDetailsTextArea;

    // Options
    private JButton quitButton;
    private JButton orderButton;
    private JButton clearButton;


    /**
     * Constructor for PizzaGUIFrame
     */
    public PizzaGUIFrame() {
        setTitle("Pizza Order Form");

        setSize(550, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createCustomizationsPanel();
        createOrderDetailsPanel();
        createOptionsPanel();

        setVisible(true);
    }

    /**
     * Creates "Customizations" panel
     */
    private void createCustomizationsPanel() {
        JPanel customizationsPanel = new JPanel();
        customizationsPanel.setLayout(new GridLayout(3, 1));

        TitledBorder customizationsBorder = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Customizations"
        );
        customizationsPanel.setBorder(customizationsBorder);

        customizationsPanel.add(createCrustPanel());
        customizationsPanel.add(createSizePanel());
        customizationsPanel.add(createToppingsPanel());

        add(customizationsPanel, BorderLayout.WEST);
    }

    /**
     * Create "Customizations" sub-panels
     */
    private JPanel createCrustPanel() {
        JPanel crustPanel = new JPanel();
        crustPanel.setLayout(new BoxLayout(crustPanel, BoxLayout.Y_AXIS));

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Crust"
        );
        crustPanel.setBorder(border);

        thinCrustButton = new JRadioButton("Thin");
        regularCrustButton = new JRadioButton("Regular");
        deepDishButton = new JRadioButton("Deep Dish");

        ButtonGroup crustButtonGroup = new ButtonGroup();
        crustButtonGroup.add(thinCrustButton);
        crustButtonGroup.add(regularCrustButton);
        crustButtonGroup.add(deepDishButton);

        crustPanel.add(thinCrustButton);
        crustPanel.add(regularCrustButton);
        crustPanel.add(deepDishButton);

        regularCrustButton.setSelected(true);

        return crustPanel;
    }

    private JPanel createSizePanel() {
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Size"
        );
        sizePanel.setBorder(border);

        smallButton = new JRadioButton("Small ($8)");
        mediumButton = new JRadioButton("Medium ($12)");
        largeButton = new JRadioButton("Large ($16)");
        superButton = new JRadioButton("Super ($20)");

        ButtonGroup sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(smallButton);
        sizeButtonGroup.add(mediumButton);
        sizeButtonGroup.add(largeButton);
        sizeButtonGroup.add(superButton);

        mediumButton.setSelected(true);

        sizePanel.add(smallButton);
        sizePanel.add(mediumButton);
        sizePanel.add(largeButton);
        sizePanel.add(superButton);

        return sizePanel;
    }

    private JPanel createToppingsPanel() {
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.Y_AXIS));

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Toppings"
        );
        toppingsPanel.setBorder(border);

        cheeseCheckBox = new JCheckBox("Cheese");
        pepperoniCheckBox = new JCheckBox("Pepperoni");
        onionsCheckBox = new JCheckBox("Onions");
        mushroomsCheckBox = new JCheckBox("Mushrooms");
        sausageCheckBox = new JCheckBox("Sausage");
        olivesCheckBox = new JCheckBox("Olives");

        cheeseCheckBox.setSelected(true);

        toppingsPanel.add(cheeseCheckBox);
        toppingsPanel.add(pepperoniCheckBox);
        toppingsPanel.add(onionsCheckBox);
        toppingsPanel.add(mushroomsCheckBox);
        toppingsPanel.add(sausageCheckBox);
        toppingsPanel.add(olivesCheckBox);

        return toppingsPanel;
    }


    /**
     * Creates "Order Details" panel
     */
    private void createOrderDetailsPanel() {
        JPanel orderDetailsPanel = new JPanel();

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Order Details"
        );
        orderDetailsPanel.setBorder(border);

        orderDetailsTextArea = new JTextArea(30, 30);
        orderDetailsTextArea.setEditable(false);
        orderDetailsTextArea.setLineWrap(true);

        JScrollPane orderDetailsScrollPane = new JScrollPane(orderDetailsTextArea);
        orderDetailsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        orderDetailsPanel.add(orderDetailsScrollPane);

        add(orderDetailsPanel, BorderLayout.EAST);
    }

    private void generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("===================================\n");
        receipt.append("Order Details:\n");
        receipt.append("===================================\n\n");

        String selectedCrust = "";
        if (thinCrustButton.isSelected()) {
            selectedCrust = "Thin Crust";
        } else if (regularCrustButton.isSelected()) {
            selectedCrust = "Regular Crust";
        } else if (deepDishButton.isSelected()) {
            selectedCrust = "Deep Dish";
        }
        receipt.append("Crust: ").append(selectedCrust).append("\n");

        String selectedSize = "";
        int basePrice = 0;
        if (smallButton.isSelected()) {
            selectedSize = "Small ($8.00)";
            basePrice = 8;
        } else if (mediumButton.isSelected()) {
            selectedSize = "Medium ($12.00)";
            basePrice = 12;
        } else if (largeButton.isSelected()) {
            selectedSize = "Large ($16.00)";
            basePrice = 16;
        } else if (superButton.isSelected()) {
            selectedSize = "Super ($20.00)";
            basePrice = 20;
        }
        receipt.append("Size: ").append(selectedSize).append("\n");

        String[] selectedToppings = new String[0];
        int toppingCount = 0;
        if (cheeseCheckBox.isSelected()) {
            receipt.append(" - Cheese ($1.00)\n");
            toppingCount++;
        }

        if (pepperoniCheckBox.isSelected()) {
            receipt.append(" - Pepperoni ($1.00)\n");
            toppingCount++;
        }

        if (onionsCheckBox.isSelected()) {
            receipt.append(" - Onions ($1.00)\n");
            toppingCount++;
        }

        if (mushroomsCheckBox.isSelected()) {
            receipt.append(" - Mushrooms ($1.00)\n");
            toppingCount++;
        }
        if (sausageCheckBox.isSelected()) {
            receipt.append(" - Sausage ($1.00)\n");
            toppingCount++;
        }

        if (olivesCheckBox.isSelected()) {
            receipt.append(" - Olives ($1.00)\n");
            toppingCount++;
        }

        int toppingsCost = toppingCount * 1;
        int subtotal = basePrice + toppingsCost;
        double tax = subtotal * .07;
        double total = subtotal + tax;

        receipt.append("\n");
        receipt.append("Subtotal: $").append(String.format("%.2f", (double)subtotal)).append("\n");
        receipt.append("Tax: $").append(String.format("%.2f", tax)).append("\n");
        receipt.append("-------------------------------------------\n");
        receipt.append("Total: $").append(String.format("%.2f", total)).append("\n");
        receipt.append("===================================");

        orderDetailsTextArea.setText(receipt.toString());
    }

    /**
     * Create options buttons panel
     */
    private void createOptionsPanel() {
        JPanel optionsPanel = new JPanel();

        quitButton = new JButton("Quit");
        orderButton = new JButton("Order");
        clearButton = new JButton("Clear");

        quitButton.addActionListener(e -> System.exit(0));
        orderButton.addActionListener(e -> generateReceipt());
        clearButton.addActionListener(e -> {
            clearForm();
        });

        optionsPanel.add(quitButton);
        optionsPanel.add(orderButton);
        optionsPanel.add(clearButton);

        add(optionsPanel, BorderLayout.SOUTH);
    }

    private void clearForm() {
        regularCrustButton.setSelected(true);

        mediumButton.setSelected(true);

        cheeseCheckBox.setSelected(true);
        pepperoniCheckBox.setSelected(false);
        onionsCheckBox.setSelected(false);
        mushroomsCheckBox.setSelected(false);
        sausageCheckBox.setSelected(false);
        olivesCheckBox.setSelected(false);

        orderDetailsTextArea.setText("");
    }
}
