package org.thingsboard.server.dao;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.asset.AssetProfileRepository;
import org.thingsboard.server.dao.sql.asset.AssetRepository;
import org.thingsboard.server.dao.sql.asset.JpaAssetDao;

@ContextConfiguration(classes = {JpaAssetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
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
   * Test {@link ExportableEntityDao#findDefaultEntityByTenantId(UUID)}.
   * <p>
   * Method under test: {@link ExportableEntityDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.ExportableEntity ExportableEntityDao.findDefaultEntityByTenantId(UUID)"})
  public void testFindDefaultEntityByTenantId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> exportableEntityDao.findDefaultEntityByTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }
}
