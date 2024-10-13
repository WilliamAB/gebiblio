package com.wab.gebiblio.repository;

import com.wab.gebiblio.entity.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório de dados de base para os repositórios da aplicação.
 */
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
