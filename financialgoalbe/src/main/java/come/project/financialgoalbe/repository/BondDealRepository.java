package come.project.financialgoalbe.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import come.project.financialgoalbe.entities.BondDeal;
import come.project.financialgoalbe.entities.CoupleStringBigDecimal;

public interface BondDealRepository extends JpaRepository<BondDeal,Long>{
	
	@Query( value = "select * from bond_deal where id_user=?1", nativeQuery = true)
	public List<BondDeal> findBondDealByOwner(Long idOwner);
	
	public BondDeal save(BondDeal bondDeal);

	@Query( value = "select * from bond_deal where isin =?1 AND id_user=?2", nativeQuery = true)
	public List<BondDeal> findDealByIsinAndOwner(String isin, long idOwner);

}
