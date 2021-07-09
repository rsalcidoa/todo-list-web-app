package mx.rsalcidoa.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.rsalcidoa.webapp.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
