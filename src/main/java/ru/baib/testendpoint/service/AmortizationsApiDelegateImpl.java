package ru.baib.testendpoint.service;

import com.rzd.task.api.AmortizationsApiDelegate;
import com.rzd.task.dto.AmortizationDto;
import com.rzd.task.dto.AmortizationFilterDto;
import com.rzd.task.dto.AmortizationViewDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.baib.testendpoint.entity.Amortization;
import ru.baib.testendpoint.mapper.AmortizationMapper;
import ru.baib.testendpoint.repository.AmortizationsRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AmortizationsApiDelegateImpl implements AmortizationsApiDelegate {

    private final AmortizationsRepository amortizationsRepository;
    private final AmortizationMapper amortizationMapper;

    public AmortizationsApiDelegateImpl(AmortizationsRepository amortizationsRepository,
                                        AmortizationMapper amortizationMapper) {
        this.amortizationsRepository = amortizationsRepository;
        this.amortizationMapper = amortizationMapper;
    }

    @Override
    public ResponseEntity<AmortizationViewDto> addAmortization(AmortizationDto amortizationDto) {
        Amortization amortization = amortizationMapper
                .amortizationDtoToAmortization(amortizationDto);
        amortization.setUuid(UUID.randomUUID());
        return new ResponseEntity<>(
                amortizationMapper.amortizationToAmortizationViewDto(amortizationsRepository.save(amortization)),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<AmortizationViewDto>> getAmortizations(AmortizationFilterDto filter, Pageable page) {
        return new ResponseEntity<>(
                amortizationsRepository.findAll()
                        .stream()
                        .map(amortizationMapper::amortizationToAmortizationViewDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
