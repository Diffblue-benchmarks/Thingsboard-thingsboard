package org.thingsboard.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.asset.AssetProfileRepository;
import org.thingsboard.server.dao.sql.asset.AssetRepository;
import org.thingsboard.server.dao.sql.asset.JpaAssetDao;

@ContextConfiguration(classes = {JpaAssetDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class ExportableEntityDaoDiffblueTest {
  @MockBean
  private AssetProfileRepository assetProfileRepository;

  @MockBean
  private AssetRepository assetRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @Autowired
  private ExportableEntityDao<AssetId, Asset> exportableEntityDao;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link ExportableEntityDao#findIdsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ExportableEntityDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindIdsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetId> actualFindIdsByTenantIdResult = exportableEntityDao.findIdsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link ExportableEntityDao#findDefaultEntityByTenantId(UUID)}.
   * <p>
   * Method under test:
   * {@link ExportableEntityDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> exportableEntityDao.findDefaultEntityByTenantId(ModelConstants.NULL_UUID));
  }
}
