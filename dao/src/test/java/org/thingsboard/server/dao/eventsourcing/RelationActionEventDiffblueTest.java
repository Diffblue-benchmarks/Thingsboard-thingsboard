package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class RelationActionEventDiffblueTest {
  /**
   * Test {@link RelationActionEvent#equals(Object)}, and
   * {@link RelationActionEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and
   * {@link RelationActionEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);
    RelationActionEvent relationActionEvent2 = new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and
   * {@link RelationActionEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null,
        ActionType.ADDED);
    RelationActionEvent relationActionEvent2 = new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null,
        ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and
   * {@link RelationActionEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), null);
    RelationActionEvent relationActionEvent2 = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), null);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent2);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent2.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}, and
   * {@link RelationActionEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationActionEvent#equals(Object)}
   *   <li>{@link RelationActionEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertEquals(relationActionEvent, relationActionEvent);
    int expectedHashCodeResult = relationActionEvent.hashCode();
    assertEquals(expectedHashCodeResult, relationActionEvent.hashCode());
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT, null,
        ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"),
        ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        mock(EntityRelation.class), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), null);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), ActionType.DELETED);

    // Act and Assert
    assertNotEquals(relationActionEvent,
        new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationActionEvent relationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT,
        new EntityRelation(), ActionType.ADDED);

    // Act and Assert
    assertNotEquals(relationActionEvent, new RelationActionEvent(null, new EntityRelation(), ActionType.ADDED));
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED),
        null);
  }

  /**
   * Test {@link RelationActionEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationActionEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationActionEvent(ModelConstants.SYSTEM_TENANT, new EntityRelation(), ActionType.ADDED),
        "Different type to RelationActionEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationActionEvent#RelationActionEvent(TenantId, EntityRelation, ActionType)}
   *   <li>{@link RelationActionEvent#toString()}
   *   <li>{@link RelationActionEvent#getActionType()}
   *   <li>{@link RelationActionEvent#getRelation()}
   *   <li>{@link RelationActionEvent#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EntityRelation relation = new EntityRelation();

    // Act
    RelationActionEvent actualRelationActionEvent = new RelationActionEvent(ModelConstants.SYSTEM_TENANT, relation,
        ActionType.ADDED);
    String actualToStringResult = actualRelationActionEvent.toString();
    ActionType actualActionType = actualRelationActionEvent.getActionType();
    EntityRelation actualRelation = actualRelationActionEvent.getRelation();
    TenantId actualTenantId = actualRelationActionEvent.getTenantId();

    // Assert
    assertEquals(
        "RelationActionEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, relation=EntityRelation(from=null,"
            + " to=null, type=null, typeGroup=null, version=null, additionalInfo=null), actionType=ADDED)",
        actualToStringResult);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(relation, actualRelation);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
