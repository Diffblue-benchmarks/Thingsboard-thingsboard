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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TbProperty;

class TbKafkaConsumerStatsServiceDiffblueTest {
  /**
   * Method under test: {@link TbKafkaConsumerStatsService#init()}
   */
  @Test
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbProperty tbProperty = mock(TbProperty.class);
    doNothing().when(tbProperty).setKey(Mockito.<String>any());
    doNothing().when(tbProperty).setValue(Mockito.<String>any());
    tbProperty.setKey("kafka-consumer-stats");
    tbProperty.setValue("42");

    ArrayList<TbProperty> other = new ArrayList<>();
    other.add(tbProperty);

    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    kafkaSettings.setOther(other);
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(kafkaSettings, statsConfig)).init();

    // Assert that nothing has changed
    verify(tbProperty).setKey(eq("kafka-consumer-stats"));
    verify(tbProperty).setValue(eq("42"));
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  void testRegisterClientGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("42");

    // Assert
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  void testRegisterClientGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("42");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#registerClientGroup(String)}
   */
  @Test
  void testRegisterClientGroup3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).registerClientGroup("");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  void testUnregisterClientGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("42");

    // Assert
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  void testUnregisterClientGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(false);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("42");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }

  /**
   * Method under test:
   * {@link TbKafkaConsumerStatsService#unregisterClientGroup(String)}
   */
  @Test
  void testUnregisterClientGroup3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaConsumerStatisticConfig statsConfig = mock(TbKafkaConsumerStatisticConfig.class);
    when(statsConfig.getEnabled()).thenReturn(true);

    // Act
    (new TbKafkaConsumerStatsService(new TbKafkaSettings(), statsConfig)).unregisterClientGroup("");

    // Assert that nothing has changed
    verify(statsConfig).getEnabled();
  }
}
