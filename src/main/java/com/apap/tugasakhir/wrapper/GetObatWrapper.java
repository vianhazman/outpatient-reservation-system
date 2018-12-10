package com.apap.tugasakhir.wrapper;

import java.util.ArrayList;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.model.PasienModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GetObatWrapper {
	private ObatModel result;

	public ObatModel getResult() {
		return result;
	}

	public void setResult(ObatModel result) {
		this.result = result;
	}
}