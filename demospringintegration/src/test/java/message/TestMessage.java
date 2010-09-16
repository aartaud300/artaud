package message;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMessage {

	
	@Autowired
	DirectChannel  input ; 
	
	@Autowired
	PollableChannel output; 
	
	@Test
	public void testbidon(){
		String message ="Sending message to Spring integration";
		
		//create a Message with a new payload
		input.send(MessageBuilder.withPayload(message).build());
		
		Message<?> T = output.receive();
		System.out.println("=>>" + T);
	}
}
