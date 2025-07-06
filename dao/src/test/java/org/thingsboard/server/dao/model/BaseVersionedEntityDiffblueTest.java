package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.AssetEntity;

public class BaseVersionedEntityDiffblueTest {
  /**
   * Test {@link BaseVersionedEntity#getVersion()}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#getVersion()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long BaseVersionedEntity.getVersion()"})
  public void testGetVersion() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getVersion());
  }

  /**
   * Test {@link BaseVersionedEntity#setVersion(Long)}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#setVersion(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseVersionedEntity.setVersion(Long)"})
  public void testSetVersion() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setVersion(1L);

    // Assert
    assertEquals(1L, assetEntity.toData().getVersion().longValue());
    assertEquals(1L, assetEntity.getVersion().longValue());
  }
}
