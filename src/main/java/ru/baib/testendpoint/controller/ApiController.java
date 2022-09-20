package ru.baib.testendpoint.controller;

import com.rzd.task.api.AmortizationsApiDelegate;
import com.rzd.task.dto.AmortizationDto;
import com.rzd.task.dto.AmortizationFilterDto;
import com.rzd.task.dto.AmortizationViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amortization")
public class ApiController {

    private final AmortizationsApiDelegate amortizationsApiDelegate;

    public ApiController(AmortizationsApiDelegate amortizationsApiDelegate) {
        this.amortizationsApiDelegate = amortizationsApiDelegate;
    }

    @GetMapping
    public ResponseEntity<List<AmortizationViewDto>> getAll(
            @RequestParam(value = "usePeriod", required = false) Integer usePeriod,
            @RequestParam(value = "avgPrice", required = false) Double avgPrice,
            @RequestParam(value = "pageNum", required = false) int pageNum,
            @RequestParam(value = "pageSize", required = false) int pageSize) {
        AmortizationFilterDto filterDto = new AmortizationFilterDto();
        filterDto.setUsePeriod(usePeriod);
        filterDto.setAvgPrice(avgPrice);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return amortizationsApiDelegate.getAmortizations(filterDto, pageable);
    }

    @PostMapping
    public ResponseEntity<AmortizationViewDto> create(@RequestBody AmortizationDto amortizationDto) {
        return amortizationsApiDelegate.addAmortization(amortizationDto);
    }


}
