package com.TechDhiraj.DemoH2DB.service;

import com.TechDhiraj.DemoH2DB.dto.AddressDTO;
import com.TechDhiraj.DemoH2DB.entity.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressService {

    // Convert AddressDTO to Address entity
    public List<Address> mapToEntityList(List<AddressDTO> addressDTOs) {
        return addressDTOs.stream()
                .map(addressDTO -> {
                    Address address = new Address();
                    address.setStreet(addressDTO.getStreet());
                    address.setCity(addressDTO.getCity());
                    return address;
                })
                .collect(Collectors.toList());
    }

    // Convert Address entity to AddressDTO
    public List<AddressDTO> mapToDTOList(List<Address> addresses) {
        return addresses.stream()
                .map(address -> {
                    AddressDTO addressDTO = new AddressDTO();
                    addressDTO.setStreet(address.getStreet());
                    addressDTO.setCity(address.getCity());
                    return addressDTO;
                })
                .collect(Collectors.toList());
    }
}
