package com.example.service;

/**
 * Contract for service --> handle mapping between entity and dto
 * @param <E> Entity to map
 * @param <D> Matching DTO
 */
public interface MapperService<E,D> {
    public E mapToEntity(D dto);
    public D mapToDto(E entity);
}
