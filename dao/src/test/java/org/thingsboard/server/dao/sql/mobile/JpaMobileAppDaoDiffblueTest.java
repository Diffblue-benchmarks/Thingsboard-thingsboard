package org.thingsboard.server.dao.sql.mobile;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.MobileAppEntity;
import org.thingsboard.server.dao.model.sql.MobileAppOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaMobileAppDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaMobileAppDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaMobileAppDao jpaMobileAppDao;

  @MockBean
  private MobileAppOauth2ClientRepository mobileAppOauth2ClientRepository;

  @MockBean
  private MobileAppRepository mobileAppRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaMobileAppDao#getEntityClass()}
   *   <li>{@link JpaMobileAppDao#getEntityType()}
   *   <li>{@link JpaMobileAppDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaMobileAppDao.getEntityClass()", "EntityType JpaMobileAppDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaMobileAppDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaMobileAppDao jpaMobileAppDao = new JpaMobileAppDao(mock(MobileAppRepository.class),
        mock(MobileAppOauth2ClientRepository.class));

    // Act
    Class<MobileAppEntity> actualEntityClass = jpaMobileAppDao.getEntityClass();
    EntityType actualEntityType = jpaMobileAppDao.getEntityType();
    jpaMobileAppDao.getRepository();

    // Assert
    assertEquals(EntityType.MOBILE_APP, actualEntityType);
    Class<MobileAppEntity> expectedEntityClass = MobileAppEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * <p>
   * Method under test: {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaMobileAppDao.addOauth2Client(MobileAppOauth2Client)"})
  public void testAddOauth2Client() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);
    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client
        .setOAuth2ClientId(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}.
   * <p>
   * Method under test: {@link JpaMobileAppDao#addOauth2Client(MobileAppOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaMobileAppDao.addOauth2Client(MobileAppOauth2Client)"})
  public void testAddOauth2Client2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(mobileAppOauth2ClientRepository.save(Mockito.<MobileAppOauth2ClientEntity>any()))
        .thenReturn(mobileAppOauth2ClientEntity);
    MobileAppId mobileAppId = mock(MobileAppId.class);
    when(mobileAppId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    mobileAppOauth2Client.setMobileAppId(mobileAppId);

    // Act
    jpaMobileAppDao.addOauth2Client(mobileAppOauth2Client);

    // Assert
    verify(mobileAppOauth2ClientRepository).save(isA(MobileAppOauth2ClientEntity.class));
    verify(mobileAppId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaMobileAppDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link MobileAppRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaMobileAppDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaMobileAppDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaMobileAppDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppRepository).deleteByTenantId(isA(UUID.class));
  }
}
