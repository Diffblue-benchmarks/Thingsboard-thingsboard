package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VersionLoadConfigDiffblueTest {
  /**
   * Test {@link VersionLoadConfig#equals(Object)}, and
   * {@link VersionLoadConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig2);
    int expectedHashCodeResult = versionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionLoadConfig2.hashCode());
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}, and
   * {@link VersionLoadConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = mock(EntityTypeVersionLoadConfig.class);
    when(entityTypeVersionLoadConfig.isLoadCredentials()).thenReturn(true);
    when(entityTypeVersionLoadConfig.isLoadAttributes()).thenReturn(true);
    when(entityTypeVersionLoadConfig.isLoadRelations()).thenReturn(true);
    when(entityTypeVersionLoadConfig.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(entityTypeVersionLoadConfig).setLoadAttributes(anyBoolean());
    doNothing().when(entityTypeVersionLoadConfig).setLoadCredentials(anyBoolean());
    doNothing().when(entityTypeVersionLoadConfig).setLoadRelations(anyBoolean());
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, entityTypeVersionLoadConfig);
    int notExpectedHashCodeResult = versionLoadConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityTypeVersionLoadConfig.hashCode());
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}, and
   * {@link VersionLoadConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig);
    int expectedHashCodeResult = versionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionLoadConfig.hashCode());
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, versionLoadConfig);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(false);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(false);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(false);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, entityTypeVersionLoadConfig);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, null);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, "Different type to VersionLoadConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionLoadConfig}
   *   <li>{@link VersionLoadConfig#setLoadAttributes(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadCredentials(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadRelations(boolean)}
   *   <li>{@link VersionLoadConfig#toString()}
   *   <li>{@link VersionLoadConfig#isLoadAttributes()}
   *   <li>{@link VersionLoadConfig#isLoadCredentials()}
   *   <li>{@link VersionLoadConfig#isLoadRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    VersionLoadConfig actualVersionLoadConfig = new VersionLoadConfig();
    actualVersionLoadConfig.setLoadAttributes(true);
    actualVersionLoadConfig.setLoadCredentials(true);
    actualVersionLoadConfig.setLoadRelations(true);
    String actualToStringResult = actualVersionLoadConfig.toString();
    boolean actualIsLoadAttributesResult = actualVersionLoadConfig.isLoadAttributes();
    boolean actualIsLoadCredentialsResult = actualVersionLoadConfig.isLoadCredentials();

    // Assert that nothing has changed
    assertEquals("VersionLoadConfig(loadRelations=true, loadAttributes=true, loadCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsLoadAttributesResult);
    assertTrue(actualIsLoadCredentialsResult);
    assertTrue(actualVersionLoadConfig.isLoadRelations());
  }
}
