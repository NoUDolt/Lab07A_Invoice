import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGUI extends JFrame {
    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea invoiceDisplay;
    private Invoice invoice;

    public InvoiceGUI() {
        setTitle("Invoice Application");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Address input (for simplicity, hardcoded here)
        Address customerAddress = new Address("123 Main St", "Cincinnati", "OH", "45202");
        invoice = new Invoice(customerAddress);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);

        inputPanel.add(new JLabel("Unit Price:"));
        unitPriceField = new JTextField();
        inputPanel.add(unitPriceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Line Item");
        addButton.addActionListener(new AddItemListener());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Display Area
        invoiceDisplay = new JTextArea();
        invoiceDisplay.setEditable(false);
        add(new JScrollPane(invoiceDisplay), BorderLayout.CENTER);

        // Display Invoice Button
        JButton displayButton = new JButton("Display Invoice");
        displayButton.addActionListener(new DisplayInvoiceListener());
        add(displayButton, BorderLayout.SOUTH);
    }

    private class AddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = productNameField.getText();
                double unitPrice = Double.parseDouble(unitPriceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                Product product = new Product(name, unitPrice);
                LineItem lineItem = new LineItem(product, quantity);
                invoice.addLineItem(lineItem);

                productNameField.setText("");
                unitPriceField.setText("");
                quantityField.setText("");

                JOptionPane.showMessageDialog(null, "Line Item Added!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the values.");
            }
        }
    }

    private class DisplayInvoiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           invoiceDisplay.setText(invoice.displayInvoice());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceGUI frame = new InvoiceGUI();
            frame.setVisible(true);
        });
    }
}