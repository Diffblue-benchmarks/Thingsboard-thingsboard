package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.thingsboard.server.dao.model.sql.AssetEntity;

public class BaseVersionedEntityDiffblueTest {
  /**
   * Test {@link BaseVersionedEntity#getVersion()}.
   * <p>
   * Method under test: {@link BaseVersionedEntity#getVersion()}
   */
  @Test
  public void testGetVersion() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getVersion());
  }

  /**
   * Test {@link BaseVersionedEntity#setVersion(Long)}.
   * <p>
   * Method under test: {@link BaseVersionedEntity#setVersion(Long)}
   */
  @Test
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
