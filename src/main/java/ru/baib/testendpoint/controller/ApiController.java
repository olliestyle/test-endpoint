package ru.baib.testendpoint.controller;

import com.rzd.task.api.AmortizationsApiDelegate;
import com.rzd.task.dto.AmortizationDto;
import com.rzd.task.dto.AmortizationViewDto;
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
    public ResponseEntity<List<AmortizationViewDto>> getAll() {
        return amortizationsApiDelegate.getAmortizations(null, null);
    }

    @PostMapping
    public ResponseEntity<AmortizationViewDto> create(@RequestBody AmortizationDto amortizationDto) {
        return amortizationsApiDelegate.addAmortization(amortizationDto);
    }


}
