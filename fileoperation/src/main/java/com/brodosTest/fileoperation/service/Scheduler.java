package com.brodosTest.fileoperation.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

		@Autowired
		ProductService productService;
	
		@Scheduled(fixedRate = 5000)
	   public void fixedRateSch() throws Exception {
	      
	       productService.processFile ();
	   }
}
