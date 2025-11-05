package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AutoVersionCreateConfigDiffblueTest {
  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}, and {@link
   * AutoVersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AutoVersionCreateConfig#equals(Object)}
   *   <li>{@link AutoVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
    assertEquals(autoVersionCreateConfig.hashCode(), autoVersionCreateConfig2.hashCode());
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}, and {@link
   * AutoVersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AutoVersionCreateConfig#equals(Object)}
   *   <li>{@link AutoVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch(null);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch(null);
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
    assertEquals(autoVersionCreateConfig.hashCode(), autoVersionCreateConfig2.hashCode());
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}, and {@link
   * AutoVersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AutoVersionCreateConfig#equals(Object)}
   *   <li>{@link AutoVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(autoVersionCreateConfig, autoVersionCreateConfig);
    int expectedHashCodeResult = autoVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, autoVersionCreateConfig.hashCode());
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("Branch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch(null);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(false);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(true);
    autoVersionCreateConfig2.setSaveCredentials(true);
    autoVersionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, autoVersionCreateConfig2);
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, null);
  }

  /**
   * Test {@link AutoVersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AutoVersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AutoVersionCreateConfig.equals(Object)",
    "int AutoVersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, "Different type to AutoVersionCreateConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AutoVersionCreateConfig}
   *   <li>{@link AutoVersionCreateConfig#setBranch(String)}
   *   <li>{@link AutoVersionCreateConfig#toString()}
   *   <li>{@link AutoVersionCreateConfig#getBranch()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AutoVersionCreateConfig.<init>()",
    "String AutoVersionCreateConfig.getBranch()",
    "void AutoVersionCreateConfig.setBranch(String)",
    "String AutoVersionCreateConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AutoVersionCreateConfig actualAutoVersionCreateConfig = new AutoVersionCreateConfig();
    actualAutoVersionCreateConfig.setBranch("janedoe/featurebranch");
    String actualToStringResult = actualAutoVersionCreateConfig.toString();

    // Assert
    assertEquals("AutoVersionCreateConfig(branch=janedoe/featurebranch)", actualToStringResult);
    assertEquals("janedoe/featurebranch", actualAutoVersionCreateConfig.getBranch());
    assertFalse(actualAutoVersionCreateConfig.isSaveAttributes());
    assertFalse(actualAutoVersionCreateConfig.isSaveCredentials());
    assertFalse(actualAutoVersionCreateConfig.isSaveRelations());
  }
}
