package come.project.financialgoalbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import come.project.financialgoalbe.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query ( value = "select * from users where id_user=?1", nativeQuery = true)
	public User findUserById(Long id);

}
