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
package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TbQueueRemoteJsInvokeSettingsDiffblueTest {
  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  void testGetRequestTopic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getRequestTopic()}
   */
  @Test
  void testGetRequestTopic2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getRequestTopic());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  void testGetResponseTopic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertEquals("Prefix.null", tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#getResponseTopic()}
   */
  @Test
  void testGetResponseTopic2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("");

    // Act and Assert
    assertNull(tbQueueRemoteJsInvokeSettings.getResponseTopic());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
    int expectedHashCodeResult = tbQueueRemoteJsInvokeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRemoteJsInvokeSettings2.hashCode());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxPendingRequests(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponsePollInterval(42);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(1L);

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, new TbQueueRemoteJsInvokeSettings());
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setRequestTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings.setResponseTopic("Prefix");
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");

    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings2 = new TbQueueRemoteJsInvokeSettings();
    tbQueueRemoteJsInvokeSettings2.setPrefix("Prefix");

    // Act and Assert
    assertNotEquals(tbQueueRemoteJsInvokeSettings, tbQueueRemoteJsInvokeSettings2);
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRemoteJsInvokeSettings(), null);
  }

  /**
   * Method under test: {@link TbQueueRemoteJsInvokeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRemoteJsInvokeSettings(), "Different type to TbQueueRemoteJsInvokeSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setMaxPendingRequests(long)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setMaxRequestsTimeout(long)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setPrefix(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setRequestTopic(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setResponsePollInterval(int)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#setResponseTopic(String)}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#toString()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getMaxPendingRequests()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getMaxRequestsTimeout()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getPrefix()}
   *   <li>{@link TbQueueRemoteJsInvokeSettings#getResponsePollInterval()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings = new TbQueueRemoteJsInvokeSettings();

    // Act
    tbQueueRemoteJsInvokeSettings.setMaxPendingRequests(1L);
    tbQueueRemoteJsInvokeSettings.setMaxRequestsTimeout(1L);
    tbQueueRemoteJsInvokeSettings.setPrefix("Prefix");
    tbQueueRemoteJsInvokeSettings.setRequestTopic("Request Topic");
    tbQueueRemoteJsInvokeSettings.setResponsePollInterval(42);
    tbQueueRemoteJsInvokeSettings.setResponseTopic("Response Topic");
    String actualToStringResult = tbQueueRemoteJsInvokeSettings.toString();
    long actualMaxPendingRequests = tbQueueRemoteJsInvokeSettings.getMaxPendingRequests();
    long actualMaxRequestsTimeout = tbQueueRemoteJsInvokeSettings.getMaxRequestsTimeout();
    String actualPrefix = tbQueueRemoteJsInvokeSettings.getPrefix();

    // Assert that nothing has changed
    assertEquals("Prefix", actualPrefix);
    assertEquals(
        "TbQueueRemoteJsInvokeSettings(prefix=Prefix, requestTopic=Prefix.Request Topic, responseTopic=Prefix.Response"
            + " Topic, maxPendingRequests=1, responsePollInterval=42, maxRequestsTimeout=1)",
        actualToStringResult);
    assertEquals(1L, actualMaxPendingRequests);
    assertEquals(1L, actualMaxRequestsTimeout);
    assertEquals(42, tbQueueRemoteJsInvokeSettings.getResponsePollInterval());
  }
}
