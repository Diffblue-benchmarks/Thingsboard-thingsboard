package org.thingsboard.server.dao.sql.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.dao.model.sql.OAuth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOAuth2ClientDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOAuth2ClientDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOAuth2ClientDao jpaOAuth2ClientDao;

  @MockBean
  private OAuth2ClientRepository oAuth2ClientRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOAuth2ClientDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientDao#getEntityType()}
   *   <li>{@link JpaOAuth2ClientDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaOAuth2ClientDao.getEntityClass()", "EntityType JpaOAuth2ClientDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaOAuth2ClientDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientDao jpaOAuth2ClientDao = new JpaOAuth2ClientDao(mock(OAuth2ClientRepository.class));

    // Act
    Class<OAuth2ClientEntity> actualEntityClass = jpaOAuth2ClientDao.getEntityClass();
    EntityType actualEntityType = jpaOAuth2ClientDao.getEntityType();
    jpaOAuth2ClientDao.getRepository();

    // Assert
    assertEquals(EntityType.OAUTH2_CLIENT, actualEntityType);
    Class<OAuth2ClientEntity> expectedEntityClass = OAuth2ClientEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByDomainId(UUID)}.
   * <ul>
   *   <li>Given {@link JdbcTemplate}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByDomainId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByDomainId(UUID)"})
  public void testFindByDomainId_givenJdbcTemplate_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByDomainIdResult = jpaOAuth2ClientDao
        .findByDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(oAuth2ClientRepository).findByDomainId(isA(UUID.class));
    assertTrue(actualFindByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}.
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String JpaOAuth2ClientDao.findAppSecret(UUID, String)"})
  public void testFindAppSecret() {
    // Arrange
    when(oAuth2ClientRepository.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult = jpaOAuth2ClientDao
        .findAppSecret(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Pkg Name");

    // Assert
    verify(oAuth2ClientRepository).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}.
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaOAuth2ClientDao.deleteByTenantId(UUID)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaOAuth2ClientDao.deleteByTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(oAuth2ClientRepository).deleteByTenantId(isA(UUID.class));
  }
}
