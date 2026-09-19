public class CustomerEvent {

    private String eventType;
    private Integer customerId;
    private String name;
    private String email;
    private String status;

    public CustomerEvent() {
    }

    public CustomerEvent(
            String eventType,
            Integer customerId,
            String name,
            String email,
            String status) {

        this.eventType = eventType;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    // getters and setters
}