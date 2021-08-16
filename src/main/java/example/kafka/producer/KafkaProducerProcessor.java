package example.kafka.producer;

import example.kafka.dto.AlertDto;
import example.kafka.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(KafkaProcessor.class)
//@EnableIntegration
public class KafkaProducerProcessor {

  @Autowired
  private KafkaProcessor processor;

  public void produceAssetMessage(AssetDto assetDto) {
    Message<AssetDto> message =
        MessageBuilder
            .withPayload(assetDto)
            .setHeader(KafkaHeaders.MESSAGE_KEY, assetDto.getId())
            .build();

    processor.assetEventSending().send(message);
  }

  public void produceAlertDetails(AlertDto alertDto) {
    Message<AlertDto> message =
        MessageBuilder
            .withPayload(alertDto)
            .setHeader(KafkaHeaders.MESSAGE_KEY, alertDto.getId())
            .build();

    processor.outEvent()
        .send(message);
  }
}
