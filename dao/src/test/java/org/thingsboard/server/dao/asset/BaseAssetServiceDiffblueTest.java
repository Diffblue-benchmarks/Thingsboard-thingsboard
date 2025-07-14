package org.thingsboard.server.dao.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class BaseAssetServiceDiffblueTest {
  /**
   * Test {@link BaseAssetService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseAssetService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType BaseAssetService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, new BaseAssetService().getEntityType());
  }
}
