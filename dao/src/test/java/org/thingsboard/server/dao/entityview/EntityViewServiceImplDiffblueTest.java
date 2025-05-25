package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class EntityViewServiceImplDiffblueTest {
  /**
   * Test {@link EntityViewServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link EntityViewServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType EntityViewServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ENTITY_VIEW, (new EntityViewServiceImpl()).getEntityType());
  }
}
