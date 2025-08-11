package com.iya.energy.electric.model.dao;

import com.iya.energy.electric.model.dto.ElectricDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ElectricMapper {
    void insertMinuteLpData(ElectricDTO data);

    List<ElectricDTO> selectAllData();
}
