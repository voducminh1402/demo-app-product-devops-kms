package com.example.productmanagement.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageSender {

    @Autowired
    private AmazonSQS amazonSQS;

    private final String queueUrl = "https://sqs.us-east-1.amazonaws.com/816069145944/test-queue-sqs-1";

    public void sendMessage(String messageBody) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody);

        amazonSQS.sendMessage(sendMessageRequest);

        System.out.println("Message sent to SQS: " + messageBody);
    }
}
