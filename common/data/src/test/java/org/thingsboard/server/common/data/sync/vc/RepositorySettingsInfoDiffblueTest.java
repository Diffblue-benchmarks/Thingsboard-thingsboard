package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.sync.vc.RepositorySettingsInfo.RepositorySettingsInfoBuilder;

class RepositorySettingsInfoDiffblueTest {
  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and
   * {@link RepositorySettingsInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and
   * {@link RepositorySettingsInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean())).thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}, and
   * {@link RepositorySettingsInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo#equals(Object)}
   *   <li>{@link RepositorySettingsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder.configured(true).readOnly(true).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.configured(anyBoolean())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder.readOnly(Mockito.<Boolean>any())).thenReturn(RepositorySettingsInfo.builder());
    RepositorySettingsInfo.RepositorySettingsInfoBuilder repositorySettingsInfoBuilder2 = mock(
        RepositorySettingsInfo.RepositorySettingsInfoBuilder.class);
    when(repositorySettingsInfoBuilder2.configured(anyBoolean())).thenReturn(repositorySettingsInfoBuilder);
    RepositorySettingsInfo buildResult = repositorySettingsInfoBuilder2.configured(true).readOnly(false).build();
    RepositorySettingsInfo buildResult2 = RepositorySettingsInfo.builder().configured(false).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RepositorySettingsInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepositorySettingsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RepositorySettingsInfo buildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RepositorySettingsInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo();
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert that nothing has changed
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
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
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    RepositorySettingsInfo actualRepositorySettingsInfo = new RepositorySettingsInfo(true, true);
    actualRepositorySettingsInfo.setConfigured(true);
    actualRepositorySettingsInfo.setReadOnly(true);
    String actualToStringResult = actualRepositorySettingsInfo.toString();
    Boolean actualReadOnly = actualRepositorySettingsInfo.getReadOnly();

    // Assert that nothing has changed
    assertEquals("RepositorySettingsInfo(configured=true, readOnly=true)", actualToStringResult);
    assertTrue(actualReadOnly);
    assertTrue(actualRepositorySettingsInfo.isConfigured());
  }

  /**
   * Test RepositorySettingsInfoBuilder
   * {@link RepositorySettingsInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#build()}
   *   <li>
   * {@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#configured(boolean)}
   *   <li>
   * {@link RepositorySettingsInfo.RepositorySettingsInfoBuilder#readOnly(Boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test RepositorySettingsInfoBuilder build()")
  void testRepositorySettingsInfoBuilderBuild() {
    // Arrange and Act
    RepositorySettingsInfo actualBuildResult = RepositorySettingsInfo.builder().configured(true).readOnly(true).build();

    // Assert
    assertTrue(actualBuildResult.getReadOnly());
    assertTrue(actualBuildResult.isConfigured());
  }
}
