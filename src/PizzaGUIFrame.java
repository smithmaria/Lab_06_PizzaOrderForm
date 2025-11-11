import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PizzaGUIFrame extends JFrame {
    // Customizations
    private String crust = "";
    private String size = "";
    private String[] toppings;

    // Totals
    private int subtotalPrice = 0;
    private double tax = subtotalPrice * .07;
    private double totalPrice = 0;

    // GUI components
    private JRadioButton thinCrustButton;
    private JRadioButton regularCrustButton;
    private JRadioButton deepDishButton;

    private JButton quitButton;
    private JButton orderButton;
    private JButton clearButton;

    /**
     * Constructor for PizzaGUIFrame
     */
    public PizzaGUIFrame() {
        setTitle("Pizza Order Form");

        setSize(800, 700);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createCustomizationsPanel();
        createOrderDetailsPanel();

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

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Crust"
        );
        crustPanel.setBorder(border);

        ButtonGroup crustButtonGroup = new ButtonGroup();

        thinCrustButton = new JRadioButton("Thin");
        regularCrustButton = new JRadioButton("Regular");
        deepDishButton = new JRadioButton("Deep Dish");

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

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Size"
        );
        sizePanel.setBorder(border);

        return sizePanel;
    }

    private JPanel createToppingsPanel() {
        JPanel toppingsPanel = new JPanel();

        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                "Toppings"
        );
        toppingsPanel.setBorder(border);

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

        add(orderDetailsPanel, BorderLayout.EAST);
    }
}
