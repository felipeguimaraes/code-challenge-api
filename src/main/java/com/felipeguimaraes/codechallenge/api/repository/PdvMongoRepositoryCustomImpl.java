package com.felipeguimaraes.codechallenge.api.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GeoNearOperation;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.felipeguimaraes.codechallenge.api.bean.Pdv;
import com.felipeguimaraes.codechallenge.api.bean.PdvWithDistance;

public class PdvMongoRepositoryCustomImpl implements PdvMongoRepositoryCustom {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public PdvMongoRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Pdv getPDVByLongitudeAndLatitude(Double lng, Double lat) {

		/*
		 * MongoDB - Query nativa: { $geoNear: { near: { type: "Point", coordinates: [ x
		 * , y ] }, limit: 1, distanceField: "distance", query: { "coverageArea":{
		 * "$geoIntersects":{ "$geometry":{ "type":"Point", "coordinates":[ x, y ] } } }
		 * } } }
		 */

		Pdv pdv = null;

		Query query = new Query()
				.addCriteria(Criteria.where("coverageArea").intersects(new GeoJsonPoint(new Point(lng, lat))));

		NearQuery nearQuery = NearQuery.near(lng, lat).num(1).spherical(true).query(query);

		Aggregation a = newAggregation(new GeoNearOperation(nearQuery, "distance").useIndex("address"));

		AggregationResults<PdvWithDistance> results = mongoTemplate.aggregate(a, Pdv.class, PdvWithDistance.class);

		if (results != null && results.getUniqueMappedResult() != null) {
			pdv = results.getUniqueMappedResult();
		}

		return pdv;

	}

}
