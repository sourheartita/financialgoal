package come.project.financialgoalbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import come.project.financialgoalbe.entities.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long>{
	
	@Query( value = "select * from folder where id_user = ?1 AND short_name=?2", nativeQuery=true)
	Folder findFolderByShortNameAndOwner(Long idOwner, String shortName);
	
	@Query( value = "select short_name from folder where id_user = ?1" , nativeQuery = true)
	List<String> findFolderByOwner(int idOwner);

}
