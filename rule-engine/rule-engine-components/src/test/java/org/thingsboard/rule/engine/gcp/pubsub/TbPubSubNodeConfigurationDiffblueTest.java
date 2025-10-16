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
package org.thingsboard.rule.engine.gcp.pubsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class TbPubSubNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbPubSubNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPubSubNodeConfiguration TbPubSubNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbPubSubNodeConfiguration actualDefaultConfigurationResult =
        new TbPubSubNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("my-google-cloud-project-id", actualDefaultConfigurationResult.getProjectId());
    assertEquals("my-pubsub-topic-name", actualDefaultConfigurationResult.getTopicName());
    assertNull(actualDefaultConfigurationResult.getServiceAccountKey());
    assertNull(actualDefaultConfigurationResult.getServiceAccountKeyFileName());
    assertTrue(actualDefaultConfigurationResult.getMessageAttributes().isEmpty());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setProjectId("myproject");

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setProjectId("myproject");

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setTopicName("Topic Name");

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setTopicName("Topic Name");

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setMessageAttributes(new HashMap<>());

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKey("3");

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setServiceAccountKey("3");

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKeyFileName("Dr Jane Doe");

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setServiceAccountKeyFileName("Dr Jane Doe");

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
    assertEquals(tbPubSubNodeConfiguration.hashCode(), tbPubSubNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}, and {@link
   * TbPubSubNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubNodeConfiguration#equals(Object)}
   *   <li>{@link TbPubSubNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    // Act and Assert
    assertEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration);
    int expectedHashCodeResult = tbPubSubNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbPubSubNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setProjectId("myproject");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, new TbPubSubNodeConfiguration());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setTopicName("Topic Name");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, new TbPubSubNodeConfiguration());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, new TbPubSubNodeConfiguration());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKey("3");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, new TbPubSubNodeConfiguration());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration.setServiceAccountKeyFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, new TbPubSubNodeConfiguration());
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setProjectId("myproject");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setTopicName("Topic Name");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setServiceAccountKey("3");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbPubSubNodeConfiguration tbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();

    TbPubSubNodeConfiguration tbPubSubNodeConfiguration2 = new TbPubSubNodeConfiguration();
    tbPubSubNodeConfiguration2.setServiceAccountKeyFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(tbPubSubNodeConfiguration, tbPubSubNodeConfiguration2);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubNodeConfiguration(), null);
  }

  /**
   * Test {@link TbPubSubNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPubSubNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbPubSubNodeConfiguration.equals(Object)",
    "int TbPubSubNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubNodeConfiguration(), "Different type to TbPubSubNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbPubSubNodeConfiguration}
   *   <li>{@link TbPubSubNodeConfiguration#setMessageAttributes(Map)}
   *   <li>{@link TbPubSubNodeConfiguration#setProjectId(String)}
   *   <li>{@link TbPubSubNodeConfiguration#setServiceAccountKey(String)}
   *   <li>{@link TbPubSubNodeConfiguration#setServiceAccountKeyFileName(String)}
   *   <li>{@link TbPubSubNodeConfiguration#setTopicName(String)}
   *   <li>{@link TbPubSubNodeConfiguration#toString()}
   *   <li>{@link TbPubSubNodeConfiguration#getMessageAttributes()}
   *   <li>{@link TbPubSubNodeConfiguration#getProjectId()}
   *   <li>{@link TbPubSubNodeConfiguration#getServiceAccountKey()}
   *   <li>{@link TbPubSubNodeConfiguration#getServiceAccountKeyFileName()}
   *   <li>{@link TbPubSubNodeConfiguration#getTopicName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbPubSubNodeConfiguration.<init>()",
    "Map TbPubSubNodeConfiguration.getMessageAttributes()",
    "String TbPubSubNodeConfiguration.getProjectId()",
    "String TbPubSubNodeConfiguration.getServiceAccountKey()",
    "String TbPubSubNodeConfiguration.getServiceAccountKeyFileName()",
    "String TbPubSubNodeConfiguration.getTopicName()",
    "void TbPubSubNodeConfiguration.setMessageAttributes(Map)",
    "void TbPubSubNodeConfiguration.setProjectId(String)",
    "void TbPubSubNodeConfiguration.setServiceAccountKey(String)",
    "void TbPubSubNodeConfiguration.setServiceAccountKeyFileName(String)",
    "void TbPubSubNodeConfiguration.setTopicName(String)",
    "String TbPubSubNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbPubSubNodeConfiguration actualTbPubSubNodeConfiguration = new TbPubSubNodeConfiguration();
    HashMap<String, String> messageAttributes = new HashMap<>();
    actualTbPubSubNodeConfiguration.setMessageAttributes(messageAttributes);
    actualTbPubSubNodeConfiguration.setProjectId("myproject");
    actualTbPubSubNodeConfiguration.setServiceAccountKey("3");
    actualTbPubSubNodeConfiguration.setServiceAccountKeyFileName("Dr Jane Doe");
    actualTbPubSubNodeConfiguration.setTopicName("Topic Name");
    String actualToStringResult = actualTbPubSubNodeConfiguration.toString();
    Map<String, String> actualMessageAttributes =
        actualTbPubSubNodeConfiguration.getMessageAttributes();
    String actualProjectId = actualTbPubSubNodeConfiguration.getProjectId();
    String actualServiceAccountKey = actualTbPubSubNodeConfiguration.getServiceAccountKey();
    String actualServiceAccountKeyFileName =
        actualTbPubSubNodeConfiguration.getServiceAccountKeyFileName();

    // Assert
    assertEquals("3", actualServiceAccountKey);
    assertEquals("Dr Jane Doe", actualServiceAccountKeyFileName);
    assertEquals(
        "TbPubSubNodeConfiguration(projectId=myproject, topicName=Topic Name, messageAttributes={}, serviceAccountKey"
            + "=3, serviceAccountKeyFileName=Dr Jane Doe)",
        actualToStringResult);
    assertEquals("Topic Name", actualTbPubSubNodeConfiguration.getTopicName());
    assertEquals("myproject", actualProjectId);
    assertTrue(actualMessageAttributes.isEmpty());
    assertSame(messageAttributes, actualMessageAttributes);
  }
}
