package com.aaulaundary.aau_laundary_system.Repositories;

import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;

// import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaundaryOrderRepository extends JpaRepository<LaundaryOrder,Long>   {
    
}
