package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.ObatModel;
import com.apap.tugasakhir.model.PenangananModel;
import com.apap.tugasakhir.model.RujukanRawatJalanModel;
import com.apap.tugasakhir.rest.BaseResponse;
import com.apap.tugasakhir.rest.Setting;
import com.apap.tugasakhir.rest.webService;
import com.apap.tugasakhir.service.ObatService;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rawat-jalan")
public class ObatController {
	@Autowired
	webService web;
	
	@Autowired
	private ObatService obatService;
	
	@PostMapping(value = "/obat/tambah/{obatId}")
    public BaseResponse<ObatModel> addObat(@PathVariable(name="obatId", required = true) long obat_id, 
    		@RequestBody @Valid ObatModel obat, BindingResult bindingResult) {
		BaseResponse<ObatModel> response = new BaseResponse<ObatModel>();
		if (bindingResult.hasErrors() || obat_id < 1) {
            response.setStatus(500);
            response.setMessage("error data");
        } else {
        	
        	obatService.addObat(obat);
        	//obat.setFlagGroup(obatId);
            response.setStatus(200);
            response.setMessage("success");
            response.setResult(obat);
        }
        return response;
    }
}
