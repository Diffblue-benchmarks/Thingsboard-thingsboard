package org.thingsboard.server.dao.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.model.sql.AssetEntity;

class BaseVersionedEntityDiffblueTest {
  /**
   * Test {@link BaseVersionedEntity#getVersion()}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long BaseVersionedEntity.getVersion()"})
  void testGetVersion() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getVersion());
  }

  /**
   * Test {@link BaseVersionedEntity#setVersion(Long)}.
   *
   * <p>Method under test: {@link BaseVersionedEntity#setVersion(Long)}
   */
  @Test
  @DisplayName("Test setVersion(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseVersionedEntity.setVersion(Long)"})
  void testSetVersion() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setVersion(1L);

    // Assert
    assertEquals(1L, assetEntity.toData().getVersion().longValue());
    assertEquals(1L, assetEntity.getVersion().longValue());
  }
}
