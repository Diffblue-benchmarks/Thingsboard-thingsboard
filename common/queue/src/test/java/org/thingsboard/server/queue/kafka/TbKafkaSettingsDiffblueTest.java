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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.TbProperty;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class TbKafkaSettingsDiffblueTest {
  /**
   * Test {@link TbKafkaSettings#toProps()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings} (default constructor).
   *   <li>Then return {@code request.timeout.ms} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName(
      "Test toProps(); given TbKafkaSettings (default constructor); then return 'request.timeout.ms' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties TbKafkaSettings.toProps()"})
  void testToProps_givenTbKafkaSettings_thenReturnRequestTimeoutMsIntValueIsZero() {
    // Arrange and Act
    Properties actualToPropsResult = new TbKafkaSettings().toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertEquals(0, ((Integer) actualToPropsResult.get("request.timeout.ms")).intValue());
  }

  /**
   * Test {@link TbKafkaSettings#toProps()}.
   *
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is {@code Key}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName(
      "Test toProps(); given TbProperty (default constructor) Key is 'Key'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties TbKafkaSettings.toProps()"})
  void testToProps_givenTbPropertyKeyIsKey_thenReturnSizeIsTwo() {
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
   * Test {@link TbKafkaSettings#toProps()}.
   *
   * <ul>
   *   <li>Given {@link TbProperty} (default constructor) Key is {@code request.timeout.ms}.
   *   <li>Then return {@code request.timeout.ms} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName(
      "Test toProps(); given TbProperty (default constructor) Key is 'request.timeout.ms'; then return 'request.timeout.ms' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties TbKafkaSettings.toProps()"})
  void testToProps_givenTbPropertyKeyIsRequestTimeoutMs_thenReturnRequestTimeoutMsIs42() {
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
   * Test {@link TbKafkaSettings#toProps()}.
   *
   * <ul>
   *   <li>Then return {@code request.timeout.ms} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaSettings#toProps()}
   */
  @Test
  @DisplayName("Test toProps(); then return 'request.timeout.ms' intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Properties TbKafkaSettings.toProps()"})
  void testToProps_thenReturnRequestTimeoutMsIntValueIsZero() {
    // Arrange
    TbKafkaSettings tbKafkaSettings = new TbKafkaSettings();
    tbKafkaSettings.setOther(new ArrayList<>());

    // Act
    Properties actualToPropsResult = tbKafkaSettings.toProps();

    // Assert
    assertEquals(1, actualToPropsResult.size());
    assertEquals(0, ((Integer) actualToPropsResult.get("request.timeout.ms")).intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaSettings#setConsumerPropertiesPerTopic(Map)}
   *   <li>{@link TbKafkaSettings#setOther(List)}
   *   <li>{@link TbKafkaSettings#getReplicationFactor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "short TbKafkaSettings.getReplicationFactor()",
    "void TbKafkaSettings.setConsumerPropertiesPerTopic(Map)",
    "void TbKafkaSettings.setOther(List)"
  })
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
