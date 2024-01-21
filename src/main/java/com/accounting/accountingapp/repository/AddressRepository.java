package com.accounting.accountingapp.repository;

import com.accounting.accountingapp.entity.Address;
import com.accounting.accountingapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE " +
            "a.addressLine1 = :addressLine1 AND " +
            "a.addressLine2 = :addressLine2 AND " +
            "a.city = :city AND " +
            "a.state = :state AND " +
            "a.zipCode = :zipCode")
    Optional<Address> findByAddressDetails(@Param("addressLine1") String addressLine1,
                                           @Param("addressLine2") String addressLine2,
                                           @Param("city") String city,
                                           @Param("state") String state,
                                           @Param("zipCode") String zipCode);
}
