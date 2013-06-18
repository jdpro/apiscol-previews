package fr.ac_versailles.crdp.apiscol.previews.fileSystem;

import org.apache.log4j.Logger;

import fr.ac_versailles.crdp.apiscol.utils.LogUtility;

public class DirectoryCleaner implements Runnable {

	@Override
	public void run() {
		System.out.println("Running the cleaning process for old directories**");
		FileSystemAccess.cleanOldDirectories();
	}

	private Logger logger;

	private void createLogger() {
		if (logger == null)
			logger = LogUtility
					.createLogger(this.getClass().getCanonicalName());

	}
}
