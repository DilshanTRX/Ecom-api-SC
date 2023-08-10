package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.google.zxing.WriterException;
import com.seekerscloud.ecomapi.ecomapi.dto.ItemDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.ItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Item;
import com.seekerscloud.ecomapi.ecomapi.repo.ItemRepo;
import com.seekerscloud.ecomapi.ecomapi.service.ItemService;
import com.seekerscloud.ecomapi.ecomapi.util.BarcodeGenerator;
import com.seekerscloud.ecomapi.ecomapi.util.Generator;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@Transactional
@EnableAutoConfiguration
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;


    @Autowired
    private ItemMapper itemMapper;

   @Autowired
    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Autowired
    private BarcodeGenerator barcodeGenerator;

    @Override
    public String createItem(ItemRequestDTO dto) {
        try {
            String barcode = barcodeGenerator.generateRandomBarcode();

            // Generate the barcode image and get the byte array
            byte[] barcodeId = barcodeGenerator.generateBarcodeImage(barcode);

            Item item = new Item(0, dto.getDescription(), dto.getQty(), dto.getUnitPrice(), barcodeId, null);
            itemRepo.save(item);

            return item.getCode() + " Saved";
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return "Failed to generate barcode and save the item.";
        }
    }



    @Override
    public ItemResponseDTO findItem(int code) throws ClassNotFoundException {
        Optional<Item> byId =itemRepo.findById(code);
        if(byId.isPresent()){
            return itemMapper.toItemResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateItem(ItemRequestDTO dto, int code) throws ClassNotFoundException {
        Optional<Item> byId = itemRepo.findById(code);

        if(byId.isPresent()) {

            byId.get().setDescription(dto.getDescription());
            byId.get().setQty(dto.getQty());
            byId.get().setUnitPrice(dto.getUnitPrice());
            itemRepo.save(byId.get());
            return byId.get().getDescription() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteItem(int code) {
        itemRepo.deleteById(code);
        return code+ "was deleted";
    }

    @Override
    public PaginatedItemResponseDTO findAllItem(String searchText, int page, int size) {
        return new PaginatedItemResponseDTO(
                itemRepo.countItem(searchText),
                itemMapper.toItemResponseDTOList(itemRepo.searchItem(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }
}
