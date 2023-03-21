package com.SandeepRKurup.mct_int.doa;

import com.SandeepRKurup.mct_int.model.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order,Integer> {
}
