package fr.ac_versailles.crdp.apiscol.previews.representations;

import java.util.UUID;

import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import fr.ac_versailles.crdp.apiscol.utils.LogUtility;

public abstract class AbstractRepresentationBuilder<T> implements
		IEntitiesRepresentationBuilder<T> {
	protected static Logger logger;

	public AbstractRepresentationBuilder() {
		createLogger();
	}

	private void createLogger() {
		if (logger == null)
			logger = LogUtility
					.createLogger(this.getClass().getCanonicalName());

	}

	protected String getConversionUri(UriInfo uriInfo, UUID conversionId) {
		return String.format("%sconversion/%s",
				uriInfo.getBaseUri().toString(), conversionId.toString());
	}

	protected String getOutputFileUri(UriInfo uriInfo, UUID conversionId,
			String fileName) {
		return String.format("%soutput/%s/%s", uriInfo.getBaseUri().toString(),
				conversionId.toString(), fileName);
	}

}
