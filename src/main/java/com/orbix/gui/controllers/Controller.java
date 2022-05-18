package com.orbix.gui.controllers;

import static com.orbix.bench.BenchmarkingMethods.*;

import com.aparapi.device.Device.TYPE;
import com.aparapi.device.OpenCLDevice;
import com.orbix.gui.controllers.handlers.*;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

@SuppressWarnings("rawtypes")
public class Controller {

  private static final String logsFileName = "logs";

  @FXML
  private ChoiceBox gpu_label;

  @FXML
  private ChoiceBox method_label;

  @FXML
  private Button run_button;

  @FXML
  private Button history_button;

  @SuppressWarnings("unchecked")
  public void initialize() {
    gpu_label
      .getItems()
      .addAll(
        OpenCLDevice
          .listDevices(TYPE.GPU)
          .stream()
          .map(OpenCLDevice::getName)
          .collect(Collectors.toList())
      );

    method_label
      .getItems()
      .addAll(
        StandardBenchmark,
        DataTransferBenchmark,
        TrigonometryBenchmark,
        MatrixMultiplicationBenchmark,
        FractalsBenchmark
      );

    run_button.setOnAction(
      new RunButtonHandler(logsFileName, gpu_label, method_label)
    );
    history_button.setOnAction(new HistoryButtonHandler(logsFileName));
  }
}
