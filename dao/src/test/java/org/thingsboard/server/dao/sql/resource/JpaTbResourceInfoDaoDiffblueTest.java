package org.thingsboard.server.dao.sql.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTbResourceInfoDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTbResourceInfoDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTbResourceInfoDao jpaTbResourceInfoDao;

  @MockBean
  private TbResourceInfoRepository tbResourceInfoRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTbResourceInfoDao#getEntityClass()}
   *   <li>{@link JpaTbResourceInfoDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaTbResourceInfoDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaTbResourceInfoDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaTbResourceInfoDao jpaTbResourceInfoDao = new JpaTbResourceInfoDao();

    // Act
    Class<TbResourceInfoEntity> actualEntityClass = jpaTbResourceInfoDao.getEntityClass();

    // Assert
    assertNull(jpaTbResourceInfoDao.getRepository());
    Class<TbResourceInfoEntity> expectedEntityClass = TbResourceInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)"})
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_thenReturnFalse() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult = jpaTbResourceInfoDao
        .existsByTenantIdAndResourceTypeAndResourceKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            "Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertFalse(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceInfoDao#existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaTbResourceInfoDao.existsByTenantIdAndResourceTypeAndResourceKey(TenantId, ResourceType, String)"})
  public void testExistsByTenantIdAndResourceTypeAndResourceKey_thenReturnTrue() {
    // Arrange
    when(tbResourceInfoRepository.existsByTenantIdAndResourceTypeAndResourceKey(Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndResourceTypeAndResourceKeyResult = jpaTbResourceInfoDao
        .existsByTenantIdAndResourceTypeAndResourceKey(ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL,
            "Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByTenantIdAndResourceTypeAndResourceKey(isA(UUID.class), eq("LWM2M_MODEL"),
        eq("Resource Key"));
    assertTrue(actualExistsByTenantIdAndResourceTypeAndResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaTbResourceInfoDao.existsByPublicResourceKey(ResourceType, String)"})
  public void testExistsByPublicResourceKey_thenReturnFalse() {
    // Arrange
    when(
        tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualExistsByPublicResourceKeyResult = jpaTbResourceInfoDao
        .existsByPublicResourceKey(ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByResourceTypeAndPublicResourceKey(eq("LWM2M_MODEL"),
        eq("Public Resource Key"));
    assertFalse(actualExistsByPublicResourceKeyResult);
  }

  /**
   * Test {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTbResourceInfoDao#existsByPublicResourceKey(ResourceType, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaTbResourceInfoDao.existsByPublicResourceKey(ResourceType, String)"})
  public void testExistsByPublicResourceKey_thenReturnTrue() {
    // Arrange
    when(
        tbResourceInfoRepository.existsByResourceTypeAndPublicResourceKey(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByPublicResourceKeyResult = jpaTbResourceInfoDao
        .existsByPublicResourceKey(ResourceType.LWM2M_MODEL, "Public Resource Key");

    // Assert
    verify(tbResourceInfoRepository).existsByResourceTypeAndPublicResourceKey(eq("LWM2M_MODEL"),
        eq("Public Resource Key"));
    assertTrue(actualExistsByPublicResourceKeyResult);
  }
}
