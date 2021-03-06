package rewards.messaging.client.receiver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import rewards.RewardConfirmation;

public class StartReceiver {

	private static final Log LOGGER = LogFactory.getLog(StartReceiver.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("rewards/messaging/client/receiver/receiver-config.xml");
		JmsTemplate template = (JmsTemplate) context.getBean("jmsTemplate");

		RewardConfirmation confirmation = null;
		do {
			confirmation = (RewardConfirmation) template.receiveAndConvert();
			if (confirmation != null) LOGGER.info("received confirmation: " + confirmation);
		} while (confirmation != null);
	}
}
