package com.kodlamaio.hrms.core.utilities.helpers;

import java.util.UUID;

public class ActivationCodeGenerator {
	public UUID generate() {
		UUID code = UUID.randomUUID();
		return code;
	}
}
