package fr.ac_versailles.crdp.apiscol.previews.fileSystem;

import org.apache.commons.lang.StringUtils;

public class ExtensionsHandling {

	private static String[] MIMES = { "image/jpeg", "image/png", "image/tiff", "video/webm", "video/ogg", "video/mp4"  };
	private static String[] EXTS = { "jpg", "png", "tiff", "webm", "ogg", "mp4" };

	public static String getExtension(String mimetype) {
		for (int i = 0; i < MIMES.length; i++) {
			if (MIMES[i].equals(mimetype))
				return EXTS[i];
		}
		return StringUtils.EMPTY;
	}

}
