package org.thingsboard.server.dao.sql.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetEntity;
import org.thingsboard.server.dao.model.sql.AssetInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAssetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAssetDaoDiffblueTest {
  @MockBean
  private AssetProfileRepository assetProfileRepository;

  @MockBean
  private AssetRepository assetRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAssetDao jpaAssetDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAssetDao#getEntityClass()}
   *   <li>{@link JpaAssetDao#getEntityType()}
   *   <li>{@link JpaAssetDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAssetDao.getEntityClass()", "EntityType JpaAssetDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAssetDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetDao jpaAssetDao = new JpaAssetDao();

    // Act
    Class<AssetEntity> actualEntityClass = jpaAssetDao.getEntityClass();
    EntityType actualEntityType = jpaAssetDao.getEntityType();

    // Assert
    assertNull(jpaAssetDao.getRepository());
    assertEquals(EntityType.ASSET, actualEntityType);
    Class<AssetEntity> expectedEntityClass = AssetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenAdditionalInfoReturnNullNode() {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(new AssetInfoEntity());

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertTrue(actualFindAssetInfoByIdResult.getAdditionalInfo() instanceof NullNode);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AssetInfo JpaAssetDao.findAssetInfoById(TenantId, UUID)"})
  public void testFindAssetInfoById_thenReturnNull() {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertNull(actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaAssetDao.countAssetsByAssetProfileId(TenantId, UUID)"})
  public void testCountAssetsByAssetProfileId() {
    // Arrange
    when(assetRepository.countByAssetProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountAssetsByAssetProfileIdResult = jpaAssetDao.countAssetsByAssetProfileId(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(assetRepository).countByAssetProfileId(isA(UUID.class));
    assertEquals(1L, actualCountAssetsByAssetProfileIdResult.longValue());
  }

  /**
   * Test {@link JpaAssetDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaAssetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(assetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaAssetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }
}
