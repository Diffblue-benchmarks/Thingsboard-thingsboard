package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityType#getNormalName()}
   *   <li>{@link EntityType#getProtoNumber()}
   *   <li>{@link EntityType#getTableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String EntityType.getNormalName()",
    "int EntityType.getProtoNumber()",
    "String EntityType.getTableName()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityType valueOfResult = EntityType.valueOf(DataConstants.TENANT);

    // Act
    String actualNormalName = valueOfResult.getNormalName();
    int actualProtoNumber = valueOfResult.getProtoNumber();

    // Assert
    assertEquals("Tenant", actualNormalName);
    assertEquals("tenant", valueOfResult.getTableName());
    assertEquals(1, actualProtoNumber);
  }
}
