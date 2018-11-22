package com.apap.tugasakhir.wrapper;

import java.util.ArrayList;

import com.apap.tugasakhir.model.PasienModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GetPasienWrapper {
	private ArrayList<PasienModel> result;

	public ArrayList<PasienModel> getResult() {
		return result;
	}

	public void setResult(ArrayList<PasienModel> result) {
		this.result = result;
	}
}
