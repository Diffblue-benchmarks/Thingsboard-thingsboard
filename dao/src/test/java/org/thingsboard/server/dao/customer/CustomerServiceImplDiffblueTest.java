package org.thingsboard.server.dao.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class CustomerServiceImplDiffblueTest {
  /**
   * Test {@link CustomerServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link CustomerServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType CustomerServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.CUSTOMER, new CustomerServiceImpl().getEntityType());
  }
}
