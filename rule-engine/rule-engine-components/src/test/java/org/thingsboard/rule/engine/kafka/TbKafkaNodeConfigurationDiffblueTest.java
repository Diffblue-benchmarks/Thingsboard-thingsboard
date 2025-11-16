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
package org.thingsboard.rule.engine.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbKafkaNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbKafkaNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbKafkaNodeConfiguration TbKafkaNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbKafkaNodeConfiguration actualDefaultConfigurationResult =
        new TbKafkaNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("-1", actualDefaultConfigurationResult.getAcks());
    assertEquals("UTF-8", actualDefaultConfigurationResult.getKafkaHeadersCharset());
    assertEquals("localhost:9092", actualDefaultConfigurationResult.getBootstrapServers());
    assertEquals("my-topic", actualDefaultConfigurationResult.getTopicPattern());
    assertEquals(
        "org.apache.kafka.common.serialization.StringSerializer",
        actualDefaultConfigurationResult.getKeySerializer());
    assertEquals(
        "org.apache.kafka.common.serialization.StringSerializer",
        actualDefaultConfigurationResult.getValueSerializer());
    assertNull(actualDefaultConfigurationResult.getKeyPattern());
    assertEquals(0, actualDefaultConfigurationResult.getLinger());
    assertEquals(0, actualDefaultConfigurationResult.getRetries());
    assertEquals(16384, actualDefaultConfigurationResult.getBatchSize());
    assertEquals(33554432, actualDefaultConfigurationResult.getBufferMemory());
    assertFalse(actualDefaultConfigurationResult.isAddMetadataKeyValuesAsKafkaHeaders());
    assertTrue(actualDefaultConfigurationResult.getOtherProperties().isEmpty());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setTopicPattern("Topic Pattern");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKeyPattern("Key Pattern");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKeyPattern("Key Pattern");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setBootstrapServers("Bootstrap Servers");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setBootstrapServers("Bootstrap Servers");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setAcks("Acks");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setAcks("Acks");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKeySerializer("Key Serializer");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKeySerializer("Key Serializer");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setValueSerializer("42");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setValueSerializer("42");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setOtherProperties(new HashMap<>());

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setOtherProperties(new HashMap<>());

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKafkaHeadersCharset("UTF-8");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKafkaHeadersCharset("UTF-8");

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
    assertEquals(tbKafkaNodeConfiguration.hashCode(), tbKafkaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}, and {@link
   * TbKafkaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbKafkaNodeConfiguration#equals(Object)}
   *   <li>{@link TbKafkaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    // Act and Assert
    assertEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration);
    int expectedHashCodeResult = tbKafkaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbKafkaNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbKafkaNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKeyPattern("Key Pattern");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setBootstrapServers("Bootstrap Servers");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setRetries(1);

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setBatchSize(3);

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setLinger(1);

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setBufferMemory(1);

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setAcks("Acks");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKeySerializer("Key Serializer");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setValueSerializer("42");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setOtherProperties(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setAddMetadataKeyValuesAsKafkaHeaders(true);

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKafkaHeadersCharset("UTF-8");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, new TbKafkaNodeConfiguration());
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setTopicPattern("Topic Pattern");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKeyPattern("Key Pattern");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setBootstrapServers("Bootstrap Servers");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setAcks("Acks");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKeySerializer("Key Serializer");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setValueSerializer("42");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setOtherProperties(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration2 = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration2.setKafkaHeadersCharset("UTF-8");

    // Act and Assert
    assertNotEquals(tbKafkaNodeConfiguration, tbKafkaNodeConfiguration2);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbKafkaNodeConfiguration(), null);
  }

  /**
   * Test {@link TbKafkaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbKafkaNodeConfiguration.equals(Object)",
    "int TbKafkaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbKafkaNodeConfiguration(), "Different type to TbKafkaNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbKafkaNodeConfiguration}
   *   <li>{@link TbKafkaNodeConfiguration#setAcks(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setAddMetadataKeyValuesAsKafkaHeaders(boolean)}
   *   <li>{@link TbKafkaNodeConfiguration#setBatchSize(int)}
   *   <li>{@link TbKafkaNodeConfiguration#setBootstrapServers(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setBufferMemory(int)}
   *   <li>{@link TbKafkaNodeConfiguration#setKafkaHeadersCharset(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setKeyPattern(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setKeySerializer(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setLinger(int)}
   *   <li>{@link TbKafkaNodeConfiguration#setOtherProperties(Map)}
   *   <li>{@link TbKafkaNodeConfiguration#setRetries(int)}
   *   <li>{@link TbKafkaNodeConfiguration#setTopicPattern(String)}
   *   <li>{@link TbKafkaNodeConfiguration#setValueSerializer(String)}
   *   <li>{@link TbKafkaNodeConfiguration#toString()}
   *   <li>{@link TbKafkaNodeConfiguration#getAcks()}
   *   <li>{@link TbKafkaNodeConfiguration#getBatchSize()}
   *   <li>{@link TbKafkaNodeConfiguration#getBootstrapServers()}
   *   <li>{@link TbKafkaNodeConfiguration#getBufferMemory()}
   *   <li>{@link TbKafkaNodeConfiguration#getKafkaHeadersCharset()}
   *   <li>{@link TbKafkaNodeConfiguration#getKeyPattern()}
   *   <li>{@link TbKafkaNodeConfiguration#getKeySerializer()}
   *   <li>{@link TbKafkaNodeConfiguration#getLinger()}
   *   <li>{@link TbKafkaNodeConfiguration#getOtherProperties()}
   *   <li>{@link TbKafkaNodeConfiguration#getRetries()}
   *   <li>{@link TbKafkaNodeConfiguration#getTopicPattern()}
   *   <li>{@link TbKafkaNodeConfiguration#getValueSerializer()}
   *   <li>{@link TbKafkaNodeConfiguration#isAddMetadataKeyValuesAsKafkaHeaders()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbKafkaNodeConfiguration.<init>()",
    "String TbKafkaNodeConfiguration.getAcks()",
    "int TbKafkaNodeConfiguration.getBatchSize()",
    "String TbKafkaNodeConfiguration.getBootstrapServers()",
    "int TbKafkaNodeConfiguration.getBufferMemory()",
    "String TbKafkaNodeConfiguration.getKafkaHeadersCharset()",
    "String TbKafkaNodeConfiguration.getKeyPattern()",
    "String TbKafkaNodeConfiguration.getKeySerializer()",
    "int TbKafkaNodeConfiguration.getLinger()",
    "Map TbKafkaNodeConfiguration.getOtherProperties()",
    "int TbKafkaNodeConfiguration.getRetries()",
    "String TbKafkaNodeConfiguration.getTopicPattern()",
    "String TbKafkaNodeConfiguration.getValueSerializer()",
    "boolean TbKafkaNodeConfiguration.isAddMetadataKeyValuesAsKafkaHeaders()",
    "void TbKafkaNodeConfiguration.setAcks(String)",
    "void TbKafkaNodeConfiguration.setAddMetadataKeyValuesAsKafkaHeaders(boolean)",
    "void TbKafkaNodeConfiguration.setBatchSize(int)",
    "void TbKafkaNodeConfiguration.setBootstrapServers(String)",
    "void TbKafkaNodeConfiguration.setBufferMemory(int)",
    "void TbKafkaNodeConfiguration.setKafkaHeadersCharset(String)",
    "void TbKafkaNodeConfiguration.setKeyPattern(String)",
    "void TbKafkaNodeConfiguration.setKeySerializer(String)",
    "void TbKafkaNodeConfiguration.setLinger(int)",
    "void TbKafkaNodeConfiguration.setOtherProperties(Map)",
    "void TbKafkaNodeConfiguration.setRetries(int)",
    "void TbKafkaNodeConfiguration.setTopicPattern(String)",
    "void TbKafkaNodeConfiguration.setValueSerializer(String)",
    "String TbKafkaNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbKafkaNodeConfiguration actualTbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    actualTbKafkaNodeConfiguration.setAcks("Acks");
    actualTbKafkaNodeConfiguration.setAddMetadataKeyValuesAsKafkaHeaders(true);
    actualTbKafkaNodeConfiguration.setBatchSize(3);
    actualTbKafkaNodeConfiguration.setBootstrapServers("Bootstrap Servers");
    actualTbKafkaNodeConfiguration.setBufferMemory(1);
    actualTbKafkaNodeConfiguration.setKafkaHeadersCharset("UTF-8");
    actualTbKafkaNodeConfiguration.setKeyPattern("Key Pattern");
    actualTbKafkaNodeConfiguration.setKeySerializer("Key Serializer");
    actualTbKafkaNodeConfiguration.setLinger(1);
    HashMap<String, String> otherProperties = new HashMap<>();
    actualTbKafkaNodeConfiguration.setOtherProperties(otherProperties);
    actualTbKafkaNodeConfiguration.setRetries(1);
    actualTbKafkaNodeConfiguration.setTopicPattern("Topic Pattern");
    actualTbKafkaNodeConfiguration.setValueSerializer("42");
    String actualToStringResult = actualTbKafkaNodeConfiguration.toString();
    String actualAcks = actualTbKafkaNodeConfiguration.getAcks();
    int actualBatchSize = actualTbKafkaNodeConfiguration.getBatchSize();
    String actualBootstrapServers = actualTbKafkaNodeConfiguration.getBootstrapServers();
    int actualBufferMemory = actualTbKafkaNodeConfiguration.getBufferMemory();
    String actualKafkaHeadersCharset = actualTbKafkaNodeConfiguration.getKafkaHeadersCharset();
    String actualKeyPattern = actualTbKafkaNodeConfiguration.getKeyPattern();
    String actualKeySerializer = actualTbKafkaNodeConfiguration.getKeySerializer();
    int actualLinger = actualTbKafkaNodeConfiguration.getLinger();
    Map<String, String> actualOtherProperties = actualTbKafkaNodeConfiguration.getOtherProperties();
    int actualRetries = actualTbKafkaNodeConfiguration.getRetries();
    String actualTopicPattern = actualTbKafkaNodeConfiguration.getTopicPattern();
    String actualValueSerializer = actualTbKafkaNodeConfiguration.getValueSerializer();
    boolean actualIsAddMetadataKeyValuesAsKafkaHeadersResult =
        actualTbKafkaNodeConfiguration.isAddMetadataKeyValuesAsKafkaHeaders();

    // Assert
    assertEquals("42", actualValueSerializer);
    assertEquals("Acks", actualAcks);
    assertEquals("Bootstrap Servers", actualBootstrapServers);
    assertEquals("Key Pattern", actualKeyPattern);
    assertEquals("Key Serializer", actualKeySerializer);
    assertEquals(
        "TbKafkaNodeConfiguration(topicPattern=Topic Pattern, keyPattern=Key Pattern, bootstrapServers=Bootstrap"
            + " Servers, retries=1, batchSize=3, linger=1, bufferMemory=1, acks=Acks, keySerializer=Key Serializer,"
            + " valueSerializer=42, otherProperties={}, addMetadataKeyValuesAsKafkaHeaders=true, kafkaHeadersCharset"
            + "=UTF-8)",
        actualToStringResult);
    assertEquals("Topic Pattern", actualTopicPattern);
    assertEquals("UTF-8", actualKafkaHeadersCharset);
    assertEquals(1, actualBufferMemory);
    assertEquals(1, actualLinger);
    assertEquals(1, actualRetries);
    assertEquals(3, actualBatchSize);
    assertTrue(actualOtherProperties.isEmpty());
    assertTrue(actualIsAddMetadataKeyValuesAsKafkaHeadersResult);
    assertSame(otherProperties, actualOtherProperties);
  }
}
