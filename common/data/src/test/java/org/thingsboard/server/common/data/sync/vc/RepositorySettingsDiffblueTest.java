package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RepositorySettingsDiffblueTest {
  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    RepositorySettings repositorySettings2 = new RepositorySettings();

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setRepositoryUri("Repository Uri");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setUsername("janedoe");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setUsername("janedoe");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPassword("iloveyou");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKey("Private Key");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKey("Private Key");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setDefaultBranch("janedoe/featurebranch");

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings2);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings2.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}, and {@link RepositorySettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#equals(Object)}
   *   <li>{@link RepositorySettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    // Act and Assert
    assertEquals(repositorySettings, repositorySettings);
    int expectedHashCodeResult = repositorySettings.hashCode();
    assertEquals(expectedHashCodeResult, repositorySettings.hashCode());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), 1);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setReadOnly(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setShowMergeCommits(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setLocalOnly(true);

    // Act and Assert
    assertNotEquals(repositorySettings, new RepositorySettings());
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setRepositoryUri("Repository Uri");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyFileName("foo.txt");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKey("Private Key");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setPrivateKeyPassword("iloveyou");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();

    RepositorySettings repositorySettings2 = new RepositorySettings();
    repositorySettings2.setDefaultBranch("janedoe/featurebranch");

    // Act and Assert
    assertNotEquals(repositorySettings, repositorySettings2);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), null);
  }

  /**
   * Test {@link RepositorySettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettings.equals(Object)",
    "int RepositorySettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RepositorySettings(), "Different type to RepositorySettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettings#RepositorySettings()}
   *   <li>{@link RepositorySettings#setAuthMethod(RepositoryAuthMethod)}
   *   <li>{@link RepositorySettings#setDefaultBranch(String)}
   *   <li>{@link RepositorySettings#setLocalOnly(boolean)}
   *   <li>{@link RepositorySettings#setPassword(String)}
   *   <li>{@link RepositorySettings#setPrivateKey(String)}
   *   <li>{@link RepositorySettings#setPrivateKeyFileName(String)}
   *   <li>{@link RepositorySettings#setPrivateKeyPassword(String)}
   *   <li>{@link RepositorySettings#setReadOnly(boolean)}
   *   <li>{@link RepositorySettings#setRepositoryUri(String)}
   *   <li>{@link RepositorySettings#setShowMergeCommits(boolean)}
   *   <li>{@link RepositorySettings#setUsername(String)}
   *   <li>{@link RepositorySettings#toString()}
   *   <li>{@link RepositorySettings#getAuthMethod()}
   *   <li>{@link RepositorySettings#getDefaultBranch()}
   *   <li>{@link RepositorySettings#getPassword()}
   *   <li>{@link RepositorySettings#getPrivateKey()}
   *   <li>{@link RepositorySettings#getPrivateKeyFileName()}
   *   <li>{@link RepositorySettings#getPrivateKeyPassword()}
   *   <li>{@link RepositorySettings#getRepositoryUri()}
   *   <li>{@link RepositorySettings#getUsername()}
   *   <li>{@link RepositorySettings#isLocalOnly()}
   *   <li>{@link RepositorySettings#isReadOnly()}
   *   <li>{@link RepositorySettings#isShowMergeCommits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RepositorySettings.<init>()",
    "RepositoryAuthMethod RepositorySettings.getAuthMethod()",
    "String RepositorySettings.getDefaultBranch()",
    "String RepositorySettings.getPassword()",
    "String RepositorySettings.getPrivateKey()",
    "String RepositorySettings.getPrivateKeyFileName()",
    "String RepositorySettings.getPrivateKeyPassword()",
    "String RepositorySettings.getRepositoryUri()",
    "String RepositorySettings.getUsername()",
    "boolean RepositorySettings.isLocalOnly()",
    "boolean RepositorySettings.isReadOnly()",
    "boolean RepositorySettings.isShowMergeCommits()",
    "void RepositorySettings.setAuthMethod(RepositoryAuthMethod)",
    "void RepositorySettings.setDefaultBranch(String)",
    "void RepositorySettings.setLocalOnly(boolean)",
    "void RepositorySettings.setPassword(String)",
    "void RepositorySettings.setPrivateKey(String)",
    "void RepositorySettings.setPrivateKeyFileName(String)",
    "void RepositorySettings.setPrivateKeyPassword(String)",
    "void RepositorySettings.setReadOnly(boolean)",
    "void RepositorySettings.setRepositoryUri(String)",
    "void RepositorySettings.setShowMergeCommits(boolean)",
    "void RepositorySettings.setUsername(String)",
    "String RepositorySettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RepositorySettings actualRepositorySettings = new RepositorySettings();
    actualRepositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    actualRepositorySettings.setDefaultBranch("janedoe/featurebranch");
    actualRepositorySettings.setLocalOnly(true);
    actualRepositorySettings.setPassword("iloveyou");
    actualRepositorySettings.setPrivateKey("Private Key");
    actualRepositorySettings.setPrivateKeyFileName("foo.txt");
    actualRepositorySettings.setPrivateKeyPassword("iloveyou");
    actualRepositorySettings.setReadOnly(true);
    actualRepositorySettings.setRepositoryUri("Repository Uri");
    actualRepositorySettings.setShowMergeCommits(true);
    actualRepositorySettings.setUsername("janedoe");
    String actualToStringResult = actualRepositorySettings.toString();
    RepositoryAuthMethod actualAuthMethod = actualRepositorySettings.getAuthMethod();
    String actualDefaultBranch = actualRepositorySettings.getDefaultBranch();
    String actualPassword = actualRepositorySettings.getPassword();
    String actualPrivateKey = actualRepositorySettings.getPrivateKey();
    String actualPrivateKeyFileName = actualRepositorySettings.getPrivateKeyFileName();
    String actualPrivateKeyPassword = actualRepositorySettings.getPrivateKeyPassword();
    String actualRepositoryUri = actualRepositorySettings.getRepositoryUri();
    String actualUsername = actualRepositorySettings.getUsername();
    boolean actualIsLocalOnlyResult = actualRepositorySettings.isLocalOnly();
    boolean actualIsReadOnlyResult = actualRepositorySettings.isReadOnly();

    // Assert
    assertEquals("Private Key", actualPrivateKey);
    assertEquals("Repository Uri", actualRepositoryUri);
    assertEquals(
        "RepositorySettings(repositoryUri=Repository Uri, authMethod=USERNAME_PASSWORD, username=janedoe,"
            + " password=iloveyou, privateKeyFileName=foo.txt, privateKey=Private Key, privateKeyPassword=iloveyou,"
            + " defaultBranch=janedoe/featurebranch, readOnly=true, showMergeCommits=true, localOnly=true)",
        actualToStringResult);
    assertEquals("foo.txt", actualPrivateKeyFileName);
    assertEquals("iloveyou", actualPassword);
    assertEquals("iloveyou", actualPrivateKeyPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals("janedoe/featurebranch", actualDefaultBranch);
    assertEquals(RepositoryAuthMethod.USERNAME_PASSWORD, actualAuthMethod);
    assertTrue(actualIsLocalOnlyResult);
    assertTrue(actualIsReadOnlyResult);
    assertTrue(actualRepositorySettings.isShowMergeCommits());
  }

  /**
   * Test {@link RepositorySettings#RepositorySettings(RepositorySettings)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RepositorySettings#RepositorySettings()} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#RepositorySettings(RepositorySettings)}
   */
  @Test
  @DisplayName(
      "Test new RepositorySettings(RepositorySettings); given 'true'; when RepositorySettings() ReadOnly is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RepositorySettings.<init>(RepositorySettings)"})
  void testNewRepositorySettings_givenTrue_whenRepositorySettingsReadOnlyIsTrue() {
    // Arrange
    RepositorySettings settings = new RepositorySettings();
    settings.setReadOnly(true);

    // Act and Assert
    assertEquals(settings, new RepositorySettings(settings));
  }

  /**
   * Test {@link RepositorySettings#RepositorySettings(RepositorySettings)}.
   *
   * <ul>
   *   <li>When {@link RepositorySettings#RepositorySettings()}.
   *   <li>Then return {@link RepositorySettings#RepositorySettings()}.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettings#RepositorySettings(RepositorySettings)}
   */
  @Test
  @DisplayName(
      "Test new RepositorySettings(RepositorySettings); when RepositorySettings(); then return RepositorySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RepositorySettings.<init>(RepositorySettings)"})
  void testNewRepositorySettings_whenRepositorySettings_thenReturnRepositorySettings() {
    // Arrange
    RepositorySettings settings = new RepositorySettings();

    // Act and Assert
    assertEquals(settings, new RepositorySettings(settings));
  }
}
