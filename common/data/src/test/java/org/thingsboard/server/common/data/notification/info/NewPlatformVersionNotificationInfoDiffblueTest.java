package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.info.NewPlatformVersionNotificationInfo.NewPlatformVersionNotificationInfoBuilder;

@ContextConfiguration(classes = {NewPlatformVersionNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class NewPlatformVersionNotificationInfoDiffblueTest {
  @Autowired
  private NewPlatformVersionNotificationInfoBuilder newPlatformVersionNotificationInfoBuilder;

  /**
   * Test {@link NewPlatformVersionNotificationInfo#getTemplateData()}.
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map NewPlatformVersionNotificationInfo.getTemplateData()"})
  void testGetTemplateData() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        new NewPlatformVersionNotificationInfo(
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "1.0.2",
            "https://example.org/example");

    // Act
    Map<String, String> actualTemplateData = newPlatformVersionNotificationInfo.getTemplateData();

    // Assert
    assertEquals(5, actualTemplateData.size());
    assertEquals("1.0.2", actualTemplateData.get("currentVersion"));
    assertEquals("1.0.2", actualTemplateData.get("latestVersion"));
    assertEquals(
        "https://example.org/example", actualTemplateData.get("currentVersionReleaseNotesUrl"));
    assertEquals(
        "https://example.org/example", actualTemplateData.get("latestVersionReleaseNotesUrl"));
    assertEquals("https://example.org/example", actualTemplateData.get("upgradeInstructionsUrl"));
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion(null)
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion(null)
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl(null)
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl(null)
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion(null)
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion(null)
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl(null)
            .upgradeInstructionsUrl("https://example.org/example")
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl(null)
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl(null)
            .build();
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo2 =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl(null)
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo2);
    assertEquals(
        newPlatformVersionNotificationInfo.hashCode(),
        newPlatformVersionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}, and {@link
   * NewPlatformVersionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationInfo, newPlatformVersionNotificationInfo);
    int expectedHashCodeResult = newPlatformVersionNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, newPlatformVersionNotificationInfo.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("https://example.org/example")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion(null)
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("1.0.2")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl(null)
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("https://example.org/example")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion(null)
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("1.0.2")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl(null)
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NewPlatformVersionNotificationInfo newPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl(null)
            .build();

    // Act and Assert
    assertNotEquals(
        newPlatformVersionNotificationInfo,
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build());
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build(),
        null);
  }

  /**
   * Test {@link NewPlatformVersionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionNotificationInfo.equals(Object)",
    "int NewPlatformVersionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build(),
        "Different type to NewPlatformVersionNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#NewPlatformVersionNotificationInfo()}
   *   <li>{@link NewPlatformVersionNotificationInfo#setCurrentVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setCurrentVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setLatestVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setLatestVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setUpgradeInstructionsUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#toString()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getCurrentVersion()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getCurrentVersionReleaseNotesUrl()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getLatestVersion()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getLatestVersionReleaseNotesUrl()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getUpgradeInstructionsUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewPlatformVersionNotificationInfo.<init>()",
    "void NewPlatformVersionNotificationInfo.<init>(String, String, String, String, String)",
    "String NewPlatformVersionNotificationInfo.getCurrentVersion()",
    "String NewPlatformVersionNotificationInfo.getCurrentVersionReleaseNotesUrl()",
    "String NewPlatformVersionNotificationInfo.getLatestVersion()",
    "String NewPlatformVersionNotificationInfo.getLatestVersionReleaseNotesUrl()",
    "String NewPlatformVersionNotificationInfo.getUpgradeInstructionsUrl()",
    "void NewPlatformVersionNotificationInfo.setCurrentVersion(String)",
    "void NewPlatformVersionNotificationInfo.setCurrentVersionReleaseNotesUrl(String)",
    "void NewPlatformVersionNotificationInfo.setLatestVersion(String)",
    "void NewPlatformVersionNotificationInfo.setLatestVersionReleaseNotesUrl(String)",
    "void NewPlatformVersionNotificationInfo.setUpgradeInstructionsUrl(String)",
    "String NewPlatformVersionNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NewPlatformVersionNotificationInfo actualNewPlatformVersionNotificationInfo =
        new NewPlatformVersionNotificationInfo();
    actualNewPlatformVersionNotificationInfo.setCurrentVersion("1.0.2");
    actualNewPlatformVersionNotificationInfo.setCurrentVersionReleaseNotesUrl(
        "https://example.org/example");
    actualNewPlatformVersionNotificationInfo.setLatestVersion("1.0.2");
    actualNewPlatformVersionNotificationInfo.setLatestVersionReleaseNotesUrl(
        "https://example.org/example");
    actualNewPlatformVersionNotificationInfo.setUpgradeInstructionsUrl(
        "https://example.org/example");
    String actualToStringResult = actualNewPlatformVersionNotificationInfo.toString();
    String actualCurrentVersion = actualNewPlatformVersionNotificationInfo.getCurrentVersion();
    String actualCurrentVersionReleaseNotesUrl =
        actualNewPlatformVersionNotificationInfo.getCurrentVersionReleaseNotesUrl();
    String actualLatestVersion = actualNewPlatformVersionNotificationInfo.getLatestVersion();
    String actualLatestVersionReleaseNotesUrl =
        actualNewPlatformVersionNotificationInfo.getLatestVersionReleaseNotesUrl();

    // Assert
    assertEquals("1.0.2", actualCurrentVersion);
    assertEquals("1.0.2", actualLatestVersion);
    assertEquals(
        "NewPlatformVersionNotificationInfo(latestVersion=1.0.2, latestVersionReleaseNotesUrl=https://example"
            + ".org/example, upgradeInstructionsUrl=https://example.org/example, currentVersion=1.0.2, currentVersi"
            + "onReleaseNotesUrl=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualCurrentVersionReleaseNotesUrl);
    assertEquals("https://example.org/example", actualLatestVersionReleaseNotesUrl);
    assertEquals(
        "https://example.org/example",
        actualNewPlatformVersionNotificationInfo.getUpgradeInstructionsUrl());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfo#NewPlatformVersionNotificationInfo(String,
   *       String, String, String, String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setCurrentVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setCurrentVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setLatestVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setLatestVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#setUpgradeInstructionsUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfo#toString()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getCurrentVersion()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getCurrentVersionReleaseNotesUrl()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getLatestVersion()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getLatestVersionReleaseNotesUrl()}
   *   <li>{@link NewPlatformVersionNotificationInfo#getUpgradeInstructionsUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewPlatformVersionNotificationInfo.<init>()",
    "void NewPlatformVersionNotificationInfo.<init>(String, String, String, String, String)",
    "String NewPlatformVersionNotificationInfo.getCurrentVersion()",
    "String NewPlatformVersionNotificationInfo.getCurrentVersionReleaseNotesUrl()",
    "String NewPlatformVersionNotificationInfo.getLatestVersion()",
    "String NewPlatformVersionNotificationInfo.getLatestVersionReleaseNotesUrl()",
    "String NewPlatformVersionNotificationInfo.getUpgradeInstructionsUrl()",
    "void NewPlatformVersionNotificationInfo.setCurrentVersion(String)",
    "void NewPlatformVersionNotificationInfo.setCurrentVersionReleaseNotesUrl(String)",
    "void NewPlatformVersionNotificationInfo.setLatestVersion(String)",
    "void NewPlatformVersionNotificationInfo.setLatestVersionReleaseNotesUrl(String)",
    "void NewPlatformVersionNotificationInfo.setUpgradeInstructionsUrl(String)",
    "String NewPlatformVersionNotificationInfo.toString()"
  })
  void testGettersAndSetters_when102() {
    // Arrange and Act
    NewPlatformVersionNotificationInfo actualNewPlatformVersionNotificationInfo =
        new NewPlatformVersionNotificationInfo(
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "1.0.2",
            "https://example.org/example");
    actualNewPlatformVersionNotificationInfo.setCurrentVersion("1.0.2");
    actualNewPlatformVersionNotificationInfo.setCurrentVersionReleaseNotesUrl(
        "https://example.org/example");
    actualNewPlatformVersionNotificationInfo.setLatestVersion("1.0.2");
    actualNewPlatformVersionNotificationInfo.setLatestVersionReleaseNotesUrl(
        "https://example.org/example");
    actualNewPlatformVersionNotificationInfo.setUpgradeInstructionsUrl(
        "https://example.org/example");
    String actualToStringResult = actualNewPlatformVersionNotificationInfo.toString();
    String actualCurrentVersion = actualNewPlatformVersionNotificationInfo.getCurrentVersion();
    String actualCurrentVersionReleaseNotesUrl =
        actualNewPlatformVersionNotificationInfo.getCurrentVersionReleaseNotesUrl();
    String actualLatestVersion = actualNewPlatformVersionNotificationInfo.getLatestVersion();
    String actualLatestVersionReleaseNotesUrl =
        actualNewPlatformVersionNotificationInfo.getLatestVersionReleaseNotesUrl();

    // Assert
    assertEquals("1.0.2", actualCurrentVersion);
    assertEquals("1.0.2", actualLatestVersion);
    assertEquals(
        "NewPlatformVersionNotificationInfo(latestVersion=1.0.2, latestVersionReleaseNotesUrl=https://example"
            + ".org/example, upgradeInstructionsUrl=https://example.org/example, currentVersion=1.0.2, currentVersi"
            + "onReleaseNotesUrl=https://example.org/example)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualCurrentVersionReleaseNotesUrl);
    assertEquals("https://example.org/example", actualLatestVersionReleaseNotesUrl);
    assertEquals(
        "https://example.org/example",
        actualNewPlatformVersionNotificationInfo.getUpgradeInstructionsUrl());
  }

  /**
   * Test NewPlatformVersionNotificationInfoBuilder {@link
   * NewPlatformVersionNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#build()}
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#currentVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#currentVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#latestVersion(String)}
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#latestVersionReleaseNotesUrl(String)}
   *   <li>{@link NewPlatformVersionNotificationInfoBuilder#upgradeInstructionsUrl(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test NewPlatformVersionNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewPlatformVersionNotificationInfoBuilder.<init>()",
    "NewPlatformVersionNotificationInfo NewPlatformVersionNotificationInfoBuilder.build()",
    "NewPlatformVersionNotificationInfoBuilder NewPlatformVersionNotificationInfoBuilder.currentVersion(String)",
    "NewPlatformVersionNotificationInfoBuilder NewPlatformVersionNotificationInfoBuilder.currentVersionReleaseNotesUrl(String)",
    "NewPlatformVersionNotificationInfoBuilder NewPlatformVersionNotificationInfoBuilder.latestVersion(String)",
    "NewPlatformVersionNotificationInfoBuilder NewPlatformVersionNotificationInfoBuilder.latestVersionReleaseNotesUrl(String)",
    "String NewPlatformVersionNotificationInfoBuilder.toString()",
    "NewPlatformVersionNotificationInfoBuilder NewPlatformVersionNotificationInfoBuilder.upgradeInstructionsUrl(String)"
  })
  void testNewPlatformVersionNotificationInfoBuilderBuild() {
    // Arrange and Act
    NewPlatformVersionNotificationInfo actualNewPlatformVersionNotificationInfo =
        NewPlatformVersionNotificationInfo.builder()
            .currentVersion("1.0.2")
            .currentVersionReleaseNotesUrl("https://example.org/example")
            .latestVersion("1.0.2")
            .latestVersionReleaseNotesUrl("https://example.org/example")
            .upgradeInstructionsUrl("https://example.org/example")
            .build();

    // Assert
    Map<String, String> templateData = actualNewPlatformVersionNotificationInfo.getTemplateData();
    assertEquals(5, templateData.size());
    assertEquals("1.0.2", templateData.get("currentVersion"));
    assertEquals("1.0.2", templateData.get("latestVersion"));
    assertEquals("1.0.2", actualNewPlatformVersionNotificationInfo.getCurrentVersion());
    assertEquals("1.0.2", actualNewPlatformVersionNotificationInfo.getLatestVersion());
    assertEquals("https://example.org/example", templateData.get("currentVersionReleaseNotesUrl"));
    assertEquals("https://example.org/example", templateData.get("latestVersionReleaseNotesUrl"));
    assertEquals("https://example.org/example", templateData.get("upgradeInstructionsUrl"));
    assertEquals(
        "https://example.org/example",
        actualNewPlatformVersionNotificationInfo.getCurrentVersionReleaseNotesUrl());
    assertEquals(
        "https://example.org/example",
        actualNewPlatformVersionNotificationInfo.getLatestVersionReleaseNotesUrl());
    assertEquals(
        "https://example.org/example",
        actualNewPlatformVersionNotificationInfo.getUpgradeInstructionsUrl());
    assertNull(actualNewPlatformVersionNotificationInfo.getAffectedCustomerId());
    assertNull(actualNewPlatformVersionNotificationInfo.getDashboardId());
    assertNull(actualNewPlatformVersionNotificationInfo.getStateEntityId());
    assertNull(actualNewPlatformVersionNotificationInfo.getAffectedTenantId());
    assertNull(actualNewPlatformVersionNotificationInfo.getAffectedUserId());
  }
}
