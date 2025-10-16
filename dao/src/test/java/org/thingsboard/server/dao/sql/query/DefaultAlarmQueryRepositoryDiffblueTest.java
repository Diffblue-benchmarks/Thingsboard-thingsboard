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
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultAlarmQueryRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultAlarmQueryRepositoryDiffblueTest {
  @Autowired private DefaultAlarmQueryRepository defaultAlarmQueryRepository;

  @MockBean private DefaultQueryLogComponent defaultQueryLogComponent;

  @MockBean private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link DefaultAlarmQueryRepository#findAlarmDataByQueryForEntities(TenantId,
   * AlarmDataQuery, Collection)}.
   *
   * <p>Method under test: {@link
   * DefaultAlarmQueryRepository#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultAlarmQueryRepository.findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)"
  })
  public void testFindAlarmDataByQueryForEntities() throws TransactionException {
    // Arrange
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult =
        defaultAlarmQueryRepository.findAlarmDataByQueryForEntities(
            ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}.
   *
   * <p>Method under test: {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId,
   * CustomerId, AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultAlarmQueryRepository.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery() throws SQLException, DataAccessException {
    // Arrange
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    when(jdbcTemplate.queryForObject(
            Mockito.<String>any(), Mockito.<SqlParameterSource>any(), Mockito.<Class<Long>>any()))
        .thenReturn(1L);

    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).close();
    doNothing().when(connection).commit();

    DataSource dataSource = mock(DataSource.class);
    when(dataSource.getConnection()).thenReturn(connection);
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
    TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

    DefaultAlarmQueryRepository defaultAlarmQueryRepository =
        new DefaultAlarmQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());
    AlarmCountQuery query = new AlarmCountQuery(0L, 0L, 0L, null, null, null, false, null);

    // Act
    long actualCountAlarmsByQueryResult =
        defaultAlarmQueryRepository.countAlarmsByQuery(ModelConstants.SYSTEM_TENANT, null, query);

    // Assert
    verify(connection).close();
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(dataSource).getConnection();
    verify(jdbcTemplate)
        .queryForObject(
            eq("select count(id) from alarm_info a where a.tenant_id = :tenantId"),
            isA(SqlParameterSource.class),
            isA(Class.class));
    assertEquals(1L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmCountQuery#getEndTs()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId,
   * CustomerId, AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultAlarmQueryRepository.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery_thenCallsGetEndTs() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.isNullUid()).thenReturn(true);

    AlarmCountQuery query = mock(AlarmCountQuery.class);
    when(query.isSearchPropagatedAlarms()).thenReturn(false);
    when(query.getSeverityList()).thenReturn(null);
    when(query.getStatusList()).thenReturn(null);
    when(query.getTypeList()).thenReturn(null);
    when(query.getEndTs()).thenReturn(0L);
    when(query.getStartTs()).thenReturn(0L);
    when(query.getTimeWindow()).thenReturn(0L);
    when(query.getAssigneeId()).thenReturn(null);

    // Act
    long actualCountAlarmsByQueryResult =
        defaultAlarmQueryRepository.countAlarmsByQuery(tenantId, customerId, query);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(customerId).isNullUid();
    verify(tenantId).getId();
    verify(query).getAssigneeId();
    verify(query).getEndTs();
    verify(query).getSeverityList();
    verify(query).getStartTs();
    verify(query).getStatusList();
    verify(query).getTimeWindow();
    verify(query).getTypeList();
    verify(query).isSearchPropagatedAlarms();
    assertEquals(1L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId,
   * CustomerId, AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultAlarmQueryRepository.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery_thenReturnThree() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(3L);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    AlarmCountQuery query = new AlarmCountQuery(0L, 0L, 0L, null, null, null, false, assigneeId);

    // Act
    long actualCountAlarmsByQueryResult =
        defaultAlarmQueryRepository.countAlarmsByQuery(ModelConstants.SYSTEM_TENANT, null, query);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(assigneeId).getId();
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }
}
