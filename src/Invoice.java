import java.util.ArrayList;

public class Invoice {
    /*private ArrayList<LineItem> lineItems;
    private Address customerAddress;

    public Invoice(Address customerAddress) {
        this.lineItems = new ArrayList<>();
        this.customerAddress = customerAddress;
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public double calculateTotal() {
        return lineItems.stream().mapToDouble(LineItem::getTotal).sum();
    }

    public String displayInvoice() {
        StringBuilder invoiceDetails = new StringBuilder();
        invoiceDetails.append("Customer Address:\n").append(customerAddress).append("\n\n");
        invoiceDetails.append("Invoice Details:\n");

        for (LineItem item : lineItems) {
            invoiceDetails.append(item.getProduct().getName()).append(" - Quantity: ")
                    .append(item.getQuantity()).append(", Total: $")
                    .append(String.format("%.2f", item.getTotal())).append("\n");
        }
        invoiceDetails.append("\nTotal Amount Due: $").append(String.format("%.2f", calculateTotal()));

        return invoiceDetails.toString();
    }
}
