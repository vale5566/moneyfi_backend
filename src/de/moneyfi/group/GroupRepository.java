package de.moneyfi.group;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, String> {
	
	public Group findByName(String name);
}
