package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UpdateMessageDiffblueTest {
  /**
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}, and {@link UpdateMessage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#equals(Object)}
   *   <li>{@link UpdateMessage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
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
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(false, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "https://example.org/example", "1.0.2",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, null, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", null, "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", null, "https://example.org/example",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", "1.0.2",
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example", null,
        "https://example.org/example");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "1.0.2");

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", null);

    // Act and Assert
    assertNotEquals(updateMessage, new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"), null);
  }

  /**
   * Test {@link UpdateMessage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateMessage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UpdateMessage.equals(Object)", "int UpdateMessage.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"), "Different type to UpdateMessage");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UpdateMessage#UpdateMessage(boolean, String, String, String, String, String)}
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UpdateMessage.<init>(boolean, String, String, String, String, String)",
      "String UpdateMessage.getCurrentVersion()", "String UpdateMessage.getCurrentVersionReleaseNotesUrl()",
      "String UpdateMessage.getLatestVersion()", "String UpdateMessage.getLatestVersionReleaseNotesUrl()",
      "String UpdateMessage.getUpgradeInstructionsUrl()", "boolean UpdateMessage.isUpdateAvailable()",
      "String UpdateMessage.toString()"})
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
