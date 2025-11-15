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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UpdateMessageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");
    UpdateMessage updateMessage2 = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage2);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, null, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");
    UpdateMessage updateMessage2 = new UpdateMessage(true, null, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage2);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", null, "https://example.org/example",
        "https://example.org/example", "https://example.org/example");
    UpdateMessage updateMessage2 = new UpdateMessage(true, "1.0.2", null, "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage2);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", null, "https://example.org/example",
        "https://example.org/example");
    UpdateMessage updateMessage2 = new UpdateMessage(true, "1.0.2", "1.0.2", null, "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage2);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", null,
        "https://example.org/example");
    UpdateMessage updateMessage2 = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", null,
        "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage2);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals(updateMessage, updateMessage);
    int expectedHashCodeResult = updateMessage.hashCode();
    assertEquals(expectedHashCodeResult, updateMessage.hashCode());
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(false, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "https://example.org/example", "1.0.2",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, null, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", null, "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", null, "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", "1.0.2",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", null,
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "1.0.2");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", null);

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"), null);
  }

  /**
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"), "Different type to UpdateMessage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UpdateMessage#UpdateMessage(boolean, String, String, String, String, String)}
   *   <li>{@link UpdateMessage#toString()}
   *   <li>{@link UpdateMessage#getCurrentVersion()}
   *   <li>{@link UpdateMessage#getCurrentVersionReleaseNotesUrl()}
   *   <li>{@link UpdateMessage#getLatestVersion()}
   *   <li>{@link UpdateMessage#getLatestVersionReleaseNotesUrl()}
   *   <li>{@link UpdateMessage#getUpgradeInstructionsUrl()}
   *   <li>{@link UpdateMessage#isUpdateAvailable()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UpdateMessage actualUpdateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");
    String actualToStringResult = actualUpdateMessage.toString();
    String actualCurrentVersion = actualUpdateMessage.getCurrentVersion();
    String actualCurrentVersionReleaseNotesUrl = actualUpdateMessage.getCurrentVersionReleaseNotesUrl();
    String actualLatestVersion = actualUpdateMessage.getLatestVersion();
    String actualLatestVersionReleaseNotesUrl = actualUpdateMessage.getLatestVersionReleaseNotesUrl();
    String actualUpgradeInstructionsUrl = actualUpdateMessage.getUpgradeInstructionsUrl();

    // Assert
    assertEquals("1.0.2", actualCurrentVersion);
    assertEquals("1.0.2", actualLatestVersion);
    assertEquals("UpdateMessage(updateAvailable=true, currentVersion=1.0.2, latestVersion=1.0.2, upgradeInstructionsUrl"
        + "=https://example.org/example, currentVersionReleaseNotesUrl=https://example.org/example, latestVersi"
        + "onReleaseNotesUrl=https://example.org/example)", actualToStringResult);
    assertEquals("https://example.org/example", actualCurrentVersionReleaseNotesUrl);
    assertEquals("https://example.org/example", actualLatestVersionReleaseNotesUrl);
    assertEquals("https://example.org/example", actualUpgradeInstructionsUrl);
    assertTrue(actualUpdateMessage.isUpdateAvailable());
  }
}
