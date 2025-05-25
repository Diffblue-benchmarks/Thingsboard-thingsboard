package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class TenantProfileServiceImplDiffblueTest {
  /**
   * Test {@link TenantProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link TenantProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType TenantProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT_PROFILE, (new TenantProfileServiceImpl()).getEntityType());
  }
}
