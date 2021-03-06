package come.project.financialgoalbe.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import come.project.financialgoalbe.entities.DataChart;

@Repository
public interface DataChartRepository extends JpaRepository<DataChart,Long>{

	@Query ( value = "exec create_flowchart @start_date = ?1, @end_date = ?2", nativeQuery = true)
	List<DataChart> getDataChartFromRange(String startDate, String endDate);
	
	

}
