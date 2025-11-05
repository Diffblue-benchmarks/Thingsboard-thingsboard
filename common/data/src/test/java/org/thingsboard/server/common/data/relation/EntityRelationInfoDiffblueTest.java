package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntityRelationInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelationInfo#EntityRelationInfo()}
   *   <li>{@link EntityRelationInfo#setFromName(String)}
   *   <li>{@link EntityRelationInfo#setToName(String)}
   *   <li>{@link EntityRelationInfo#getFromName()}
   *   <li>{@link EntityRelationInfo#getToName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityRelationInfo.<init>()",
    "String EntityRelationInfo.getFromName()",
    "String EntityRelationInfo.getToName()",
    "void EntityRelationInfo.setFromName(String)",
    "void EntityRelationInfo.setToName(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityRelationInfo actualEntityRelationInfo = new EntityRelationInfo();
    actualEntityRelationInfo.setFromName("jane.doe@example.org");
    actualEntityRelationInfo.setToName("To Name");
    String actualFromName = actualEntityRelationInfo.getFromName();

    // Assert
    assertEquals("To Name", actualEntityRelationInfo.getToName());
    assertEquals("jane.doe@example.org", actualFromName);
    assertNull(actualEntityRelationInfo.getVersion());
    assertNull(actualEntityRelationInfo.getType());
    assertNull(actualEntityRelationInfo.getFrom());
    assertNull(actualEntityRelationInfo.getTo());
    assertNull(actualEntityRelationInfo.getTypeGroup());
  }

  /**
   * Test {@link EntityRelationInfo#EntityRelationInfo(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#EntityRelationInfo(EntityRelation)}
   */
  @Test
  @DisplayName(
      "Test new EntityRelationInfo(EntityRelation); when EntityRelation(); then return AdditionalInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityRelationInfo.<init>(EntityRelation)"})
  void testNewEntityRelationInfo_whenEntityRelation_thenReturnAdditionalInfoIsNull() {
    // Arrange and Act
    EntityRelationInfo actualEntityRelationInfo = new EntityRelationInfo(new EntityRelation());

    // Assert
    assertNull(actualEntityRelationInfo.getAdditionalInfo());
    assertNull(actualEntityRelationInfo.getVersion());
    assertNull(actualEntityRelationInfo.getType());
    assertNull(actualEntityRelationInfo.getFromName());
    assertNull(actualEntityRelationInfo.getToName());
    assertNull(actualEntityRelationInfo.getFrom());
    assertNull(actualEntityRelationInfo.getTo());
    assertNull(actualEntityRelationInfo.getTypeGroup());
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}, and {@link EntityRelationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelationInfo#equals(Object)}
   *   <li>{@link EntityRelationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    EntityRelationInfo entityRelationInfo2 = new EntityRelationInfo();

    // Act and Assert
    assertEquals(entityRelationInfo, entityRelationInfo2);
    assertEquals(entityRelationInfo.hashCode(), entityRelationInfo2.hashCode());
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}, and {@link EntityRelationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelationInfo#equals(Object)}
   *   <li>{@link EntityRelationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();

    // Act and Assert
    assertEquals(entityRelationInfo, entityRelationInfo);
    int expectedHashCodeResult = entityRelationInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationInfo.hashCode());
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), 1);
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    entityRelationInfo.setToName("To Name");

    // Act and Assert
    assertNotEquals(entityRelationInfo, new EntityRelationInfo());
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();
    entityRelationInfo.setFrom(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityRelationInfo, new EntityRelationInfo());
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityRelationInfo entityRelationInfo = new EntityRelationInfo();

    EntityRelationInfo entityRelationInfo2 = new EntityRelationInfo();
    entityRelationInfo2.setToName("To Name");

    // Act and Assert
    assertNotEquals(entityRelationInfo, entityRelationInfo2);
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), null);
  }

  /**
   * Test {@link EntityRelationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityRelationInfo.equals(Object)",
    "int EntityRelationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityRelationInfo(), "Different type to EntityRelationInfo");
  }
}
