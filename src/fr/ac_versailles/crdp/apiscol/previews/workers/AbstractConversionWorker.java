package fr.ac_versailles.crdp.apiscol.previews.workers;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import fr.ac_versailles.crdp.apiscol.previews.Conversion;

public abstract class AbstractConversionWorker implements IConversionWorker {

	protected File incomingFile;
	protected final File outputDir;
	protected int pageLimit;
	protected List<String> askedMimesTypes;
	protected final Conversion conversion;

	public AbstractConversionWorker(File incomingFile, File outputDir,
			List<String> outputMimeTypeList, int pageLimit,
			Conversion conversion) {
		this.incomingFile = incomingFile;
		this.outputDir = outputDir;
		this.askedMimesTypes = outputMimeTypeList;
		this.pageLimit = pageLimit;
		this.conversion = conversion;

	}

	protected String getOutputFileExtension(String askedMimeType) {
		if (askedMimeType.contains("jpeg"))
			return "jpg";
		if (askedMimeType.contains("tiff"))
			return "tiff";
		if (askedMimeType.contains("png"))
			return "png";
		if (askedMimeType.contains("webm"))
			return "webm";
		if (askedMimeType.contains("ogg"))
			return "ogg";
		if (askedMimeType.contains("mp4"))
			return "mp4";
		return "unknown";
	}

	protected static BufferedReader getOutput(Process p) {
		return new BufferedReader(new InputStreamReader(p.getInputStream()));
	}

	protected static BufferedReader getError(Process p) {
		return new BufferedReader(new InputStreamReader(p.getErrorStream()));
	}

}
