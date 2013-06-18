package fr.ac_versailles.crdp.apiscol.previews.workers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import fr.ac_versailles.crdp.apiscol.previews.Conversion;

public class VideoConversionWorker extends PDFConversionWorker {

	public VideoConversionWorker(File incomingFile, File outputDir,
			List<String> outputMimeTypeList, int pageLimit,
			Conversion conversion) {
		super(incomingFile, outputDir, outputMimeTypeList, pageLimit,
				conversion);
	}

	@Override
	public void run() {
		conversion.setState(Conversion.States.INITIATED,
				"Conversion process from video to image has been launched.");

		convertVideo();

		conversion.setState(Conversion.States.SUCCESS,
				"Conversion process terminated.");
	}

	protected void convertVideo() {
		conversion.setState(Conversion.States.INITIATED,
				"Conversion process has been launched.");
		for (int i = 0; i < askedMimesTypes.size(); i++) {
			String askedMimeType = askedMimesTypes.get(i);
			boolean success = convertVideoToMimeType(askedMimeType);
			if (success)
				conversion.setState(Conversion.States.RUNNING,
						"Conversion has been performed to mimeType : "
								+ askedMimeType);
		}
		conversion.setState(Conversion.States.SUCCESS,
				"Conversion process terminated.");

	}

	private boolean convertVideoToMimeType(String askedMimeType) {
		try {
			String outputExtension = getOutputFileExtension(askedMimeType);
			String newFileName = changeExtension(incomingFile.getName(),
					outputExtension);
			String[] commande = { "avconv", "-i",
					incomingFile.getAbsolutePath(), newFileName };
			String[] envp = {};
			Process p = Runtime.getRuntime().exec(commande, envp, outputDir);
			BufferedReader output = getOutput(p);
			BufferedReader error = getError(p);
			String ligne = "";
			while ((ligne = output.readLine()) != null) {
				System.out.println("err. " + ligne);
			}

			while ((ligne = error.readLine()) != null) {
				System.out.println(ligne);
			}

			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	String changeExtension(String originalName, String newExtension) {
		int lastDot = originalName.lastIndexOf(".");
		if (lastDot != -1) {
			return originalName.substring(0, lastDot+1) + newExtension;
		} else {
			return originalName + newExtension;
		}
	}
}
