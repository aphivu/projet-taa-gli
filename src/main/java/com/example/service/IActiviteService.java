package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;

/**
 * Activite Security component
 */
public interface IActiviteService extends MapperService<Activite, ActiviteDTO> {

    public Activite getActiviteById(long id);

    public Activite createActivite(ActiviteDTO dto);
    public Activite removeActiviteById(long id);
}
