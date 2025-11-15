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
package org.thingsboard.server.transport.lwm2m.server.adaptors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;

class LwM2MJsonAdaptorDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(new JsonNull()));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry4() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException("ts"));
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry5() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("values", new JsonArray(3));
    jsonObject.add("ts", new JsonArray(3));
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  void testConvertToPostTelemetry6() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonArray()).thenThrow(new IllegalStateException("foo"));
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonArray(3)));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonNull()));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes4() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException("foo"));
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes5() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement value = mock(JsonElement.class);
    when(value.getAsJsonPrimitive()).thenThrow(new IllegalStateException("foo"));
    when(value.isJsonObject()).thenReturn(true);
    when(value.isJsonPrimitive()).thenReturn(true);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(value).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(value).isJsonPrimitive();
  }

  /**
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  void testConvertToPostAttributes6() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement value = mock(JsonElement.class);
    when(value.isJsonObject()).thenReturn(true);
    when(value.isJsonPrimitive()).thenReturn(true);
    JsonElement value2 = mock(JsonElement.class);
    when(value2.isJsonObject()).thenThrow(new RuntimeException("foo"));
    when(value2.isJsonPrimitive()).thenThrow(new RuntimeException("foo"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("42", value2);
    jsonObject.add("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(value2).isJsonPrimitive();
  }
}
