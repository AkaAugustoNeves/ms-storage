package br.com.pilares.msstorage.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.pilares.msstorage.model.dto.PersonDTO;

@Component
public class PersonListener {

	@RabbitListener(queues = "NEW_PERSON.CREATE_PATH")
	public void createPath(PersonDTO person) {
		System.out.println("/*--------------------------------------------------*/");
		System.out.println("hash: "+ person.getHash());
		System.out.println("name: "+ person.getName());
		System.out.println("email: "+ person.getEmail());
		System.out.println("/*--------------------------------------------------*/");
	}
	
}
