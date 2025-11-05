package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDataInfoDiffblueTest {
  /**
   * Test {@link EntityDataInfo#equals(Object)}, and {@link EntityDataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, true);
    EntityDataInfo entityDataInfo2 = new EntityDataInfo(true, true, true);

    // Act and Assert
    assertEquals(entityDataInfo, entityDataInfo2);
    assertEquals(entityDataInfo.hashCode(), entityDataInfo2.hashCode());
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}, and {@link EntityDataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataInfo#equals(Object)}
   *   <li>{@link EntityDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(false, true, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, false, true);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataInfo entityDataInfo = new EntityDataInfo(true, true, false);

    // Act and Assert
    assertNotEquals(entityDataInfo, new EntityDataInfo(true, true, true));
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), null);
  }

  /**
   * Test {@link EntityDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityDataInfo.equals(Object)", "int EntityDataInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataInfo(true, true, true), "Different type to EntityDataInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataInfo.<init>()",
    "void EntityDataInfo.<init>(boolean, boolean, boolean)",
    "boolean EntityDataInfo.isHasAttributes()",
    "boolean EntityDataInfo.isHasCredentials()",
    "boolean EntityDataInfo.isHasRelations()",
    "void EntityDataInfo.setHasAttributes(boolean)",
    "void EntityDataInfo.setHasCredentials(boolean)",
    "void EntityDataInfo.setHasRelations(boolean)",
    "String EntityDataInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo();
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert
    assertEquals(
        "EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataInfo.<init>()",
    "void EntityDataInfo.<init>(boolean, boolean, boolean)",
    "boolean EntityDataInfo.isHasAttributes()",
    "boolean EntityDataInfo.isHasCredentials()",
    "boolean EntityDataInfo.isHasRelations()",
    "void EntityDataInfo.setHasAttributes(boolean)",
    "void EntityDataInfo.setHasCredentials(boolean)",
    "void EntityDataInfo.setHasRelations(boolean)",
    "String EntityDataInfo.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityDataInfo actualEntityDataInfo = new EntityDataInfo(true, true, true);
    actualEntityDataInfo.setHasAttributes(true);
    actualEntityDataInfo.setHasCredentials(true);
    actualEntityDataInfo.setHasRelations(true);
    String actualToStringResult = actualEntityDataInfo.toString();
    boolean actualIsHasAttributesResult = actualEntityDataInfo.isHasAttributes();
    boolean actualIsHasCredentialsResult = actualEntityDataInfo.isHasCredentials();

    // Assert
    assertEquals(
        "EntityDataInfo(hasRelations=true, hasAttributes=true, hasCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsHasAttributesResult);
    assertTrue(actualIsHasCredentialsResult);
    assertTrue(actualEntityDataInfo.isHasRelations());
  }
}
