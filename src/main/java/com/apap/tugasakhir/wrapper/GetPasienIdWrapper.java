package com.apap.tugasakhir.wrapper;

import java.util.ArrayList;

import com.apap.tugasakhir.model.PasienModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GetPasienIdWrapper {
	private PasienModel result;

	public PasienModel getResult() {
		return result;
	}

	public void setResult(PasienModel result) {
		this.result = result;
	}
}

