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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAlarmQueryRepositoryDiffblueTest {
  @InjectMocks private DefaultAlarmQueryRepository defaultAlarmQueryRepository;

  @Mock private TransactionTemplate transactionTemplate;

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
    TransactionTemplate transactionTemplate = mock(TransactionTemplate.class);
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn(emptyPageDataResult);
    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);

    DefaultAlarmQueryRepository defaultAlarmQueryRepository =
        new DefaultAlarmQueryRepository(
            jdbcTemplate, transactionTemplate, new DefaultQueryLogComponent());
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
        defaultAlarmQueryRepository.countAlarmsByQuery(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(assigneeId).getId();
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }
}
