package org.thingsboard.server.dao.util;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultDbTypeInfoComponent.class})
@ExtendWith(SpringExtension.class)
class DefaultDbTypeInfoComponentDiffblueTest {
  @Autowired
  private DefaultDbTypeInfoComponent defaultDbTypeInfoComponent;

  /**
   * Test {@link DefaultDbTypeInfoComponent#isLatestTsDaoStoredToSql()}.
   * <p>
   * Method under test:
   * {@link DefaultDbTypeInfoComponent#isLatestTsDaoStoredToSql()}
   */
  @Test
  @DisplayName("Test isLatestTsDaoStoredToSql()")
  void testIsLatestTsDaoStoredToSql() {
    // Arrange, Act and Assert
    assertTrue(defaultDbTypeInfoComponent.isLatestTsDaoStoredToSql());
  }

  /**
   * Test {@link DefaultDbTypeInfoComponent#getLatestTsDbType()}.
   * <p>
   * Method under test: {@link DefaultDbTypeInfoComponent#getLatestTsDbType()}
   */
  @Test
  @DisplayName("Test getLatestTsDbType()")
  void testGetLatestTsDbType() {
    // Arrange, Act and Assert
    assertNull((new DefaultDbTypeInfoComponent()).getLatestTsDbType());
  }
}
