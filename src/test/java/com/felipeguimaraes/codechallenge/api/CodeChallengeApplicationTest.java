package com.felipeguimaraes.codechallenge.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.felipeguimaraes.codechallenge.api.CodeChallengeApplication;
import com.felipeguimaraes.codechallenge.api.resource.PdvResource;
import com.mongodb.client.ListIndexesIterable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeChallengeApplication.class)
public class CodeChallengeApplicationTest {

	@Autowired
	private PdvResource pdvResource;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contexLoads() throws Exception {
		assertThat(pdvResource).isNotNull();
	}

	@Test
	public void checkIfCoverageAreaIndexExistsInMongoDB() throws Exception {
		boolean exists = false;
		ListIndexesIterable<Document> indexes = mongoTemplate.getCollection("pdv").listIndexes();
		for (Document document : indexes) {
			if (document.values().contains("coverageArea_2dsphere")) {
				exists = true;
			}
		}
		assertTrue(exists);
	}

	@Test
	public void checkIfAddressIndexExistsInMongoDB() throws Exception {
		boolean exists = false;
		ListIndexesIterable<Document> indexes = mongoTemplate.getCollection("pdv").listIndexes();
		for (Document document : indexes) {
			if (document.values().contains("address_2dsphere")) {
				exists = true;
			}
		}
		assertTrue(exists);
	}

	@Test
	public void checkIfUniqueDocumentIndexExistsInMongoDB() throws Exception {
		boolean exists = false;
		ListIndexesIterable<Document> indexes = mongoTemplate.getCollection("pdv").listIndexes();
		for (Document document : indexes) {
			if (document.values().contains("document_cnpj")) {
				exists = true;
			}
		}
		assertTrue(exists);
	}
}
