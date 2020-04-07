package com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.Admin;




import com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<UserApp, Long> {





}
