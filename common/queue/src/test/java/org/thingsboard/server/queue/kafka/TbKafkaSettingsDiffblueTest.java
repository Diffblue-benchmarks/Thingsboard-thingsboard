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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbKafkaSettingsDiffblueTest {
  @InjectMocks
  private String string;

  @InjectMocks
  private TbKafkaSettings tbKafkaSettings;

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   * <p>
   * Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties TbKafkaSettings.toProps()"})
  void testToProps() {
    // Arrange and Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertEquals(0, ((Integer) actualToPropsResult.get("request.timeout.ms")).intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbKafkaSettings#setConsumerPropertiesPerTopic(Map)}
   *   <li>{@link TbKafkaSettings#setOther(List)}
   *   <li>{@link TbKafkaSettings#getReplicationFactor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short TbKafkaSettings.getReplicationFactor()",
      "void TbKafkaSettings.setConsumerPropertiesPerTopic(Map)", "void TbKafkaSettings.setOther(List)"})
  void testGettersAndSetters() {
    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();

    // Act
    tbKafkaSettings.setConsumerPropertiesPerTopic(new HashMap<>());
    tbKafkaSettings.setOther(new ArrayList<>());

    // Assert
    assertEquals((short) 0, tbKafkaSettings.getReplicationFactor());
  }
}
