package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityViewEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewEntity#EntityViewEntity()}
   *   <li>{@link EntityViewEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityViewEntity.<init>()", "java.lang.String EntityViewEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity();

    // Assert
    assertEquals("EntityViewEntity()", actualEntityViewEntity.toString());
    assertNull(actualEntityViewEntity.getAdditionalInfo());
    assertNull(actualEntityViewEntity.getVersion());
    assertNull(actualEntityViewEntity.getKeys());
    assertNull(actualEntityViewEntity.getName());
    assertNull(actualEntityViewEntity.getType());
    assertNull(actualEntityViewEntity.getId());
    assertNull(actualEntityViewEntity.getUuid());
    assertNull(actualEntityViewEntity.getCustomerId());
    assertNull(actualEntityViewEntity.getEntityId());
    assertNull(actualEntityViewEntity.getExternalId());
    assertNull(actualEntityViewEntity.getTenantId());
    assertNull(actualEntityViewEntity.getEntityType());
    assertEquals(0L, actualEntityViewEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewEntity.getEndTs());
    assertEquals(0L, actualEntityViewEntity.getStartTs());
  }
}
