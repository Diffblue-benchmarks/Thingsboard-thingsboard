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
package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TbProperty;

class TbKafkaSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbKafkaSettings#setConsumerPropertiesPerTopic(Map)}
   *   <li>{@link TbKafkaSettings#setOther(List)}
   *   <li>{@link TbKafkaSettings#getReplicationFactor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();

    // Act
    tbKafkaSettings.setConsumerPropertiesPerTopic(new HashMap<>());
    tbKafkaSettings.setOther(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals((short) 0, tbKafkaSettings.getReplicationFactor());
  }

  /**
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  void testToProps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Properties actualToPropsResult = (new TbKafkaSettings()).toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }

  /**
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  void testToProps2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(new ArrayList<>());

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }

  /**
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  void testToProps3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("request.timeout.ms"));
  }

  /**
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  void testToProps4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("request.timeout.ms");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty2);
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(2, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("request.timeout.ms"));
    assertEquals("request.timeout.ms", actualToPropsResult.get("Key"));
  }

  /**
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  void testToProps5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = mock(TbProperty.class);
    when(tbProperty.getKey()).thenReturn("Key");
    when(tbProperty.getValue()).thenReturn("42");
    doNothing().when(tbProperty).setKey(Mockito.<String>any());
    doNothing().when(tbProperty).setValue(Mockito.<String>any());
    tbProperty.setKey("request.timeout.ms");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(other);

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    verify(tbProperty).getKey();
    verify(tbProperty).getValue();
    verify(tbProperty).setKey(eq("request.timeout.ms"));
    verify(tbProperty).setValue(eq("42"));
    assertEquals(2, actualToPropsResult.size());
    assertEquals("42", actualToPropsResult.get("Key"));
    assertTrue(actualToPropsResult.containsKey("request.timeout.ms"));
  }
}
