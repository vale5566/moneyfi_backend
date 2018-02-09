package de.moneyfi.company;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, String> {
	
	public Company findByName(String name);
}
