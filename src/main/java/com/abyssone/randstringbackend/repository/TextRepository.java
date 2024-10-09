package com.abyssone.randstringbackend.repository;

import com.abyssone.randstringbackend.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Long> {
}
