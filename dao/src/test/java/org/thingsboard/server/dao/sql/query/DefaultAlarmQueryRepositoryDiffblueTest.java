package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DefaultAlarmQueryRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class DefaultAlarmQueryRepositoryDiffblueTest {
  @Autowired
  private DefaultAlarmQueryRepository defaultAlarmQueryRepository;

  @MockBean
  private DefaultQueryLogComponent defaultQueryLogComponent;

  @MockBean
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link DefaultAlarmQueryRepository#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <p>
   * Method under test:
   * {@link DefaultAlarmQueryRepository#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities() throws TransactionException {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = defaultAlarmQueryRepository
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAlarmQueryRepository#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}
   */
  @Test
  public void testCountAlarmsByQuery_thenReturnThree() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(3L);

    // Act
    long actualCountAlarmsByQueryResult = defaultAlarmQueryRepository.countAlarmsByQuery(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmCountQuery());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }
}
