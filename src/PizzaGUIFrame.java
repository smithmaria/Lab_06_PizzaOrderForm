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


    // Options
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
