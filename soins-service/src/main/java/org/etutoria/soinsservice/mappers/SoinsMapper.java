package org.etutoria.soinsservice.mappers;
import org.etutoria.soinsservice.dtos.SoinsDto;
import org.etutoria.soinsservice.entities.Soins;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class SoinsMapper {




    public SoinsMapper() {

    }

    public SoinsDto fromSoins(Soins soins) {
        if (soins == null) {
            return null;
        }
        SoinsDto soinsDto = new SoinsDto();
        BeanUtils.copyProperties(soins, soinsDto);
        return soinsDto;
    }

    public Soins fromSoinsDto(SoinsDto soinsDto) {
        if (soinsDto == null) {
            return null;
        }
        Soins soins = new Soins();
        BeanUtils.copyProperties(soinsDto, soins);
        return soins;
    }
}