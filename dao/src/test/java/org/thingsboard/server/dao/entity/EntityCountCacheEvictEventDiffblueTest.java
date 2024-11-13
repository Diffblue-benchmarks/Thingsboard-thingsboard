package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityCountCacheEvictEventDiffblueTest {
  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and
   * {@link EntityCountCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 = new EntityCountCacheEvictEvent(
        ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and
   * {@link EntityCountCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(null, EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 = new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and
   * {@link EntityCountCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        null);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 = new EntityCountCacheEvictEvent(
        ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and
   * {@link EntityCountCacheEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        null);

    // Act and Assert
    assertNotEquals(entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent = new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT,
        EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityCountCacheEvictEvent, new EntityCountCacheEvictEvent(null, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityCountCacheEvictEvent#EntityCountCacheEvictEvent(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheEvictEvent#toString()}
   *   <li>{@link EntityCountCacheEvictEvent#getEntityType()}
   *   <li>{@link EntityCountCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheEvictEvent actualEntityCountCacheEvictEvent = new EntityCountCacheEvictEvent(
        ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheEvictEvent.toString();
    EntityType actualEntityType = actualEntityCountCacheEvictEvent.getEntityType();
    TenantId actualTenantId = actualEntityCountCacheEvictEvent.getTenantId();

    // Assert
    assertEquals("EntityCountCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT)",
        actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
