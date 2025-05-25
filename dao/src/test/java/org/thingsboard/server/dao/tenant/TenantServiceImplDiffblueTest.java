package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class TenantServiceImplDiffblueTest {
  /**
   * Test {@link TenantServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link TenantServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType TenantServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT, (new TenantServiceImpl()).getEntityType());
  }
}
