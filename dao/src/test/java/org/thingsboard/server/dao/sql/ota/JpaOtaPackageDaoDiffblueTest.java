package org.thingsboard.server.dao.sql.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OtaPackageEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOtaPackageDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOtaPackageDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOtaPackageDao jpaOtaPackageDao;

  @MockBean
  private OtaPackageRepository otaPackageRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOtaPackageDao#getEntityClass()}
   *   <li>{@link JpaOtaPackageDao#getEntityType()}
   *   <li>{@link JpaOtaPackageDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaOtaPackageDao.getEntityClass()", "EntityType JpaOtaPackageDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaOtaPackageDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaOtaPackageDao jpaOtaPackageDao = new JpaOtaPackageDao();

    // Act
    Class<OtaPackageEntity> actualEntityClass = jpaOtaPackageDao.getEntityClass();
    EntityType actualEntityType = jpaOtaPackageDao.getEntityType();

    // Assert
    assertNull(jpaOtaPackageDao.getRepository());
    assertEquals(EntityType.OTA_PACKAGE, actualEntityType);
    Class<OtaPackageEntity> expectedEntityClass = OtaPackageEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOtaPackageDao#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOtaPackageDao#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaOtaPackageDao.sumDataSizeByTenantId(TenantId)"})
  public void testSumDataSizeByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(otaPackageRepository.sumDataSizeByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualSumDataSizeByTenantIdResult = jpaOtaPackageDao.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageRepository).sumDataSizeByTenantId(isA(UUID.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult.longValue());
  }
}
