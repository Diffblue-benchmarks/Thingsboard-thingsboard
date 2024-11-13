package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewEvictEventDiffblueTest {
  /**
   * Test {@link EntityViewEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEvictEvent entityViewEvictEvent = new EntityViewEvictEvent(ModelConstants.SYSTEM_TENANT,
        mock(EntityViewId.class), BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "New Name",
        "Old Name");

    // Act and Assert
    assertNotEquals(entityViewEvictEvent, new EntityViewEvictEvent(ModelConstants.SYSTEM_TENANT, null,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "New Name", "Old Name"));
  }

  /**
   * Test {@link EntityViewEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEvictEvent(ModelConstants.SYSTEM_TENANT, mock(EntityViewId.class),
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "New Name", "Old Name"), "42");
  }

  /**
   * Test {@link EntityViewEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewEvictEvent entityViewEvictEvent = new EntityViewEvictEvent(null, mock(EntityViewId.class),
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(entityViewEvictEvent, new EntityViewEvictEvent(ModelConstants.SYSTEM_TENANT, null,
        BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "New Name", "Old Name"));
  }
}
