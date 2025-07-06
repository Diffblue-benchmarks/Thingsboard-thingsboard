package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.sync.vc.RepositorySettingsInfo.RepositorySettingsInfoBuilder;

@ContextConfiguration(classes = {RepositorySettingsInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class RepositorySettingsInfoDiffblueTest {
  @Autowired private RepositorySettingsInfoBuilder repositorySettingsInfoBuilder;

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and {@link
   * RepositorySettingsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and {@link
   * RepositorySettingsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any()))
        .thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean()))
        .thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult =
        repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 =
        RepositorySettingsInfo.builder().configured(false).readOnly(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and {@link
   * RepositorySettingsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean()))
        .thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult =
        repositorySettingsInfoBuilder.configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean()))
        .thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult =
        repositorySettingsInfoBuilder.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 =
        RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any()))
        .thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 =
        mock(RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean()))
        .thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult =
        repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 =
        RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepositorySettingsInfo.equals(Object)",
    "int RepositorySettingsInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RepositorySettingsInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfo#RepositorySettingsInfo()}
   *   <li>{@link RepositorySettingsInfo#setConfigured(boolean)}
   *   <li>{@link RepositorySettingsInfo#setReadOnly(Boolean)}
   *   <li>{@link RepositorySettingsInfo#toString()}
   *   <li>{@link RepositorySettingsInfo#getReadOnly()}
   *   <li>{@link RepositorySettingsInfo#isConfigured()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RepositorySettingsInfo.<init>()",
    "void RepositorySettingsInfo.<init>(boolean, Boolean)",
    "Boolean RepositorySettingsInfo.getReadOnly()",
    "boolean RepositorySettingsInfo.isConfigured()",
    "void RepositorySettingsInfo.setConfigured(boolean)",
    "void RepositorySettingsInfo.setReadOnly(Boolean)",
    "String RepositorySettingsInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo();
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfo#RepositorySettingsInfo(boolean, Boolean)}
   *   <li>{@link RepositorySettingsInfo#setConfigured(boolean)}
   *   <li>{@link RepositorySettingsInfo#setReadOnly(Boolean)}
   *   <li>{@link RepositorySettingsInfo#toString()}
   *   <li>{@link RepositorySettingsInfo#getReadOnly()}
   *   <li>{@link RepositorySettingsInfo#isConfigured()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RepositorySettingsInfo.<init>()",
    "void RepositorySettingsInfo.<init>(boolean, Boolean)",
    "Boolean RepositorySettingsInfo.getReadOnly()",
    "boolean RepositorySettingsInfo.isConfigured()",
    "void RepositorySettingsInfo.setConfigured(boolean)",
    "void RepositorySettingsInfo.setReadOnly(Boolean)",
    "String RepositorySettingsInfo.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo(true, true);
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Test RepositorySettingsInfoBuilder {@link RepositorySettingsInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepositorySettingsInfoBuilder#build()}
   *   <li>{@link RepositorySettingsInfoBuilder#configured(boolean)}
   *   <li>{@link RepositorySettingsInfoBuilder#readOnly(Boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test RepositorySettingsInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RepositorySettingsInfoBuilder.<init>()",
    "RepositorySettingsInfo RepositorySettingsInfoBuilder.build()",
    "RepositorySettingsInfoBuilder RepositorySettingsInfoBuilder.configured(boolean)",
    "RepositorySettingsInfoBuilder RepositorySettingsInfoBuilder.readOnly(Boolean)",
    "String RepositorySettingsInfoBuilder.toString()"
  })
  void testRepositorySettingsInfoBuilderBuild() {
    // Arrange and Act
    RepositorySettingsInfo actualBuildResult =
        RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Assert
    assertTrue(actualBuildResult.getReadOnly());
    assertTrue(actualBuildResult.isConfigured());
  }
}
