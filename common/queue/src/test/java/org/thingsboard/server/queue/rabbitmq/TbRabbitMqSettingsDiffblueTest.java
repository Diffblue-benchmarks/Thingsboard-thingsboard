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
package org.thingsboard.server.queue.rabbitmq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

class TbRabbitMqSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setExchangeName("Exchange Name");

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setExchangeName("Exchange Name");

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setHost("localhost");

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setHost("localhost");

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setVirtualHost("localhost");

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setVirtualHost("localhost");

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setUsername("janedoe");

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setUsername("janedoe");

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setPassword("iloveyou");

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#equals(Object)}
   *   <li>{@link TbRabbitMqSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    // Act and Assert
    assertEquals(tbRabbitMqSettings, tbRabbitMqSettings);
    int expectedHashCodeResult = tbRabbitMqSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbRabbitMqSettings.hashCode());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqSettings(), 1);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setExchangeName("Exchange Name");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setPort(8080);

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setVirtualHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setAutomaticRecoveryEnabled(true);

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setConnectionTimeout(10);

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setHandshakeTimeout(10);

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setMaxPollMessages(3);

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setConnectionFactory(new ConnectionFactory());

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setExchangeName("Exchange Name");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setVirtualHost("localhost");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    TbRabbitMqSettings tbRabbitMqSettings2 = new TbRabbitMqSettings();
    tbRabbitMqSettings2.setConnectionFactory(new ConnectionFactory());

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, tbRabbitMqSettings2);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();
    tbRabbitMqSettings.setConnectionFactory(mock(ConnectionFactory.class));

    // Act and Assert
    assertNotEquals(tbRabbitMqSettings, new TbRabbitMqSettings());
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqSettings(), null);
  }

  /**
   * Method under test: {@link TbRabbitMqSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRabbitMqSettings(), "Different type to TbRabbitMqSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRabbitMqSettings#setAutomaticRecoveryEnabled(boolean)}
   *   <li>{@link TbRabbitMqSettings#setConnectionFactory(ConnectionFactory)}
   *   <li>{@link TbRabbitMqSettings#setConnectionTimeout(int)}
   *   <li>{@link TbRabbitMqSettings#setExchangeName(String)}
   *   <li>{@link TbRabbitMqSettings#setHandshakeTimeout(int)}
   *   <li>{@link TbRabbitMqSettings#setHost(String)}
   *   <li>{@link TbRabbitMqSettings#setMaxPollMessages(int)}
   *   <li>{@link TbRabbitMqSettings#setPassword(String)}
   *   <li>{@link TbRabbitMqSettings#setPort(int)}
   *   <li>{@link TbRabbitMqSettings#setUsername(String)}
   *   <li>{@link TbRabbitMqSettings#setVirtualHost(String)}
   *   <li>{@link TbRabbitMqSettings#toString()}
   *   <li>{@link TbRabbitMqSettings#getConnectionFactory()}
   *   <li>{@link TbRabbitMqSettings#getConnectionTimeout()}
   *   <li>{@link TbRabbitMqSettings#getExchangeName()}
   *   <li>{@link TbRabbitMqSettings#getHandshakeTimeout()}
   *   <li>{@link TbRabbitMqSettings#getHost()}
   *   <li>{@link TbRabbitMqSettings#getMaxPollMessages()}
   *   <li>{@link TbRabbitMqSettings#getPassword()}
   *   <li>{@link TbRabbitMqSettings#getPort()}
   *   <li>{@link TbRabbitMqSettings#getUsername()}
   *   <li>{@link TbRabbitMqSettings#getVirtualHost()}
   *   <li>{@link TbRabbitMqSettings#isAutomaticRecoveryEnabled()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbRabbitMqSettings tbRabbitMqSettings = new TbRabbitMqSettings();

    // Act
    tbRabbitMqSettings.setAutomaticRecoveryEnabled(true);
    ConnectionFactory connectionFactory = new ConnectionFactory();
    tbRabbitMqSettings.setConnectionFactory(connectionFactory);
    tbRabbitMqSettings.setConnectionTimeout(10);
    tbRabbitMqSettings.setExchangeName("Exchange Name");
    tbRabbitMqSettings.setHandshakeTimeout(10);
    tbRabbitMqSettings.setHost("localhost");
    tbRabbitMqSettings.setMaxPollMessages(3);
    tbRabbitMqSettings.setPassword("iloveyou");
    tbRabbitMqSettings.setPort(8080);
    tbRabbitMqSettings.setUsername("janedoe");
    tbRabbitMqSettings.setVirtualHost("localhost");
    tbRabbitMqSettings.toString();
    ConnectionFactory actualConnectionFactory = tbRabbitMqSettings.getConnectionFactory();
    int actualConnectionTimeout = tbRabbitMqSettings.getConnectionTimeout();
    String actualExchangeName = tbRabbitMqSettings.getExchangeName();
    int actualHandshakeTimeout = tbRabbitMqSettings.getHandshakeTimeout();
    String actualHost = tbRabbitMqSettings.getHost();
    int actualMaxPollMessages = tbRabbitMqSettings.getMaxPollMessages();
    String actualPassword = tbRabbitMqSettings.getPassword();
    int actualPort = tbRabbitMqSettings.getPort();
    String actualUsername = tbRabbitMqSettings.getUsername();
    String actualVirtualHost = tbRabbitMqSettings.getVirtualHost();

    // Assert that nothing has changed
    assertEquals("Exchange Name", actualExchangeName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("localhost", actualHost);
    assertEquals("localhost", actualVirtualHost);
    assertEquals(10, actualConnectionTimeout);
    assertEquals(10, actualHandshakeTimeout);
    assertEquals(3, actualMaxPollMessages);
    assertEquals(8080, actualPort);
    assertTrue(tbRabbitMqSettings.isAutomaticRecoveryEnabled());
    assertSame(connectionFactory, actualConnectionFactory);
  }
}
