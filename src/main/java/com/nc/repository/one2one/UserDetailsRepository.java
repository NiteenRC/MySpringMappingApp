package com.nc.repository.one2one;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.one2one.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
