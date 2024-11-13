package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {JpaEntityQueryDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class JpaEntityQueryDaoDiffblueTest {
  @MockBean
  private EntityQueryRepository entityQueryRepository;

  @Autowired
  private JpaEntityQueryDao jpaEntityQueryDao;

  /**
   * Test
   * {@link JpaEntityQueryDao#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}.
   * <p>
   * Method under test:
   * {@link JpaEntityQueryDao#countEntitiesByQuery(TenantId, CustomerId, EntityCountQuery)}
   */
  @Test
  public void testCountEntitiesByQuery() {
    // Arrange
    when(entityQueryRepository.countEntitiesByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityCountQuery>any())).thenReturn(3L);

    // Act
    long actualCountEntitiesByQueryResult = jpaEntityQueryDao.countEntitiesByQuery(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new EntityCountQuery());

    // Assert
    verify(entityQueryRepository).countEntitiesByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityCountQuery.class));
    assertEquals(3L, actualCountEntitiesByQueryResult);
  }

  /**
   * Test
   * {@link JpaEntityQueryDao#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}.
   * <p>
   * Method under test:
   * {@link JpaEntityQueryDao#findEntityDataByQuery(TenantId, CustomerId, EntityDataQuery)}
   */
  @Test
  public void testFindEntityDataByQuery() {
    // Arrange
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityQueryRepository.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EntityData> actualFindEntityDataByQueryResult = jpaEntityQueryDao
        .findEntityDataByQuery(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new EntityDataQuery());

    // Assert
    verify(entityQueryRepository).findEntityDataByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(EntityDataQuery.class));
    assertSame(actualFindEntityDataByQueryResult.EMPTY_PAGE_DATA, actualFindEntityDataByQueryResult);
  }
}
