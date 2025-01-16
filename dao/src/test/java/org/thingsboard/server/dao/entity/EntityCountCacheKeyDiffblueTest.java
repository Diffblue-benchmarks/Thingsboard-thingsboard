package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityCountCacheKeyDiffblueTest {
  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and
   * {@link EntityCountCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and
   * {@link EntityCountCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and
   * {@link EntityCountCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);
    EntityCountCacheKey entityCountCacheKey2 = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and
   * {@link EntityCountCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityCountCacheKey, new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(entityCountCacheKey, new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT,
        EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(entityCountCacheKey, new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityCountCacheKey, new EntityCountCacheKey(null, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCacheKey#EntityCountCacheKey(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheKey#toString()}
   *   <li>{@link EntityCountCacheKey#getEntityType()}
   *   <li>{@link EntityCountCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheKey actualEntityCountCacheKey = new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT,
        EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheKey.toString();
    EntityType actualEntityType = actualEntityCountCacheKey.getEntityType();
    TenantId actualTenantId = actualEntityCountCacheKey.getTenantId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_TENANT", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
