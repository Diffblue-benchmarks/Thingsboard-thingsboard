package org.thingsboard.server.dao.eventsourcing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class RelationActionEventDiffblueTest {
  /**
   * Test {@link RelationActionEvent#equals(Object)}, and {@link RelationActionEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    assertEquals(relationActionEvent.hashCode(), relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and {@link RelationActionEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    assertEquals(relationActionEvent.hashCode(), relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and {@link RelationActionEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null, ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null, ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    assertEquals(relationActionEvent.hashCode(), relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and {@link RelationActionEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), null);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), null);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    assertEquals(relationActionEvent.hashCode(), relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and {@link RelationActionEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(tenantId, new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null, ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, relation, ActionType.ADDED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), null);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.DELETED);
    RelationActionEvent relationActionEvent2 =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, relationActionEvent2);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, null);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationActionEvent.equals(Object)",
    "int RelationActionEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationActionEvent relationActionEvent =
        new RelationActionEvent(
            ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, "Different type to RelationActionEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationActionEvent#RelationActionEvent(TenantId, EntityRelation, ActionType)}
   *   <li>{@link RelationActionEvent#toString()}
   *   <li>{@link RelationActionEvent#getActionType()}
   *   <li>{@link RelationActionEvent#getRelation()}
   *   <li>{@link RelationActionEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationActionEvent.<init>(TenantId, EntityRelation, ActionType)",
    "ActionType RelationActionEvent.getActionType()",
    "EntityRelation RelationActionEvent.getRelation()",
    "TenantId RelationActionEvent.getTenantId()",
    "String RelationActionEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityRelation relation = new EntityRelation();

    // Act
    RelationActionEvent actualRelationActionEvent =
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, relation, ActionType.ADDED);
    String actualToStringResult = actualRelationActionEvent.toString();
    ActionType actualActionType = actualRelationActionEvent.getActionType();
    EntityRelation actualRelation = actualRelationActionEvent.getRelation();

    // Assert
    assertEquals(
        "RelationActionEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, relation=EntityRelation(from=null,"
            + " to=null, type=null, typeGroup=null, version=null, additionalInfo=null), actionType=ADDED)",
        actualToStringResult);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(relation, actualRelation);
    assertSame(TenantId.SYS_TENANT_ID, actualRelationActionEvent.getTenantId());
  }
}
