package by.bsu.mysummerproj.service.impl;

import by.bsu.mysummerproj.dto.flat.FlatDTO;
import by.bsu.mysummerproj.entity.Flat;
import by.bsu.mysummerproj.entity.Meeting;
import by.bsu.mysummerproj.repository.FlatRepository;
import by.bsu.mysummerproj.service.FlatService;
import by.bsu.mysummerproj.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class FlatServiceImpl implements FlatService {
    private final FlatRepository flatRepository;
    @Override
    public List<Flat> getAll() {
        return this.flatRepository.findAll();
    }

    @Override
    public Flat getById(Integer id) {
        return this.flatRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Flat create(FlatDTO dto) throws ParseException {
        final Flat flat = Flat
                .builder()
                .flatnumber(dto.flatnumber())
                .area(dto.area())
                .build();

        return this.flatRepository.save(flat);
    }
}
