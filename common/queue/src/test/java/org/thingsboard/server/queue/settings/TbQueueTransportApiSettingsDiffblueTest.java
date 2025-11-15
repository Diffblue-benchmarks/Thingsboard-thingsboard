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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbQueueTransportApiSettingsDiffblueTest {
  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}, and {@link TbQueueTransportApiSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportApiSettings#equals(Object)}
   *   <li>{@link TbQueueTransportApiSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportApiSettings tbQueueTransportApiSettings2 = new TbQueueTransportApiSettings();

    // Act and Assert
    assertEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings2);
    int expectedHashCodeResult = tbQueueTransportApiSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportApiSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}, and {@link TbQueueTransportApiSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportApiSettings#equals(Object)}
   *   <li>{@link TbQueueTransportApiSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setRequestsTopic("Requests Topic");

    TbQueueTransportApiSettings tbQueueTransportApiSettings2 = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings2.setRequestsTopic("Requests Topic");

    // Act and Assert
    assertEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings2);
    int expectedHashCodeResult = tbQueueTransportApiSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportApiSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}, and {@link TbQueueTransportApiSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportApiSettings#equals(Object)}
   *   <li>{@link TbQueueTransportApiSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setResponsesTopic("Responses Topic");

    TbQueueTransportApiSettings tbQueueTransportApiSettings2 = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings2.setResponsesTopic("Responses Topic");

    // Act and Assert
    assertEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings2);
    int expectedHashCodeResult = tbQueueTransportApiSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportApiSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}, and {@link TbQueueTransportApiSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportApiSettings#equals(Object)}
   *   <li>{@link TbQueueTransportApiSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();

    // Act and Assert
    assertEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings);
    int expectedHashCodeResult = tbQueueTransportApiSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportApiSettings.hashCode());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportApiSettings(), 1);
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setRequestsTopic("Requests Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setResponsesTopic("Responses Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setMaxPendingRequests(3);

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setMaxRequestsTimeout(3);

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setMaxCallbackThreads(3);

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setRequestPollInterval(42L);

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings.setResponsePollInterval(42L);

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, new TbQueueTransportApiSettings());
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();

    TbQueueTransportApiSettings tbQueueTransportApiSettings2 = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings2.setRequestsTopic("Requests Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings2);
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();

    TbQueueTransportApiSettings tbQueueTransportApiSettings2 = new TbQueueTransportApiSettings();
    tbQueueTransportApiSettings2.setResponsesTopic("Responses Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportApiSettings, tbQueueTransportApiSettings2);
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportApiSettings(), null);
  }

  /**
   * Test {@link TbQueueTransportApiSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueTransportApiSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbQueueTransportApiSettings.equals(Object)",
      "int TbQueueTransportApiSettings.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportApiSettings(), "Different type to TbQueueTransportApiSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportApiSettings#setMaxCallbackThreads(int)}
   *   <li>{@link TbQueueTransportApiSettings#setMaxPendingRequests(int)}
   *   <li>{@link TbQueueTransportApiSettings#setMaxRequestsTimeout(int)}
   *   <li>{@link TbQueueTransportApiSettings#setRequestPollInterval(long)}
   *   <li>{@link TbQueueTransportApiSettings#setRequestsTopic(String)}
   *   <li>{@link TbQueueTransportApiSettings#setResponsePollInterval(long)}
   *   <li>{@link TbQueueTransportApiSettings#setResponsesTopic(String)}
   *   <li>{@link TbQueueTransportApiSettings#toString()}
   *   <li>{@link TbQueueTransportApiSettings#getMaxCallbackThreads()}
   *   <li>{@link TbQueueTransportApiSettings#getMaxPendingRequests()}
   *   <li>{@link TbQueueTransportApiSettings#getMaxRequestsTimeout()}
   *   <li>{@link TbQueueTransportApiSettings#getRequestPollInterval()}
   *   <li>{@link TbQueueTransportApiSettings#getRequestsTopic()}
   *   <li>{@link TbQueueTransportApiSettings#getResponsePollInterval()}
   *   <li>{@link TbQueueTransportApiSettings#getResponsesTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbQueueTransportApiSettings.getMaxCallbackThreads()",
      "int TbQueueTransportApiSettings.getMaxPendingRequests()",
      "int TbQueueTransportApiSettings.getMaxRequestsTimeout()",
      "long TbQueueTransportApiSettings.getRequestPollInterval()",
      "String TbQueueTransportApiSettings.getRequestsTopic()",
      "long TbQueueTransportApiSettings.getResponsePollInterval()",
      "String TbQueueTransportApiSettings.getResponsesTopic()",
      "void TbQueueTransportApiSettings.setMaxCallbackThreads(int)",
      "void TbQueueTransportApiSettings.setMaxPendingRequests(int)",
      "void TbQueueTransportApiSettings.setMaxRequestsTimeout(int)",
      "void TbQueueTransportApiSettings.setRequestPollInterval(long)",
      "void TbQueueTransportApiSettings.setRequestsTopic(String)",
      "void TbQueueTransportApiSettings.setResponsePollInterval(long)",
      "void TbQueueTransportApiSettings.setResponsesTopic(String)", "String TbQueueTransportApiSettings.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportApiSettings tbQueueTransportApiSettings = new TbQueueTransportApiSettings();

    // Act
    tbQueueTransportApiSettings.setMaxCallbackThreads(3);
    tbQueueTransportApiSettings.setMaxPendingRequests(3);
    tbQueueTransportApiSettings.setMaxRequestsTimeout(3);
    tbQueueTransportApiSettings.setRequestPollInterval(42L);
    tbQueueTransportApiSettings.setRequestsTopic("Requests Topic");
    tbQueueTransportApiSettings.setResponsePollInterval(42L);
    tbQueueTransportApiSettings.setResponsesTopic("Responses Topic");
    String actualToStringResult = tbQueueTransportApiSettings.toString();
    int actualMaxCallbackThreads = tbQueueTransportApiSettings.getMaxCallbackThreads();
    int actualMaxPendingRequests = tbQueueTransportApiSettings.getMaxPendingRequests();
    int actualMaxRequestsTimeout = tbQueueTransportApiSettings.getMaxRequestsTimeout();
    long actualRequestPollInterval = tbQueueTransportApiSettings.getRequestPollInterval();
    String actualRequestsTopic = tbQueueTransportApiSettings.getRequestsTopic();
    long actualResponsePollInterval = tbQueueTransportApiSettings.getResponsePollInterval();

    // Assert
    assertEquals("Requests Topic", actualRequestsTopic);
    assertEquals("Responses Topic", tbQueueTransportApiSettings.getResponsesTopic());
    assertEquals("TbQueueTransportApiSettings(requestsTopic=Requests Topic, responsesTopic=Responses Topic,"
        + " maxPendingRequests=3, maxRequestsTimeout=3, maxCallbackThreads=3, requestPollInterval=42,"
        + " responsePollInterval=42)", actualToStringResult);
    assertEquals(3, actualMaxCallbackThreads);
    assertEquals(3, actualMaxPendingRequests);
    assertEquals(3, actualMaxRequestsTimeout);
    assertEquals(42L, actualRequestPollInterval);
    assertEquals(42L, actualResponsePollInterval);
  }
}
