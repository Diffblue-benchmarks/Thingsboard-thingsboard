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
package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TbAwsSqsSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setUseDefaultCredentialProviderChain(true);

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setUseDefaultCredentialProviderChain(true);

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setRegion("us-east-2");

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setRegion("us-east-2");

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#equals(Object)}
   *   <li>{@link TbAwsSqsSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    // Act and Assert
    assertEquals(tbAwsSqsSettings, tbAwsSqsSettings);
    int expectedHashCodeResult = tbAwsSqsSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsSqsSettings.hashCode());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsSqsSettings(), 1);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setUseDefaultCredentialProviderChain(true);

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setThreadsPerTopic(1);

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();
    tbAwsSqsSettings.setThreadPoolSize(3);

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, new TbAwsSqsSettings());
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setUseDefaultCredentialProviderChain(true);

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    TbAwsSqsSettings tbAwsSqsSettings2 = new TbAwsSqsSettings();
    tbAwsSqsSettings2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbAwsSqsSettings, tbAwsSqsSettings2);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsSqsSettings(), null);
  }

  /**
   * Method under test: {@link TbAwsSqsSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsSqsSettings(), "Different type to TbAwsSqsSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsSqsSettings#setAccessKeyId(String)}
   *   <li>{@link TbAwsSqsSettings#setRegion(String)}
   *   <li>{@link TbAwsSqsSettings#setSecretAccessKey(String)}
   *   <li>{@link TbAwsSqsSettings#setThreadPoolSize(int)}
   *   <li>{@link TbAwsSqsSettings#setThreadsPerTopic(int)}
   *   <li>{@link TbAwsSqsSettings#setUseDefaultCredentialProviderChain(Boolean)}
   *   <li>{@link TbAwsSqsSettings#toString()}
   *   <li>{@link TbAwsSqsSettings#getAccessKeyId()}
   *   <li>{@link TbAwsSqsSettings#getRegion()}
   *   <li>{@link TbAwsSqsSettings#getSecretAccessKey()}
   *   <li>{@link TbAwsSqsSettings#getThreadPoolSize()}
   *   <li>{@link TbAwsSqsSettings#getThreadsPerTopic()}
   *   <li>{@link TbAwsSqsSettings#getUseDefaultCredentialProviderChain()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbAwsSqsSettings tbAwsSqsSettings = new TbAwsSqsSettings();

    // Act
    tbAwsSqsSettings.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    tbAwsSqsSettings.setRegion("us-east-2");
    tbAwsSqsSettings.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    tbAwsSqsSettings.setThreadPoolSize(3);
    tbAwsSqsSettings.setThreadsPerTopic(1);
    tbAwsSqsSettings.setUseDefaultCredentialProviderChain(true);
    String actualToStringResult = tbAwsSqsSettings.toString();
    String actualAccessKeyId = tbAwsSqsSettings.getAccessKeyId();
    String actualRegion = tbAwsSqsSettings.getRegion();
    String actualSecretAccessKey = tbAwsSqsSettings.getSecretAccessKey();
    int actualThreadPoolSize = tbAwsSqsSettings.getThreadPoolSize();
    int actualThreadsPerTopic = tbAwsSqsSettings.getThreadsPerTopic();

    // Assert that nothing has changed
    assertEquals("EXAMPLEakiAIOSFODNN7", actualAccessKeyId);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualSecretAccessKey);
    assertEquals(
        "TbAwsSqsSettings(useDefaultCredentialProviderChain=true, accessKeyId=EXAMPLEakiAIOSFODNN7, secretAccessKey"
            + "=EXAMPLEakiAIOSFODNN7, region=us-east-2, threadsPerTopic=1, threadPoolSize=3)",
        actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(1, actualThreadsPerTopic);
    assertEquals(3, actualThreadPoolSize);
    assertTrue(tbAwsSqsSettings.getUseDefaultCredentialProviderChain());
  }
}
