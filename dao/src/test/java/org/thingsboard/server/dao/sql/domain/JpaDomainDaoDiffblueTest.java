package org.thingsboard.server.dao.sql.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DomainEntity;
import org.thingsboard.server.dao.model.sql.DomainOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDomainDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDomainDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DomainOauth2ClientRepository domainOauth2ClientRepository;

  @MockBean
  private DomainRepository domainRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDomainDao jpaDomainDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDomainDao#getEntityClass()}
   *   <li>{@link JpaDomainDao#getEntityType()}
   *   <li>{@link JpaDomainDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaDomainDao.getEntityClass()", "EntityType JpaDomainDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaDomainDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaDomainDao jpaDomainDao = new JpaDomainDao(mock(DomainRepository.class),
        mock(DomainOauth2ClientRepository.class));

    // Act
    Class<DomainEntity> actualEntityClass = jpaDomainDao.getEntityClass();
    EntityType actualEntityType = jpaDomainDao.getEntityType();
    jpaDomainDao.getRepository();

    // Assert
    assertEquals(EntityType.DOMAIN, actualEntityType);
    Class<DomainEntity> expectedEntityClass = DomainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaDomainDao.countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)"})
  public void testCountDomainByTenantIdAndOauth2Enabled_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(domainRepository.countByTenantIdAndOauth2Enabled(Mockito.<UUID>any(), anyBoolean())).thenReturn(1);

    // Act
    int actualCountDomainByTenantIdAndOauth2EnabledResult = jpaDomainDao
        .countDomainByTenantIdAndOauth2Enabled(ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(domainRepository).countByTenantIdAndOauth2Enabled(isA(UUID.class), eq(true));
    assertEquals(1, actualCountDomainByTenantIdAndOauth2EnabledResult);
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   * <p>
   * Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaDomainDao.addOauth2Client(DomainOauth2Client)"})
  public void testAddOauth2Client() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);
    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainId).getId();
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   * <p>
   * Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaDomainDao.addOauth2Client(DomainOauth2Client)"})
  public void testAddOauth2Client2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);
    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link DomainRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDomainDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaDomainDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(domainRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaDomainDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainRepository).deleteByTenantId(isA(UUID.class));
  }
}
