package example.kafka.controller;

import example.kafka.producer.KafkaProducerProcessor;
import example.kafka.producer.KafkaRecordProducer;
import example.kafka.dto.AlertDto;
import example.kafka.dto.AssetDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MainController {

  private final KafkaProducerProcessor kafkaProducerProcessor;

  public MainController(KafkaProducerProcessor kafkaProducerProcessor) {
    this.kafkaProducerProcessor = kafkaProducerProcessor;
  }

  @PutMapping("/createAsset")
  public void createMessage(@RequestBody() AssetDto assetDto) {
    System.out.println("Sending assetDto " + assetDto.getId());
    kafkaProducerProcessor.produceAssetMessage(assetDto);
    System.out.println("assetDto sent " + assetDto.getId());
  }

  @PutMapping("/createAlert")
  public void createMessage(@RequestBody() AlertDto alertDto) throws InterruptedException {
    System.out.println("Sending alertDto " + alertDto.getId());
//    kafkaProducerProcessor.produceAlertDetails(alertDto);
    kafkaProducerProcessor.produceAlertDetails(alertDto);
    System.out.println("alertDto sent " + alertDto.getId());
  }
}
