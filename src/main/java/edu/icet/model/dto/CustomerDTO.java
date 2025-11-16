package edu.icet.model.dto;

public class CustomerDTO {
    private final String id;
    private final String name;
    private final String address;
    private final String contact;

    public CustomerDTO(String id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    // Getters are required for the TableView to work
    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }
}
