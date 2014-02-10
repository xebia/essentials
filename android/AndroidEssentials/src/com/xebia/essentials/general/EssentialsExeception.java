package com.xebia.essentials.general;

import java.io.Serializable;


public class EssentialsExeception extends RuntimeException implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1184939654075039477L;

	public EssentialsExeception(String message) {
		super(message);
	}

	public EssentialsExeception(Exception exc) {
		super(exc);
	}

}
