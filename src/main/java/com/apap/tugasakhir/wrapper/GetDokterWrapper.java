package com.apap.tugasakhir.wrapper;

import java.util.ArrayList;

import com.apap.tugasakhir.model.DokterModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDokterWrapper {
private ArrayList<DokterModel> result;

public ArrayList<DokterModel> getResult() {
	return result;
}

public void setResult(ArrayList<DokterModel> result) {
	this.result = result;
}

}
