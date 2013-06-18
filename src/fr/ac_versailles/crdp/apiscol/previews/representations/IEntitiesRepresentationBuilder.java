package fr.ac_versailles.crdp.apiscol.previews.representations;

import javax.ws.rs.core.UriInfo;

import fr.ac_versailles.crdp.apiscol.previews.Conversion;

public interface IEntitiesRepresentationBuilder<T> {
	T getConversionRepresentation(Conversion conversion, UriInfo uriInfo);

	T getNotFoundMessage(String conversionId);
}
