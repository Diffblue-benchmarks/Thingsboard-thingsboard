package org.thingsboard.server.dao.sql.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
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
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantProfileEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTenantProfileDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaTenantProfileDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTenantProfileDao jpaTenantProfileDao;

  @MockBean
  private TenantProfileRepository tenantProfileRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTenantProfileDao#getEntityClass()}
   *   <li>{@link JpaTenantProfileDao#getEntityType()}
   *   <li>{@link JpaTenantProfileDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaTenantProfileDao.getEntityClass()", "EntityType JpaTenantProfileDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaTenantProfileDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantProfileDao jpaTenantProfileDao = new JpaTenantProfileDao();

    // Act
    Class<TenantProfileEntity> actualEntityClass = jpaTenantProfileDao.getEntityClass();
    EntityType actualEntityType = jpaTenantProfileDao.getEntityType();

    // Assert
    assertNull(jpaTenantProfileDao.getRepository());
    assertEquals(EntityType.TENANT_PROFILE, actualEntityType);
    Class<TenantProfileEntity> expectedEntityClass = TenantProfileEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaTenantProfileDao#findTenantProfileInfoById(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityInfo JpaTenantProfileDao.findTenantProfileInfoById(TenantId, UUID)"})
  public void testFindTenantProfileInfoById() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");

    when(tenantProfileRepository.findTenantProfileInfoById(Mockito.<UUID>any())).thenReturn(entityInfo);

    // Act
    EntityInfo actualFindTenantProfileInfoByIdResult = jpaTenantProfileDao.findTenantProfileInfoById(
        ModelConstants.SYSTEM_TENANT, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(tenantProfileRepository).findTenantProfileInfoById(isA(UUID.class));
    assertSame(entityInfo, actualFindTenantProfileInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}.
   * <ul>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantProfileDao#findDefaultTenantProfile(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantProfile JpaTenantProfileDao.findDefaultTenantProfile(TenantId)"})
  public void testFindDefaultTenantProfile_thenReturnName() {
    // Arrange
    TenantProfileEntity tenantProfileEntity = new TenantProfileEntity();
    tenantProfileEntity.setCreatedTime(1L);
    tenantProfileEntity.setDefault(true);
    tenantProfileEntity.setDescription("The characteristics of someone or something");
    tenantProfileEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tenantProfileEntity.setIsolatedTbRuleEngine(true);
    tenantProfileEntity.setName("Name");
    tenantProfileEntity.setProfileData(MissingNode.getInstance());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    tenantProfileEntity.setUuid(id);
    when(tenantProfileRepository.findByDefaultTrue()).thenReturn(tenantProfileEntity);

    // Act
    TenantProfile actualFindDefaultTenantProfileResult = jpaTenantProfileDao
        .findDefaultTenantProfile(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findByDefaultTrue();
    assertEquals("Name", actualFindDefaultTenantProfileResult.getName());
    assertEquals("The characteristics of someone or something", actualFindDefaultTenantProfileResult.getDescription());
    assertNull(actualFindDefaultTenantProfileResult.getProfileDataBytes());
    assertEquals(1L, actualFindDefaultTenantProfileResult.getCreatedTime());
    assertTrue(actualFindDefaultTenantProfileResult.isDefault());
    assertTrue(actualFindDefaultTenantProfileResult.isIsolatedTbRuleEngine());
    assertSame(id, actualFindDefaultTenantProfileResult.getUuidId());
  }

  /**
   * Test {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}.
   * <p>
   * Method under test: {@link JpaTenantProfileDao#findDefaultTenantProfileInfo(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityInfo JpaTenantProfileDao.findDefaultTenantProfileInfo(TenantId)"})
  public void testFindDefaultTenantProfileInfo() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name");

    when(tenantProfileRepository.findDefaultTenantProfileInfo()).thenReturn(entityInfo);

    // Act
    EntityInfo actualFindDefaultTenantProfileInfoResult = jpaTenantProfileDao
        .findDefaultTenantProfileInfo(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantProfileRepository).findDefaultTenantProfileInfo();
    assertSame(entityInfo, actualFindDefaultTenantProfileInfoResult);
  }
}
