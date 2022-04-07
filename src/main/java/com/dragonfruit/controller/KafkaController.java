package com.dragonfruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragonfruit.bean.Greeting;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaController {

	
	@Autowired
	private KafkaTemplate<String, Greeting> kafkaTemplate;
	
	@PostMapping("/object")
	public void postObject(@RequestBody Greeting greeting) {
		kafkaTemplate.send("dragonfruit",greeting);
	}
}
