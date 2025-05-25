package org.thingsboard.server.dao.customer;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class CustomerServiceImplDiffblueTest {
  /**
   * Test {@link CustomerServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType CustomerServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.CUSTOMER, (new CustomerServiceImpl()).getEntityType());
  }
}
