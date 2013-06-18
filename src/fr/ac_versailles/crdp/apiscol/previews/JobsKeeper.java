package fr.ac_versailles.crdp.apiscol.previews;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JobsKeeper {

	private static Map<UUID, Conversion> registry = new HashMap<UUID, Conversion>();

	public static void register(Conversion conversion) {
		registry.put(conversion.getJobId(), conversion);
	}

	public static Conversion getConversion(UUID id) {
		return registry.get(id);
	}

}
