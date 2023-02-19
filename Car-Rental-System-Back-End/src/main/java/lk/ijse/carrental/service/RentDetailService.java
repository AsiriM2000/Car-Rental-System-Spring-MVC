package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.RentDetailDTO;

import java.util.ArrayList;

public interface RentDetailService {
    void saveRentalDetail(RentDetailDTO dto);
    ArrayList<RentDetailDTO> getAllRentalDetail();
}
