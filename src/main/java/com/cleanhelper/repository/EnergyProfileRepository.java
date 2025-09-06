package com.cleanhelper.repository;

import com.cleanhelper.model.EnergyProfile;
import com.cleanhelper.model.TaskType;
import com.cleanhelper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnergyProfileRepository extends JpaRepository<EnergyProfile, Long> {
    Optional<EnergyProfile> findByUserAndTaskType(User user, TaskType taskType);
}
