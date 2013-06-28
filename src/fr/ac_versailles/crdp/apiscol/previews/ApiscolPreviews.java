package fr.ac_versailles.crdp.apiscol.previews;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class ApiscolPreviews extends ServletContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Context
	ServletContext context;

	public ApiscolPreviews() { 

	}

	public ApiscolPreviews(Class<? extends Application> appClass) {
		super(appClass);
	}

	public ApiscolPreviews(Application app) {
		super(app);
	}

	@PreDestroy
	public void deinitialize() {
		PreviewsApi.stopCleaner();
		PreviewsApi.stopExecutors();
	}

	

	@PostConstruct
	public void initialize() {
	
	}
}
