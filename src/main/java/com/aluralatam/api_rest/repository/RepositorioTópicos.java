package com.aluralatam.api_rest.repository;

import com.aluralatam.api_rest.model.Tópico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTópicos extends JpaRepository<Tópico, Long> {
}
