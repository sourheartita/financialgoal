package come.project.financialgoalbe.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table ( name = "users")
public class User {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	@Column ( name = "id_user")
	private Long idUser;
	
	@Column ( name = "username")
	private String username;
	
	@Column ( name = "password")
	private String password;
	
	@OneToMany(mappedBy="owner")
	private List<BondDeal> bondDeal;
	
	@OneToMany(mappedBy="owner")
	private List<Folder> folder;
	
	@OneToMany(mappedBy="owner")
	private List<EquityDeal> equityDeal;
	
	@OneToMany(mappedBy="owner")
	private List<GeneralMovement> generalMovement;
	
	@OneToMany(mappedBy="owner")
	private List<Loan> loan;

}
