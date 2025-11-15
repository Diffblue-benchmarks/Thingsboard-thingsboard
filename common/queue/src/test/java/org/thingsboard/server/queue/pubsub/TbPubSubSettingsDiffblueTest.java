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
package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import org.junit.jupiter.api.Test;

class TbPubSubSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSettings#equals(Object)}
   *   <li>{@link TbPubSubSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();

    // Act and Assert
    assertEquals(tbPubSubSettings, tbPubSubSettings2);
    int expectedHashCodeResult = tbPubSubSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbPubSubSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSettings#equals(Object)}
   *   <li>{@link TbPubSubSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setProjectId("myproject");

    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();
    tbPubSubSettings2.setProjectId("myproject");

    // Act and Assert
    assertEquals(tbPubSubSettings, tbPubSubSettings2);
    int expectedHashCodeResult = tbPubSubSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbPubSubSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSettings#equals(Object)}
   *   <li>{@link TbPubSubSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setServiceAccount("3");

    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();
    tbPubSubSettings2.setServiceAccount("3");

    // Act and Assert
    assertEquals(tbPubSubSettings, tbPubSubSettings2);
    int expectedHashCodeResult = tbPubSubSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbPubSubSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSettings#equals(Object)}
   *   <li>{@link TbPubSubSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();

    // Act and Assert
    assertEquals(tbPubSubSettings, tbPubSubSettings);
    int expectedHashCodeResult = tbPubSubSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbPubSubSettings.hashCode());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubSettings(), 1);
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setProjectId("myproject");

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setServiceAccount("3");

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setMaxMsgSize(3);

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setMaxMessages(3);

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setThreadPoolSize(3);

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    tbPubSubSettings.setCredentialsProvider(mock(CredentialsProvider.class));

    // Act and Assert
    assertNotEquals(tbPubSubSettings, new TbPubSubSettings());
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();

    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();
    tbPubSubSettings2.setProjectId("myproject");

    // Act and Assert
    assertNotEquals(tbPubSubSettings, tbPubSubSettings2);
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();

    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();
    tbPubSubSettings2.setServiceAccount("3");

    // Act and Assert
    assertNotEquals(tbPubSubSettings, tbPubSubSettings2);
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();

    TbPubSubSettings tbPubSubSettings2 = new TbPubSubSettings();
    tbPubSubSettings2.setCredentialsProvider(mock(CredentialsProvider.class));

    // Act and Assert
    assertNotEquals(tbPubSubSettings, tbPubSubSettings2);
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubSettings(), null);
  }

  /**
   * Method under test: {@link TbPubSubSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbPubSubSettings(), "Different type to TbPubSubSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSettings#setCredentialsProvider(CredentialsProvider)}
   *   <li>{@link TbPubSubSettings#setExecutorProvider(FixedExecutorProvider)}
   *   <li>{@link TbPubSubSettings#setMaxMessages(int)}
   *   <li>{@link TbPubSubSettings#setMaxMsgSize(int)}
   *   <li>{@link TbPubSubSettings#setProjectId(String)}
   *   <li>{@link TbPubSubSettings#setServiceAccount(String)}
   *   <li>{@link TbPubSubSettings#setThreadPoolSize(int)}
   *   <li>{@link TbPubSubSettings#toString()}
   *   <li>{@link TbPubSubSettings#getCredentialsProvider()}
   *   <li>{@link TbPubSubSettings#getExecutorProvider()}
   *   <li>{@link TbPubSubSettings#getMaxMessages()}
   *   <li>{@link TbPubSubSettings#getMaxMsgSize()}
   *   <li>{@link TbPubSubSettings#getProjectId()}
   *   <li>{@link TbPubSubSettings#getServiceAccount()}
   *   <li>{@link TbPubSubSettings#getThreadPoolSize()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbPubSubSettings tbPubSubSettings = new TbPubSubSettings();
    CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);

    // Act
    tbPubSubSettings.setCredentialsProvider(credentialsProvider);
    tbPubSubSettings.setExecutorProvider(null);
    tbPubSubSettings.setMaxMessages(3);
    tbPubSubSettings.setMaxMsgSize(3);
    tbPubSubSettings.setProjectId("myproject");
    tbPubSubSettings.setServiceAccount("3");
    tbPubSubSettings.setThreadPoolSize(3);
    tbPubSubSettings.toString();
    CredentialsProvider actualCredentialsProvider = tbPubSubSettings.getCredentialsProvider();
    tbPubSubSettings.getExecutorProvider();
    int actualMaxMessages = tbPubSubSettings.getMaxMessages();
    int actualMaxMsgSize = tbPubSubSettings.getMaxMsgSize();
    String actualProjectId = tbPubSubSettings.getProjectId();
    String actualServiceAccount = tbPubSubSettings.getServiceAccount();

    // Assert that nothing has changed
    assertEquals("3", actualServiceAccount);
    assertEquals("myproject", actualProjectId);
    assertEquals(3, actualMaxMessages);
    assertEquals(3, actualMaxMsgSize);
    assertEquals(3, tbPubSubSettings.getThreadPoolSize());
    assertSame(credentialsProvider, actualCredentialsProvider);
  }
}
