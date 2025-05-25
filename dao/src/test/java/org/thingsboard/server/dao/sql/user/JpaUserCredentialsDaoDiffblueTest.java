package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.sql.UserCredentialsEntity;

public class JpaUserCredentialsDaoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaUserCredentialsDao#getEntityClass()}
   *   <li>{@link JpaUserCredentialsDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaUserCredentialsDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaUserCredentialsDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaUserCredentialsDao jpaUserCredentialsDao = new JpaUserCredentialsDao();

    // Act
    Class<UserCredentialsEntity> actualEntityClass = jpaUserCredentialsDao.getEntityClass();

    // Assert
    assertNull(jpaUserCredentialsDao.getRepository());
    Class<UserCredentialsEntity> expectedEntityClass = UserCredentialsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
