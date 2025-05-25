package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class DashboardServiceImplDiffblueTest {
  /**
   * Test {@link DashboardServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DashboardServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DashboardServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, (new DashboardServiceImpl()).getEntityType());
  }
}
