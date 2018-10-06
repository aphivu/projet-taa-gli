package com.example.service;

import com.example.dto.ActiviteDTO;
import com.example.entity.Activite;
import com.example.entity.Personne;

import java.util.List;

public interface IActiviteService extends MapperService<Activite, ActiviteDTO> {

    public Activite getActiviteById(long id);
    public List<Activite> getActivitesByUserName(String username);

    public Activite createActivite(long pid,long sid, long lid);
    public Activite removeActiviteById(long id);
}
