package dev.warmup.app;

import org.springframework.data.jpa.repository.JpaRepository;

interface ExperimentRepository extends JpaRepository<ExperimentRecord, Long> {}
