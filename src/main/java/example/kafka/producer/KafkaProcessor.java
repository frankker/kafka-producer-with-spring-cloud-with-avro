package example.kafka.producer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface KafkaProcessor {
  String ALERT_OUTPUT = "alert-output";
  String ASSET_OUTPUT = "asset-output";

  @Output(ALERT_OUTPUT)
  MessageChannel outEvent();

  @Output(ASSET_OUTPUT)
  MessageChannel assetEventSending();
}