package ru.baib.testendpoint.mapper;

import com.rzd.task.dto.AmortizationDto;
import com.rzd.task.dto.AmortizationViewDto;
import org.mapstruct.Mapper;
import ru.baib.testendpoint.entity.Amortization;

@Mapper(componentModel = "spring")
public interface AmortizationMapper {

    Amortization amortizationDtoToAmortization(AmortizationDto amortizationDto);
    AmortizationViewDto amortizationToAmortizationViewDto(Amortization amortization);
}
