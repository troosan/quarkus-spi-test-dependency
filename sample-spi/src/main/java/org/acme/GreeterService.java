package org.acme;

import java.util.Iterator;
import java.util.ServiceLoader;

public class GreeterService {

	private static volatile IGreeter greeterService;

	public GreeterService() {
		ServiceLoader<IGreeter> loader = ServiceLoader.load(IGreeter.class);
		Iterator<IGreeter> iterator = loader.iterator();
		if (iterator.hasNext()) {
			greeterService = iterator.next();
		} else {
			throw new RuntimeException("No ICallService implementation found, verify classpath");
		}
		if (iterator.hasNext()) {
			throw new RuntimeException("More than one IGreeter implementation found, verify classpath, only one IGreeter implementation should exist");
		}
	}

	public static IGreeter getService() {
		if (greeterService == null) {
			synchronized (GreeterService.class) {
				if (greeterService == null) {
					new GreeterService();
				}
			}
		}
		// Should not be null anymore when reaching this point
		return greeterService;
	}
}
