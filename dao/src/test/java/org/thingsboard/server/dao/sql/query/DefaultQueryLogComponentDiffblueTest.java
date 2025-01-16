package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultQueryLogComponent.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
public class DefaultQueryLogComponentDiffblueTest {
  @Autowired
  private DefaultQueryLogComponent defaultQueryLogComponent;

  /**
   * Test
   * {@link DefaultQueryLogComponent#substituteParametersInSqlString(String, SqlParameterSource)}.
   * <p>
   * Method under test:
   * {@link DefaultQueryLogComponent#substituteParametersInSqlString(String, SqlParameterSource)}
   */
  @Test
  public void testSubstituteParametersInSqlString() {
    // Arrange, Act and Assert
    assertEquals("Sql",
        defaultQueryLogComponent.substituteParametersInSqlString("Sql", mock(SqlParameterSource.class)));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <p>
   * Method under test:
   * {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  public void testGetValueForSQLQuery() {
    // Arrange, Act and Assert
    assertEquals("''''''", defaultQueryLogComponent.getValueForSQLQuery("''"));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>Then return {@code ''''}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
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
   * Method under test:
   * {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  public void testGetValueForSQLQuery_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", defaultQueryLogComponent.getValueForSQLQuery(42));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code '13814000-1dd2-11b2-8080-808080808080'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  public void testGetValueForSQLQuery_whenNull_uuid_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals("'13814000-1dd2-11b2-8080-808080808080'",
        defaultQueryLogComponent.getValueForSQLQuery(ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   * <ul>
   *   <li>When {@code Value Parameter}.</li>
   *   <li>Then return {@code 'Value Parameter'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  public void testGetValueForSQLQuery_whenValueParameter_thenReturnValueParameter() {
    // Arrange, Act and Assert
    assertEquals("'Value Parameter'", defaultQueryLogComponent.getValueForSQLQuery("Value Parameter"));
  }
}
