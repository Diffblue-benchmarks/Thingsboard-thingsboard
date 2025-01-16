package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityDataInfoDiffblueTest {
  /**
   * Test {@link EntityDataInfo#equals(Object)}, and
   * {@link EntityDataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, true);
    EntityDataInfo entityDataInfo2 = new EntityDataInfo(true, true, true);

    // Act and Assert
    assertEquals(entityDataInfo, entityDataInfo2);
    int expectedHashCodeResult = entityDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityDataInfo2.hashCode());
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}, and
   * {@link EntityDataInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, true);

    // Act and Assert
    assertEquals(entityDataInfo, entityDataInfo);
    int expectedHashCodeResult = entityDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityDataInfo.hashCode());
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(false, true, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, false, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, false);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), null);
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), "Different type to EntityDataInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#EntityDataInfo()}
   *   <li>{@link EntityDataInfo#setHasAttributes(boolean)}
   *   <li>{@link EntityDataInfo#setHasCredentials(boolean)}
   *   <li>{@link EntityDataInfo#setHasRelations(boolean)}
   *   <li>{@link EntityDataInfo#toString()}
   *   <li>{@link EntityDataInfo#isHasAttributes()}
   *   <li>{@link EntityDataInfo#isHasCredentials()}
   *   <li>{@link EntityDataInfo#isHasRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo();
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert that nothing has changed
    assertEquals("EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)", actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataInfo#EntityDataInfo(boolean, boolean, boolean)}
   *   <li>{@link EntityDataInfo#setHasAttributes(boolean)}
   *   <li>{@link EntityDataInfo#setHasCredentials(boolean)}
   *   <li>{@link EntityDataInfo#setHasRelations(boolean)}
   *   <li>{@link EntityDataInfo#toString()}
   *   <li>{@link EntityDataInfo#isHasAttributes()}
   *   <li>{@link EntityDataInfo#isHasCredentials()}
   *   <li>{@link EntityDataInfo#isHasRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo(true, true, true);
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert that nothing has changed
    assertEquals("EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)", actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
  }
}
