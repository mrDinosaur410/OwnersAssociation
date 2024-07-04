package by.bsu.mysummerproj.service;

import by.bsu.mysummerproj.dto.flat.FlatDTO;
import by.bsu.mysummerproj.entity.Flat;

import java.text.ParseException;
import java.util.List;

public interface FlatService {
    List<Flat> getAll();
    Flat getById(Integer id);
    Flat create(FlatDTO dto) throws ParseException;

}
