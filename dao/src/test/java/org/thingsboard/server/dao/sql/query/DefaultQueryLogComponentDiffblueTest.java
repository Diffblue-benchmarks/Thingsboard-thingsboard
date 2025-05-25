package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultQueryLogComponent.class})
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultQueryLogComponentDiffblueTest {
  @Autowired
  private DefaultQueryLogComponent defaultQueryLogComponent;

  /**
   * Test {@link DefaultQueryLogComponent#substituteParametersInSqlString(String, SqlParameterSource)}.
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#substituteParametersInSqlString(String, SqlParameterSource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.substituteParametersInSqlString(String, SqlParameterSource)"})
  public void testSubstituteParametersInSqlString() {
    // Arrange, Act and Assert
    assertEquals("Sql",
        defaultQueryLogComponent.substituteParametersInSqlString("Sql", mock(SqlParameterSource.class)));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery() {
    // Arrange, Act and Assert
    assertEquals("''''''", defaultQueryLogComponent.getValueForSQLQuery("''"));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>Then return {@code '784f394c-42b6-435a-983c-b7beff2784f9'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals("'784f394c-42b6-435a-983c-b7beff2784f9'",
        defaultQueryLogComponent.getValueForSQLQuery(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>Then return {@code ''''}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_thenReturnApostropheApostropheApostropheApostrophe() {
    // Arrange, Act and Assert
    assertEquals("''''", defaultQueryLogComponent.getValueForSQLQuery("'"));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", defaultQueryLogComponent.getValueForSQLQuery(42));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>When {@code Value Parameter}.</li>
   *   <li>Then return {@code 'Value Parameter'}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_whenValueParameter_thenReturnValueParameter() {
    // Arrange, Act and Assert
    assertEquals("'Value Parameter'", defaultQueryLogComponent.getValueForSQLQuery("Value Parameter"));
  }
}
