package org.thingsboard.server.dao.rule;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;

public class BaseRuleChainServiceDiffblueTest {
  /**
   * Test {@link BaseRuleChainService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseRuleChainService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.RULE_CHAIN, new BaseRuleChainService().getEntityType());
  }
}
