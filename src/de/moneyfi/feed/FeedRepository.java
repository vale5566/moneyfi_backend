package de.moneyfi.feed;

import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Integer> {

    public Feed findById(Integer id);

}
