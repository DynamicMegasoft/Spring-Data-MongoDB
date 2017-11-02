package com.dynamic.core.hosting.dao;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import com.hostingcompass.core.db.dao.MongoDaoImpl;

@Repository
public class HostingDaoImpl
	extends MongoDaoImpl<Hosting> implements HostingDao {

	@Override
	public List<Hosting> findTopHosting(int numOfRecord) {

		Query query = new Query();

		if (numOfRecord > 0)
			query.limit(numOfRecord);

		query.with(new Sort(Sort.Direction.DESC, "count"));
		query.fields().include("_id");
		query.fields().include("domain");
		query.fields().include("count");

		return findAll(query, Hosting.class);

	}

}
