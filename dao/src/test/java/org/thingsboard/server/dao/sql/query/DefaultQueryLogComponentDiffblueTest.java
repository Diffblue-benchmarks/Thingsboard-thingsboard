/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultQueryLogComponent.class})
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultQueryLogComponentDiffblueTest {
  @Autowired private DefaultQueryLogComponent defaultQueryLogComponent;

  /**
   * Test {@link DefaultQueryLogComponent#substituteParametersInSqlString(String,
   * SqlParameterSource)}.
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#substituteParametersInSqlString(String,
   * SqlParameterSource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultQueryLogComponent.substituteParametersInSqlString(String, SqlParameterSource)"
  })
  public void testSubstituteParametersInSqlString() {
    // Arrange, Act and Assert
    assertEquals(
        "Sql",
        defaultQueryLogComponent.substituteParametersInSqlString(
            "Sql", mock(SqlParameterSource.class)));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery() {
    // Arrange, Act and Assert
    assertEquals("''''''", defaultQueryLogComponent.getValueForSQLQuery("''"));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   *
   * <ul>
   *   <li>Then return {@code ''''}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_thenReturnApostropheApostropheApostropheApostrophe() {
    // Arrange, Act and Assert
    assertEquals("''''", defaultQueryLogComponent.getValueForSQLQuery("'"));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", defaultQueryLogComponent.getValueForSQLQuery(42));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code '13814000-1dd2-11b2-8080-808080808080'}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_whenNull_uuid_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "'13814000-1dd2-11b2-8080-808080808080'",
        defaultQueryLogComponent.getValueForSQLQuery(ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}.
   *
   * <ul>
   *   <li>When {@code Value Parameter}.
   *   <li>Then return {@code 'Value Parameter'}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultQueryLogComponent#getValueForSQLQuery(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultQueryLogComponent.getValueForSQLQuery(Object)"})
  public void testGetValueForSQLQuery_whenValueParameter_thenReturnValueParameter() {
    // Arrange, Act and Assert
    assertEquals(
        "'Value Parameter'", defaultQueryLogComponent.getValueForSQLQuery("Value Parameter"));
  }
}
