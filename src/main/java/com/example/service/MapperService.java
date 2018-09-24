package com.example.service;

public interface MapperService<E,D> {
    public E mapToEntity(D dto);
    public D mapToDto(E entity);
}
