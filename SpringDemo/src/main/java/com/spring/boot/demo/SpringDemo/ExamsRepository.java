package com.spring.boot.demo.SpringDemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamsRepository extends JpaRepository<Exams, ExamsKey> {
}
