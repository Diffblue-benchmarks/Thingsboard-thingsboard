package org.thingsboard.server.dao.sql.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.dao.model.sql.OAuth2ClientRegistrationTemplateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOAuth2ClientRegistrationTemplateDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOAuth2ClientRegistrationTemplateDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao;

  @MockBean
  private OAuth2ClientRegistrationTemplateRepository oAuth2ClientRegistrationTemplateRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaOAuth2ClientRegistrationTemplateDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaOAuth2ClientRegistrationTemplateDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao = new JpaOAuth2ClientRegistrationTemplateDao(
        mock(OAuth2ClientRegistrationTemplateRepository.class));

    // Act
    Class<OAuth2ClientRegistrationTemplateEntity> actualEntityClass = jpaOAuth2ClientRegistrationTemplateDao
        .getEntityClass();
    jpaOAuth2ClientRegistrationTemplateDao.getRepository();

    // Assert
    Class<OAuth2ClientRegistrationTemplateEntity> expectedEntityClass = OAuth2ClientRegistrationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaOAuth2ClientRegistrationTemplateDao.findAll()"})
  public void testFindAll_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult = jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
