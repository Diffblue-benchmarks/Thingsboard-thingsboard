package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VersionCreateConfigDiffblueTest {
  /**
   * Test {@link VersionCreateConfig#equals(Object)}, and {@link VersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, versionCreateConfig2);
    int expectedHashCodeResult = versionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionCreateConfig2.hashCode());
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}, and {@link VersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.isSaveCredentials()).thenReturn(true);
    when(autoVersionCreateConfig.isSaveAttributes()).thenReturn(true);
    when(autoVersionCreateConfig.isSaveRelations()).thenReturn(true);
    when(autoVersionCreateConfig.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, autoVersionCreateConfig);
    int notExpectedHashCodeResult = versionCreateConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, autoVersionCreateConfig.hashCode());
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}, and {@link VersionCreateConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreateConfig#equals(Object)}
   *   <li>{@link VersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertEquals(versionCreateConfig, versionCreateConfig);
    int expectedHashCodeResult = versionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionCreateConfig.hashCode());
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(autoVersionCreateConfig, versionCreateConfig);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(false);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(false);
    versionCreateConfig.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(false);

    VersionCreateConfig versionCreateConfig2 = new VersionCreateConfig();
    versionCreateConfig2.setSaveAttributes(true);
    versionCreateConfig2.setSaveCredentials(true);
    versionCreateConfig2.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, versionCreateConfig2);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, autoVersionCreateConfig);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, null);
  }

  /**
   * Test {@link VersionCreateConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreateConfig.equals(Object)",
    "int VersionCreateConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);

    // Act and Assert
    assertNotEquals(versionCreateConfig, "Different type to VersionCreateConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionCreateConfig}
   *   <li>{@link VersionCreateConfig#setSaveAttributes(boolean)}
   *   <li>{@link VersionCreateConfig#setSaveCredentials(boolean)}
   *   <li>{@link VersionCreateConfig#setSaveRelations(boolean)}
   *   <li>{@link VersionCreateConfig#toString()}
   *   <li>{@link VersionCreateConfig#isSaveAttributes()}
   *   <li>{@link VersionCreateConfig#isSaveCredentials()}
   *   <li>{@link VersionCreateConfig#isSaveRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionCreateConfig.<init>()",
    "boolean VersionCreateConfig.isSaveAttributes()",
    "boolean VersionCreateConfig.isSaveCredentials()",
    "boolean VersionCreateConfig.isSaveRelations()",
    "void VersionCreateConfig.setSaveAttributes(boolean)",
    "void VersionCreateConfig.setSaveCredentials(boolean)",
    "void VersionCreateConfig.setSaveRelations(boolean)",
    "String VersionCreateConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VersionCreateConfig actualVersionCreateConfig = new VersionCreateConfig();
    actualVersionCreateConfig.setSaveAttributes(true);
    actualVersionCreateConfig.setSaveCredentials(true);
    actualVersionCreateConfig.setSaveRelations(true);
    String actualToStringResult = actualVersionCreateConfig.toString();
    boolean actualIsSaveAttributesResult = actualVersionCreateConfig.isSaveAttributes();
    boolean actualIsSaveCredentialsResult = actualVersionCreateConfig.isSaveCredentials();

    // Assert
    assertEquals(
        "VersionCreateConfig(saveRelations=true, saveAttributes=true, saveCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsSaveAttributesResult);
    assertTrue(actualIsSaveCredentialsResult);
    assertTrue(actualVersionCreateConfig.isSaveRelations());
  }
}
