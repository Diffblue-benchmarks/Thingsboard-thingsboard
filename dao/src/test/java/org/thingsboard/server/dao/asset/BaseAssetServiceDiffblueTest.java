package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class BaseAssetServiceDiffblueTest {
  /**
   * Test {@link BaseAssetService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseAssetService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseAssetService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, new BaseAssetService().getEntityType());
  }
}
