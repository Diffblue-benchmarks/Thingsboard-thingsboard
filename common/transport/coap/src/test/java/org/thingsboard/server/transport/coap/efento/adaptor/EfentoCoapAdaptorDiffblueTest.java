/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.coap.efento.adaptor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;

@ContextConfiguration(classes = {EfentoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class EfentoCoapAdaptorDiffblueTest {
  @Autowired
  private EfentoCoapAdaptor efentoCoapAdaptor;

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonArray(3)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonArray(3)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive("ts")));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive(true)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(new CoapEfentoTransportResource.EfentoTelemetry(-1L, new JsonPrimitive('\u0001')));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(false);
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry8() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add('A');
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry9() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(Integer.valueOf(1));
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry10() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray values = new JsonArray(3);
    values.add(new JsonArray(3));
    values.add(true);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(-1L,
        values);

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(efentoTelemetry);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostTelemetry(UUID, List)}
   */
  @Test
  void testConvertToPostTelemetry11() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    ArrayList<CoapEfentoTransportResource.EfentoTelemetry> telemetryList = new ArrayList<>();
    telemetryList.add(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostTelemetry(sessionId, telemetryList));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonArray(3)));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonNull()));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId,
        new JsonPrimitive("[{}] Failed to convert JsonObject to PostTelemetry request!")));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, new JsonPrimitive(true)));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(false);
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add('\u0000');
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes8() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(Integer.valueOf(1));
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }

  /**
   * Method under test:
   * {@link EfentoCoapAdaptor#convertToPostAttributes(UUID, JsonElement)}
   */
  @Test
  void testConvertToPostAttributes9() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    JsonArray deviceInfo = new JsonArray(3);
    deviceInfo.add(new JsonArray(3));
    deviceInfo.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> efentoCoapAdaptor.convertToPostAttributes(sessionId, deviceInfo));
  }
}
