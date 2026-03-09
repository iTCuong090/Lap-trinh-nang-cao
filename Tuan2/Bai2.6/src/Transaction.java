public class Transaction {
    private final String transactionId, amount, timestamp;
    
    public Transaction(String transactionId, String amount, String timestamp) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("[ID: %s | Amount: %s | Time: %s]", 
                             transactionId, amount, timestamp);
    }

}