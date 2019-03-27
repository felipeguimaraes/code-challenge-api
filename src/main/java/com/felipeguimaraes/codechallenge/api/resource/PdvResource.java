package com.felipeguimaraes.codechallenge.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipeguimaraes.codechallenge.api.bean.Pdv;
import com.felipeguimaraes.codechallenge.api.exception.PdvNotFoundException;
import com.felipeguimaraes.codechallenge.api.repository.PdvMongoRepository;

@RestController
public class PdvResource {

	@Autowired
	private PdvMongoRepository pdvRepository;

	@GetMapping("/pdvs/{id}")
	public Resource<Pdv> getPDV(@PathVariable int id) {
		Optional<Pdv> pdv = pdvRepository.findById(id);

		if (!pdv.isPresent())
			throw new PdvNotFoundException("id-" + id);

		Resource<Pdv> resource = new Resource<Pdv>(pdv.get());

		return resource;
	}

	@GetMapping("/pdvs/search/")
	public Resource<Pdv> searchPDV(@RequestParam(name = "lng", defaultValue = "0", required = true) Double lng,
			@RequestParam(name = "lat", defaultValue = "0", required = true) Double lat) {

		Pdv pdv = pdvRepository.getPDVByLongitudeAndLatitude(lng, lat);

		if (pdv == null)
			throw new PdvNotFoundException("lng/lat-" + lng + "/" + lat);

		return new Resource<Pdv>(pdv);
	}

	@PostMapping("/pdvs")
	public void createPDV(@Valid @RequestBody Pdv pdv) {
		Pdv savedPDV = pdvRepository.save(pdv);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPDV.getId())
				.toUri();

		ResponseEntity.created(location).build();
	}

//	@PostMapping("/pdvs/bulk")
	public void createPDVs(@Valid @RequestBody List<Pdv> pdvs) {
		for (Pdv pdv : pdvs) {
			pdvRepository.save(pdv);
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		ResponseEntity.created(location).build();
	}

}
