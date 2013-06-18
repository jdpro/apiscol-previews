package fr.ac_versailles.crdp.apiscol.previews.representations;

import javax.servlet.ServletContext;
import javax.ws.rs.core.MediaType;

public class EntitiesRepresentationBuilderFactory {

	public static IEntitiesRepresentationBuilder<?> getRepresentationBuilder(
			String requestedFormat, ServletContext context) {
		if (requestedFormat.equals(MediaType.APPLICATION_XML) || requestedFormat.equals(MediaType.APPLICATION_ATOM_XML)) {
			return new XMLRepresentationBuilder();
		} 
		throw new UnknownMediaTypeForResponseException(requestedFormat);
	}

}
