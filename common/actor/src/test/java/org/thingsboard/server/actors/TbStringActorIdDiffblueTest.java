package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TbStringActorIdDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbStringActorId#TbStringActorId(String)}
   *   <li>{@link TbStringActorId#getEntityType()}
   *   <li>{@link TbStringActorId#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbStringActorId.<init>(String)",
    "EntityType TbStringActorId.getEntityType()",
    "String TbStringActorId.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbStringActorId actualTbStringActorId = new TbStringActorId("42");
    EntityType actualEntityType = actualTbStringActorId.getEntityType();

    // Assert
    assertEquals("42", actualTbStringActorId.toString());
    assertNull(actualEntityType);
  }

  /**
   * Test {@link TbStringActorId#equals(Object)}, and {@link TbStringActorId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbStringActorId#equals(Object)}
   *   <li>{@link TbStringActorId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbStringActorId.equals(Object)", "int TbStringActorId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("42");
    TbStringActorId tbStringActorId2 = new TbStringActorId("42");

    // Act and Assert
    assertEquals(tbStringActorId, tbStringActorId2);
    assertEquals(tbStringActorId.hashCode(), tbStringActorId2.hashCode());
  }

  /**
   * Test {@link TbStringActorId#equals(Object)}, and {@link TbStringActorId#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbStringActorId#equals(Object)}
   *   <li>{@link TbStringActorId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbStringActorId.equals(Object)", "int TbStringActorId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("42");

    // Act and Assert
    assertEquals(tbStringActorId, tbStringActorId);
    int expectedHashCodeResult = tbStringActorId.hashCode();
    assertEquals(expectedHashCodeResult, tbStringActorId.hashCode());
  }

  /**
   * Test {@link TbStringActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbStringActorId.equals(Object)", "int TbStringActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbStringActorId tbStringActorId = new TbStringActorId("Id");

    // Act and Assert
    assertNotEquals(tbStringActorId, new TbStringActorId("42"));
  }

  /**
   * Test {@link TbStringActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbStringActorId.equals(Object)", "int TbStringActorId.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbStringActorId("42"), null);
  }

  /**
   * Test {@link TbStringActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbStringActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbStringActorId.equals(Object)", "int TbStringActorId.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbStringActorId("42"), "Different type to TbStringActorId");
  }
}
