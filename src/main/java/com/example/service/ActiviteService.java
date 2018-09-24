package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;
import org.springframework.stereotype.Service;

@Service
public class ActiviteService implements IActiviteService {
    @Override
    public Activite mapToEntity(ActiviteDTO dto) {
        /**
         * TODO: make imlementation
         */
        return null;
    }

    @Override
    public ActiviteDTO mapToDto(Activite entity) {
        return new ActiviteDTO(entity.getSport().getName(),
                entity.getLocalisation().getVille());
    }
}
