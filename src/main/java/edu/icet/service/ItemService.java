package edu.icet.service;

import edu.icet.model.dto.ItemDTO;
import javafx.collections.ObservableList;

public interface ItemService {
    boolean addItem(ItemDTO itemDTO);
    boolean updateItem(String id,ItemDTO itemDTO);
    boolean deleteItem(String id);
    ObservableList<ItemDTO> getAllItems();
}
