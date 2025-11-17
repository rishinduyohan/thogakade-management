package edu.icet.controller.service;

import edu.icet.model.dto.CustomerDTO;
import java.util.List;

public interface CustomerService {
     boolean addCustomer(CustomerDTO customer);
     boolean updateCustomer(CustomerDTO customer);
     boolean deleteCustomer(String id);
     List<CustomerDTO> getAllCustomers();


}
