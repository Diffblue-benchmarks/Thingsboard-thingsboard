package org.thingsboard.server.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.asset.AssetProfileRepository;
import org.thingsboard.server.dao.sql.asset.AssetRepository;
import org.thingsboard.server.dao.sql.asset.JpaAssetDao;
import org.thingsboard.server.dao.sql.dashboard.DashboardRepository;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardDao;

@ContextConfiguration(classes = {JpaDashboardDao.class, JpaAssetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class ExportableEntityDaoDiffblueTest {
  @MockBean private AssetProfileRepository assetProfileRepository;

  @MockBean private AssetRepository assetRepository;

  @MockBean private DashboardRepository dashboardRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @Autowired private ExportableEntityDao<AssetId, Asset> exportableEntityDao;

  @Autowired private ExportableEntityDao<DashboardId, Dashboard> exportableEntityDao2;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link ExportableEntityDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link ExportableEntityDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @DisplayName("Test findByTenantIdAndName(UUID, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.ExportableEntity ExportableEntityDao.findByTenantIdAndName(UUID, String)"
  })
  void testFindByTenantIdAndName() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            exportableEntityDao2.findByTenantIdAndName(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Name"));
  }

  /**
   * Test {@link ExportableEntityDao#findIdsByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link ExportableEntityDao#findIdsByTenantId(UUID, PageLink)}
   */
  @Test
  @DisplayName("Test findIdsByTenantId(UUID, PageLink); then return TotalElements is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData ExportableEntityDao.findIdsByTenantId(UUID, PageLink)"})
  void testFindIdsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetId> actualFindIdsByTenantIdResult =
        exportableEntityDao.findIdsByTenantId(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
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
   *
   * <p>Method under test: {@link ExportableEntityDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @DisplayName("Test findDefaultEntityByTenantId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.ExportableEntity ExportableEntityDao.findDefaultEntityByTenantId(UUID)"
  })
  void testFindDefaultEntityByTenantId() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            exportableEntityDao.findDefaultEntityByTenantId(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
