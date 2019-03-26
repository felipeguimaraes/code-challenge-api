package com.felipeguimaraes.codechallenge.api.repository;

import com.felipeguimaraes.codechallenge.api.bean.Pdv;

public interface PdvMongoRepositoryCustom {

	/**
	 * Dado uma localização (lng, lat), busque o PDV mais próximo e que atenda à
	 * mesma, conforme sua área de cobertura.
	 * 
	 * @param lng Longitude (x)
	 * @param lat Latitude (y)
	 * @return @Pdv do PDV encontrado
	 */
	Pdv getPDVByLongitudeAndLatitude(Double lng, Double lat);
}
