package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.RuleNodeStateEntity;

public class JpaRuleNodeStateDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleNodeStateDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeStateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaRuleNodeStateDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaRuleNodeStateDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleNodeStateDao jpaRuleNodeStateDao = new JpaRuleNodeStateDao();

    // Act
    Class<RuleNodeStateEntity> actualEntityClass = jpaRuleNodeStateDao.getEntityClass();

    // Assert
    assertNull(jpaRuleNodeStateDao.getRepository());
    Class<RuleNodeStateEntity> expectedEntityClass = RuleNodeStateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
